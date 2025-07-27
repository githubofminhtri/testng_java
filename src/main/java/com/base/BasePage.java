package com.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class BasePage {
    protected final WebDriver driver;
    protected Logger logger;
    private final Wait<WebDriver> fluentWait;
    private static int TIMEOUT = 10;
    private static int POLLING = 2;
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.fluentWait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(BasePage.TIMEOUT))
                .pollingEvery(Duration.ofSeconds(BasePage.POLLING))
                .ignoring(NoSuchElementException.class);
        this.logger = LoggerFactory.getLogger(this.getClass());
    }
    protected WebElement waitForVisibility(By locator){
        return this.fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected List<WebElement> waitForElementsVisibility(By locator){
        return this.fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected WebElement waitForClickable(By locator){
        WebElement element = waitForVisibility(locator);
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        return this.fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected WebElement waitUntil(Function<WebDriver, WebElement> condition){
        return this.fluentWait.until(condition);
    }
    protected void clickElement(By locator){
        waitForClickable(locator).click();
        logger.info("Clicking on element: {}",locator.toString());
    }
    protected void inputText(By locator, String args0){
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(args0);
        logger.info("Typing '{}' into element: {}",args0,locator.toString());
    }
    protected String getText(By locator){
        String text = waitForVisibility(locator).getText();
        logger.info("Text '{}' from element: {}",text, locator);
        return text;
    }
    protected void selectDdlRandom(By locator){
        Select select = new Select(waitForVisibility(locator));
        int numberOptions = select.getOptions().size();
        Random random = new Random();
        int randomNumber = random.nextInt(numberOptions);
        select.selectByIndex(randomNumber);
        logger.info("Select option {} in element: {}",randomNumber,locator.toString());
    }
    protected boolean elementIsDisplayed(By locator){
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException e){
            return false;
        }
    }
    protected boolean waitUntilPageLoadCompeletely(){
        return this.fluentWait.until((Function<WebDriver, Boolean>) wd ->{
            String readyState = (String) ((JavascriptExecutor) wd).executeScript("return document.readyState");
            logger.info("Page loaded completely");
            return "complete".equals(readyState);
        });
    }
    public String getCurrentUrl(){
        if(waitUntilPageLoadCompeletely()){
            return this.driver.getCurrentUrl();
        }
        return null;
    }
    protected void clickRandomElements(By locator){
        try{
            List<WebElement> elements = waitForElementsVisibility(locator);
            if(!elements.isEmpty()){
                Random random = new Random();
                int randomNumber = random.nextInt(elements.size());
                WebElement randomElement = elements.get(randomNumber);
                randomElement.click();
                logger.info("Select option {} in elements: {}",randomNumber, locator.toString());
            }
        } catch (TimeoutException e){
            logger.error("{}",e.getMessage());
        }

    }
}
