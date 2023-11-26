package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass{
	
	@Test
	public void LoginSuccessTest() {
		LoginPage Login = new LoginPage(driver);
		Login.loginfunction("standard_user", "secret_sauce");
		
		WebElement product = driver.findElement(By.xpath("//div[text()='Products']"));
		
		String actpage = product.getText();
		String exppage = "Products";
		Assert.assertEquals(actpage, exppage);
	}
	
	@Test
	public void LoginFailureTest() {
		
		LoginPage login = new LoginPage(driver);
		login.loginfunction("standard_user", "secret_sauce1");
		
		WebElement errmsg = driver.findElement(By.xpath("//h3[text()=text()='Epic sadface:']"));
		System.out.println("Eroor Msg:" + errmsg.getText());
		
		String actmsg = errmsg.getText();
		String expmsg = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(actmsg, expmsg);
	}

}
