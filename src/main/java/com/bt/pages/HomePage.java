package com.bt.pages;


import org.openqa.selenium.By;
import org.testng.Assert;

import com.bt.base.Page;

public class HomePage extends Page {
	
			
	public void gotoSignUp() {
		click("signUpLink_CSS");
	}
	
	public LoginPage gotoLogIn() {
	//	click("loginLink_CSS");
			click("Loginlink_CSS");
			switchh("Frame_ID");
		
			return new LoginPage();
	}
	
	public void gotoSupport() {
		click("support_CSS");
		
	}
	
	public void gotocontactSales() {
		click("gotoCustomerSales_CSS");
		
	}
	
	public void gotoCustomers() {
		click("gotoCustomers_CSS");		
	}
	
	public void gotoValidateFooterLinks() {
				
	}		
}