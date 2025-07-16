package com.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
    private final TestContext testContext;
    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }


    @Before
    public void setUp(){
        System.out.println("Before scenario hook executed.");
    }
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) testContext.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (WebDriverException e) {
                System.err.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
        testContext.quitDriver(); // Quit the driver after each scenario
        System.out.println("After scenario hook executed.");
    }
}
