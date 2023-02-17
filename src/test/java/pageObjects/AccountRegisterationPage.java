package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage{

	public AccountRegisterationPage (WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(name="firstname")
	WebElement txtFirstname;
	
	@FindBy(name="lastname")
	WebElement txtLastname;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtTelephone;
	
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="confirm")
	WebElement txtconfPassword;
	
	//@FindBy(id="input-newsletter-no")
	//WebElement chkbNewsNo;
	
	@FindBy(name="agree")
	WebElement chkbPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;


	public void setfirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setlastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setemail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void settelephone(String number)
	{
		txtTelephone.sendKeys(number);
	}
	
	public String pwd;
	public void setpassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setconfpassword(String pwd)
	{
		txtconfPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkbPolicy.click();
	}
	
	public void clickcontinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try {
			return(msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
	}
	
	
}	

