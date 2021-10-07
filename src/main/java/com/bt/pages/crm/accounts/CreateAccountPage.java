package com.bt.pages.crm.accounts;


import com.bt.base.Page;

public class CreateAccountPage extends Page{
				
	
	public void createAccount(String stateid,String deptid,String serviceid) {
			
				type("StateID_XPATH", stateid);
				type("DeptID_XPATH", deptid);
				type("ServiceID_XPATH", serviceid);
				
				click("DetailsTaken_ID");
				select("Mob_ID", "Mobile Number");
				select("Email_ID", "E-Mail");
				
				click("Submit_CSS");
				
	}
}
