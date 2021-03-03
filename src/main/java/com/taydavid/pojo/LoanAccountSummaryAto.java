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
@JsonPropertyOrder({ "loanAccountNumber", "postIssuanceLoanStatus", "daysPastDue", "loanProductType" })
public class LoanAccountSummaryAto {

	@JsonProperty("loanAccountNumber")
	private Object loanAccountNumber;
	@JsonProperty("postIssuanceLoanStatus")
	private Object postIssuanceLoanStatus;
	@JsonProperty("daysPastDue")
	private Integer daysPastDue;
	@JsonProperty("loanProductType")
	private Object loanProductType;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("loanAccountNumber")
	public Object getLoanAccountNumber() {
		return loanAccountNumber;
	}

	@JsonProperty("loanAccountNumber")
	public void setLoanAccountNumber(Object loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	@JsonProperty("postIssuanceLoanStatus")
	public Object getPostIssuanceLoanStatus() {
		return postIssuanceLoanStatus;
	}

	@JsonProperty("postIssuanceLoanStatus")
	public void setPostIssuanceLoanStatus(Object postIssuanceLoanStatus) {
		this.postIssuanceLoanStatus = postIssuanceLoanStatus;
	}

	@JsonProperty("daysPastDue")
	public Integer getDaysPastDue() {
		return daysPastDue;
	}

	@JsonProperty("daysPastDue")
	public void setDaysPastDue(Integer daysPastDue) {
		this.daysPastDue = daysPastDue;
	}

	@JsonProperty("loanProductType")
	public Object getLoanProductType() {
		return loanProductType;
	}

	@JsonProperty("loanProductType")
	public void setLoanProductType(Object loanProductType) {
		this.loanProductType = loanProductType;
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
