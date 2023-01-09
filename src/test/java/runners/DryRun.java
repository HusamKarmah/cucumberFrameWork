package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="./src/test/resources/features", 
		glue="step_definitions",
		dryRun=true, //dryRun true means, cucumber runs the scenario steps that have not been implemented
		tags=" @amazonSearchTests" 
		)


public class DryRun {
	

}
