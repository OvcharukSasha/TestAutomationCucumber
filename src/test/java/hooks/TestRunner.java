package hooks;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@ui, @api",
        features = "src/test/resource"
        , glue = {"stepDefinitions"}
        , strict = true, format = {
        "pretty", "html:target/cucumber", "json:target/cucumber/report.json", "junit:target/cucumber/junit.xml"}
)

public class TestRunner {

}