package com.bt.pages;

import org.openqa.selenium.By;

import com.bt.base.Page;
import com.bt.pages.crm.CRMHomePage;

public class ZohoAppsPage extends Page{
			
	public void goToBooks() {
		driver.findElement(By.cssSelector("._logo-books._logo-x96.zod-app-logo")).click();
	}
	
	public CRMHomePage goToCRM() {
		click("ManageServices_XPATH");
		click("ViewServices_CSS");
		type("SerchBox_XPATH", "Test Service category");
		click("Actions_CSS");
		click("ClickOnModify_CSS");
		
		return new CRMHomePage();
	}
	
	public void goToConnect() {
		driver.findElement(By.cssSelector("._logo-connect._logo-x96.zod-app-logo")).click();	
	}
	
	public void goToMail() {
		driver.findElement(By.cssSelector("._logo-mail._logo-x96.zod-app-logo")).click();		
	}
	
	public void goToWriter() {
		driver.findElement(By.cssSelector("._logo-writer._logo-x96.zod-app-logo")).click();		
	}
}
