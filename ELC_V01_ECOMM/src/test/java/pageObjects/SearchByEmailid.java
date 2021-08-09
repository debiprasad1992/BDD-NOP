package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sun.tools.javac.util.List;

import utilities.WaitHelper;

public class SearchByEmailid {

	public WebDriver mdriver;
	WaitHelper waithelp;

	public SearchByEmailid(WebDriver sdriver) {
		mdriver = sdriver;
		PageFactory.initElements(sdriver, this);
		WaitHelper waithelp = new WaitHelper(mdriver);
	}

	By tableExtract = By.xpath("//table[@id='customers-grid']/thead/following-sibling::tbody/tr[1]/td[2]");
	By srchButtonn = By.xpath("//button[@id='search-customers']");
	By email = By.xpath("//input[@id='SearchEmail']");
	By Fname = By.xpath("//*[@id='SearchFirstName']");
	By Lname = By.xpath("//*[@id='SearchLastName']");

	public void searchByEmail(String emailid) {
		mdriver.findElement(email).sendKeys(emailid);
		// waithelp.WaitForElement((WebElement) email,50);
	}

	public void srchButton() {
		mdriver.findElement(srchButtonn).click();
	}

	public void setFirstName(String firstname) {
		WebElement name = mdriver.findElement(Fname);
		WaitHelper waithelp = new WaitHelper(mdriver);
		waithelp.WaitForElement(name, 50);
		mdriver.findElement(Fname).sendKeys(firstname);

	}

	public void setLastName(String lastname) {
		mdriver.findElement(Lname).sendKeys(lastname);

	}

	public boolean GetResult(String testemail) {
		boolean flag = false;
		int rowCount = mdriver
				.findElements(By.xpath("//table[@id='customers-grid']/thead/following-sibling::tbody/child::tr"))
				.size();
		for (int i = 1; i < rowCount; i++) {
			String realEmail = mdriver
					.findElement(By
							.xpath("//table[@id='customers-grid']/thead/following-sibling::tbody/tr[" + i + "]/td[2]"))
					.getText();
			if (testemail.contains(realEmail)) {
				flag = true;
			}
		}
		return flag;
	}

	public boolean GetResultforName() {
		boolean flag = false;
		String realName=null;
		int rowCount=mdriver
				.findElements(By.xpath("//table[@id='customers-grid']/thead/following-sibling::tbody/child::tr"))
				.size();
		System.out.println(rowCount);
		for (int i = 1;i <=rowCount;i++) {
			 realName = mdriver
					.findElement(By.xpath("//table[@id='customers-grid']/thead/following-sibling::tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println(realName);
			String name[] = realName.split(" ");
            if(name[0].equals("Victoria") && name[1].equals("Terces")) {
				flag = true;
		}
			
		}
		return flag;
		
	}

}
