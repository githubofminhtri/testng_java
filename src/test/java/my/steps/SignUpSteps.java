package my.steps;
import com.base.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import com.pages.HomePage;
import com.pages.SignUpPage;
import my.testdata.UserInfo;
import org.testng.Assert;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SignUpSteps {
    private final TestContext testContext;
    private final HomePage homePage;
    private final SignUpPage signUpPage;
    @DataTableType
    public UserInfo userInfoEntry(Map<String, String> entry){
        return new UserInfo(
                entry.get("password"),
                entry.get("firstName"),
                entry.get("lastName"),
                entry.get("companyName"),
                entry.get("address1"),
                entry.get("address2"),
                entry.get("state"),
                entry.get("city"),
                entry.get("zipCode"),
                entry.get("mobileNumber")
        );

    }
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
    public void iFulfillsMyInformation(List<UserInfo> userInfos) {
        for (UserInfo userInfo: userInfos){
            this.signUpPage.enterPassword(userInfo.getPassword());
            this.signUpPage.enterFirstName(userInfo.getFirstName());
            this.signUpPage.enterLastName(userInfo.getLastname());
            this.signUpPage.enterCompanyName(userInfo.getCompanyName());
            this.signUpPage.enterAddress1(userInfo.getAddress1());
            this.signUpPage.enterAddress2(userInfo.getAddress2());
            this.signUpPage.enterState(userInfo.getState());
            this.signUpPage.enterCity(userInfo.getCity());
            this.signUpPage.enterZipcode(userInfo.getZipCode());
            this.signUpPage.enterMobileNumber(userInfo.getMobileNumber());
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
