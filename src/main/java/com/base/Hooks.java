package com.base;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private final TestContext testContext;
    private final Logger logger;
    public Hooks(TestContext testContext){
        this.testContext = testContext;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }


    @Before
    public void setUp(){
        this.logger.info("Before scenario hook executed.");
    }
    @AfterStep
    public void takeScreenShoot(Scenario scenario) {
        if(scenario.isFailed()){
            this.logger.error("Step failed");
            byte[] screenshot = ((TakesScreenshot) testContext.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","Failed!!!");
        }
    }
    @After
    public void tearDown() {
        testContext.quitDriver(); // Quit the driver after each scenario
        this.logger.info("After scenario hook executed.");
    }
}
