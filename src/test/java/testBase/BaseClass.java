package testBase;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br)
	{
		rb= ResourceBundle.getBundle("config");
		logger= LogManager.getLogger(this.getClass());
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String [] {"enable-automation"});
		
		if(br.equals("chrome"))
		{
		driver= new ChromeDriver(options);
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
		driver= new FirefoxDriver();	
		}
		
		driver.get("http://localhost/opencart/upload/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass(groups= {"master","Sanity","Regression"})
	public void teardown()
	{
		driver.close();
	}
	
	public String randomString()
	{
		String generatedString= RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
	}
	
	public String randomNumber()
	{
		String generatedString2= RandomStringUtils.randomNumeric(10);
		return(generatedString2);
	}
	
	public String randomAlphaNumeric()
	{
		String str= RandomStringUtils.randomAlphabetic(3);
		String num= RandomStringUtils.randomNumeric(4);
		return(str+"@"+num);
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(1));
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}


	
	/*public String captureScreen(String tname) throws Exception{
		
		
		String timestamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
		File source= takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"\\screenshot\\"+tname+"_"+timestamp+".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		}
		catch (Exception e){
			e.getMessage();
			
		}
		
		return destination;		
		}
*/

	
	}
	
	

