package my.tests;

import my.base.BaseTest;
import my.pages.HomePage;
import my.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    @Test(description = "Verify that sign up new user successfully")
    @Parameters({"userName", "email", "password","firstName","lastName","companyName","address1", "address2", "state", "city", "zipcode", "mobileNumber"})
    public void testSuccessfulSignUp(String userName, String email, String password, String firstName, String lastName, String companyName,
                                     String address1, String address2, String state, String city, String zipcode, String mobileNumber){
        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpBtn();
        SignUpPage signUpPage = new SignUpPage(driver);
        Assert.assertEquals(signUpPage.getSignUpHeader(),"New User Signup!");
        signUpPage.signUpFirstStep(userName, email);
        Assert.assertEquals(signUpPage.getAccountInformationHeader(),"ENTER ACCOUNT INFORMATION");
        signUpPage.signUpSecondStep(password,firstName, lastName, companyName,
                address1, address2, state, city, zipcode, mobileNumber);
        Assert.assertEquals(signUpPage.getCreatedAccountLabel(),"ACCOUNT CREATED!");
        signUpPage.signUpThirdStep();
        Assert.assertEquals(homePage.getLoggedInLabel(),"Logged in as "+userName);
        homePage.clickDeleteAccountHyperLink();
        Assert.assertEquals(homePage.getDeleteAccountLabel(),"ACCOUNT DELETED!");
        homePage.clickContinueBtn();
    }
}
