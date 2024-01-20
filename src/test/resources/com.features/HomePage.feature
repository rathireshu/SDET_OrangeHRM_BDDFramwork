@OrangeHRM_Home
Feature: OrangeHRM HomePage feature
 
  @HomePagee
  Scenario: Login to OrangeHRM as admin user with given credentials
    Given User is already on OrangeHRM login page
    When user enters given credentials and click on login button
    Then user successfully loggedin and redirected to home page
    And validate home page url
    And validate logged in username
   