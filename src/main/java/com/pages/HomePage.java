package com.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // 1. Locators
    private final By homeSignUpBtn = By.cssSelector("a[href='/login']");
    private final By loggedInLabel = By.cssSelector("ul.nav.navbar-nav > li:last-child > a");
    private final By deleteAccountHyperLink = By.cssSelector("ul.nav.navbar-nav > li > a[href='/delete_account']");
    private final By deleteAccountLabel = By.cssSelector("h2[data-qa='account-deleted']>b");
    private final By continueBtn = By.cssSelector("a[data-qa='continue-button']");
    private final By logOutBtn = By.cssSelector("a[href='/logout']");
    // 2. Constructor
    public HomePage (WebDriver driver){
       super(driver);

    }
    // 3. Actions
    public void clickSignUpBtn(){
        clickElement(homeSignUpBtn);
    }
    public String getLoggedInLabel(){
        return getText(loggedInLabel);
    }
    public void clickDeleteAccountHyperLink(){
        clickElement(deleteAccountHyperLink);
    }
    public String getDeleteAccountLabel(){
        return getText(deleteAccountLabel);
    }
    public void clickContinueBtn(){
        clickElement(continueBtn);
    }
    public void clickLogOutBtn(){
        clickElement(logOutBtn);
    }
}

