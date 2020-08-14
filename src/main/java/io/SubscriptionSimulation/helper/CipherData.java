package io.SubscriptionSimulation.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.SubscriptionSimulation.client.ApiException;


public class CipherData {

	private static CipherData instance = new CipherData();
	private Properties prop = new Properties();

	public static byte[] iv = new SecureRandom().generateSeed(16);

	private Logger logger = LoggerFactory.getLogger(CipherData.class.getName());
	private final String confg_file = "config.properties";
	private PrivateKey privateKey;
	private PublicKey publicKey;

	private CipherData() {
		InputStream input = null;
		try {
			input = new FileInputStream(new File(CipherData.class.getClassLoader().getResource(this.confg_file).getFile()));
			prop.load(input);
			privateKey = readPrivateKeyFromKeystore();
			publicKey = readPublicCDC();
		} catch (IOException | NullPointerException e) {
			logger.error(this.confg_file+" not found");
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("InputStream not closed correctly");
				}
			}
		}
	}

	public static CipherData getInstance() {
		return instance;

	}

	private PrivateKey readPrivateKeyFromKeystore() {
		PrivateKey ecKey = null;
		try {
			logger.info("keystore_file:" + prop.getProperty("keystore_file"));
			File file = new File(prop.getProperty("keystore_file"));
			FileInputStream inputStream = new FileInputStream(file);
			KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
			keystore.load(inputStream, prop.getProperty("keystore_password").toCharArray());
			ecKey = (PrivateKey) keystore.getKey(prop.getProperty("key_alias"),prop.getProperty("key_password").toCharArray());
		} catch (KeyStoreException e) {
			logger.error(e.getMessage());
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
		} catch (CertificateException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (UnrecoverableKeyException e) {
			logger.error(e.getMessage());
		} finally {
			if (ecKey == null) {
				logger.error("Could not read the private key, please review your configuration");
			}
		}
		return ecKey;
	}

	public PublicKey readPublicCDC() {
		PublicKey pubKey = null;
		logger.debug("keystore_file:" + prop.getProperty("cdc_cert_file"));
		File file = new File(prop.getProperty("cdc_cert_file"));
		FileInputStream certificate;
		try {
			certificate = new FileInputStream(file);
			CertificateFactory fact = CertificateFactory.getInstance("X.509");
			X509Certificate x509cert = (X509Certificate) fact.generateCertificate(certificate);
			pubKey = x509cert.getPublicKey();
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (CertificateException e) {
			logger.error(e.getMessage());
		} finally {
			if (pubKey == null) {
				logger.error("Could not read the certificate, please review your configuration");
			}
		}

		return pubKey;
	}
	
	public String cipherData(String toChipher) throws ApiException {

		logger.debug("CHIPHER:" + toChipher);
		if(this.privateKey == null)
		{
			throw new ApiException(500, "Private key is null, check your configuration (keystore_password, key_alias or key_password)");
		}
		if(this.publicKey == null)
		{
			throw new ApiException(500, "Certificate is null, check your configuration");
		}
		// Create two AES secret keys to encrypt/decrypt the message
		SecretKey secretKeyA = generateSharedSecret(this.privateKey, this.publicKey);

		// Encrypt the message using 'secretKeyA'
		String cipherText = encryptString(secretKeyA, toChipher);

		System.out.println("Encrypted cipher text: " + cipherText);

		return cipherText;
	}

	public static SecretKey generateSharedSecret(PrivateKey privateKey, PublicKey publicKey) {
		try {
			KeyAgreement keyAgreement = KeyAgreement.getInstance("ECDH",
					new org.bouncycastle.jce.provider.BouncyCastleProvider());
			keyAgreement.init(privateKey);
			keyAgreement.doPhase(publicKey, true);

			SecretKey key = keyAgreement.generateSecret("AES");
			return key;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String encryptString(SecretKey key, String plainText) {
		try {
			IvParameterSpec ivSpec = new IvParameterSpec(iv);
			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding",
					new org.bouncycastle.jce.provider.BouncyCastleProvider());
			byte[] plainTextBytes = plainText.getBytes("UTF-8");
			byte[] cipherText;

			cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
			cipherText = new byte[cipher.getOutputSize(plainTextBytes.length)];
			int encryptLength = cipher.update(plainTextBytes, 0, plainTextBytes.length, cipherText, 0);
			encryptLength += cipher.doFinal(cipherText, encryptLength);

			// initial
			byte[] encoded = Base64.getEncoder().encode(iv);

			return bytesToHex(cipherText).concat(".").concat(new String(encoded));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String bytesToHex(byte[] data, int length) {
		String digits = "0123456789ABCDEF";
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i != length; i++) {
			int v = data[i] & 0xff;

			buffer.append(digits.charAt(v >> 4));
			buffer.append(digits.charAt(v & 0xf));
		}

		return buffer.toString();
	}

	public static String bytesToHex(byte[] data) {
		return bytesToHex(data, data.length);
	}
}
