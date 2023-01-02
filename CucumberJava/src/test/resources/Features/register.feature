
Feature: Register functionality

  @validdata
  Scenario: Register with valid credentials
    Given user is on register page
    When user enters valid firstname, lastname, email, password and confirm password  
    And click on register button
    Then he is registered successfuly on the page
    

  @invaliddata
  Scenario: Register with invalid credentials
  	Given user is on register page
  	When user enters invalid firstname, lastname,email, password and confirm password
  	And click on register button
  	Then he receive a error message
  
  