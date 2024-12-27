package steps;

import java.time.LocalDate;
import java.time.LocalTime;
import org.testng.Assert;
import com.spotify.pojo.Playlist;
import AuthManager.TokenGenerator;
import Utility.SpecBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class PlayListSteps {

	static String playlistID; ///static to store information pemanatly
	RequestSpecification Res;
	Response Response ;
	
	@Given("Create Playlist Api Playload")
	public void create_playlist_Api_Playload() {

		LocalDate date =LocalDate.now();
		LocalTime time =LocalTime.now();

		Playlist Reqplaylist= new Playlist();   //create pojo class object and call setter method	
		Reqplaylist.setName("13 july pojo playlist"+date+"_"+time);
		Reqplaylist.setDescription("This is test playlist With BDD Approch");
		Reqplaylist.setPublic(false);
		
		 Res = given(SpecBuilder.reqSpec(TokenGenerator.reNewToken()))
			  .body(Reqplaylist);
	}
	
	@When("User call with Post Http request")
	public void user_call_with_post_http_request() {
	
	 Response = Res.when()
			   .post("users/31d2nmyj3svxqcrcai6nhct6edgu/playlists");
	}
	
	@Then("API call executed with status Code {int}")
	public void api_call_executed_with_status_code(Integer int1) {
		
		 Playlist resPlaylist = Response.as(Playlist.class);
		 //Get pla
		 String nameOfPlaylist = resPlaylist.getName();  // get playlistname
		 System.out.println(nameOfPlaylist);			
		 
		 playlistID = resPlaylist.getId();				//get playlist ID
		 System.out.println(playlistID);
		 
		 Response.then()
		 .assertThat()
		 .statusCode(int1);
	}
	
	@Given("get a playlist payload")
	public void get_a_playlist_payload() {
		
	Res =given(SpecBuilder.reqSpec(TokenGenerator.reNewToken()))
	.pathParam("pathprm", playlistID);     // globally declare 
										  //and use previous method output which is playlist id 
	}
	
	@When("User call with GET http request")
	public void user_call_with_get_http_request() {
	
		Response =	Res.when()
		.get("playlists/{pathprm}");
	}
	
	@Then("Api call executed Status Code {int}")
	public void api_call_executed_status_code(Integer int1) {

		 Response.then()
		.spec(SpecBuilder.resSpec());
		 System.out.println(Response.statusCode());
		 Assert.assertEquals(Response.statusCode(), int1);	
	}
	
	@Given("Update playlist api payload")
	public void update_playlist_api_payload() {
	
	Playlist Reqplaylist= new Playlist();    				//create pojo class object and call setter method
		
		LocalDate date =LocalDate.now();
		LocalTime time =LocalTime.now();

		Reqplaylist.setName("Updated 13 july playlist"+date+"_"+time);
		Reqplaylist.setDescription("This is test playlist With BDD Approch");
		Reqplaylist.setPublic(false);

		 Res = given(SpecBuilder.reqSpec(TokenGenerator.reNewToken()))
				.body(Reqplaylist);
		
	}
	
	@When("User call with PUT http request")
	public void user_call_with_put_http_request() {
	
		Response =Res.when()
		.put("playlists/"+playlistID);
		System.out.println(playlistID);
	}
	
	@Then("API call should executes with Status code {int}")
	public void api_call_should_executes_with_status_code(Integer int1) {
	
		Response.then()
		.assertThat()
		.statusCode(int1);
		System.out.println(Response.statusCode());
		System.out.println(int1);
	}
	}
