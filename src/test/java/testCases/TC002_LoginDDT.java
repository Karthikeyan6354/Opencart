package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC002_LoginDDT extends BaseTest{
	
	@Test (dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= "DataDriven")
	public void verify_loginDDT(String username, String password, String result)
	{
		try
		{
		HomePage hp=new HomePage(driver);
		hp.click_Account();
		hp.click_login();
		
		LoginPage lp=new LoginPage (driver);
		lp.setemail_user(username);
		lp.setpwd_user(password);
		lp.clicklogin();
		
		MyAccountPage myacc=new MyAccountPage(driver);
		boolean targetpage= myacc.isMyAcctDiplayed();
		
		/* Data is Valid - login Success - test pass  - logout
		 *                 login unSuccess - test fail
		 *                 
		 * Data is Invalid - login success - testfail - logout
		 *                  login Unsuccess - test pass		  
		 */
		
		if(result.equalsIgnoreCase("Valid"))
		{
			if (targetpage==true)
			{
				Thread.sleep(3000);
				myacc.Click_Logout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertFalse(false);
			}
		}
		if (result.equalsIgnoreCase("Invalid"))
		{
			if (targetpage==true)
			{
				myacc.Click_Logout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}			
	 }
	catch(Exception e)
		{
		Assert.fail();
		}

	}

}
