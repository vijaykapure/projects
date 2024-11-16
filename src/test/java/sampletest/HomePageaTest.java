package sampletest;

import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.ITestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.ServiceManager.Listener;

import base.Baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Homepage;
import utility.Extendreportclass;


public class HomePageaTest extends Baseclass {
	Homepage getHomepage;

	@BeforeMethod
	public static void setup() {
		
		launchApp("chrome");
		System.out.println("karan has update the project");
	}

	@Test
	public void Varifylogo() {
		getHomepage = new Homepage(driver);
		boolean result = getHomepage.ValidateLogo();
		AssertJUnit.assertTrue(result);
	}
	@Test

	public void Varifytitle() {
		getHomepage = new Homepage(driver);
		String Actualtitle = getHomepage.ValidateTitle();
		String Expectedtitle = "Index";
		AssertJUnit.assertEquals(Actualtitle, Expectedtitle);

	}
	@Test

	public void login() {
		getHomepage = new Homepage(driver);
		getHomepage.loginWithEmailOrSkip(true);

	}

	@AfterMethod
	public void teardown() {
		System.out.println("karan has update the 2nd code line");
		System.out.println("karan has update 3rd code line");
		driver.close();
	}
}
