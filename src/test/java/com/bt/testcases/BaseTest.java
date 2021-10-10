package com.bt.testcases;

import org.testng.annotations.AfterSuite;

import com.bt.base.Page;

public class BaseTest {
		
	String a="hey ";
	
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		Page.quit();
		System.out.println(a+"how are?");

	}
}
