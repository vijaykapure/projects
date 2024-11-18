package sampletest;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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
import utility.Extendreportclass;
import utility.Listener;

import java.io.IOException;

public class basic3 extends Baseclass {

	public static Homepage getHomepage;

	@BeforeMethod
	public static void setup() {

		launchApp("chrome");
	}

	@Test
	public void Varifylogo() throws IOException {
		getHomepage = new Homepage(driver);
		boolean result = getHomepage.ValidateLogo();
		Assert.assertTrue(result);
	}

	@Test
	public void Varifytitle() throws IOException {

		getHomepage = new Homepage(driver);
		String Actualtitle = getHomepage.ValidateTitle();
		String Expectedtitle = "Index";
		Assert.assertEquals(Actualtitle, Expectedtitle);

	}

	@Test
	public void login() throws IOException {

		getHomepage = new Homepage(driver);
		getHomepage.loginWithEmailOrSkip(true);

	}

	@Test
	public void failtest()throws IOException
	{
		Assert.assertTrue(false);
	}

	@Test
	public void skiptest() throws IOException
	{

		throw new SkipException("skip this test case");
	}

	@AfterMethod
	public void teardown( ) throws IOException{

		driver.close();
	}

}
