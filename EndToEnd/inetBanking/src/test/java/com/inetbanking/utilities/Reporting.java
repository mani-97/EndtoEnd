package com.inetbanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetbanking.testCases.BaseClass;

//Listener class used to generate Extent reports

public class Reporting extends BaseClass implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
public void onStart(ITestContext re) {
		// TODO Auto-generated method stub
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());//time stamp
		String repName=re.getName()+timeStamp+".html";		
		String filepath=System.getProperty("user.dir")+"\\OutputReport\\"+repName;
		sparkReporter=new ExtentSparkReporter(filepath);//spcify location
		extent= new ExtentReports();
		extent.setSystemInfo("Host name"," localhost");
		extent.setSystemInfo("Environment"," QA");
		extent.setSystemInfo("User", "Mani");
		extent.attachReporter(sparkReporter);
		
		sparkReporter.config().setDocumentTitle("InetBanking Test Project");//Title of report
		sparkReporter.config().setReportName("Functional Test Automation Report");//name of the report
		sparkReporter.config().setTheme(Theme.DARK);			
	}

	public void onTestStart(ITestResult result) {
	}
	
	public void onTestSuccess(ITestResult re) {
		
		test=extent.createTest(re.getName());//create new entry in the report
		test.log(Status.PASS,MarkupHelper.createLabel(re.getName()+"Test is Passed", ExtentColor.GREEN));//send the passed information		
	}
	
	public void onTestFailure(ITestResult re) {
		
		test=extent.createTest(re.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel(re.getName()+"Test is failed", ExtentColor.RED));
		String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+re.getName()+".png";
		File f=new File(screenshotpath);
		
		if(f.exists()) {
			try { 
			test.fail("Screenshot is below: "+test.addScreenCaptureFromPath(screenshotpath));
			}
			catch(Exception e) {
				test.log(Status.FAIL,e.getMessage());
			}
		}	
	}

	public void onTestSkipped(ITestResult re) {
		test=extent.createTest(re.getName());//create new entry in the report
		test.log(Status.SKIP, MarkupHelper.createLabel(re.getName()+"Test is Skipped", ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}


	

}