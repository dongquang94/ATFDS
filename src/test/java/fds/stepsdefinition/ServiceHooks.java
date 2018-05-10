package test.java.fds.stepsdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import main.java.fds.cucumber.TestContext;
import main.java.fds.managers.FileReaderManager;

public class ServiceHooks {
	
	TestContext testContext;
	WebDriver driver;

	public ServiceHooks(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
	}

	@Before
	public void initializeTest() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/****************************************
	 * Take screenshot if scenario failed
	 ****************************************/
	@After
	public void takescreenshot(Scenario  scenario) {
		if (scenario.isFailed()) {
			try {
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        InputStream screenshotStream = new FileInputStream(screenshot);
		        scenario.embed(IOUtils.toByteArray(screenshotStream), "image/png");  
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@After
	public void teadown() {
		driver.quit();
	}
}
