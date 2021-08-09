package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver mdriver;
	public LoginPage(WebDriver sdriver) {
		mdriver=sdriver;
		PageFactory.initElements(sdriver, this);
		}
	@FindBy(xpath="//input[@id='Email']")
	@CacheLookup
	WebElement txtEmail;
	
//	@FindBy(css="[id='form--registration_short--field--PC_EMAIL_ADDRESS']")
//	@CacheLookup
//	WebElement txtGuestEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	@CacheLookup
	WebElement txtPassword;
	
//	@FindBy(css="[id='form--registration_short--field--PASSWORD']")
//	@CacheLookup
//	WebElement txtGuestPassword;
	
	@FindBy(css="[placeholder*='By clicking \"Register\",']")
	@CacheLookup
	WebElement acceptPrivacy;
	
	@FindBy(css="[data-test-id='form_registration_continue']")
	@CacheLookup
	WebElement registerNewuser;
	
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	@CacheLookup
	WebElement submitButton;
	
	@FindBy(css="[class*='account-profile__newsletter']")
	@CacheLookup
	WebElement CheckNewsLetterEnabled;
	
	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
//	public void setGuestEmail(String guestEmail) {
//		txtGuestEmail.clear();
//		txtGuestEmail.sendKeys(guestEmail);
//	}
	
	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
//	public void setGuestPassword(String guestpwd) {
//		txtGuestPassword.clear();
//		txtGuestPassword.sendKeys(guestpwd);
//	}
//	public void acceptPrivacy() {
//		acceptPrivacy.click();
//	}
	public void loginUser() {
		submitButton.click();
	}
//	public boolean checkNewsletter() {
//		CheckNewsLetterEnabled.isDisplayed();
//		return true;
//		}
//	public void registerNewUser() {
//		registerNewuser.click();
//	}
	
			
	
}
