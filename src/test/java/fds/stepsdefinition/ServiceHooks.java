package fds.stepsdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import fds.cucumber.TestContext;

public class ServiceHooks {
	
	TestContext testContext;
	WebDriver driver;
	
	public ServiceHooks (TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
	}
	@Before
	public void initializeTest() {
		driver.manage().window().maximize();
	}
	/**********************take screenshot if scenario failed**********************/ 
	@After
	public void takescreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
	       try {
	    	   final byte[] screenshot = ((TakesScreenshot) driver )
                       .getScreenshotAs(OutputType.BYTES);
	    	   scenario.embed(screenshot, "image/png"); 
	       } catch (Exception e) {
	            e.printStackTrace();
	       }
	   }
	}
	@After
	public void teadown(){
		driver.quit();
	}
}
