package step_definitions;


import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.caterDashboardPage;
import pages.craterLoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class UserManagementSteps {

	craterLoginPage craterLogin = new craterLoginPage();
	caterDashboardPage dashboard = new caterDashboardPage();
	BrowserUtils utils = new BrowserUtils();
	CraterCommonPage commonPage = new CraterCommonPage();

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {

		Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
		
		
	}

	// Valid login test

	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) {

		utils.sendKeysWithActionClass(craterLogin.useremail, username);
		utils.sendKeysWithActionClass(craterLogin.password, password);

	}

	@When("clicks on the loging button")
	public void clicks_on_the_loging_button() {
		craterLogin.loginButton.click();
	}

	@Then("user should be on the dashboard page")
	public void user_should_be_on_the_dashboard_page() {
		// When need to wait until the element to be visible
		// element : dashboard.amountDueText from craterDashboardPage
		// utils coming from the BrwserUtils which we created an object at the top
		utils.waitUntilElementVisible(dashboard.amountDueText);
		// We need to verify the element is visible by using Assert
		Assert.assertTrue(dashboard.amountDueText.isDisplayed());

	}

	@Then("user quits the browser")
	public void user_quits_the_browser() {
		Driver.quitDriver();
	}

	// Invalid Login attempts
	@When("user enters invalid useremail {string} and password {string}")
	public void user_enters_invalid_and(String invalidusereamil, String invalidPassword) {
		utils.sendKeysWithActionClass(craterLogin.useremail, invalidusereamil);
		utils.sendKeysWithActionClass(craterLogin.password, invalidPassword);

	}

	@Then("an error message appears")
	public void an_error_message_appears() {
		// We can just verify that the login button means we still at the loging page
		// Mean the we have unsuccessful login
		Assert.assertTrue(craterLogin.loginButton.isDisplayed());
	}

	@Then("user is not logged in")
	public void user_is_not_logged_in() {

		// we validate using the login button element which means user isn't able to
		// login
		// and we still at the login page
		Assert.assertTrue(craterLogin.loginButton.isDisplayed());

	}
	

		
	//Invalid login scenario outline
	boolean useremailEmpty; 
	boolean passwordEmpty;
	@When("user enters invalid useremail  {string} and password {string}")
	public void user_enters_invalid_useremail_and_password(String invalidusereamil, String invalidPassword) {
		
		useremailEmpty = invalidusereamil.isBlank(); 
		passwordEmpty = invalidPassword.isBlank(); 
		utils.sendKeysWithActionClass(craterLogin.useremail, invalidusereamil);
		utils.sendKeysWithActionClass(craterLogin.password, invalidPassword);
	}
	
	@Then("error message appear")
	public void error_message_appear() {
	 
		if (useremailEmpty || passwordEmpty ) {
			utils.waitUntilElementVisible(craterLogin.fieldRequired); 
			Assert.assertTrue(craterLogin.fieldRequired.isDisplayed());
		}else {
			utils.waitUntilElementVisible(craterLogin.loginButton);
			Assert.assertTrue(craterLogin.loginButton.isDisplayed());
		}
	}




}
