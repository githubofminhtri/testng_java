package com.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestContext {
    @Getter
    private final WebDriver driver;
    public String browserType = System.getProperty("browser", "chrome"); //default value

    public TestContext(){
        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new"); // Preferred for modern Chrome
            // options.addArguments("--headless"); // Also works for the default headless behavior
            // options.addArguments("--disable-gpu"); // Sometimes recommended for older headless Chrome,
            // less necessary now but can still be included.
            options.addArguments("--window-size=1920,1080"); // Set a consistent window size for testing
            driver = new ChromeDriver(options);
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
