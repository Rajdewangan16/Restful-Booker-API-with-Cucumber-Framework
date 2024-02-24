package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\booker\\featureFile",
				glue = {"booker.stepdefinations" , "booker.hooks"},
				plugin = {"pretty","html:target\\index.html"})
public class TestRunner {

}
