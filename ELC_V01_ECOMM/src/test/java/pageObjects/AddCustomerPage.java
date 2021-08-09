package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseProperties;

public class AddCustomerPage extends BaseProperties {
	
	 public WebDriver ldriver;
	 public AddCustomerPage(WebDriver rdriver) {
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	 }
	
     public String getPageTitle() {
	   String pageTitle =ldriver.getTitle();
	   return (pageTitle);
     }
     By LnkCustomerMenu =By.xpath("//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/child::li[4]");
     By LnkCutomerMenuItem =By.xpath("//li[@class='nav-item has-treeview menu-open']/child::ul/child::li[1]");
     By addNewCustomer =By.xpath("//a[@class='btn btn-primary']");
     By email =By.xpath("//input[@id='Email']");
     By password =By.xpath("//input[@id='Password']");
     By Fname =By.xpath("//input[@id='FirstName']");
     By Lname =By.xpath("//input[@id='LastName']");
     By genderMale =By.xpath("//input[@id='Gender_Male']");
     By dateofBirth =By.xpath("//input[@id='DateOfBirth']");
     By company =By.xpath("//input[@id='Company']");
     By userType_Guest =By.xpath("(//div[@role='listbox'])[2]");
     By sucessMessage =By.xpath("//div[@class='alert alert-success alert-dismissable']");
     //By customerMenu=By.xpath("//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/child::li[4]");
     By saveDeatils =By.xpath("(//button[@class='btn btn-primary'and @type='submit'])[1]");
     
     public void clickCustomerMenu() throws InterruptedException {
    	 ldriver.findElement(LnkCustomerMenu).click();
    	 Thread.sleep(5000);
     }
     public void LnkCutomerMenuItem() {
    	 ldriver.findElement(LnkCutomerMenuItem).click();
     }
     public void addNewCustomer() {
    	 ldriver.findElement(addNewCustomer).click();
     }
     public void enterEmail() {
    	 String randomEmail=generateRandomString()+"@gmail.com";
    	 ldriver.findElement(email).sendKeys(randomEmail);
     }
     public void enterPwd() {
    	 String pwd=generateRandomString();
    	 ldriver.findElement(password).sendKeys(pwd);
     }
     public void enterFame() {
    	 ldriver.findElement(Fname).sendKeys(generateRandomString());
     }
     public void enterLame() {
    	 ldriver.findElement(Lname).sendKeys(generateRandomString());
     }
     public void selectGender() {
    	 ldriver.findElement(genderMale).click();
     }
     public void enterDob() {
    	 ldriver.findElement(dateofBirth).click();
     }
     public void selectCompany() {
    	 ldriver.findElement(company).sendKeys(generateRandomString());
     }
     public void selectUserType() {
    	 ldriver.findElement(userType_Guest).click();
     }
     public String GetSucessmessage() {
    	 String sucessmessage =ldriver.findElement(sucessMessage).getText();
    	 return(sucessmessage);
     }
     public void saveUserDeatils() {
    	 ldriver.findElement(saveDeatils).click();
     }
    
     
     
   

}
