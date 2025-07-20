Feature: Logout account and Delete account
  As a registered user
  I want to delete my account or log out my account after log in to the application
  So that I can exit the application and protect my own account

  Rule: I already created an account in the application
    Background:
      Given I am on the home page
      And I click on Signup / Login hyperlink
      And I logged in with valid account:
        | email                    | password |
        | tomsmith9911@yopmail.com | aaa      |

    @Logout
    Scenario: Logout user
      When I click on Logout button
      Then I should be navigated to the Login page

    @Delete
    Scenario: Delete user
      When I click on Delete Account hyperlink
       And I should see a message "ACCOUNT DELETED!" after deleting account
       And I click on Continue button after account deleted