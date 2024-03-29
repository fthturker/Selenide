package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
        },
        monochrome = true,
        features = "./src/test/resources/features",
        glue={"stepdefinitions"},
        tags="@scrollwithjs",
        dryRun = false
)
public class Runners {

}
