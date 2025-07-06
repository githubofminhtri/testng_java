package my.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser name: "+ browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.automationexercise.com/");
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
