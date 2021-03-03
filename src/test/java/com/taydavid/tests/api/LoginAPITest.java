package com.taydavid.tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.taydavid.pojo.LoginRequest;
import com.taydavid.pojo.LoginResponse;
import com.taydavid.tests.BaseAPITest;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;

/**
 * Upgrade exposes a login API for registered users, that should provide a 200
 * response if credentials are valid. And a 401 response if the credentials are
 * invalid. The API endpoint is available at:
 * https://credapi.credify.tech/api/brportorch/v2/login
 * 
 * @author tayda
 *
 */
public class LoginAPITest extends BaseAPITest {

	private ObjectMapper mObjectMapper = new ObjectMapper();
	private static final String LOGIN_ENDPOINT = "https://credapi.credify.tech/api/brportorch/v2/login";

	@Test
	public void testLoginPost200() throws IOException {
		final LoginRequest req = mObjectMapper
				.readValue(new File("src/test/resources/requests/login_request_valid.json"), LoginRequest.class);
		final Response res = given().contentType("application/json").headers(mHeaderMap).body(req).when()
				.post(LOGIN_ENDPOINT);
		Assert.assertEquals(res.statusCode(), 200);

		final LoginResponse loginRes = res.as(LoginResponse.class);
		Assert.assertNotNull(loginRes.getLoansInReview(), "Loans in review field was null or non-existant");
		Assert.assertTrue(loginRes.getLoansInReview().size() > 0, "Loans in review was size 0");
		loginRes.getLoansInReview().forEach(loans -> Assert.assertEquals(loans.getProductType(), "PERSONAL_LOAN"));
	}

	@Test
	public void testLoginPost401() throws IOException {
		final LoginRequest req = mObjectMapper
				.readValue(new File("src/test/resources/requests/login_request_invalid.json"), LoginRequest.class);
		final Response res = given().contentType("application/json").headers(mHeaderMap).body(req).when()
				.post(LOGIN_ENDPOINT);
		Assert.assertEquals(res.statusCode(), 401);
	}

}
