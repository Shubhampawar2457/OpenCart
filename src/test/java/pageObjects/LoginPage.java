package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	

public LoginPage(WebDriver driver) {
	super(driver);
}

//Elements
@FindBy(name="email")
WebElement txtemail;

@FindBy(name="password")
WebElement txtpassword;


@FindBy(xpath="//input[@value='Login']")
WebElement btnLogin;


public void setemail(String email) {
	txtemail.sendKeys(email);
}

public void clearemail()
{
	txtemail.clear();
}

public void setpassword(String pwd) {
	txtpassword.sendKeys(pwd);
}

public void clearpassword() {
	txtpassword.clear();
}

public void clickbtnLogin() {
	btnLogin.click();
}
}
