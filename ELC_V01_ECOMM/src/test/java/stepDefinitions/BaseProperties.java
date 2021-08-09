package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchByEmailid;

public class BaseProperties {
	public WebDriver driver; 
	public LoginPage lp;
	public AddCustomerPage Ap;
	public Properties configProperties;
	public SearchByEmailid semaild;
    //Generating Random Unique Alphabets	
	public static String generateRandomString() {
		String Emaidid=RandomStringUtils.randomAlphabetic(5);
		return(Emaidid);
	}
	
}
