package utility;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.Baseclass;
import pageobjects.Homepage;

public 
class Extendreportclass extends Baseclass {
	public static Homepage getHomepage;

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;

	@BeforeTest
	public static void setextentreport() {
		htmlReporter = new ExtentSparkReporter("MyReport.html");
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

	@AfterTest
	public void endextendreports() {
		reports.flush();
	}

}
