package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

import utils.CommonUtils;

import org.openqa.selenium.*;


import factory.DriverFactory;

public class Login {
	WebDriver driver;
private LoginPage loginPage;
private AccountPage accountPage;
private CommonUtils commonUtils;
private DriverFactory driverFactory;

	@Given("User navigates to login page")
	public void User_navigates_to_login_page() {
		driverFactory=new DriverFactory();
		driver= driverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
	   loginPage= homePage.selectLoginOption();
	}

	@When("^User enters valid email address (.+) into the email field$")
	public void user_enters_valid_email_address_into_the_email_field(String emailText) {
		
		loginPage.enterEmailAddress(emailText);
		
	}

	@And("^User enters valid password (.+) into the password field$")
	public void user_enters_valid_password_into_the_password_field(String password) {
				
		loginPage.enterPassword(password);
	}

	@And("User Clicks on login button")
	public void user_clicks_on_login_button() {
		
		accountPage=loginPage.clickOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
		Assert.assertTrue(accountPage.displayStatusofEditYourAccountInformationOption());
	}

	@When("User enters invalid email address {string} into the email field")
	public void user_enters_invalid_email_address_into_the_email_field(String invalidemailText) {
		 commonUtils=new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailwithTimeStamp());
	
	}

	@And("User enters invalid password {string} into the password field")
	public void user_enters_invalid_password_into_the_password_field(String invalidpassword) {
	loginPage.enterPassword(invalidpassword);	
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		
		Assert.assertTrue(loginPage.getWarningMessageText().contains(
				"Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter email address into the email field")
	public void user_dont_enter_email_address_into_the_email_field() {
		}

	@And("User dont enter password into the password field")
	public void user_dont_enter_password_into_the_password_field() {
			}
	
	

}
