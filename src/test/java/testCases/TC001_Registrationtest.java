package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseTest;

public class TC001_Registrationtest extends BaseTest{
	
				
	@Test (groups= {"Sanity","Master"})
	public void testRegistration() throws InterruptedException
	{
		HomePage hp=new HomePage (driver);
		hp.click_Account();
		hp.click_Register();
		
		RegistrationPage reg=new RegistrationPage (driver);
		reg.setFirstName(getRandomAlphabetic());
		reg.setLastName(getRandomAlphabetic());
		reg.setEmail(getalphanumberic()+"@xyx.com");
		reg.setPhoneno(getRandomNumeric());
		String password=getalphanumberic();
		reg.setPassword(password);
		reg.SetConfirmPwd(password);
		reg.Click_Enable();
		reg.Click_Submit();	
		
		String expected_Message=reg.acct_successful();
		Assert.assertEquals("Your Account Has Been Created!", expected_Message);
		System.out.println("Message: "+ expected_Message);
		
	}

}
