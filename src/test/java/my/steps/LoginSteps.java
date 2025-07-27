package my.steps;

import com.base.TestContext;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignUpPage;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import my.testdata.TestData;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class LoginSteps {
    private final TestContext testContext;
    private final LoginPage loginPage;
    private final HomePage homePage;
    public LoginSteps(TestContext testContext){
        this.testContext = testContext;
        this.loginPage = new LoginPage(this.testContext.getDriver());
        this.homePage = new HomePage(this.testContext.getDriver());

    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String arg0, String arg1) {
        loginPage.enterEmail(arg0);
        loginPage.enterPassword(arg1);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("I should see a login status {string}")
    public void iShouldSeeALoginStatus(String arg0) {
        String status = null;
        String currentURL = homePage.getCurrentUrl();
        if(currentURL.contains("/login")){
            status = loginPage.getLoginStatus();
        } else {
            status = homePage.getLoggedInLabel();
        }
        Assert.assertEquals(status,arg0);
    }
}
