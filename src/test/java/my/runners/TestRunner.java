package my.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "my.steps",             // Package where your step definitions are located
        plugin = {
                "pretty",                             // Prints Gherkin steps to console
                "html:target/cucumber-reports/cucumber-html-report.html", // Generates HTML report
                "json:target/cucumber-reports/cucumber.json",           // Generates JSON report
                "rerun:target/failed_scenarios.txt",                    // Generates a file for failed scenarios
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // For ExtentReports
        },
        monochrome = true,                        // Makes console output more readable
        tags = "@Signup or @Smoke"                 // Run scenarios tagged with @Login OR @Smoke (optional)
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
