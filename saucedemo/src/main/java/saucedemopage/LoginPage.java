package saucedemopage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver driver;
	
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement loginbtn;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public void setValues(String uname, String pass) {
		username.clear();
		username.sendKeys(uname);
		password.clear();
		password.sendKeys(pass);
	}
	public void loginClick() {
		loginbtn.click();
	}

}
