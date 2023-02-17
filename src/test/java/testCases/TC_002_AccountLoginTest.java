package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_AccountLoginTest extends BaseClass{

	@Test(groups= {"Sanity","master"})
	public void test_AccountLogin()
	{
		logger.info("***   started TC_002_AccountLoginTest  *** ");
		
		try
		{HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on MyAccount");
		hp.clicklnklogin();
		logger.info("clicked on login");
		LoginPage lp=new LoginPage(driver);
		
		Thread.sleep(4000);
		lp.setemail(rb.getString("email"));
		logger.info("entered email address");
		lp.setpassword(rb.getString("password"));
		logger.info("Entered password");
		lp.clickbtnLogin();
		
		
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetPage= macc.isMyAccountPageExist();
		Assert.assertEquals(targetPage, false,"invaid login data");
		//macc.isMyAccountPageExist();
		logger.info("Logged in MyAcount");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****  fineshed TC_002_AccountLoginTest  **** ");
	}
	
	
}
