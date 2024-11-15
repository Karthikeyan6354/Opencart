package pageObjects;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
	
	public WebDriver driver;
		
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_FirstName;
	
	@FindBy (xpath="//input[@id='input-lastname']")
	WebElement txt_LastName;
	
	@FindBy (xpath="//input[@id='input-email']")
	WebElement txt_Email;
	
	@FindBy (xpath="//input[@id='input-password']")
	WebElement txt_Password;
	
	@FindBy (xpath="//input[@id='input-confirm']")
	WebElement txt_cnfrmpwd;
	
	@FindBy (xpath="//input[@name='agree']") 
	WebElement chk_TermsAgree;  
	
	@FindBy (xpath="//input[@value='Continue']") 
	WebElement btn_Submit;
	
	@FindBy (xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msg_account_Success;
	
	@FindBy (id="input-telephone")
	WebElement txt_phone;
	
	public void setFirstName(String firstname)
	{
		txt_FirstName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname)
	{
		txt_LastName.sendKeys(lastname);
	}
	
	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txt_Password.sendKeys(pwd);
	}
	
	public void setPhoneno(String P_number)
	{
		txt_phone.sendKeys(P_number);	}
	
	public void SetConfirmPwd(String pwd) {
		txt_cnfrmpwd.sendKeys(pwd);
	}
		
	
	
	public void Click_Enable() throws InterruptedException
	{
		try {
			Thread.sleep(3000);
			
			chk_TermsAgree.click();
        } catch (ElementClickInterceptedException e) {
            
        	WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
        	mywait.until(ExpectedConditions.elementToBeClickable(chk_TermsAgree));
        	
        	
        }
	}
	
		
	public void Click_Submit()
	{
		btn_Submit.click();
	}
	
	public String acct_successful()
	{
		String message=msg_account_Success.getText();
		return message;
	}
	
	
	

	

}
