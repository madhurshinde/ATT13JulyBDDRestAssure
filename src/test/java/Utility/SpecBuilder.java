package Utility;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

	@Step   // to log in the Assured
	public static RequestSpecification reqSpec(String token) {
		
		//Request Body 
		return new RequestSpecBuilder()
	
		.setBaseUri("https://api.spotify.com")
		.setBasePath("/v1")
		
		.addHeader("Content-Type", "application/json")
		
		.addHeader("Authorization", "Bearer "+token)
		
		.addFilter(new AllureRestAssured())   //allure 	
		 
		.log(LogDetail.ALL)
		
		.build();
	}
	
	@Step   // to log in the Assured
	public static ResponseSpecification resSpec() {
		
	     return new ResponseSpecBuilder()
	
		// Response Body 
		.expectContentType(ContentType.JSON)
		
		.log(LogDetail.ALL)
		
		 .build();
	}
}
