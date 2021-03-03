package com.taydavid.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * POJO to model login response
 * 
 * JSON Sample:
 * 
 * { 
 * "firstName": "Ian", 
 * "userId": 9114917, 
 * "userUuid": "34c16f53-38c4-461a-bd14-11fa748d2663", 
 * "authenticationLevel": "FULL",
 * "actorIds": [ 9096778 ], 
 * "loanApplications": [], 
 * "loansInReview": [ 
 * { "id": 9545966, "uuid": "230ea84a-7199-41c9-bf38-fff27e35970d", "status":
 * "WITHDRAWN", "productType": "PERSONAL_LOAN", "hasOpenBackendCounter": false,
 * "purpose": "CREDIT_CARD", "createDate": "2019-08-21T18:18:59.959Z",
 * "postIssuanceStatus": null, "addon": null } ], 
 * "loanAccountSummaryAto": [ {
 * "loanAccountNumber": null, "postIssuanceLoanStatus": null, "daysPastDue": 0,
 * "loanProductType": null } ] 
 * }
 * 
 * @author tayda
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "firstName", "userId", "userUuid", "authenticationLevel", "actorIds", "loanApplications",
		"loansInReview", "loanAccountSummaryAto" })
public class LoginResponse {

	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("userId")
	private Integer userId;
	@JsonProperty("userUuid")
	private String userUuid;
	@JsonProperty("authenticationLevel")
	private String authenticationLevel;
	@JsonProperty("actorIds")
	private List<Integer> actorIds = null;
	@JsonProperty("loanApplications")
	private List<Object> loanApplications = null;
	@JsonProperty("loansInReview")
	private List<LoansInReview> loansInReview = null;
	@JsonProperty("loanAccountSummaryAto")
	private List<LoanAccountSummaryAto> loanAccountSummaryAto = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("userId")
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@JsonProperty("userUuid")
	public String getUserUuid() {
		return userUuid;
	}

	@JsonProperty("userUuid")
	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	@JsonProperty("authenticationLevel")
	public String getAuthenticationLevel() {
		return authenticationLevel;
	}

	@JsonProperty("authenticationLevel")
	public void setAuthenticationLevel(String authenticationLevel) {
		this.authenticationLevel = authenticationLevel;
	}

	@JsonProperty("actorIds")
	public List<Integer> getActorIds() {
		return actorIds;
	}

	@JsonProperty("actorIds")
	public void setActorIds(List<Integer> actorIds) {
		this.actorIds = actorIds;
	}

	@JsonProperty("loanApplications")
	public List<Object> getLoanApplications() {
		return loanApplications;
	}

	@JsonProperty("loanApplications")
	public void setLoanApplications(List<Object> loanApplications) {
		this.loanApplications = loanApplications;
	}

	@JsonProperty("loansInReview")
	public List<LoansInReview> getLoansInReview() {
		return loansInReview;
	}

	@JsonProperty("loansInReview")
	public void setLoansInReview(List<LoansInReview> loansInReview) {
		this.loansInReview = loansInReview;
	}

	@JsonProperty("loanAccountSummaryAto")
	public List<LoanAccountSummaryAto> getLoanAccountSummaryAto() {
		return loanAccountSummaryAto;
	}

	@JsonProperty("loanAccountSummaryAto")
	public void setLoanAccountSummaryAto(List<LoanAccountSummaryAto> loanAccountSummaryAto) {
		this.loanAccountSummaryAto = loanAccountSummaryAto;
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
