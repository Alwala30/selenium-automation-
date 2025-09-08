package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testcases.Basetestclass;

public class extent_reportsmanager implements ITestListener {

	public ExtentSparkReporter sparkReporter;//UI of report
	public ExtentReports extent;//populate common info
	public ExtentTest test; //create test case entry and update status of tests
	
	 public void onStart(ITestContext context) {
		   sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		   
		   sparkReporter.config().setDocumentTitle("Automation Reports");
		   sparkReporter.config().setReportName("Kawasaki testing report");
		   sparkReporter.config().setTheme(Theme.DARK);
		   
		   extent=new ExtentReports();
		   extent.attachReporter(sparkReporter);
		   extent.setSystemInfo("Computer Name","localhost");
		   extent.setSystemInfo("Tester Name", "Tarun");
		   extent.setSystemInfo("Browser name","Chrome");
		   extent.setSystemInfo("Environment","QA");
	 }
	 
	 public void onTestSuccess(ITestResult result) {
		    test=extent.createTest(result.getName());
		    test.log(Status.PASS, "Test case Passed" +result.getName());
		    }
	 
	 public void onTestFailure(ITestResult result) {
         test=extent.createTest(result.getName());
         test.log(Status.FAIL,"Test is failed:"+result.getName());
         test.log(Status.FAIL,"Test case failed due to:"+result.getThrowable());
        try
        {
         String imgpath=new Basetestclass().Takescreenshot(result.getName());
         test.addScreenCaptureFromPath(imgpath);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	 }

	 public void onTestSkipped(ITestResult result) {
         test=extent.createTest(result.getName());
         test.log(Status.SKIP,"test is skipped:" +result.getName());
         }
	 public void onFinish(ITestContext context) {
		    extent.flush();
		  }
	 
	 
	
		    
	
		   
		  }


