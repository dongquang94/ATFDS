package test.java.fds.stepsdefinition;

import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import main.java.fds.cucumber.TestContext;
import main.java.fds.pages.AdminPage;
import main.java.fds.pages.HomePage;
import main.java.fds.utils.Log;
import main.java.utils.database.ConnectToDatabase;
import main.java.fds.managers.FileReaderManager;
import main.java.fds.bean.User;

public class Create {

	TestContext testContext;
	HomePage homePage;
	AdminPage adminPage;
	
	User user;
	
	private String testDataSqlTag = "login";
	
	public Create(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		adminPage = testContext.getPageObjectManager().getAdminPage();
	}
	
	
	/***************************************
	 * Prepare Test Data for feature
	 ***************************************/
	@Before
	public void prepareData() throws Throwable {
		String sqlQuery = FileReaderManager.getInstance().getSQLReader().getQueryString(testDataSqlTag);
		ConnectToDatabase connection = new ConnectToDatabase();
		connection.SetUpConnection();
		connection.PrepareTestData(sqlQuery);
		connection.CloseTheConnection();
	}
	
	/***************************************
	 * Feature actions
	 ***************************************/
 
    @When("^I fill in username and password with \"([^\"]*)\"$")
    public void i_fill_in_username_and_password(String id) throws Throwable {
    	user = FileReaderManager.getInstance().getJsonReader().getUserById(id);
        homePage.goToLoginPanel(user.getUsername(), user.getPassword());
    }
 
    @When("^I click on the \"([^\"]*)\" button$")
    public void i_click_on_the_button(String arg1) throws Throwable {
    	    	
    	if(arg1.equalsIgnoreCase("Đăng nhập")){
    		homePage.clickLogin();
    	} else {
    		homePage.clickOtherButton(arg1.toUpperCase());
    	}
    }
    
    @When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void i_fill_data(String arg1, String id) throws Throwable{
    	user = FileReaderManager.getInstance().getJsonReader().getUserById(id);
    	homePage.fillData(arg1.replaceAll(" ", "").toUpperCase(), user.getFullName());
    }
    
    @When("^I click file upload \"([^\"]*)\" file \"([^\"]*)\"$")
    public void i_click_file_upload(String arg1, String id) throws Throwable{
    	user = FileReaderManager.getInstance().getJsonReader().getUserById(id);
    	homePage.fileUpload(arg1, user.getFileUpload());
    	Log.info("--Filename from steps:"+user.getFileUpload());
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
    
    @When("^I fill username and password with user \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_fill_in_username_and_password_with_specific_user_pass(String arg1, String arg2) throws Throwable {
        homePage.goToLoginPanel(arg1, arg2);
    }
}
