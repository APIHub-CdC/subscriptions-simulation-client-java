package io.SubscriptionSimulation.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A list of subscriptions showed in pages.")

public class SubscriptionsMetadata {
	@SerializedName("_metadata")
	private Metadata metadata = null;
	@SerializedName("subscriptions")
	private Subscriptions subscriptions = null;

	public SubscriptionsMetadata metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	@ApiModelProperty(value = "")
	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public SubscriptionsMetadata subscriptions(Subscriptions subscriptions) {
		this.subscriptions = subscriptions;
		return this;
	}

	@ApiModelProperty(value = "")
	public Subscriptions getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Subscriptions subscriptions) {
		this.subscriptions = subscriptions;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SubscriptionsMetadata subscriptionsMetadata = (SubscriptionsMetadata) o;
		return Objects.equals(this.metadata, subscriptionsMetadata.metadata)
				&& Objects.equals(this.subscriptions, subscriptionsMetadata.subscriptions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(metadata, subscriptions);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SubscriptionsMetadata {\n");

		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		sb.append("    subscriptions: ").append(toIndentedString(subscriptions)).append("\n");
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
