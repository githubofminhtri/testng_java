package com.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import org.slf4j.Logger;

public class TestContext {
    @Getter
    private final WebDriver driver;
    private final String browserType = System.getProperty("browser.type", "chrome"); //default value
    private final Logger logger = LoggerFactory.getLogger(TestContext.class);
    public TestContext(){
        this.logger.info("Browser Name {}",this.browserType);
        WebDriver webDriver = null;
        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new"); // Preferred for modern Chrome
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080"); // Set a consistent window size for testing
                webDriver = new ChromeDriver(options);
                break;
            case "safari":
                webDriver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: "+browserType);
        }
        this.driver = webDriver;
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void quitDriver(){
        if (this.driver != null){
            this.driver.quit();
        }
    }
}
