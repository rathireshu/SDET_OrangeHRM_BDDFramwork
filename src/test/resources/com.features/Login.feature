@OrangeHRM_Login
Feature: Login to OrangeHRM feature
 
  @validCredential
  Scenario: Login to OrangeHRM as admin user with given credentials
    Given User is already on OrangeHRM login page
    When user provides given credentials "Admin" and "admin123" and click on login btn
    Then user successfully loggedin and redirected to home page   
    And close the browser
 
 @InvalidCredentials
 Scenario Outline: Login with invalid credentials
    Given User is already on OrangeHRM login page 
    When User enters username as "<username>" and password as "<password>" and click on login button
    Then User should be able to see error message "<errorMessage>"
    And close the browser
     
  Examples:
  | username   | password    | errorMessage          |
  | next       | next12$$    | Invalid credentials   |
  | admin$$    | admin123    | Invalid credentials   |
  | abhd123    | xyz$$       | Invalid credentials   |