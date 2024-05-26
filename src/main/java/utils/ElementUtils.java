package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;
	public ElementUtils(WebDriver driver){
		this.driver=driver;
	}
	public WebElement waitForElement(WebElement element,long durationInSeconds) {
		WebElement webElement=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Throwable e) {
			e.printStackTrace();			
		}
		return webElement;	
	}
	public void clickOnElement(WebElement element,long durationInSeconds) {
		WebElement webElement=waitForElement(element, durationInSeconds);
	    webElement.click();
	}
	public void typeTextInToElement(WebElement element,String typeToBeTyped,long durationInSeconds) {
		WebElement webElement=waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(typeToBeTyped);;
		
	}
	public String getTextFromElement(WebElement element,long durationInSeconds) {
		WebElement webElement=waitForElement(element, durationInSeconds);
		return webElement.getText();
	}
	public boolean displayStatus(WebElement element,long durationInSeconds) {
		try {
		WebElement webElement=waitForElement(element, durationInSeconds);
		return webElement.isDisplayed();
		}catch(Throwable e) {
			e.printStackTrace();
			return false;
		}
	}
	public void selectOptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds) {
		WebElement webElement=waitForElement(element, durationInSeconds);
		Select select=new Select(element);
		select.selectByVisibleText(dropDownOption);
	}
	public Alert waitForAlert(long durationInSeconds) {
		Alert alert=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		alert=wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}
	public void acceptAlert(long durationInSeconds) {
		Alert alert=waitForAlert(durationInSeconds);
		alert.accept();
	}
	public void dismissAlert(long durationInSeconds) {
		Alert alert=waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	public WebElement waitForvisibilityOfElement(WebElement element,long durationInSeconds) {
		WebElement webElement=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webElement=wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	public void mouseHoverAndClick(WebElement element,long durationInSeconds){
		WebElement webElement=waitForvisibilityOfElement(element,durationInSeconds);
		Actions actions=new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
		
	}
	public void javaScriptClick(WebElement element,long durationInSeconds) {
		WebElement webElement=waitForvisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click", webElement);
		
	}

public void javaScriptEnterText(WebElement element,long durationInSeconds,String text) {
	WebElement webElement=waitForvisibilityOfElement(element,durationInSeconds);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].value='"+text+"'",webElement);
			
}
}