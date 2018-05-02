package fds.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import fds.pages.AdminPage;
import fds.pages.HomePage;

public class PageObjectManager {
	private WebDriver driver;
	private WebDriverWait wait;
 
	private AdminPage adminPage;
	private HomePage homePage; 
 
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage(){
		return (homePage == null) ? homePage = new HomePage(driver, wait) : homePage;
	}

	public AdminPage getAdminPage() {
		return (adminPage == null) ? adminPage = new AdminPage(driver,wait) : adminPage;
	}

}
