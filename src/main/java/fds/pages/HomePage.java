package main.java.fds.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import main.java.fds.managers.FileReaderManager;
import main.java.fds.utils.Log;

public class HomePage extends BasePage {

	//*********Web Elements*********
    //login creater
    String loginButton = "/html/body/div/header/div/div[2]/section/div/div/div/div[1]/form/div[2]/div[2]/button[2]";
    String usernameBox = "//*[@id='input_login']";
    String passwordBox = "//*[@id='input_password']";
    String errorLoginMessage = "//*[@id='yui_patched_v3_18_1_1_1524709531033_76']/div";
    //create
    String dossierManage = "//*[@id='layout_3']/a/span";
    String newDossier = "//*[@id='btn_create_new_dossier']";
    String choice = "//*[@id='NTBD_BVHTTDL']/div/div[3]/div[3]/div/button";
    String missPermission = "//*[@id='dropdown-menu12104']/li/span";
    //fill data
    String fullName = "//*[@id='tenthisinh']";
    //save
    String save = "//*[@id='btn-save-formalpacaTP1']";
    String submit = "//*[@id='btn-submit-dossier']";
    String confirm = "/html/body/div[10]/div[3]/button[2]";
    // get id
    String id = "//*[@id='completedDossierForm']/div[2]/div[1]/p/span[1]";
    //log out
    String info = "//*[@id='dropdownMenu1']/b";
    String logout = "//*[@id='portlet_FrontendWebPortal_LoginPortlet_INSTANCE_FrontendWebPortal_LoginPortlet_1']/div/div/div/div/div/div/ul/li[2]/a";
    //search
    String searchBox = "//*[@id='app']/div/div/div/div/div/div[1]/div[2]/div/div/div[1]/input";
    
    String dossierId = "";
    
    String top = "//*[@id='app']/div/div/div/div/div/div[2]/div[1]/table/tbody/tr/td[3]/a";
    String response = "//*[@id='app']/div/div/div/div/div/div/div[2]/div[1]/div/ul/li[2]/a";
    String approve = "//*[@id='tab-dossier-detail-2']/div/div/div/ul/li[1]/a/button/div";
    String comment = "//*[@id='tab-dossier-detail-2']/div[2]/div/div[2]/div/div/div/div/div[1]/textarea";
    String formOnline = "//*[@id='tab-dossier-detail-2']/div[2]/div/ul/li/div[1]/div[1]/small";
    String save2 = "//*[@id='btn-save-formalpacaKQ1']/div";
    String confirm2 = "//*[@id='tab-dossier-detail-2']/div[2]/div/div[3]/button/div";
    //String fileUpload = "//*[@id='tab-dossier-detail-2']/div[2]/div/ul/li/div[1]/div[2]/button[1]/div";
    
    //*********Constructor*********
    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    //*********Page Methods*********

    public void goToLoginPanel (String username, String password) throws Exception {   
        Thread.sleep(500);
    	writeText(By.xpath(usernameBox),username);
        Thread.sleep(500);
        writeText(By.xpath(passwordBox), password);
    }
    
    public void clickLogin () throws Exception {
    	Thread.sleep(500);
    	click(By.xpath(loginButton));
    }
    
    //Verify Login Condition
    public void verifyLogin (String expectedText) throws Exception {
    	Thread.sleep(1000);
        Assert.assertEquals(readText(By.xpath(errorLoginMessage)), expectedText);
    }
    
    public void clickOtherButton(String label) throws Exception{
    	Thread.sleep(500);
    	if(label.equalsIgnoreCase("Quản lý hồ sơ")){
    		click(By.xpath(dossierManage));
    	} else if(label.equalsIgnoreCase("Tạo hồ sơ mới")){
    		click(By.xpath(newDossier));
    	} else if(label.equalsIgnoreCase("Chọn")){
    		click(By.xpath(choice));
    	} else if(label.equalsIgnoreCase("Cấp giấy phép đưa thí sinh đi tham dự cuộc thi người đẹp, người mẫu quốc tế")){
    		click(By.xpath(missPermission));
    	} else if(label.equalsIgnoreCase("Ghi lại")){
    		click(By.xpath(save));
    	} else if(label.equalsIgnoreCase("Nộp hồ sơ") || label.equalsIgnoreCase("Lưu")){
    		Thread.sleep(2000);
    		click(By.xpath(submit));
    	} else if(label.equalsIgnoreCase("Tên công ty/tổ chức")){
    		Thread.sleep(1000);
    		click(By.xpath(info));
    		Thread.sleep(1000);
    	} else if(label.equalsIgnoreCase(" Đăng xuất")){
    		click(By.xpath(logout));
    	} else if(label.equalsIgnoreCase("top")){
    		click(By.xpath(top));
    	} else if(label.equalsIgnoreCase("Thụ lý hồ sơ")){
    		click(By.xpath(response));
    	} else if(label.equalsIgnoreCase("Hồ sơ hợp lệ")){
    		click(By.xpath(approve));
    		boolean isSync = false;
    		do{
    			isSync = seachElement(By.xpath(confirm2));
    			System.out.println("isSync: "+isSync);
    			if(!isSync){
    				refresh();
    				Thread.sleep(2000);
    				writeText(By.xpath(searchBox), dossierId);
    				Thread.sleep(500);
    				click(By.xpath(top));
    				Thread.sleep(500);
    				click(By.xpath(response));
    				Thread.sleep(500);
    				click(By.xpath(approve));
    			}
    		} while (!isSync);
    	} else if(label.equalsIgnoreCase("Form trực tuyến")){
    		click(By.xpath(formOnline));
    	} else if(label.equalsIgnoreCase("Ghi lại 2")){
    		click(By.xpath(save2));
    	} else if(label.equalsIgnoreCase("Xác nhận")){
    		click(By.xpath(confirm2));
    	}
    }
    
    public void fillData(String element, String value) throws Exception{
    	Thread.sleep(500);
    	if(element.equalsIgnoreCase("fullName")){
    		writeText(By.xpath(fullName), value);
    	} else if(element.equalsIgnoreCase("Comment")){
    		writeText(By.xpath(comment), value);
    	} else {
    		boolean isNotFound = false;
    		do{
    			writeText(By.xpath(searchBox), dossierId);
    			Thread.sleep(500);
    			isNotFound = seachElement(By.xpath(top));
    			System.out.println("isNotFound: "+isNotFound);
    			if(!isNotFound){
    				refresh();
    				Thread.sleep(2000);
    			}
    		} while (!isNotFound);
    	}
    }
    
    
    public void fileUpload(String fileIndex, String filename) throws Exception{
    	Thread.sleep(500);
    	String elemenLocation = "//*[@id='file"+fileIndex+"']";
//    	if(fileIndex.equalsIgnoreCase("File")){
//    		elemenLocation = fileUpload;
//    		System.out.println(fileUpload);
//    	} else {
//    		elemenLocation = "//*[@id='file"+fileIndex+"']";
//    	}
    	fileUpload(By.xpath(elemenLocation),filename);
    }
    
    public void confirmDialog(String label) throws Exception{
    	Thread.sleep(500);
    	click(By.xpath(confirm));
    	Thread.sleep(2000);
    	dossierId = readText(By.xpath(id));
    	System.out.println("dossierId: "+dossierId);
    }
}