package my.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // 1. Locators
    private By homeSignUpBtn = By.cssSelector("a[href='/login']");

    // 2. Constructor
    public HomePage (WebDriver driver){
        this.driver = driver;

    }
    // 3. Actions
    public void clickSignUpBtn(){
        driver.findElement(homeSignUpBtn).click();
    }
}

