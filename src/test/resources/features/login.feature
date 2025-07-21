Feature: User Login Functionality
  As a registered user
  I want to log in to the application
  So that I can access my account features

  Background:
    Given I am on the home page
    When I click on Signup / Login hyperlink
    And I enter username "tomsmith" and email "tomsmith9911@yopmail.com"
    And I click the Signup button
    And I see a header "ENTER ACCOUNT INFORMATION"
    And I select checkbox Sign up for our newsletter!
    And I select checkbox Receive special offers from our partners!
    And I fulfills my information:
      | password | firstName | lastName | companyName      | address1  | address2  | state | city | zipcode  | mobileNumber  |
      | aaa      | tri       | pham     | tri pham company | address 1 | address 2 | state | city | zip code | mobile number |
    And I clicks on Create Account button
    Then I should be signed up new account successfully
    And I should see a message "ACCOUNT CREATED!" after creating account
    And I click on Continue button after account created
    And I click on Logout button
  @Login
  Scenario Outline: Login with various credentials
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should see a login status "<status_message>"
    But I click on Delete Account hyperlink
    And I should see a message "ACCOUNT DELETED!" after deleting account
    And I click on Continue button after account deleted
    Examples:
      | username                 | password | status_message                       |
      | tomsmith9911@yopmail.com | aaa      | Logged in as tomsmith                |
      | tomsmith9911@yopmail.com | aaa1     | Your email or password is incorrect! |
