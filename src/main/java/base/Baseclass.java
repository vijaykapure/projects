package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
public static WebDriver driver;
public static Baseclass util=new Baseclass();
	public static boolean headlessmode=false;
		
		public static void launchApp(String browserName) {
			// String browserName = prop.getProperty("browser");
			if (browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				// Set Browser to ThreadLocalMap
				if(headlessmode) {
					ChromeOptions headlessOptions = new ChromeOptions();
					headlessOptions.addArguments("--headless");
					driver = new ChromeDriver(headlessOptions);
				}else {
					 driver = new ChromeDriver();

				}
			} else if (browserName.equalsIgnoreCase("FireFox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();
			}
			//Maximize the screen
			driver.manage().window().maximize();
			//Delete all the cookies
			driver.manage().deleteAllCookies();
			//Implicit TimeOuts
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			//PageLoad TimeOuts
	        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			//Launching the URL
			driver.get("https://demo.automationtesting.in/Index.html");
			
			//close add
			driver.findElement(By.tagName("html")).sendKeys(Keys.ESCAPE);

			
			//close the add
			  //JavascriptExecutor js = (JavascriptExecutor) driver;
		        //js.executeScript("document.getElementById('ad-element-id').remove();");

			
		}
		
		public static void screenshots(String filename) {
			String datename=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	        TakesScreenshot screenshot = (TakesScreenshot) driver;
	        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
	        try {
	            FileHandler.copy(srcFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+filename+".png"));
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot: " + e.getMessage());
	        }
			
		}
	}
	

