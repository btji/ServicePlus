package com.bt.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bt.base.Page;
import com.bt.pages.HomePage;
import com.bt.pages.LoginPage;
import com.bt.pages.ZohoAppsPage;
import com.bt.pages.crm.accounts.AccountsPage;
import com.bt.pages.crm.accounts.CreateAccountPage;

public class LoginTest{
	
	
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		/*
		 * HomePage home=new HomePage(); home.gotoLogIn(); 
		 * LoginPage login=new LoginPage(); login.doLogIn("lawlessbt@gmail.com", "Admin@0810"); ZohoAppsPage
		 * zp=new ZohoAppsPage(); zp.goToCRM(); Page.menu.gotoAccounts(); 
		 * AccountsPage account=new AccountsPage(); account.gotoCreateAccounts(); 
		 * CreateAccountPage cap=new CreateAccountPage(); cap.createAccount("Brijesh");
		 */
	
		
		/*
		 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		 * + "\\resources\\executables\\chromedriver.exe"); driver=new ChromeDriver();
		 * 
		 * driver.get("https://www.zoho.com/index1.html");
		 * driver.findElement(By.cssSelector(".login")).click();
		 * driver.findElement(By.cssSelector("#login_id")).sendKeys(
		 * "lawlessbt@gmail.com");
		 * driver.findElement(By.xpath("//form[@id='login']//button[@id='nextbtn']")).
		 * click(); Thread.sleep(3000);
		 * driver.findElement(By.cssSelector("#password")).sendKeys("Admin@0810");
		 * driver.findElement(By.cssSelector("#login>#nextbtn")).click();
		 */

		
		


		//After Page Object Model implemented..
		
		  HomePage home=new HomePage(); LoginPage lp=home.gotoLogIn(); ZohoAppsPage
		  zp=lp.doLogIn("JK000115", "Admin@123", "jw62ka"); 
		  zp.goToCRM();
		  
		  AccountsPage account= Page.menu.gotoAccounts(); CreateAccountPage
		  cap=account.gotoCreateAccounts(); 
		  cap.createAccount("Brijesh", "dd", "dd");
		 	
	}

}
