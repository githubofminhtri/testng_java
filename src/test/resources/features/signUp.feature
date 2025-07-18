Feature: User Signup Functionality
  As a guest user
  I want to sign up to the application
  So that I can access my account features

  @Signup
  Scenario: Successful sign up with valid credentials
    Given I am on the home page
    When I click on Signup hyperlink
    And I enter username "tomsmith" and email "tomsmith9911@yopmail.com"
    And I click the Signup button
    And I navigate to the Sign Up screen
    And I see a message "ENTER ACCOUNT INFORMATION"
    And I select checkbox Sign up for our newsletter!
    And I select checkbox Receive special offers from our partners!
    And I fulfills my information:
      | password | firstName | lastName | companyName      | address1  | address2  | state | city | zipcode  | mobileNumber  |
      | aaa      | tri       | pham     | tri pham company | address 1 | address 2 | state | city | zip code | mobile number |
    And I clicks on Create Account button
    Then I should be signed up new account successfully
    And I should see a message "ACCOUNT CREATED!" after creating account
    And I click on Continue button after account created
    And I should see a label 'Logged in as tomsmith' is visible
    # But I click on Delete Account hyperlink
    # And I should see a message "ACCOUNT DELETED!" after deleting account
    # And I click on Continue button after account deleted

  Scenario Outline: Login with various credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should see a login status "<status_message>"

    Examples:
      | username     | password            | status_message                  |
      | tomsmith     | SuperSecretPassword!| You logged into a secure area!  |
      | invalidUser  | invalidPassword     | Your username is invalid!       |
      | tomsmith     | wrongpassword       | Your username is invalid!       |