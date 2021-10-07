package com.bt.pages.crm.accounts;

import org.openqa.selenium.By;

import com.bt.base.Page;

public class AccountsPage extends Page{
	
	public CreateAccountPage gotoCreateAccounts() {
		click("AddNewConfig_XPATH");
		select("ConfigTypeDD_CSS", "Rapid Assessment System ");
		click("ConfigBtn_CSS");
		return new CreateAccountPage();
	}	
	public void gotoImportAccounts() {
		driver.findElement(By.cssSelector(".importIcon")).click();	
		driver.findElement(By.linkText("Import Accounts")).click();
	}	
	public void gotoImportantNotes() {
		driver.findElement(By.cssSelector(".importIcon")).click();	
		driver.findElement(By.linkText("Import Notes")).click();	
	}
}
