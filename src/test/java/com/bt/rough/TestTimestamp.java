package com.bt.rough;

import java.util.Date;

public class TestTimestamp {
	public static void main(String[] args) {
			
		Date d= new Date();
		String screenshotName=d.toString().replace(":","_").replace(" ", "_")+".png";
		System.out.println(screenshotName);
	}
}
