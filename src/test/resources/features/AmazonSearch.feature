
@tag
Feature: Amazon Search
  


  @amazonSearchTests
  Scenario Outline: Search items on amazon 
    Given I am on the amazon homepage
    When I enter the search term "<items>"
    And I click on the search button 
    Then I should see the search items "<items>" on the search results page 

    Examples: 
      | name  | value | 
      | name1 |     5 | 
      | name2 |     7 | 
