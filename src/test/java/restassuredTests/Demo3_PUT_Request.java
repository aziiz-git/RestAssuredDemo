package restassuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*; // static package
import static org.hamcrest.Matchers.*; // static package

public class Demo3_PUT_Request {

	public static HashMap<String, String> myMap = new HashMap<String, String>();
	int empID = 2;

	@BeforeMethod
	public void putDataPrerequisites() {
		myMap.put("name", RestUtils.getName());
		myMap.put("job", RestUtils.getJob());
		
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users" + empID;
	}

	@Test
	public void putData() {
		given()
			.contentType("application/json")
			.body(myMap)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();	// Logs data in console
	}

}