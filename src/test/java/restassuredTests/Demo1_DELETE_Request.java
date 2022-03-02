package restassuredTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*; // static package
import static org.hamcrest.Matchers.*; // static package

public class Demo1_DELETE_Request {
	
	int empID = 2;
	
	@BeforeMethod
	public void deleteDatePrerequisites() {		
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "api/users/" + empID;		
	}
	
	@Test
	public void deleteData() {
		Response myResponse =
		given()
			//.contentType("application/json")	--> As nothing in the request body
		.when()
			.delete()
		.then()
			.statusCode(204)
			.statusLine("HTTP/1.1 204 No Content")
			.log().all()
			.extract().response();	// Returns the full response to 'myResponse'
		
		String jsonAsString = myResponse.asString();
		Assert.assertEquals(jsonAsString.contains(""), true);
		
	}

}