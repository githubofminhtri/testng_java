package my.steps;

import com.base.TestContext;
import com.pages.HomePage;
import com.pages.SignUpPage;
import io.cucumber.java.en.Given;

public class CommonSteps {
    private final TestContext testContext;
    private final HomePage homePage;
    private final SignUpPage signUpPage;
    public CommonSteps(TestContext testContext){

        this.testContext = testContext;
        this.homePage = new HomePage(testContext.getDriver());
        this.signUpPage = new SignUpPage(testContext.getDriver());
    }
    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        this.testContext.getDriver().get("https://www.automationexercise.com/");

    }
}
