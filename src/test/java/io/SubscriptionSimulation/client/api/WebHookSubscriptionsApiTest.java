package io.SubscriptionSimulation.client.api;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.SubscriptionSimulation.client.ApiClient;
import io.SubscriptionSimulation.client.ApiException;
import io.SubscriptionSimulation.client.model.Subscription;
import io.SubscriptionSimulation.client.model.SubscriptionAcknowledge;
import io.SubscriptionSimulation.client.model.SubscriptionsMetadata;
import io.SubscriptionSimulation.helper.EncriptHelper;
import okhttp3.OkHttpClient;

public class WebHookSubscriptionsApiTest {
	private Logger logger = LoggerFactory.getLogger(WebHookSubscriptionsApiTest.class.getName());
    private final WebHookSubscriptionsApi api = new WebHookSubscriptionsApi();
    private ApiClient apiClient = null;
    private String xApiKey = "your_api_key";
    private UUID subscriptionId = null;
    
    @Before
    public void setUp() {
    	this.apiClient = api.getApiClient();
    	this.apiClient.setBasePath("the_url");
    	OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
    	apiClient.setHttpClient(okHttpClient);
    }
    
    @Test
    public void postSubscriptionTest() {
        Subscription enrollment = new Subscription();
        
        enrollment.setEventType("mx.com.circulodecredito.eva");//[ mx.com.circulodecredito.eva, mx.com.circulodecredito.ada ]
        enrollment.setWebHookUrl("https://yourdomain.com/v1/notifications");
        enrollment.setEnrollmentId(UUID.randomUUID());
        
        try {
        	EncriptHelper encript = new EncriptHelper("your_username","your_password");
            String xWebhookJwtAuth = encript.getCredentialJWT();
        	SubscriptionAcknowledge subsAck = api.postSubscription(this.xApiKey, enrollment, xWebhookJwtAuth);
        	Assert.assertNotNull(subsAck);
            logger.info(subsAck.toString());

            
            this.subscriptionId = subsAck.getSubscription().getSubscriptionId();
            Assert.assertNotNull(this.subscriptionId);


            if(this.subscriptionId != null) {
                //GET ID
            	Subscription subsResponse = api.getSubscription(this.xApiKey, this.subscriptionId.toString());
            	Assert.assertNotNull(subsResponse);
                logger.info(subsResponse.toString());
                
                //GET LIST
                String page = "1";
                String perPage = "5";                
                SubscriptionsMetadata response = api.getSubscriptions(this.xApiKey, page, perPage);
                Assert.assertNotNull(response);
                logger.info(response.toString());
                
                //DELETE ID
                SubscriptionAcknowledge deletionResponse = api.deleteSubscription(this.xApiKey, this.subscriptionId.toString());
            	Assert.assertNotNull(deletionResponse);
                logger.info(deletionResponse.toString());
            }
        }
        catch (ApiException ae) {
        	logger.error(Integer.toString(ae.getCode()));
        	if (ae.getResponseBody() == null) {
        		logger.error(ae.getMessage());
        	}
        	else {
        		logger.error(ae.getResponseBody());
        	}
        }
    }
}
