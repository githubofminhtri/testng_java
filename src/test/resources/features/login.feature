Feature: User Login Functionality
  As a registered user
  I want to log in to the application
  So that I can access my account features
@Login
Scenario Outline: Login with various credentials
  Given I am on the home page
  And I click on Login hyperlink
  When I enter username "<username>" and password "<password>"
  And I click the login button
  Then I should see a login status "<status_message>"
  Examples:
    | username | password | status_message |
    | tomsmith9911@yopmail.com | aaa| Logged in as tomsmith|