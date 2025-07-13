package my.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CommonHooks {
    private final TestContext testContext;
    public CommonHooks (TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void setUpBrowser(){
//        if (testContext.browserType.equalsIgnoreCase("chrome")){
//            WebDriverManager.chromedriver().setup();
//            testContext.driver = new ChromeDriver();
//        } else {
//            throw new IllegalArgumentException("Unsupported browser: "+ testContext.browserType);
//        }
//        testContext.driver.manage().window().maximize();
//        testContext.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Setup Browser");
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            // Take a screenshot if the scenario fails
            byte[] screenshot = ((TakesScreenshot) testContext.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot for " + scenario.getName());
        }
        testContext.quitDriver(); // Quit the WebDriver
    }
}
