package fds.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    
    //Constructor
    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //Click Method
    public void click (By elementLocation) {
    	WebElement element = driver.findElement(elementLocation);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Actions action = new Actions(driver);
    	action.moveToElement(element).build().perform();
    	element.click();
    }

    //Write Text
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
    
    //File Upload
    public void fileUpload(By elemenLocation){
    	WebElement element = driver.findElement(elemenLocation);
    	element.sendKeys("C://Users//dvquang//Desktop//file_test.png");
    }
    
    public boolean seachElement(By elemenLocation){
    	try{
    		WebElement element = driver.findElement(elemenLocation);
    		return true;
    	} catch (NoSuchElementException ex){
    		System.out.println("not found element");
    		return false;
    	}
    }
    
    public void refresh(){
    	driver.navigate().refresh();
    }
}
