package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
     
	 public WebDriver driver;
	 
	 public MyAccountPage (WebDriver driver) {
		 super (driver);
	 }
	 
	 @FindBy (xpath="//h2[normalize-space()='My Account']")
	 WebElement myacct;
	 
	 @FindBy (xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	 WebElement link_logout;
	 
	 public boolean isMyAcctDiplayed()
	 {
		 return (myacct.isDisplayed());
	 }
	 
	 public void Click_Logout()
	 {
		 link_logout.click();
	 }


	
}
