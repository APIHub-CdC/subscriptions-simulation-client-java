package io.SubscriptionSimulation.client.model;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.threeten.bp.OffsetDateTime;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Subscription acknowledge information.")

public class SubscriptionAcknowledge {
	@SerializedName("acknowledgeId")
	private UUID acknowledgeId = null;
	@SerializedName("dateTime")
	private OffsetDateTime dateTime = null;

	@JsonAdapter(OperationEnum.Adapter.class)
	public enum OperationEnum {
		ENROLLMENT("enrollment"),

		CANCELLATION("cancellation");

		private String value;

		OperationEnum(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public static OperationEnum fromValue(String text) {
			for (OperationEnum b : OperationEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}

		public static class Adapter extends TypeAdapter<OperationEnum> {
			@Override
			public void write(final JsonWriter jsonWriter, final OperationEnum enumeration) throws IOException {
				jsonWriter.value(enumeration.getValue());
			}

			@Override
			public OperationEnum read(final JsonReader jsonReader) throws IOException {
				String value = jsonReader.nextString();
				return OperationEnum.fromValue(String.valueOf(value));
			}
		}
	}

	@SerializedName("operation")
	private OperationEnum operation = null;
	@SerializedName("message")
	private String message = null;
	@SerializedName("subscription")
	private Subscription subscription = null;

	@ApiModelProperty(example = "627aa72a-c799-4abf-b98e-0c4838af9bd5", value = "The acknowledge identifier (UUID).")
	public UUID getAcknowledgeId() {
		return acknowledgeId;
	}

	@ApiModelProperty(example = "2020-04-12T22:20:50.52Z", value = "Date and time when the acknowledge was sent.")
	public OffsetDateTime getDateTime() {
		return dateTime;
	}

	@ApiModelProperty(example = "enrollment", value = "Subscription activity.")
	public OperationEnum getOperation() {
		return operation;
	}

	@ApiModelProperty(example = "The subscription was created.", value = "Descriptive and human-readable message.")
	public String getMessage() {
		return message;
	}

	public SubscriptionAcknowledge subscription(Subscription subscription) {
		this.subscription = subscription;
		return this;
	}

	@ApiModelProperty(value = "")
	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SubscriptionAcknowledge subscriptionAcknowledge = (SubscriptionAcknowledge) o;
		return Objects.equals(this.acknowledgeId, subscriptionAcknowledge.acknowledgeId)
				&& Objects.equals(this.dateTime, subscriptionAcknowledge.dateTime)
				&& Objects.equals(this.operation, subscriptionAcknowledge.operation)
				&& Objects.equals(this.message, subscriptionAcknowledge.message)
				&& Objects.equals(this.subscription, subscriptionAcknowledge.subscription);
	}

	@Override
	public int hashCode() {
		return Objects.hash(acknowledgeId, dateTime, operation, message, subscription);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SubscriptionAcknowledge {\n");

		sb.append("    acknowledgeId: ").append(toIndentedString(acknowledgeId)).append("\n");
		sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
		sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
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
