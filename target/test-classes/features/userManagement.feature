@Regression @userManagement
Feature: Crater User Management
  User management foucses on user creation, update and delete
  and also authentication.
  
  Background: 
   Given user is on the login page
	
	@validLoginTest @loginTests @smokeTest
  Scenario: User is able to login succssfully
    When user enters valid "hussamsalman79@yahoo.com" and "Password1234"
    And clicks on the loging button
    Then user should be on the dashboard page
    And user quits the browser
    

   @invalidLogin @loginTests
   Scenario: Invalid login attemps
    When user enters invalid "hellojoan@gmail.com" and "Test1234"
    And clicks on the loging button 
    Then an error message appears 
    And user is not logged in
    And user quits the browser
    
    @invalidTests
    Scenario Outline: Invalid login attemps
	  When user enters invalid useremail "<useremail>" and password "<password>"
	  And clicks on the loging button 
	  Then error message appear 
	  And user is not logged in
	  And user quits the browser
	  
	  Examples: 
	  |useremail								|password		   |
	  |hussamsalman79@yahoo.com |Passw1234	 	 |
	  |invalidemail@yahoo.com		|Password1234	 |
	  |													|Password1234	 |
	  |invalidemail@yahoo.com   |							 |
	  	
	  		
	  
