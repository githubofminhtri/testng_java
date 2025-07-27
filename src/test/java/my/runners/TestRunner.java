package my.runners;
import io.cucumber.java.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

// A static ThreadLocal to pass browser info from TestNG to Cucumber Hooks

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"my.steps","com.base"},
        plugin = {
                "pretty",
//                "html:target/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "not @Parallel"
)

public class TestRunner extends AbstractTestNGCucumberTests {
        private Logger logger = LoggerFactory.getLogger(TestRunner.class);
        @Override
        @DataProvider(parallel = true) // Enable parallel execution of scenarios
        public Object[][] scenarios() {
                return super.scenarios();
        }

        @BeforeTest
        @Parameters("browser")
        public void beforeTest(String browser){
                this.logger.info("Before Test TestNG - Thread {} - Browser {}", Thread.currentThread().getId(), browser);
                System.setProperty("browser.type", browser);

        }

        @AfterTest
        public void afterTest(){
                this.logger.info("after test testNG - Thread {}", Thread.currentThread().getId());
        }
}