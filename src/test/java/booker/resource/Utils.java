package booker.resource;

import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	private static RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws Exception {
		
		if(req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
			req = new RequestSpecBuilder()
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.addHeader("Content-Type", "application/json")
					.addHeader("Accept", "application/json").build();
			return req;
		}
		return req;
	}
	
	public String getJsonPath(Response resp, String key) {
		String response = resp.asString();
		JsonPath js = new JsonPath(response);
		return js.get(key).toString();
	}
}