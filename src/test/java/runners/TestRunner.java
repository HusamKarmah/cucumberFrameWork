package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// using plugin line here to generate a report after running the test
		plugin = {"pretty", "html:Reports/htmlReport.html", "json:Reports/jsonReport.json"},
		features="./src/test/resources/features", 
		glue="step_definitions",
		tags="@amazonSearchTests", 
		publish=true
		)
public class TestRunner {
	
	

}
