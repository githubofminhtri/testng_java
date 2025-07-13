package my.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import my.pages.HomePage;
import my.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestContext {
    public WebDriver driver;
    public HomePage homePage;
    public SignUpPage signUpPage;
    public String browserType = System.getProperty("browser", "chrome"); //default value


    public TestContext(){
        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: "+browserType);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void quitDriver(){
        if (driver != null){
            driver.quit();
        }
    }
}
