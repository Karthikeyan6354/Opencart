package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement Link_MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement link_Register;
	
	@FindBy (xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	
	WebElement link_login;
	
	public void click_Account()
	{
		Link_MyAccount.click();
	}
	
	public void click_Register()
	{
		link_Register.click();
	}
	
	public void click_login()
	{
		link_login.click();
	}
	
	
}
