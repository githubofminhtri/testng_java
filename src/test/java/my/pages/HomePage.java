package my.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    // 1. Locators
    private final By homeSignUpBtn = By.cssSelector("a[href='/login']");
    private final By loggedInLabel = By.cssSelector("ul.nav.navbar-nav > li:last-child");
    private final By deleteAccountHyperLink = By.cssSelector("ul.nav.navbar-nav > li > a[href='/delete_account']");
    private final By deleteAccountLabel = By.cssSelector("h2[data-qa='account-deleted']>b");
    private final By continueBtn = By.cssSelector("a[data-qa='continue-button']");
    // 2. Constructor
    public HomePage (WebDriver driver){
        this.driver = driver;

    }
    // 3. Actions
    public void clickSignUpBtn(){
        driver.findElement(homeSignUpBtn).click();
    }
    public String getLoggedInLabel(){
        return driver.findElement(loggedInLabel).getText();
    }
    public void clickDeleteAccountHyperLink(){
        driver.findElement(deleteAccountHyperLink).click();
    }
    public String getDeleteAccountLabel(){
        return driver.findElement(deleteAccountLabel).getText();
    }
    public void clickContinueBtn(){
        driver.findElement(continueBtn).click();
    }
}

