package com.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailTbx = By.cssSelector("input[data-qa='login-email']");
    private final By passwordTbx = By.cssSelector("input[data-qa='login-password']");
    private final By loginBtn = By.cssSelector("button[data-qa='login-button']");
    private final By loginMessage = By.cssSelector("div.login-form p");

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void enterEmail(String email){
        inputText(emailTbx,email);
    }
    public void enterPassword(String password){
        inputText(passwordTbx, password);
    }
    public void clickLoginBtn(){
        clickElement(loginBtn);
    }
    public String getLoginStatus(){
        return getText(loginMessage);
    }
}
