package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	@FindBy(id="input-email")
	private WebElement emailField;
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	@FindBy(id="input-password")
	private WebElement passwordField;
	@FindBy(id="input-confirm")
	private WebElement confirmField;
	@FindBy(name="agree")
	private WebElement agree;
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueClick;
	@FindBy(xpath="//input[@name='newsletter']")
	private WebElement newsLetter;
	@FindBy(xpath="//div[contains(@class,'alert')]")
	private WebElement warningMessage;
	@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	@FindBy(xpath="//input[@name='lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	@FindBy(xpath="//input[@name='email']/following-sibling::div")
	private WebElement emailWarning;
	@FindBy(xpath="//input[@name='telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	@FindBy(xpath="//input[@name='password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public void enterFirstName(String firstNameText) {
		elementUtils.typeTextInToElement(firstNameField, firstNameText, 30);
	}
	public void enterLastName(String lastNameText) {
		elementUtils.typeTextInToElement(lastNameField, lastNameText, 30);
	}
	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextInToElement(emailField, emailText, 30);
	}
	public void enterTelephone(String telephoneText) {
		elementUtils.typeTextInToElement(telephoneField, telephoneText, 30);
	}
	public void enterPassword(String passwordText) {
		elementUtils.typeTextInToElement(passwordField, passwordText, 30);
	}
	public void enterConfirmPassword(String confirmPasswordText) {
		elementUtils.typeTextInToElement(confirmField, confirmPasswordText, 30);
	}
	public void clickAgree() {
		elementUtils.clickOnElement(agree, 30);
	}
	public AccountSuccessPage clickContinue() {
		elementUtils.clickOnElement(continueClick, 30);
		return new AccountSuccessPage(driver);
	}
	public void checkNewsLetter() {
		elementUtils.clickOnElement(newsLetter, 30);
	}
	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMessage, 30);
	}
	public String getFirstNameWarning() {
		return elementUtils.getTextFromElement(firstNameWarning, 30);
	}
	public String getLastNameWarning() {
		return elementUtils.getTextFromElement(lastNameWarning, 30);
	}
	public String getEmailWarning() {
		return elementUtils.getTextFromElement(emailWarning, 30);
	}
	public String getTelephoneWarning() {
		return elementUtils.getTextFromElement(telephoneWarning, 30);
	}
	public String getPasswordWarning() {
		return elementUtils.getTextFromElement(passwordWarning, 30);
	}
}
