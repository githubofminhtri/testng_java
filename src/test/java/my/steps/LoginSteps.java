package my.steps;

import com.base.TestContext;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    private final TestContext testContext;
    private final LoginPage loginPage;
    private final SignUpPage signUpPage;
    private final HomePage homePage;
    public LoginSteps(TestContext testContext){
        this.testContext = testContext;
        this.loginPage = new LoginPage(this.testContext.getDriver());
        this.signUpPage = new SignUpPage(this.testContext.getDriver());
        this.homePage = new HomePage(this.testContext.getDriver());
    }
    @And("I click on Login hyperlink")
    public void iClickOnLoginHyperlink() {
        System.out.println("I click on Login hyperlink");
        homePage.clickSignUpBtn();

    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String arg0, String arg1) {
        System.out.println("I enter username {string} and password {string}");
        loginPage.enterEmail(arg0);
        loginPage.enterPassword(arg1);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        System.out.println("I click the login button");
        loginPage.clickLoginBtn();
    }

    @Then("I should see a login status {string}")
    public void iShouldSeeALoginStatus(String arg0) {
        System.out.println("I should see a login status {string}");
        Assert.assertEquals(homePage.getLoggedInLabel(),arg0);
    }
}
