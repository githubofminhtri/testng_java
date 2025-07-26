@Signup
Feature: Signup Functionality
  As a guest user
  I want to sign up to the application
  So that I can access my account features

  Rule: I am a guest in the application
    Background:
      Given I am on the home page

    @Signup
    Scenario: Successful sign up with valid credentials
      When I click on Signup / Login hyperlink
      And I enter username "tomsmith" and email "tomsmith9911@yopmail.com"
      And I click the Signup button
      And I see a header "ENTER ACCOUNT INFORMATION"
      And I select checkbox Sign up for our newsletter!
      And I select checkbox Receive special offers from our partners!
      And I fulfills my information:
        | password | firstName | lastName | companyName      | address1  | address2  | state | city | zipCode  | mobileNumber  |
        | aaa      | tri       | pham     | tri pham company | address 1 | address 2 | state | city | zip code | mobile number |
      And I clicks on Create Account button
      Then I should be signed up new account successfully
      And I should see a message "ACCOUNT CREATED!" after creating account
      And I click on Continue button after account created
      And I should see a label 'Logged in as tomsmith' is visible
      But I click on Delete Account hyperlink
      And I should see a message "ACCOUNT DELETED!" after deleting account
      And I click on Continue button after account deleted
