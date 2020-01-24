package hooks;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@ui, @api",
        features = "src/test/resource"
        , glue = {"stepDefinitions"}
)

public class TestRunner {

}