package com.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class SignUpPage extends BasePage {

    // 1. Locators
    private final By signUpTxt = By.cssSelector("div.signup-form>h2");
    private final By nameTxb = By.cssSelector("form[action='/signup']>input[name='name']");
    private final By emailTxb = By.cssSelector("form[action='/signup']>input[name='email']");
    private final By signUpBtn = By.cssSelector("form[action='/signup']>button[data-qa='signup-button']");
    private final By step2HeaderTxt = By.cssSelector("div.login-form >h2>b");
    private final By genderRadioBtn = By.id("uniform-id_gender1");
    private final By passwordTxb = By.id("password");
    private final By selectDayDdl = By.id("days");
    private final By selectMonthDdl = By.id("months");
    private final By selectYearDdl = By.id("years");
    private final By newsletterCbx = By.id("newsletter");
    private final By specialOfferCbx = By.id("optin");
    private final By firstNameTxb = By.id("first_name");
    private final By lastNameTxb = By.id("last_name");
    private final By companyTxb = By.id("company");
    private final By address1Txb = By.id("address1");
    private final By address2Txb = By.id("address2");
    private final By selectCountryDdl = By.id("country");
    private final By stateTxb = By.id("state");
    private final By cityTxb = By.id("city");
    private final By zipcodeTxb = By.id("zipcode");
    private final By mobileNumberTxb = By.id("mobile_number");
    private final By createAccountBtn = By.cssSelector("button[data-qa='create-account']");
    private final By accountCreatedLabel = By.cssSelector("h2[data-qa='account-created'] > b");
    private final By continueBtn = By.cssSelector("a[data-qa='continue-button']");
    // 2. Constructor
    public SignUpPage(WebDriver driver){
        super(driver);
    }
    // 3. Actions
    public String getSignUpHeader(){
        return getText(signUpTxt);
    }
    public void enterName(String name){
        inputText(nameTxb,name);
    }
    public void enterEmail(String email){
       inputText(emailTxb, email);
    }
    public void clickSignUpBtn(){
        clickElement(signUpBtn);
    }
    public String getAccountInformationHeader(){
        return getText(step2HeaderTxt);
    }
    public void selectGender(){
        clickRandomElements(genderRadioBtn);
    }
    public void enterPassword(String password){
        inputText(passwordTxb,password);
    }
    public void selectDateOfBirth(){
        selectDdlRandom(selectDayDdl);
        selectDdlRandom(selectMonthDdl);
        selectDdlRandom(selectYearDdl);
    }
    public void selectNewsLetterCbx(){
        clickElement(newsletterCbx);
    }
    public void selectSpecialOfferCbx(){
        clickElement(specialOfferCbx);
    }
    public void enterFirstName(String firstName){
        inputText(firstNameTxb,firstName);
    }
    public void enterLastName(String lastName){
        inputText(lastNameTxb,lastName);
    }
    public void enterCompanyName(String companyName){
        inputText(companyTxb, companyName);
    }
    public void enterAddress1(String address){
        inputText(address1Txb, address);
    }
    public void enterAddress2(String address){
        inputText(address2Txb, address);
    }
    public void selectCountryDdl(){
       selectDdlRandom(selectCountryDdl);
    }
    public void enterState(String state){
        inputText(stateTxb, state);
    }
    public void enterCity(String city){
        inputText(cityTxb, city);
    }
    public void enterZipcode(String zipcode){
        inputText(zipcodeTxb, zipcode);
    }
    public void enterMobileNumber(String mobileNumber){
        inputText(mobileNumberTxb, mobileNumber);
    }
    public void clickCreateAccountBtn(){
        clickElement(createAccountBtn);
    }
    public String getCreatedAccountLabel(){
        return getText(accountCreatedLabel);
    }
    public void clickContinueBtn(){
        clickElement(continueBtn);
    }
    public SignUpPage signUpFirstStep(String name, String email){
        enterName(name);
        enterEmail(email);
        clickSignUpBtn();
        return new SignUpPage(driver);
    }
    public SignUpPage signUpSecondStep(String password, String firstName, String lastName, String companyName,
                                       String address1, String address2, String state, String city, String zipcode, String mobileNumber){
        selectGender();
        enterPassword(password);
        selectDateOfBirth();
        selectNewsLetterCbx();
        selectSpecialOfferCbx();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterCompanyName(companyName);
        enterAddress1(address1);
        enterAddress2(address2);
        selectCountryDdl();
        enterState(state);
        enterCity(city);
        enterZipcode(zipcode);
        enterMobileNumber(mobileNumber);
        clickCreateAccountBtn();
        return new SignUpPage(driver);
    }
    public SignUpPage signUpThirdStep(){
        clickContinueBtn();
        return new SignUpPage(driver);
    }
}

