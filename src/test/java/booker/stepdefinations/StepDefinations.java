package booker.stepdefinations;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import booker.resource.APIResource;
import booker.resource.TestBuildDatas;
import booker.resource.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinations extends Utils {

	RequestSpecification reqPayload;
	Response response;
	String token;
	public static int bookingId;

	@Given("Create Booking Payload with {string} {string} {int} {string}")
	public void create_booking_payload_with(String firstname, String lastname, int totalprice, String depositpaid)
			throws Exception {
		reqPayload = given().spec(requestSpecification()).body(
				TestBuildDatas.createBookingPayload
				(firstname, lastname, totalprice, Boolean.valueOf(depositpaid)));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {
		APIResource resrc = APIResource.valueOf(resource);

		if (httpMethod.equalsIgnoreCase("POST"))
			response = reqPayload.when().post(resrc.getResource());
		else if (httpMethod.equalsIgnoreCase("GET"))
			response = reqPayload.when().get(resrc.getResource());
		else if (httpMethod.equalsIgnoreCase("PUT"))
			response = reqPayload.when().put(resrc.getResource());
		else if (httpMethod.equalsIgnoreCase("DELETE"))
			response = reqPayload.when().delete(resrc.getResource());
	}

	@Then("API call is success with status code {int}")
	public void api_call_is_success_with_status_code(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);

	}

	@Then("verify the bookingid created maps to {string} with {string}")
	public void verify_the_bookingid_created_maps_to_with(String firstname, String resource) throws Exception {
		bookingId = Integer.parseInt(getJsonPath(response, "bookingid"));
		reqPayload = given().spec(requestSpecification()).pathParam("id", bookingId);
		user_calls_with_http_request(resource, "Get");
		String firstnm = getJsonPath(response, "firstname");
		Assert.assertEquals(firstnm, firstname);
	}

	@Given("Create token Payload using {string} with {string} http request")
	public void createTokenPayload(String apiName, String requestType) throws Exception {
		reqPayload = given().spec(requestSpecification()).body(TestBuildDatas.tokenPayload());
		user_calls_with_http_request(apiName, requestType);
		token = getJsonPath(response, "token");
	}

	@Given("Update Booking Payload with {string} {string} {int} {string}")
	public void updateBookingPayload(String firstname, String lastname, int totalprice, String depositpaid) throws Exception {
		reqPayload = given().spec(requestSpecification()).header("Cookie",token)
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.pathParam("id", bookingId)
				.body(TestBuildDatas.updateBookingPayload
						(firstname, lastname, totalprice, Boolean.valueOf(depositpaid)));
	}
	@Given("Delete Booking Payload")
	public void deleteBookingPayload() throws Exception {
		reqPayload = given().spec(requestSpecification()).header("Cookie",token)
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.pathParam("id", bookingId);
	}
}
