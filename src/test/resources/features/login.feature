Feature: User Login Functionality
  As a registered user
  I want to log in to the application
  So that I can access my account features
  Rule: User registered a new account
    Background:
      Given I am on the home page
      When I click on Signup / Login hyperlink

    @Login
    Scenario Outline: Login with valid credentials
      When I enter username "<username>" and password "<password>"
      And I click the login button
      Then I should see a login status "<status_message>"
      But I click on Delete Account hyperlink
      And I should see a message "ACCOUNT DELETED!" after deleting account
      And I click on Continue button after account deleted
      Examples:
        | username                 | password | status_message                       |
        | tomsmith9911@yopmail.com | aaa      | Logged in as tomsmith                |

    @Login
    Scenario Outline: Login with invalid credentials
      When I enter username "<username>" and password "<password>"
      And I click the login button
      Then I should see a login status "<status_message>"
      Examples:
        | username                 | password | status_message                       |
        | tomsmith9911@yopmail.com | aaa1     | Your email or password is incorrect! |