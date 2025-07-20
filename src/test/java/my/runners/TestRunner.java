package my.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = {"my.steps", "com.base"},             // Package where your step definitions are located
        plugin = {
                "pretty",                             // Prints Gherkin steps to console
                "html:target/cucumber-reports/cucumber-html-report.html", // Generates HTML report
                "json:target/cucumber-reports/cucumber.json",           // Generates JSON report
                "rerun:target/failed_scenarios.txt",                    // Generates a file for failed scenarios
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // For ExtentReports
        },
        monochrome = true,                        // Makes console output more readable
        tags = ""                 // Run scenarios tagged with @Login OR @Smoke (optional)
)
@RunWith(Cucumber.class)
public class TestRunner {

}
