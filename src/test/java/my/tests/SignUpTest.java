package my.tests;

import my.base.BaseTest;
import my.pages.HomePage;
import my.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    @Test(description = "Verify that sign up new user successfully")
    public void testSuccessfulSignUp(){
        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpBtn();
        SignUpPage signUpPage = new SignUpPage(driver);
        Assert.assertEquals(signUpPage.getSignUpHeader(),"New User Signup!");
        signUpPage.signUpFirstStep("tri pham", "tri.pham1919@yopmail.com");
        Assert.assertEquals(signUpPage.getAccountInformationHeader(),"ENTER ACCOUNT INFORMATION");
        signUpPage.signUpSecondStep("aaa");
    }
}
