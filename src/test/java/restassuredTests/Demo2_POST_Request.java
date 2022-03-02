package restassuredTests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;		// static package
import static org.hamcrest.Matchers.*;			// static package

public class Demo2_POST_Request {
	
	public static HashMap<String, String> myMap = new HashMap<String, String>();
	
	@BeforeClass
	public void postDataPrerequisites() {		
		myMap.put("name", RestUtils.getName());
		myMap.put("job", RestUtils.getJob());
		
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users";
	}
	
	@Test
	public void postData() {
		
		Response myResponse =
		
		given()
			.contentType("application/json")
			.body(myMap)
		.when()
			.post()
		.then()
			.statusCode(201)
			.and()	// Optional
			.body("name", equalTo(myMap.get("name")))	// myMap.get("name") because API return is the same date which we posted
			.and()
			.body("job", equalTo(myMap.get("job")))	// myMap.get("job") because API return is the same date which we posted
			.extract().response();
		
		String jsonAsString = myResponse.asString();
		System.out.println(jsonAsString);
		Assert.assertEquals(jsonAsString.contains("createdAt"), true);
	}
}