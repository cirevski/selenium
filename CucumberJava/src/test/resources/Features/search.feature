
Feature: Search functionality

  

  @search
  Scenario Outline: Search a products
    Given User is on home page
    When user enters <products>
    And click search button
    Then is displayed search results

    Examples: 
      |products|
      | Nike |
      | Asus |
      | Sony |
      |erikson|