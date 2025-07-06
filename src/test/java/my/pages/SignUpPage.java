package my.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class SignUpPage {
    private WebDriver driver;

    // 1. Locators
    private By signUpTxt = By.cssSelector("div.signup-form>h2");
    private By nameTxb = By.cssSelector("form[action='/signup']>input[name='name']");
    private By emailTxb = By.cssSelector("form[action='/signup']>input[name='email']");
    private By signUpBtn = By.cssSelector("form[action='/signup']>button[data-qa='signup-button']");
    private By step2HeaderTxt = By.cssSelector("div.login-form >h2>b");
    private By genderRadioBtn = By.id("uniform-id_gender1");
    private By passwordTxb = By.id("password");
    private By selectDayDdl = By.id("days");
    private By selectMonthDdl = By.id("months");
    private By selectYearDdl = By.id("years");
    private By newsletterCbx = By.id("newsletter");
    private By specialOfferCbx = By.id("optin");
    private By firstNameTxb = By.id("first_name");
    private By lastNameTxb = By.id("last_name");
    private By companyTxb = By.id("company");
    private By address1Txb = By.id("address1");
    private By address2Txb = By.id("address2");
    private By selectCountryDdl = By.id("country");
    private By stateTxb = By.id("state");
    private By cityTxb = By.id("city");
    private By zipcodeTxb = By.id("zipcode");
    private By mobileNumberTxb = By.id("mobile_number");
    private By createAccountBtn = By.cssSelector("button[data-qa='create-account']");
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
    public SignUpPage signUpFirstStep(String name, String email){
        enterName(name);
        enterEmail(email);
        clickSignUpBtn();
        return new SignUpPage(driver);
    }
    public SignUpPage signUpSecondStep(String password){
        selectGender();
        enterPassword(password);
        selectDateOfBirth();
        selectNewsLetterCbx();
        selectSpecialOfferCbx();
        return new SignUpPage(driver);
    }
}

