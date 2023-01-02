Feature: Login functionality testing on Swag labs

  Scenario Outline: Test valid login
    Given user is on home page
    When user enters <username> and <password>
    And click on login button
    Then login should be <status>

    Examples: 
      | username                | password     | status       |
      | standard_user           | secret_sauce | successful   |
      | performance_glitch_user | secret_sauce | successful   |
      | problem_user            | secret_sauce | successful   |
      | dkfjsdij                | secret_sauce | unsuccessful |
      |                         | secret_sauce | unsuccessful |
      | standard_user           |              | unsuccessful |
