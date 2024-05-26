package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {
WebDriver driver;
private ElementUtils elementUtils;
private RegisterPage registerPage;

public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	elementUtils=new ElementUtils(driver);
}
@FindBy(xpath="//span[text()='My Account']")
private WebElement myAccountDropMenu;
@FindBy(linkText="Login")
private WebElement loginOption;
@FindBy(linkText="Register")
private WebElement registerOption;
@FindBy(name="search")
private WebElement searchBoxField;
@FindBy(xpath="//button[contains(@class,'btn-default')]")
private WebElement searchButton;

public void clickOnMyAccount() {
	elementUtils.clickOnElement(myAccountDropMenu, 30);
}
public LoginPage selectLoginOption() {
	elementUtils.clickOnElement(loginOption, 30);
	return new LoginPage(driver);
}
public RegisterPage selectregisterOption() {
	elementUtils.clickOnElement(registerOption, 30);
	return new RegisterPage(driver);
}
public void enterProductintoSearchBox(String ProductText) {
	elementUtils.typeTextInToElement(searchBoxField, ProductText, 30);
}
public SearchResultsPage clickSearchButton() {
	elementUtils.clickOnElement(searchButton, 30);
	return new SearchResultsPage(driver);
}
}
