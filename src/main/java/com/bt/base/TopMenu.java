package com.bt.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bt.pages.crm.accounts.AccountsPage;

public class TopMenu {
	
	/*
	 * HomePage hasA Topmenu
	 * Leads 	hasA Topmenu
	 * Accounts hasA Topmenu
	 * etc... so 
	 */
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver) {
		this.driver=driver;
	}
		
	
	public void gotoHome() {
		
	}	
	
	public void gotoLeads() {
		
	}	
	
	public void gotoContacts() {
		
	}	
	
	public void gotoDeals() {
		
	}	
	
	public AccountsPage gotoAccounts() {
//		Page.driver.findElement(By.cssSelector(".lyteMenuActive.lyteItem")).click();	
//		driver.findElement(By.cssSelector(".lyteMenuActive.lyteItem")).click();
		driver.findElement(By.cssSelector(".nav.nav-tabs.list-inline>li:nth-child(12)")).click();
		
		return new AccountsPage();
	}
	
	public void gotoActivities() {
		
	}
	
	public void gotoReports() {
		
	}
	
	public void signOut() {
		
	}
	
}
