package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Features/Customer.feature"},
		glue = {"StepDefintions"},
		monochrome =false
//		tags = {"@SmokeTest"}
		)


public class AmazonTest {

}
