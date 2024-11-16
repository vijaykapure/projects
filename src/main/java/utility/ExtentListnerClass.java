package utility;

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

import base.Baseclass;

public class ExtentListnerClass extends Baseclass implements ITestListener {
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public void configurereport() {
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("HostName", "Myhost");
		reports.setSystemInfo("ProjectName", "FTA_UI");
		reports.setSystemInfo("Tester", "Vijay Kapure");
		reports.setSystemInfo("OS", "Win11");
		reports.setSystemInfo("Browser", "Chrome");

		htmlReporter.config().setDocumentTitle("FTA_UI_PROJECT");
		htmlReporter.config().setReportName("FTA_UI_TEST_REPORT");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE , MMMM dd, yyyy, hh:mm y '('zzz')'");

	}
	
	
	    public void onTestStart(ITestResult result) {
			test = reports.createTest(result.getName());

	        System.out.println("Test started: " + result.getName());
	    }

	    public void onTestSuccess(ITestResult result) {
	    	if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS, "Pass Test case is: " + result.getName());
			}
	        System.out.println("Test passed: " + result.getName());
	    }

	    public void onTestFailure(ITestResult result) {
			test = reports.createTest(result.getName());
			if (result.getStatus() == ITestResult.FAILURE) {
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				screenshots(result.getName());

			}
	        System.out.println("Test failed: " + result.getName());
	    }

	    public void onTestSkipped(ITestResult result) {
	    	if (result.getStatus() == ITestResult.SKIP) {
				test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
			}
	        System.out.println("Test skipped: " + result.getName());
	    }

	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        System.out.println("Test failed but within success percentage: " + result.getName());
	    }

	    public void onStart(ITestContext context) {
	    	configurereport();
	        System.out.println("Test suite started: " + context.getName());
	    }

	    public void onFinish(ITestContext context) {
	        System.out.println("Test suite fineshed: " + context.getName());
	    	reports.flush();

	    }
	}


