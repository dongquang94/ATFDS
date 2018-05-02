package test.java.fds.stepsdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import main.java.fds.cucumber.TestContext;
import main.java.fds.pages.AdminPage;
import main.java.fds.pages.HomePage;

public class Create {

	TestContext testContext;
	HomePage homePage;
	AdminPage adminPage;
	
	public Create(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		adminPage = testContext.getPageObjectManager().getAdminPage();
	}
	
	@Given("^I am on URL \"([^\"]*)\"$")
    public void i_am_on_the_page_on_URL(String arg1) throws Throwable {	 
		homePage.goToHomePage(arg1);
    }
 
    @When("^I fill in username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_fill_in_username_and_password(String arg1, String arg2) throws Throwable {
        homePage.goToLoginPanel(arg1, arg2);
    }
 
    @When("^I click on the \"([^\"]*)\" button$")
    public void i_click_on_the_button(String arg1) throws Throwable {
    	    	
    	if(arg1.equalsIgnoreCase("Đăng nhập")){
    		homePage.clickLogin();
    	} else {
    		homePage.clickOtherButton(arg1.toUpperCase());
    	}
    }
    
    @When("^I fill in \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_fill_data(String arg1, String arg2) throws Throwable{
    	homePage.fillData(arg1.replaceAll(" ", "").toUpperCase(), arg2);
    }
    
    @When("^I click file upload \"([^\"]*)\"$")
    public void i_click_file_upload(String arg1) throws Throwable{
    	homePage.fileUpload(arg1);
    }
    
    @When("^I click on the \"([^\"]*)\" in confirm dialog$")
    public void i_click_confirm_dialog(String arg1) throws Throwable{
    	homePage.confirmDialog(arg1);
    }
    
    @When("^I click on the label \"([^\"]*)\"$")
    public void i_click_label(String arg1) throws Throwable{
    	homePage.clickOtherButton(arg1);
    }
    
    @When("^I choose \"([^\"]*)\" in dropdown menu$")
    public void i_choose_link_dropdown_menu(String arg1) throws Throwable{
    	homePage.clickOtherButton(arg1);
    }
    
    @When("^I fill dossier id to search box$")
    public void i_fill_search_box() throws Throwable{
    	homePage.fillData("", "");
    }
    
    @When("^I choose dossier in the top$")
    public void i_choose_top() throws Throwable{
    	homePage.clickOtherButton("top");
    }
}
