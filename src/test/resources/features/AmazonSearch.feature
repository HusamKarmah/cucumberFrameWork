Feature: Amazon Search
  


  @amazonSearchTests
  Scenario Outline: Search items on amazon 
    Given I am on the amazon homepage
    When I enter the search term "<items>"
    And I click on the search button 
    Then I should see the search items "<items>" on the search results page 
    And the page title should contain the searched item "<items>"

    Examples: 
      | items         | 
      | coffee mug    |
      | Kitchen Knife |
      | Towels        |
      | Apron         |
     
