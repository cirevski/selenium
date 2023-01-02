

Feature: Login functionality
  I want to use this template for my feature file


  @login  
  Scenario Outline: Check login is successfull with valid credentials
    Given user is on home page
    When user enters <username> and <password>
    And user click on login button
    Then user is navigate on a inventory page
   
  Examples:     
    |username|password|
    |standard_user|secret_sauce
    |locked_out_user|secret_sauce
    |problem_user|secret_sauce
    |performance_glitch_user|secret_sauce
