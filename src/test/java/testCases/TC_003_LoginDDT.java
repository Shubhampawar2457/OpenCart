package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_003_LoginDDT extends BaseClass{

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email,String password,String exp)
	{
		try {
		logger.info("****   started TC_003_LoginDDT   ****");
		
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on MyAccount");
		hp.clicklnklogin();
		logger.info("clicked on login");
		
		LoginPage lp=new LoginPage(driver);
		lp.setemail(email);
		logger.info("entered email address");
		lp.setpassword(password);
		logger.info("Entered password");
		lp.clickbtnLogin();
		Thread.sleep(4000);
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExist();
		
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				macc.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				macc.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
		
		/*hp.clickMyAccount();
		logger.info("clicked on MyAccount");
		hp.clicklnklogin();
		logger.info("clicked on login");
		*/
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
}	
	

