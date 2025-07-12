package my.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class SignUpPage {
    private final WebDriver driver;

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
        this.driver=driver;
    }
    // 3. Actions
    public String getSignUpHeader(){
        return driver.findElement(signUpTxt).getText();
    }
    public void enterName(String name){
        driver.findElement(nameTxb).sendKeys(name);
    }
    public void enterEmail(String email){
        driver.findElement(emailTxb).sendKeys(email);
    }
    public void clickSignUpBtn(){
        driver.findElement(signUpBtn).click();
    }
    public String getAccountInformationHeader(){
        return driver.findElement(step2HeaderTxt).getText();
    }
    public void selectGender(){
        driver.findElement(genderRadioBtn).click();
    }
    public void enterPassword(String password){
        driver.findElement(passwordTxb).sendKeys(password);
    }
    public void selectDateOfBirth(){
        WebElement dayDdlElement = driver.findElement(selectDayDdl);
        WebElement monthDdlElement = driver.findElement(selectMonthDdl);
        WebElement yearDdlElement = driver.findElement(selectYearDdl);
        Select selectDay = new Select(dayDdlElement);
        Select selectMonth = new Select(monthDdlElement);
        Select selectYear = new Select(yearDdlElement);
        int numberDayOptions = selectDay.getOptions().size();
        int numberMonthOptions = selectMonth.getOptions().size();
        int numberYearOptions = selectYear.getOptions().size();
        Random random = new Random();

        int randomDay = random.nextInt(numberDayOptions)+1;
        int randomMonth = random.nextInt(numberMonthOptions)+1;
        int randomYear = random.nextInt(numberYearOptions)+1;
        selectDay.selectByIndex(randomDay);
        selectMonth.selectByIndex(randomMonth);
        selectYear.selectByIndex(randomYear);

    }
    public void selectNewsLetterCbx(){
        driver.findElement(newsletterCbx).click();
    }
    public void selectSpecialOfferCbx(){
        driver.findElement(specialOfferCbx).click();
    }
    public void enterFirstName(String firstName){
        driver.findElement(firstNameTxb).sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        driver.findElement(lastNameTxb).sendKeys(lastName);
    }
    public void enterCompanyName(String companyName){
        driver.findElement(companyTxb).sendKeys(companyName);
    }
    public void enterAddress1(String address){
        driver.findElement(address1Txb).sendKeys(address);
    }
    public void enterAddress2(String address){
        driver.findElement(address2Txb).sendKeys(address);
    }
    public void selectCountryDdl(){
        WebElement countryDdl = driver.findElement(selectCountryDdl);
        Select selectCountry = new Select(countryDdl);
        int totalCountryOptions = selectCountry.getOptions().size();
        Random random = new Random();
        int randomCountry = random.nextInt(totalCountryOptions)+1;
        selectCountry.selectByIndex(randomCountry);
    }
    public void enterState(String state){
        driver.findElement(stateTxb).sendKeys(state);
    }
    public void enterCity(String city){
        driver.findElement(cityTxb).sendKeys(city);
    }
    public void enterZipcode(String zipcode){
        driver.findElement(zipcodeTxb).sendKeys(zipcode);
    }
    public void enterMobileNumber(String mobileNumber){
        driver.findElement(mobileNumberTxb).sendKeys(mobileNumber);
    }
    public void clickCreateAccountBtn(){
        driver.findElement(createAccountBtn).click();
    }
    public String getCreatedAccountLabel(){
        return driver.findElement(accountCreatedLabel).getText();
    }
    public void clickContinueBtn(){
        driver.findElement(continueBtn).click();
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

