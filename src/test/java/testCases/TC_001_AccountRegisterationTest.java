package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegisterationTest extends BaseClass{
	
	
	@Test(groups={"Regression","master"})
	public void test_account_registeration() throws Exception
	{
		try {
			
			logger.info("***   started TC_001_AccountRegisterationTest  *** ");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on MyAccount");
		hp.clicklnkRegister();
		logger.info("clicked on Register");
		AccountRegisterationPage regpage= new AccountRegisterationPage(driver);
		regpage.setfirstname(randomString().toUpperCase());
		regpage.setlastname(randomString().toUpperCase());
		regpage.setemail(randomString()+"@gmail.com");
		regpage.settelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		regpage.setpassword(password);
		regpage.setconfpassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickcontinue();
		logger.info("clicked on continue");
		
		String confmsg= regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		
		logger.info("***    fineshed TC_001_AccountRegisterationTest  *** ");
	}

}
