Feature: Login Scenario for Salesforce application

Background:
  Given User is on "LoginPage"


@smoke
Scenario: Login into salesforce appliaction with valid username and password
  When Enter into textbox username as "janani.bhar@gmail.com"
  When Enter into password as "Hello@123"
  When click on Button "Login"
  Then user should be seeing home page
  
@smoke @regression
Scenario: Login into salesforce appliaction with valid username and password
  When User enters valid username
  When User enters valid password
  When click on login Button
  Then user should be seeing home page
