package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC002_LoginTest extends BaseTest{
	
	
	@Test (groups={"Regression","Master"})
	public void login()
	{
		HomePage hp=new HomePage(driver);
		hp.click_Account();
		hp.click_login();
		
		LoginPage lp=new LoginPage (driver);
		lp.setemail_user(prop.getProperty("email"));
		lp.setpwd_user(prop.getProperty("password"));
		lp.clicklogin();
		
		MyAccountPage myacc=new MyAccountPage(driver);
		Assert.assertEquals(true, myacc.isMyAcctDiplayed());
		
	}

}
