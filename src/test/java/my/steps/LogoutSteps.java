package my.steps;

import com.base.TestContext;
import com.pages.HomePage;
import com.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    @And("I logged in with valid account:")
    public void iLoggedInWithValidAccount(DataTable dataTable) {
        List<Map<String, String>> users = dataTable.asMaps(String.class, String.class);
        for (Map<String,String> user : users){
            String email = user.get("email");
            String password = user.get("password");
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickLoginBtn();
        }
    }

    @When("I click on Logout button")
    public void iClickOnLogoutButton() {
        homePage.clickLogOutBtn();
    }

    @Then("I should be navigated to the Login page")
    public void iShouldBeNavigatedToTheLoginPage() {
        Assert.assertTrue(loginPage.getCurrentUrl().contains("/login"));
    }
}
