package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utils.CommonUtils;

public class DriverFactory {
	static WebDriver driver=null;
	
	public  WebDriver initializeBrowser(String browserName) {
		
		if(browserName.equals("chrome")){
			 driver=new ChromeDriver();
		}else if(browserName.equals("edge")) {
			 driver=new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGELOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICITWAIT_TIME));
		
		return driver;
	}
	
	public  WebDriver getDriver() {
		return driver;
	}

}
