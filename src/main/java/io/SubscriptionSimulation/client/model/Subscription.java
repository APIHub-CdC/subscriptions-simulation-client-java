package io.SubscriptionSimulation.client.model;

import java.util.Objects;
import java.util.UUID;

import org.threeten.bp.OffsetDateTime;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A product subscription.")

public class Subscription {
	@SerializedName("eventType")
	private String eventType = null;
	
	@SerializedName("webHookUrl")
	private String webHookUrl = null;
	
	@SerializedName("enrollmentId")
	private UUID enrollmentId = null;
	
	@SerializedName("subscriptionId")
	private UUID subscriptionId = null;
	
	@SerializedName("dateTime")
	private OffsetDateTime dateTime = null;

	public Subscription eventType(String eventType) {
		this.eventType = eventType;
		return this;
	}

	@ApiModelProperty(example = "mx.com.circulolaboral.employmentcheck", required = true, value = "Event type you are interested in.")
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Subscription webHookUrl(String webHookUrl) {
		this.webHookUrl = webHookUrl;
		return this;
	}

	@ApiModelProperty(example = "https://yourdomain.com/v1/notifications", required = true, value = "The URL which will receive API Hub event notifications.")
	public String getWebHookUrl() {
		return webHookUrl;
	}

	public void setWebHookUrl(String webHookUrl) {
		this.webHookUrl = webHookUrl;
	}

	public Subscription enrollmentId(UUID enrollmentId) {
		this.enrollmentId = enrollmentId;
		return this;
	}

	@ApiModelProperty(example = "470987ab-b4cb-4a1e-9eaf-8856a813da59", value = "Your enrollment identifier to associate with the subscription identifier (UUID).")
	public UUID getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(UUID enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	@ApiModelProperty(example = "4fc07667-b928-4a5c-a9d4-e18d3d515d24", value = "Subscription identifier (UUID).")
	public UUID getSubscriptionId() {
		return subscriptionId;
	}

	@ApiModelProperty(example = "2020-04-12T22:20:50.52Z", value = "Date and time when the subscription was created.")
	public OffsetDateTime getDateTime() {
		return dateTime;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Subscription subscription = (Subscription) o;
		return Objects.equals(this.eventType, subscription.eventType)
				&& Objects.equals(this.webHookUrl, subscription.webHookUrl)
				&& Objects.equals(this.enrollmentId, subscription.enrollmentId)
				&& Objects.equals(this.subscriptionId, subscription.subscriptionId)
				&& Objects.equals(this.dateTime, subscription.dateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventType, webHookUrl, enrollmentId, subscriptionId, dateTime);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Subscription {\n");

		sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
		sb.append("    webHookUrl: ").append(toIndentedString(webHookUrl)).append("\n");
		sb.append("    enrollmentId: ").append(toIndentedString(enrollmentId)).append("\n");
		sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
		sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
