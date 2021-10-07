package com.bt.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.bt.base.Page;
import com.bt.utilities.MonitoringMail;
import com.bt.utilities.TestConfig;
import com.bt.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class Customelisteners extends Page implements ITestListener{
	
	
	String messagebody;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=rep.startTest(result.getName().toUpperCase());
		
		//Run modes- Y/N
		/*
		 * if(!TestUtil.isTestRunnable(result.getName(), excel)) { throw new
		 * SkipException("skipping the test "+result.getName().toUpperCase()
		 * +" as the runmode is NO: "); }
		 */
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Page.test.log(LogStatus.PASS, result.getName().toUpperCase()+" Pass..");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//Below line only for reportNG to view html link or html tags on the report.
		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Page.test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with exception: "+result.getThrowable());		
		Page.test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));		
		
		
		Reporter.log("Capturing Screenshot..");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshott</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" height=200 width=200></a>");
		
		rep.endTest(test);
		rep.flush();
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+" Skipped the test as the run mode is No.");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		MonitoringMail mail=new MonitoringMail();		
		
		try {
			messagebody = "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/Live%20Project%20-%20DD%20with%20POM/Extent_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messagebody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
