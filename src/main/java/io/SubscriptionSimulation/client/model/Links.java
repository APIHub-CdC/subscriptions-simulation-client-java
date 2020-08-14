package io.SubscriptionSimulation.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Pagination information.")

public class Links {
	@SerializedName("self")
	private String self = null;
	@SerializedName("first")
	private String first = null;
	@SerializedName("previous")
	private String previous = null;
	@SerializedName("next")
	private String next = null;
	@SerializedName("last")
	private String last = null;

	@ApiModelProperty(example = "https://services.circulodecredito.com.mx/v1/subscriptions?page=7&perPage=15", value = "URL of this page.")
	public String getSelf() {
		return self;
	}

	@ApiModelProperty(example = "https://services.circulodecredito.com.mx/v1/subscriptions?page=1&perPage=15", value = "URL of the first page.")
	public String getFirst() {
		return first;
	}

	@ApiModelProperty(example = "https://services.circulodecredito.com.mx/v1/subscriptions?page=6&perPage=15", value = "URL of the previous page.")
	public String getPrevious() {
		return previous;
	}

	@ApiModelProperty(example = "https://services.circulodecredito.com.mx/v1/subscriptions?page=8&perPage=15", value = "URL of the next page.")
	public String getNext() {
		return next;
	}

	@ApiModelProperty(example = "https://services.circulodecredito.com.mx/v1/subscriptions?page=12&perPage=15", value = "URL of the last page.")
	public String getLast() {
		return last;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Links links = (Links) o;
		return Objects.equals(this.self, links.self) && Objects.equals(this.first, links.first)
				&& Objects.equals(this.previous, links.previous) && Objects.equals(this.next, links.next)
				&& Objects.equals(this.last, links.last);
	}

	@Override
	public int hashCode() {
		return Objects.hash(self, first, previous, next, last);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Links {\n");

		sb.append("    self: ").append(toIndentedString(self)).append("\n");
		sb.append("    first: ").append(toIndentedString(first)).append("\n");
		sb.append("    previous: ").append(toIndentedString(previous)).append("\n");
		sb.append("    next: ").append(toIndentedString(next)).append("\n");
		sb.append("    last: ").append(toIndentedString(last)).append("\n");
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
