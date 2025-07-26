
@Delete
Feature: Delete Functionality
  As a registered user
  I want to delete my account
  So that I can delete my own account

  Rule: I already created an account in the application
    Background:
      Given I am on the home page
      And I click on Signup / Login hyperlink
      And I logged in with valid account

    @Delete
    Scenario: Delete user
      When I click on Delete Account hyperlink
      And I should see a message "ACCOUNT DELETED!" after deleting account
      And I click on Continue button after account deleted