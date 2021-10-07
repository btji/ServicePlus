package com.bt.pages;


import com.bt.base.Page;

public class LoginPage extends Page {
	
	public ZohoAppsPage doLogIn(String userName, String password,String captcha){
		
		
		type("UserName_ID", userName);
		type("Pass_ID", password);
		type("Captcha_ID", captcha);
		
		click("SuccBtn_CSS");
		return new ZohoAppsPage();
	}
	
	
	
	
}
