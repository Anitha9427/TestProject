package testClasses;

import org.testng.annotations.Test;

import UtilityClasses.Screenshot_class;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public static WebDriver driver;
    static Properties pr;

	public static void readProperty() throws IOException {
		 pr=new Properties();
		 FileInputStream f= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\configuration.properties");
	     pr.load(f);
	}
	
	@BeforeClass()
	@Parameters("browser")
	public void beforeClass(String browserValue) {
		
		if(browserValue.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		}
		else
		{
			if(browserValue.equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
			}
		}
		
	}
	
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  readProperty();
	  
	  driver.get(pr.getProperty("Base_url"));
	  driver.manage().window().maximize();
	  driver.navigate().refresh();
	  
	  
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException, IOException {
	  
//	  if(itr.getStatus()==ITestResult.FAILURE)
//	  {
//		 Screenshot_class.takeScreenShot(driver, itr.getName());
//	  }
	  Thread.sleep(2000);
	   driver.quit();
  }
  @BeforeSuite(alwaysRun = true)
  public void createReport(final ITestContext testContext) {
		extentReport.ExtentManager.createInstance();
	}

  @AfterSuite 
  
  public void afterSuite(){
	  
	  System.out.println("*******Test execution completed******");
  
	  
	  
  }
  
}
