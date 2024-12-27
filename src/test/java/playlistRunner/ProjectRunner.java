package playlistRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	
		
		// need changes added 
		features= {"src\\test\\resources\\SpotifyFeature"}, 
		
		glue= {"steps,hooks"},
		
		plugin= {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
				
		publish = true
		)

public class ProjectRunner extends AbstractTestNGCucumberTests {

}
