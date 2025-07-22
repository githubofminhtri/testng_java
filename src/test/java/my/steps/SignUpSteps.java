package my.steps;
import com.base.TestContext;
import io.cucumber.java.en.*;
import com.pages.HomePage;
import com.pages.SignUpPage;
import org.testng.Assert;
import org.testng.SkipException;

import java.util.List;
import java.util.Objects;



public class SignUpSteps {
    private final TestContext testContext;
    private final HomePage homePage;
    private final SignUpPage signUpPage;
    // Cucumber will automatically inject this instance if picocontainer is used
    public SignUpSteps(TestContext testContext ) {
        this.testContext = testContext;
        this.homePage = new HomePage(testContext.getDriver());
        this.signUpPage = new SignUpPage(testContext.getDriver());
    }





    @And("I enter username {string} and email {string}")
    public void iEnterUsernameAndEmail(String userName, String email) {
        this.signUpPage.enterName(userName);
        this.signUpPage.enterEmail(email);
    }

    @And("I click the Signup button")
    public void iClickTheSignupButton() {
        this.signUpPage.clickSignUpBtn();
    }

    @And("I navigate to the Sign Up screen")
    public void iNavigateToTheSignUpScreen() {
        Assert.assertTrue(Objects.requireNonNull(this.testContext.getDriver().getCurrentUrl()).contains("/signup"));
    }

    @And("I see a header {string}")
    public void iSeeAMessage(String message) {
        Assert.assertEquals(this.signUpPage.getAccountInformationHeader(),message);
    }

    @And("I select checkbox Receive special offers from our partners!")
    public void iSelectCheckbox2() {
        this.signUpPage.selectSpecialOfferCbx();
    }

    @And("I select checkbox Sign up for our newsletter!")
    public void iSelectCheckbox1() {
        this.signUpPage.selectNewsLetterCbx();
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
            this.signUpPage.enterPassword(password);
            this.signUpPage.enterFirstName(firstName);
            this.signUpPage.enterLastName(lastName);
            this.signUpPage.enterCompanyName(companyName);
            this.signUpPage.enterAddress1(address1);
            this.signUpPage.enterAddress2(address2);
            this.signUpPage.enterState(state);
            this.signUpPage.enterCity(city);
            this.signUpPage.enterZipcode(zipcode);
            this.signUpPage.enterMobileNumber(mobileNumber);

        }

    }

    @And("I clicks on Create Account button")
    public void iClicksOnCreateAccountButton() {
        this.signUpPage.clickCreateAccountBtn();
    }

    @Then("I should be signed up new account successfully")
    public void iShouldBeSignedUpNewAccountSuccessfully() {

    }

    @And("I should see a message {string} after creating account")
    public void iShouldSeeAMessageAfterCreateAccount(String message) {
        Assert.assertEquals(this.signUpPage.getCreatedAccountLabel(), message);
    }

    @And("I click on Continue button after account created")
    public void iClickOnContinueButtonAfterAccountCreated() {
        this.signUpPage.clickContinueBtn();
    }

    @And("I should see a label {string} is visible")
    public void iShouldSeeALabelLoggedInAsUsernameIsVisible(String message) {
        Assert.assertEquals(this.homePage.getLoggedInLabel(),message);
    }

    @But("I click on Delete Account hyperlink")
    public void iClickOnDeleteAccountHyperlink() {
        this.homePage.clickDeleteAccountHyperLink();
    }
    @And("I should see a message {string} after deleting account")
    public void iShouldSeeAMessageAfterDeleteAccount(String message) {
        Assert.assertEquals(this.homePage.getDeleteAccountLabel(), message);
    }
    @And("I click on Continue button after account deleted")
    public void iClickOnContinueButtonAfterAccountDeleted() {
        this.homePage.clickContinueBtn();
    }
}
