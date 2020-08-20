package io.SubscriptionSimulation.client.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import io.SubscriptionSimulation.client.ApiClient;
import io.SubscriptionSimulation.client.ApiException;
import io.SubscriptionSimulation.client.ApiResponse;
import io.SubscriptionSimulation.client.Configuration;
import io.SubscriptionSimulation.client.Pair;
import io.SubscriptionSimulation.client.ProgressRequestBody;
import io.SubscriptionSimulation.client.ProgressResponseBody;
import io.SubscriptionSimulation.client.model.Subscription;
import io.SubscriptionSimulation.client.model.SubscriptionAcknowledge;
import io.SubscriptionSimulation.client.model.SubscriptionsMetadata;

public class WebHookSubscriptionsApi {
	private ApiClient apiClient;

	public WebHookSubscriptionsApi() {
		this(Configuration.getDefaultApiClient());
	}

	public WebHookSubscriptionsApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public okhttp3.Call deleteSubscriptionCall(String xApiKey, String subscriptionId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;
		String localVarPath = "/sandbox/v1/subscriptions/{subscriptionId}".replaceAll("\\{" + "subscriptionId" + "\\}",
				apiClient.escapeString(subscriptionId.toString()));
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call deleteSubscriptionValidateBeforeCall(String xApiKey, String subscriptionId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		if (xApiKey == null) {
			throw new ApiException("Missing the required parameter 'xApiKey' when calling deleteSubscription(Async)");
		}
		if (subscriptionId == null) {
			throw new ApiException(
					"Missing the required parameter 'subscriptionId' when calling deleteSubscription(Async)");
		}

		okhttp3.Call call = deleteSubscriptionCall(xApiKey, subscriptionId, progressListener, progressRequestListener);
		return call;
	}

	public SubscriptionAcknowledge deleteSubscription(String xApiKey, String subscriptionId) throws ApiException {
		ApiResponse<SubscriptionAcknowledge> resp = deleteSubscriptionWithHttpInfo(xApiKey, subscriptionId);
		return resp.getData();
	}

	public ApiResponse<SubscriptionAcknowledge> deleteSubscriptionWithHttpInfo(String xApiKey, String subscriptionId)
			throws ApiException {
		okhttp3.Call call = deleteSubscriptionValidateBeforeCall(xApiKey, subscriptionId, null, null);
		Type localVarReturnType = new TypeToken<SubscriptionAcknowledge>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	public okhttp3.Call getSubscriptionCall(String xApiKey, String subscriptionId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;
		String localVarPath = "/sandbox/v1/subscriptions/{subscriptionId}".replaceAll("\\{" + "subscriptionId" + "\\}",
				apiClient.escapeString(subscriptionId.toString()));
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call getSubscriptionValidateBeforeCall(String xApiKey, String subscriptionId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		if (xApiKey == null) {
			throw new ApiException("Missing the required parameter 'xApiKey' when calling getSubscription(Async)");
		}
		if (subscriptionId == null) {
			throw new ApiException(
					"Missing the required parameter 'subscriptionId' when calling getSubscription(Async)");
		}

		okhttp3.Call call = getSubscriptionCall(xApiKey, subscriptionId, progressListener, progressRequestListener);
		return call;
	}

	public Subscription getSubscription(String xApiKey, String subscriptionId) throws ApiException {
		ApiResponse<Subscription> resp = getSubscriptionWithHttpInfo(xApiKey, subscriptionId);
		return resp.getData();
	}

	public ApiResponse<Subscription> getSubscriptionWithHttpInfo(String xApiKey, String subscriptionId)
			throws ApiException {
		okhttp3.Call call = getSubscriptionValidateBeforeCall(xApiKey, subscriptionId, null, null);
		Type localVarReturnType = new TypeToken<Subscription>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	public okhttp3.Call getSubscriptionsCall(String xApiKey, String page, String perPage,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;
		String localVarPath = "/sandbox/v1/subscriptions";
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		if (page != null)
			localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
		if (perPage != null)
			localVarQueryParams.addAll(apiClient.parameterToPair("perPage", perPage));
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call getSubscriptionsValidateBeforeCall(String xApiKey, String page, String perPage,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		if (xApiKey == null) {
			throw new ApiException("Missing the required parameter 'xApiKey' when calling getSubscriptions(Async)");
		}

		okhttp3.Call call = getSubscriptionsCall(xApiKey, page, perPage, progressListener, progressRequestListener);
		return call;
	}

	public SubscriptionsMetadata getSubscriptions(String xApiKey, String page, String perPage) throws ApiException {
		ApiResponse<SubscriptionsMetadata> resp = getSubscriptionsWithHttpInfo(xApiKey, page, perPage);
		return resp.getData();
	}

	public ApiResponse<SubscriptionsMetadata> getSubscriptionsWithHttpInfo(String xApiKey, String page, String perPage)
			throws ApiException {
		okhttp3.Call call = getSubscriptionsValidateBeforeCall(xApiKey, page, perPage, null, null);
		Type localVarReturnType = new TypeToken<SubscriptionsMetadata>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}


	public okhttp3.Call postSubscriptionCall(String xApiKey, Subscription enrollment, String xWebhookJwtAuth,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = enrollment;
		String localVarPath = "/sandbox/v1/subscriptions";
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		if (xWebhookJwtAuth != null)
			localVarHeaderParams.put("x-webhook-jwt-auth", apiClient.parameterToString(xWebhookJwtAuth));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call postSubscriptionValidateBeforeCall(String xApiKey, Subscription enrollment,
			String xWebhookJwtAuth, final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		if (xApiKey == null) {
			throw new ApiException("Missing the required parameter 'xApiKey' when calling postSubscription(Async)");
		}
		if (enrollment == null) {
			throw new ApiException("Missing the required parameter 'enrollment' when calling postSubscription(Async)");
		}
		if (xWebhookJwtAuth == null) {
			throw new ApiException(
					"Missing the required parameter 'xWebhookJwtAuth' when calling postSubscription(Async)");
		}

		okhttp3.Call call = postSubscriptionCall(xApiKey, enrollment, xWebhookJwtAuth, progressListener,
				progressRequestListener);
		return call;
	}

	public SubscriptionAcknowledge postSubscription(String xApiKey, Subscription enrollment, String xWebhookJwtAuth)
			throws ApiException {
		ApiResponse<SubscriptionAcknowledge> resp = postSubscriptionWithHttpInfo(xApiKey, enrollment, xWebhookJwtAuth);
		return resp.getData();
	}

	public ApiResponse<SubscriptionAcknowledge> postSubscriptionWithHttpInfo(String xApiKey, Subscription enrollment,
			String xWebhookJwtAuth) throws ApiException {
		okhttp3.Call call = postSubscriptionValidateBeforeCall(xApiKey, enrollment, xWebhookJwtAuth, null, null);
		Type localVarReturnType = new TypeToken<SubscriptionAcknowledge>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}
}
