package my.steps;
import io.cucumber.java.en.*;
import my.base.TestContext;
import my.pages.HomePage;
import my.pages.SignUpPage;
import org.testng.Assert;
import java.util.List;
import java.util.Objects;



public class SignUpSteps {
    private final TestContext testContext;

    // Cucumber will automatically inject TestContext instance if picocontainer is used
    public SignUpSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        testContext.driver.get("https://www.automationexercise.com/");
        testContext.homePage = new HomePage(testContext.driver);

    }

    @When("I click on Signup hyperlink")
    public void iClickOnSignupLogInHyperlink() {
        testContext.homePage.clickSignUpBtn();
        testContext.signUpPage = new SignUpPage(testContext.driver);
        Assert.assertEquals(testContext.signUpPage.getSignUpHeader(),"New User Signup!");
    }

    @And("I enter username {string} and email {string}")
    public void iEnterUsernameAndEmail(String userName, String email) {
        testContext.signUpPage.enterName(userName);
        testContext.signUpPage.enterEmail(email);
    }

    @And("I click the Signup button")
    public void iClickTheSignupButton() {
        testContext.signUpPage.clickSignUpBtn();
    }

    @And("I navigate to the Sign Up screen")
    public void iNavigateToTheSignUpScreen() {
        Assert.assertTrue(Objects.requireNonNull(testContext.driver.getCurrentUrl()).contains("/signup"));
    }

    @And("I see a message {string}")
    public void iSeeAMessage(String message) {
        Assert.assertEquals(testContext.signUpPage.getAccountInformationHeader(),message);
    }

    @And("I select checkbox Receive special offers from our partners!")
    public void iSelectCheckbox2() {
        testContext.signUpPage.selectSpecialOfferCbx();
    }

    @And("I select checkbox Sign up for our newsletter!")
    public void iSelectCheckbox1() {
        testContext.signUpPage.selectNewsLetterCbx();
    }

    @And("I fulfills my information:")
    public void iFulfillsMyInformation(List<List<String>> userInformation) {
        for(int i =1; i<userInformation.size(); i++){
            List<String> row = userInformation.get(i);
            String password = row.get(0);
            String firstName = row.get(1);
            String lastName = row.get(2);
            String companyName = row.get(3);
            String address1 = row.get(4);
            String address2 = row.get(5);
            String state = row.get(6);
            String city = row.get(7);
            String zipcode = row.get(8);
            String mobileNumber = row.get(9);
//            testContext.signUpPage.signUpSecondStep(password,firstName,lastName,companyName,address1,address2,state,city,zipcode,mobileNumber);
            testContext.signUpPage.enterPassword(password);
            testContext.signUpPage.enterFirstName(firstName);
            testContext.signUpPage.enterLastName(lastName);
            testContext.signUpPage.enterCompanyName(companyName);
            testContext.signUpPage.enterAddress1(address1);
            testContext.signUpPage.enterAddress2(address2);
            testContext.signUpPage.enterState(state);
            testContext.signUpPage.enterCity(city);
            testContext.signUpPage.enterZipcode(zipcode);
            testContext.signUpPage.enterMobileNumber(mobileNumber);

        }

    }

    @And("I clicks on Create Account button")
    public void iClicksOnCreateAccountButton() {
        testContext.signUpPage.clickCreateAccountBtn();
    }

    @Then("I should be signed up new account successfully")
    public void iShouldBeSignedUpNewAccountSuccessfully() {

    }

    @And("I should see a message {string} after creating account")
    public void iShouldSeeAMessageAfterCreateAccount(String message) {
        Assert.assertEquals(testContext.signUpPage.getCreatedAccountLabel(), message);
    }

    @And("I click on Continue button after account created")
    public void iClickOnContinueButtonAfterAccountCreated() {
        testContext.signUpPage.clickContinueBtn();
    }

    @And("I should see a label {string} is visible")
    public void iShouldSeeALabelLoggedInAsUsernameIsVisible(String message) {
        Assert.assertEquals(testContext.homePage.getLoggedInLabel(),message);
    }

    @But("I click on Delete Account hyperlink")
    public void iClickOnDeleteAccountHyperlink() {
        testContext.homePage.clickDeleteAccountHyperLink();
    }
    @And("I should see a message {string} after deleting account")
    public void iShouldSeeAMessageAfterDeleteAccount(String message) {
        Assert.assertEquals(testContext.homePage.getDeleteAccountLabel(), message);
    }
    @And("I click on Continue button after account deleted")
    public void iClickOnContinueButtonAfterAccountDeleted() {
        testContext.homePage.clickContinueBtn();
    }

//    @Given("I am on the login page")
//    public void iAmOnTheLoginPage() {
//    }
//
//    @When("I enter username {string} and password {string}")
//    public void iEnterUsernameAndPassword() {
//    }
//
//    @And("I click the login button")
//    public void iClickTheLoginButton() {
//    }
//
//    @Then("I should see a login status {string}")
//    public void iShouldSeeALoginStatus() {
}
