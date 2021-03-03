package com.taydavid.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "uuid", "status", "productType", "hasOpenBackendCounter", "purpose", "createDate",
		"postIssuanceStatus", "addon" })
public class LoansInReview {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("uuid")
	private String uuid;
	@JsonProperty("status")
	private String status;
	@JsonProperty("productType")
	private String productType;
	@JsonProperty("hasOpenBackendCounter")
	private Boolean hasOpenBackendCounter;
	@JsonProperty("purpose")
	private String purpose;
	@JsonProperty("createDate")
	private String createDate;
	@JsonProperty("postIssuanceStatus")
	private Object postIssuanceStatus;
	@JsonProperty("addon")
	private Object addon;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("uuid")
	public String getUuid() {
		return uuid;
	}

	@JsonProperty("uuid")
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("productType")
	public String getProductType() {
		return productType;
	}

	@JsonProperty("productType")
	public void setProductType(String productType) {
		this.productType = productType;
	}

	@JsonProperty("hasOpenBackendCounter")
	public Boolean getHasOpenBackendCounter() {
		return hasOpenBackendCounter;
	}

	@JsonProperty("hasOpenBackendCounter")
	public void setHasOpenBackendCounter(Boolean hasOpenBackendCounter) {
		this.hasOpenBackendCounter = hasOpenBackendCounter;
	}

	@JsonProperty("purpose")
	public String getPurpose() {
		return purpose;
	}

	@JsonProperty("purpose")
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@JsonProperty("createDate")
	public String getCreateDate() {
		return createDate;
	}

	@JsonProperty("createDate")
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@JsonProperty("postIssuanceStatus")
	public Object getPostIssuanceStatus() {
		return postIssuanceStatus;
	}

	@JsonProperty("postIssuanceStatus")
	public void setPostIssuanceStatus(Object postIssuanceStatus) {
		this.postIssuanceStatus = postIssuanceStatus;
	}

	@JsonProperty("addon")
	public Object getAddon() {
		return addon;
	}

	@JsonProperty("addon")
	public void setAddon(Object addon) {
		this.addon = addon;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
