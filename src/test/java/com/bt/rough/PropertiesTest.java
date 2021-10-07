package com.bt.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println(System.getProperty("user.dir"));
		Properties config=new Properties();
		Properties or=new Properties();
		
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\resources\\properties\\config.properties");		
			config.load(fis);
			
			fis= new FileInputStream(System.getProperty("user.dir")+"\\resources\\properties\\OR.properties");		
			or.load(fis);
			
			System.out.println(config.getProperty("browser"));

			System.out.println(or.getProperty("bmlBtn"));
			
	}

}
