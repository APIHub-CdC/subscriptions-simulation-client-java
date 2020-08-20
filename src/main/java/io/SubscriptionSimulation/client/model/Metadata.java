package io.SubscriptionSimulation.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Pagination information.")

public class Metadata {
	@SerializedName("page")
	private Integer page = null;
	@SerializedName("perPage")
	private Integer perPage = null;
	@SerializedName("pageCount")
	private Integer pageCount = null;
	@SerializedName("totalCount")
	private Integer totalCount = null;
	@SerializedName("links")
	private Links links = null;

	@ApiModelProperty(example = "7", value = "Current page.")
	public Integer getPage() {
		return page;
	}

	@ApiModelProperty(example = "15", value = "Rows per page.")
	public Integer getPerPage() {
		return perPage;
	}

	@ApiModelProperty(example = "12", value = "Total number of pages.")
	public Integer getPageCount() {
		return pageCount;
	}

	@ApiModelProperty(example = "175", value = "Total number of rows.")
	public Integer getTotalCount() {
		return totalCount;
	}

	public Metadata links(Links links) {
		this.links = links;
		return this;
	}

	@ApiModelProperty(value = "")
	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Metadata metadata = (Metadata) o;
		return Objects.equals(this.page, metadata.page) && Objects.equals(this.perPage, metadata.perPage)
				&& Objects.equals(this.pageCount, metadata.pageCount)
				&& Objects.equals(this.totalCount, metadata.totalCount) && Objects.equals(this.links, metadata.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(page, perPage, pageCount, totalCount, links);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Metadata {\n");

		sb.append("    page: ").append(toIndentedString(page)).append("\n");
		sb.append("    perPage: ").append(toIndentedString(perPage)).append("\n");
		sb.append("    pageCount: ").append(toIndentedString(pageCount)).append("\n");
		sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
		sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
