package stepdefinitions;

import java.util.GregorianCalendar;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	WebDriver driver;
	private RegisterPage registerPage;
    private AccountSuccessPage accountSuccessPage;
    private CommonUtils commonUtils;
    private DriverFactory driverFactory;
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() throws InterruptedException {
		driverFactory=new DriverFactory();
		driver= driverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		Thread.sleep(1000);
		registerPage=homePage.selectregisterOption();
		Thread.sleep(1000);
	}

	@When("User enters below details")
	public void user_enters_below_details(DataTable dataTable) throws InterruptedException {
	   Map<String,String> dataMap= dataTable.asMap(String.class,String.class);
	   commonUtils=new CommonUtils();
	   registerPage.enterFirstName(dataMap.get("firstName"));
	   registerPage.enterLastName(dataMap.get("lastName"));
	   registerPage.enterEmailAddress(commonUtils.getEmailwithTimeStampnano());
	   registerPage.enterTelephone(dataMap.get("telephone"));
	   registerPage.enterPassword(dataMap.get("password"));
	   registerPage.enterConfirmPassword(dataMap.get("password"));
	   
	    	}
	@When("User enters below details with duplicate email")
	public void user_enters_below_details_with_duplicate_email(DataTable dataTable) throws InterruptedException {
	   Map<String,String> dataMap= dataTable.asMap(String.class,String.class);
	   
	   registerPage.enterFirstName(dataMap.get("firstName"));
	   registerPage.enterLastName(dataMap.get("lastName"));
	   registerPage.enterEmailAddress(dataMap.get("email"));
	   registerPage.enterTelephone(dataMap.get("telephone"));
	   registerPage.enterPassword(dataMap.get("password"));
	   registerPage.enterConfirmPassword(dataMap.get("password"));
	   
	    	}

	@And("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		registerPage.clickAgree();
	   
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() throws InterruptedException {
		accountSuccessPage=registerPage.clickContinue();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	
	   Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
	}

	@And("User selects Newsletter")
	public void user_selects_newsletter() {
		registerPage.checkNewsLetter();
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() { 
	   Assert.assertEquals("Warning: E-Mail Address is already registered!",registerPage.getWarningMessageText());
	}

	@When("User dont enter details")
	public void user_dont_enter_details() {
	  //Intentionally kept blank  
	   
	}

	@Then("User should get a proper warning messages for every mandatory field")
	public void user_should_get_a_proper_warning_messages_for_every_mandatory_field() {
		
	  Assert.assertTrue(registerPage.getWarningMessageText()
			   .contains("Warning: You must agree to the Privacy Policy!"));
	  Assert.assertEquals("First Name must be between 1 and 32 characters!", 
			  registerPage.getFirstNameWarning());
	  Assert.assertEquals("Last Name must be between 1 and 32 characters!", 
			  registerPage.getLastNameWarning());
	  Assert.assertEquals("E-Mail Address does not appear to be valid!", 
			  registerPage.getEmailWarning());
	  Assert.assertEquals("Telephone must be between 3 and 32 characters!", 
			  registerPage.getTelephoneWarning());
	  Assert.assertEquals("Password must be between 4 and 20 characters!", 
			  registerPage.getPasswordWarning());
	}

	


}
