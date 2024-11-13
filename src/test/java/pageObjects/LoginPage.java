package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy (xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement btn_login;
	
	public void setemail_user(String email)
	{
		txt_email.sendKeys(email);	
	}
	
	public void setpwd_user(String pwd) {
		txt_password.sendKeys(pwd);
	}
	
	public void clicklogin()
	{
		btn_login.click();
	}
	

}
