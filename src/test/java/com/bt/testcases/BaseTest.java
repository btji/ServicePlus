package com.bt.testcases;

import org.testng.annotations.AfterSuite;

import com.bt.base.Page;

public class BaseTest {
		
	
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		Page.quit();
	}
}
