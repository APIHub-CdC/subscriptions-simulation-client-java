package io.SubscriptionSimulation.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.threeten.bp.OffsetDateTime;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "The information about your event acknowledge.")

public class Errors {
	@SerializedName("acknowledgeId")
	private UUID acknowledgeId = null;
	@SerializedName("eventId")
	private UUID eventId = null;
	@SerializedName("dateTime")
	private OffsetDateTime dateTime = null;
	@SerializedName("errors")
	private List<Error> errors = null;

	public Errors acknowledgeId(UUID acknowledgeId) {
		this.acknowledgeId = acknowledgeId;
		return this;
	}

	@ApiModelProperty(example = "627aa72a-c799-4abf-b98e-0c4838af9bd5", required = true, value = "The identifier of your acknowledge (UUID).")
	public UUID getAcknowledgeId() {
		return acknowledgeId;
	}

	public void setAcknowledgeId(UUID acknowledgeId) {
		this.acknowledgeId = acknowledgeId;
	}

	public Errors eventId(UUID eventId) {
		this.eventId = eventId;
		return this;
	}

	@ApiModelProperty(example = "4fc07667-b928-4a5c-a9d4-e18d3d515d24", required = true, value = "The identifier of the API Hub notification event you got in the request (UUID).")
	public UUID getEventId() {
		return eventId;
	}

	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}

	public Errors dateTime(OffsetDateTime dateTime) {
		this.dateTime = dateTime;
		return this;
	}

	@ApiModelProperty(example = "2020-04-12T22:20:50.52Z", required = true, value = "Date and time of your acknowledge.")
	public OffsetDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(OffsetDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Errors errors(List<Error> errors) {
		this.errors = errors;
		return this;
	}

	public Errors addErrorsItem(Error errorsItem) {
		if (this.errors == null) {
			this.errors = new ArrayList<Error>();
		}
		this.errors.add(errorsItem);
		return this;
	}

	@ApiModelProperty(value = "List of errors.")
	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Errors errors = (Errors) o;
		return Objects.equals(this.acknowledgeId, errors.acknowledgeId) && Objects.equals(this.eventId, errors.eventId)
				&& Objects.equals(this.dateTime, errors.dateTime) && Objects.equals(this.errors, errors.errors);
	}

	@Override
	public int hashCode() {
		return Objects.hash(acknowledgeId, eventId, dateTime, errors);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Errors {\n");

		sb.append("    acknowledgeId: ").append(toIndentedString(acknowledgeId)).append("\n");
		sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
		sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
		sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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
