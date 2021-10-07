package com.bt.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.bt.utilities.ExcelReader;
import com.bt.utilities.ExtentManager;
import com.bt.utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Page {

	public static WebDriver driver; // static so that driver instance can be pass On
									// instead of creating new instance.

	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\resources\\excell\\testData.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;

	public static TopMenu menu;

	public Page() {
		if (driver == null) { // Only create driver instance when it is null
							// else above will be pass on.
			
//to load prperties file 			
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			config.load(fis);
			log.debug("config file loaded !!!!!!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			or.load(fis);
			log.debug("OR file loaded !!!!!!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//to map browsers with jenkins..	Jenkins browser filter configuration.		
		if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
			browser = System.getenv("browser");
		} else {
			browser = config.getProperty("browser");
		}
		config.setProperty("browser", browser);

//Browser codes			
		if (config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir") + "\\resources\\executables\\geckodriver.exe");

			driver = new FirefoxDriver();
		} 
		else if (config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\resources\\executables\\chromedriver.exe");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("start-maximized");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

	
			driver = new ChromeDriver(options);
		}	
		else if (config.getProperty("browser").equals("IE"))
		{
			System.setProperty("webdriver.IE.driver","IE.exe path");
			driver=new InternetExplorerDriver();
		}

		
		driver.get(config.getProperty("testurl"));
		log.debug("Navigate to: "+config.getProperty("testurl"));
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		wait=new WebDriverWait(driver,5);
		
		menu = new TopMenu(driver);
		}		
	
	}
	public static void quit() {
		driver.quit();
	}	
	
	
	
// to Check if particural element is present on the web-page.
		public boolean isElementPresent(By by) 
		{
			try {
				driver.findElement(by);
				return true;
			}
			catch (NoSuchElementException e) {
				// TODO: handle exception			
				return false;
			}		
		}
		
//to switch to some other window
		public void switchh(String locator)
		{
			driver.switchTo().frame(or.getProperty(locator));
			
			log.debug("Clicking an element: "+locator);
			test.log(LogStatus.INFO, "clicking on: "+locator);
		}
		
		
// to CLick on any element using locators on Web Page	
		public void click(String locator)
		{
			if(locator.endsWith("_CSS"))
				driver.findElement(By.cssSelector(or.getProperty(locator))).click();			
			else if (locator.endsWith("_XPATH"))
				driver.findElement(By.xpath(or.getProperty(locator))).click();			
			else if (locator.endsWith("_ID"))
				driver.findElement(By.id(or.getProperty(locator))).click();	
			
			log.debug("Clicking an element: "+locator);
			test.log(LogStatus.INFO, "clicking on: "+locator);
		}	
		
		
// to Type on any element using locators on Web Page	
		public void type(String locator,String value)
		{
			if(locator.endsWith("_CSS"))
				driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
			
			else if(locator.endsWith("_XPATH"))
				driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
			
			else if (locator.endsWith("_ID"))	
				driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
			
			log.debug("Typing in element: "+locator+ " entered value as: " +value);
			test.log(LogStatus.INFO,"Typing in: "+locator+ " entered value as: " +value);
		}
		
		
// to handle drop-down on any element using locators on Web Page	
		public static WebElement dropdown;
		public static void select(String locator, String value)
		{
			if(locator.endsWith("_CSS"))
				dropdown=driver.findElement(By.cssSelector(or.getProperty(locator)));		
			
			else if(locator.endsWith("_XPATH"))
				dropdown=driver.findElement(By.xpath(or.getProperty(locator)));		
			
			else if (locator.endsWith("_ID"))	
				dropdown=driver.findElement(By.id(or.getProperty(locator)));
			
			Select select=new Select(dropdown);
			select.selectByVisibleText(value);		
			
			log.debug("Selecting from drop down : "+locator+ " value as: " +value);
			test.log(LogStatus.INFO,"Selecting from drop down : "+locator+ " value as: " +value);
		}
		
		
		
//Verify equalsss
		public static void verifyEquals(String expected, String actual) throws IOException
		{
			try {
				Assert.assertEquals(expected, actual);
			
			}catch(Throwable t){
				Utilities.captureScreenshot();
				
//ReportNG
				Reporter.log("<br>"+"Verification failed : "+t.getMessage()+"<br>");
				Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" height=200 width=200></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");
				
//Extent Report
				Page.test.log(LogStatus.FAIL,"Verification Failed with exception: "+t.getMessage());		
				Page.test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));		
				
			}
		}
	
	
	
}

