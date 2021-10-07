package com.bt.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.bt.pages.HomePage;
import com.bt.pages.LoginPage;
import com.bt.utilities.Utilities;

public class LoginTest extends BaseTest{
	
	
	@Test(dataProviderClass = Utilities.class, dataProvider ="dp" )
	public void loginTest(Hashtable<String, String> data) throws InterruptedException {
		HomePage home=new HomePage();
		LoginPage lp=home.gotoLogIn();
		lp.doLogIn(data.get("username"), data.get("password"), data.get("captcha"));		
		
	}
}
