package stepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchByEmailid;

public class Steps extends BaseProperties {
	@Before
	public void SetUp() throws IOException {
		configProperties = new Properties();
		FileInputStream fis = new FileInputStream("Config.properties");
		configProperties.load(fis);
		String runBrowser = configProperties.getProperty("browsername");
		System.out.println(runBrowser);
	    System.setProperty("webdriver.chrome.driver", configProperties.getProperty("ChromePath"));
		driver = new ChromeDriver();
		
	}
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() throws IOException {
//		configProperties = new Properties();
//		FileInputStream fis = new FileInputStream("Config.properties");
//		configProperties.load(fis);
//		System.out.println(configProperties.getProperty("ChromePath"));
//		System.setProperty("webdriver.chrome.driver",configProperties.getProperty("ChromePath"));
//		driver = new ChromeDriver();
		lp = new LoginPage(driver);
		Ap = new AddCustomerPage(driver);
		semaild = new SearchByEmailid(driver);
		

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} ans Password as {string}")
	public void user_enters_email_as_ans_password_as(String email, String pwd) {
		lp.setEmail(email);
		lp.setPassword(pwd);
	}

	@When("Click on Login")
	public void click_on_login() {
		// lp.acceptPrivacy();
		lp.loginUser();
	}

	@Then("validate Login Sucessful")
	public void validate_login_sucessful() throws InterruptedException {
		System.out.print("VALIDATION DONE");
		Thread.sleep(10000);
	}

	@Then("Close browser")
	public void close_browser() {
		driver.quit();
	}

	// DashBoard page
	@Then("User Can View Dashboard")
	public void user_can_view_dashboard() {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("Dashboard / nopCommerce administration", Ap.getPageTitle());
		// Assert.assertEquals("Dashboard / nopCommerce
		// administration",Ap.getPageTitle());
	}

	@When("User click on Cutomer menu")
	public void user_click_on_cutomer_menu() throws InterruptedException {
		// Ap = new AddCustomerPage(driver);
		Ap.clickCustomerMenu();
	}

	@When("Click on Cutomermenu item")
	public void click_on_cutomermenu_item() {
		Ap.LnkCutomerMenuItem();
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() {
		Ap = new AddCustomerPage(driver);
		Ap.addNewCustomer();
	}

	@Then("User Can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("Add a new customer / nopCommerce administration", Ap.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		Ap.enterFame();
		Ap.enterEmail();
		Ap.enterLame();
		Ap.enterDob();
		Ap.selectCompany();
		Thread.sleep(20000);
	}

	@When("click on Save button")
	public void click_on_save_button() {
		Ap.saveUserDeatils();
	}

	@Then("User can view confirmaton message {string}")
	public void user_can_view_confirmaton_message(String string) {
		String message = Ap.GetSucessmessage();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(message, string);
//	    String message=Ap.GetSucessmessage();
//	    Assert.assertEquals(message,string);
	}

//Search By EmailId///
	@When("Entered emailadd as {string} for search")
	public void entered_emailadd_as_for_search(String string) throws InterruptedException {
		semaild = new SearchByEmailid(driver);
		semaild.searchByEmail(string);
		Thread.sleep(5000);
	}

	@When("Click on Search button")
	public void click_on_search_button() {
		semaild.srchButton();
	}

	@Then("Userresult should be validated from table")
	public void userresult_should_be_validated_from_table() {
		Boolean ststus = semaild.GetResult("victoria_victoria@nopCommerce.com");
		System.out.println(ststus + "FOUND RESULT");
		Assert.assertTrue(ststus);

	}

//Seacrh result by Fname and Lname
	@When("Entered firstname as {string} and lastname as {string}")
	public void entered_firstname_as_and_lastname_as(String string, String string2) throws InterruptedException {
		semaild = new SearchByEmailid(driver);
		semaild.setFirstName(string);
		Thread.sleep(50000);
		semaild.setLastName(string2);
		Thread.sleep(50000);
	}

	@Then("Userresult for name should be validated from table")
	public void userresult_for_name_should_be_validated_from_table() throws InterruptedException {
		Boolean ststus = semaild.GetResultforName();
		System.out.println(ststus);
		Assert.assertTrue(ststus);
//		Thread.sleep(20000);
//		String name=semaild.GetResultforName();
//		System.out.println(name);
	}

}
