package com.bt.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.bt.utilities.MonitoringMail;
import com.bt.utilities.TestConfig;

public class TestHostAdd {

	public static void main(String[] args) throws UnknownHostException, AddressException, MessagingException {
		// TODO Auto-generated method stub
		
		MonitoringMail mail=new MonitoringMail();
		
		String messagebody="http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/1DataDriven/Extent_20Report/";
		System.out.println(messagebody);
		
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messagebody);
	}

}
