package com.bt.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.bt.base.Page;
import com.bt.pages.ZohoAppsPage;
import com.bt.pages.crm.accounts.AccountsPage;
import com.bt.pages.crm.accounts.CreateAccountPage;
import com.bt.utilities.Utilities;

public class CreateAccontTest {

	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String, String> data)
	{
		ZohoAppsPage zp=new ZohoAppsPage();
		zp.goToCRM();
		
		AccountsPage account= Page.menu.gotoAccounts();
		CreateAccountPage cap=account.gotoCreateAccounts();
		cap.createAccount(data.get("stateid"),data.get("deptid"),data.get(""));
	}
}
