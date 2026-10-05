package com.comcast.crm.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

import genericUtility.UtilityClassObject;

public class ListenerImpClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public  ExtentTest test;
   
	@Override
    public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		// spark report config
		spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add env information & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	} 
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=====>" + result.getMethod().getMethodName() + "<===start===");
		String mtdname=result.getMethod().getMethodName();
		test = report.createTest(mtdname);
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, mtdname+"====Started====");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String mtdname=result.getMethod().getMethodName();
		System.out.println("=====>" +mtdname  + "<===end===");
		test.log(Status.PASS, mtdname+"====Completed====");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String mtdname = result.getMethod().getMethodName();
		TakesScreenshot eDriver=(TakesScreenshot)BaseClass.sdriver;
		String filepath=eDriver.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(filepath, mtdname+"_"+time);
		test.log(Status.FAIL, mtdname +"====Failed====");

	}
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP, result.getMethod().getMethodName()+"====Skipped====");

	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
	@Override
 	public void onStart(ITestContext context) {

	}

}
