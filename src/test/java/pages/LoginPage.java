package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//==============Locators==================
	
	@FindBy(name="user-name")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbtn;
	
	//==============Constructor=========
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//==============functions=================
	
	public void loginfunction(String usernames, String passwords) {
		
		username.sendKeys(usernames);
		password.sendKeys(passwords);
		loginbtn.click();
	}
	
}
