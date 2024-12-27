package steps;

import java.util.List;
import java.util.Map;
import AuthManager.TokenGenerator;
import Utility.SpecBuilder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;


  public class SearchSteps {

	    RequestSpecification Res;
	    Response response;
	    
	@Given("Get a search track payload")
	public void get_a_search_track_payload(DataTable dataTable) {

      List<Map<String, String>> completeData = dataTable.asMaps();
      Map<String, String> Value = completeData.get(0);
      String nameofsong = Value.get("songname");
      String type = Value.get("track");
      
      Res = given(SpecBuilder.reqSpec(TokenGenerator.reNewToken()))
				.queryParams("q", nameofsong,"type",type);     
	}

	@When("User call will GET request")
	public void user_call_will_get_request() {
	
		 response = Res.when()
		.get("search");
	}

	@Then("API executes with Status code {int}")
	public void api_executes_with_status_code(Integer int1) {
		response.then()
		.spec(SpecBuilder.resSpec())
		.assertThat()
		.statusCode(int1);
	}

}
