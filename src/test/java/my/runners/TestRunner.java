package my.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"my.steps","com.base"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@Login"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}