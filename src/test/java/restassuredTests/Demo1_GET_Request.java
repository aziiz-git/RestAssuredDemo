package restassuredTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;				// For RestAssured.baseURI & RestAssured.basePath

import static io.restassured.RestAssured.*;		// static package
import static org.hamcrest.Matchers.*;			// static package

public class Demo1_GET_Request {
	
	@BeforeMethod
	public void getDataPrerequisites() {		
		RestAssured.baseURI = "https://reqres.in";	// This would be 'get' automatically
		RestAssured.basePath = "/api/users/2";		// This would be 'get' automatically	
	}
	
	@Test
	public void getData() {
		given().
		when().
			get().
		then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("data.first_name", equalTo("Janet"))
			.assertThat().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
			.header("Content-Type", "application/json; charset=utf-8")
			.header("Connection", "keep-alive");
	}

}