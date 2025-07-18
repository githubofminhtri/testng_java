package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By emailTbx = By.cssSelector("input[data-qa='login-email']");
    private final By passwordTbx = By.cssSelector("input[data-qa='login-password']");
    private final By loginBtn = By.cssSelector("button[data-qa='login-button']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterEmail(String email){
        driver.findElement(emailTbx).sendKeys(email);
    }
    public void enterPassword(String password){
        driver.findElement(passwordTbx).sendKeys(password);
    }
    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }
    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }
}
