package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader confReader;
	Properties prop;
	
	@Before(order = 0 ) // in @Before "0" will be executed first
	public void getProperty() {
		confReader = new ConfigReader();
		prop = confReader.init_prop();

	}
	@Before(order = 1 )
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
	}
	
	@After(order = 0 ) // in @After "0" will be executed last
	public void quitBrowser() {
		if(driver!=null) {
			driver.quit();
		}
		
	}
	
	@After(order = 1)
	public void tearDown(Scenario sc) {
		if(sc.isFailed()) {
			// take screenshot
			String screenshotName = sc.getName().replaceAll(" ", "_");
			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcePath, "image/png", screenshotName);
		}
		
	}
	

}
