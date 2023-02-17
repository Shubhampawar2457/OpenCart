package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class MyAccountPage extends BaseClass {

	public MyAccountPage (WebDriver driver) {
		super();
	}

  @FindBy(xpath="//h2[text()='My Account']")
  WebElement msgHeading;
  
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
  WebElement lnkLogout;
  
  
  public boolean isMyAccountPageExist()
  {
	  try {
		  return(msgHeading.isDisplayed());
	  } 
	  catch (Exception e){
	return false;
	  }
  }
  
  public void clicklogout() {
	  lnkLogout.click();
  }



}
