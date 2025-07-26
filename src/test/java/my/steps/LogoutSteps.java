package my.steps;

import com.base.TestContext;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignUpPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import my.testdata.TestData;
import my.testdata.UserInfo;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class LogoutSteps {
    private final TestContext testContext;
    private final HomePage homePage;
    private final LoginPage loginPage;
    public LogoutSteps(TestContext testContext){
        this.testContext = testContext;
        this.loginPage = new LoginPage(this.testContext.getDriver());
        this.homePage = new HomePage(this.testContext.getDriver());
    }


    @When("I click on Logout button")
    public void iClickOnLogoutButton() {
        homePage.clickSignUpOrLogoutBtn();
    }

    @Then("I should be navigated to the Login page")
    public void iShouldBeNavigatedToTheLoginPage() {
        Assert.assertTrue(loginPage.getCurrentUrl().contains("/login"));
    }
}
