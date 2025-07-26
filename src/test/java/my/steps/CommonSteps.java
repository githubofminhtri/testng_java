package my.steps;

import com.base.TestContext;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignUpPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import my.testdata.TestData;
import my.testdata.UserInfo;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class CommonSteps {
    private final TestContext testContext;
    private final HomePage homePage;
    private final SignUpPage signUpPage;
    private final LoginPage loginPage;
    private final UserInfo userInfo = new UserInfo();
    public CommonSteps(TestContext testContext){

        this.testContext = testContext;
        this.homePage = new HomePage(testContext.getDriver());
        this.signUpPage = new SignUpPage(testContext.getDriver());
        this.loginPage = new LoginPage(testContext.getDriver());
    }
    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        this.testContext.getDriver().get(TestData.baseUrl);

    }
    @When("^I click on Signup / Login hyperlink$")
    public void iClickOnSignupLogInHyperlink() {
        this.homePage.clickSignUpOrLogoutBtn();
            Assert.assertEquals(this.signUpPage.getSignUpHeader(), "New User Signup!");
    }

    @And("I logged in with valid account")
    public void iLoggedInWithValidAccount() {
        loginPage.enterEmail(this.userInfo.getEmail());
        loginPage.enterPassword(this.userInfo.getPassword());
        loginPage.clickLoginBtn();
    }
    @Before(order = 2, value = "@Login_with_valid_account or @Logout or @Delete")
    public void checkAccountExisted(Scenario scenario){
        testContext.getDriver().get(TestData.baseUrl);
        homePage.clickSignUpOrLogoutBtn();
        SignUpPage signUpPage = new SignUpPage(testContext.getDriver());
        signUpPage.enterName(TestData.userName);
        signUpPage.enterEmail(TestData.email);
        signUpPage.clickSignUpBtn();
        if(signUpPage.getErrorMessage().equalsIgnoreCase("Email Address already exist!")){
            System.out.println("Email Address already exist!");
            return;
        } else {
            signUpPage.signUpSecondStep(TestData.password,TestData.firstName,TestData.lastName,
                    TestData.companyName,TestData.address1,TestData.address2,TestData.state,
                    TestData.city,TestData.zipCode,TestData.mobileNumber);
            System.out.println("Sign Up New Account Successfully");
        }
    }
}
