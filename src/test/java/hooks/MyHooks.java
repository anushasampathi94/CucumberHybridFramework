package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;
	private ConfigReader configReader;
	private DriverFactory driverFactory;
	@Before
	public void setup() throws IOException {
		 configReader=new ConfigReader();
		Properties prop=configReader.initializeProperties();
		driverFactory=new DriverFactory();
		driver=driverFactory.initializeBrowser(prop.getProperty("browser"));		
		driver.get(prop.getProperty("url"));
		
		}

	@After
	public void teardown(Scenario scenario) {
		String scenarioName=scenario.getName().replace(" ","_");
		if(scenario.isFailed()) {
			byte[] srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		driver.quit();
	}

}
