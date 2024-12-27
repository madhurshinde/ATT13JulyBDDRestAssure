package AuthManager;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TokenGenerator {

//	@Test
	public static String reNewToken() {
		
		HashMap<String,String> param =new HashMap<String,String>(); 
		
		param.put("grant_type", "refresh_token");
		param.put("refresh_token", "AQB_Cnq39teWrUlTa7fiIdcsfZ0ldmtpviIXL3VoptjA1wIKQenrU5dP7eH23BY9kdQZXelDp9DdIFh1N61zSv98vrujuXKWXrhctebFZzd_M-CLLmNvuedQy6E8l4Eau6Q");
		param.put("client_id", "a524ab94fbba4776bcdd6ac4d4b9cefb");
		param.put("client_secret", "85645d1bf1e842108204629db6f39656");
	
		RestAssured.baseURI= "https://accounts.spotify.com";
		Response Response = given()
		
		.header("Content-Type","application/x-www-form-urlencoded")
		
		.formParams(param)
		
		.when()
		
		.post("/api/token")
		
		.then().extract().response();
		
		JsonPath js = Response.jsonPath();
		String token = js.getString("access_token");
		
		System.out.println("Access Tokan "+ token);
	
	
	if(Response.statusCode()!=200) {
	 throw new RuntimeException("Failed to generate access token");	
		
	}
	return token;
	}
}
