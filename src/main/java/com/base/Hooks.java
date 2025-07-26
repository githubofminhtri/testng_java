package com.base;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;

public class Hooks {
    private final TestContext testContext;
    private final Logger logger;
    public Hooks(TestContext testContext){
        this.testContext = testContext;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }


    @Before(order = 1)
    public void setUp(){
        this.logger.info("Before scenario hook executed - Thread {}", Thread.currentThread().getId());
    }
//    @AfterStep
//    public void takeScreenShoot(Scenario scenario) {
//        if(scenario.isFailed()){
//            this.logger.error("Step failed");
//            byte[] screenshot = ((TakesScreenshot) testContext.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot,"image/png","Failed!!!");
//        }
//    }
    @AfterStep
    public void takeScreenShoot(Scenario scenario){
        this.logger.info("Scenario {} - Status: {}",scenario.getName(), scenario.getStatus());
        byte[] screenshot = ((TakesScreenshot) testContext.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png",scenario.getStatus().toString());
    }

    @After
    public void tearDown(Scenario scenario) {
        testContext.quitDriver(); // Quit the driver after each scenario
        this.logger.info("After scenario hook executed - Thread {} - Scenario {}", Thread.currentThread().getId(), scenario.getName());
    }

}