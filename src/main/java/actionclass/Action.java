package actionclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {

	public void Type(WebElement ele, String text) {

		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(text);
		} else {
			System.out.println("Element not found");
		}
	}

	public void click(WebElement ele) {
		ele.isDisplayed();
		ele.click();
	}

	public boolean isDisplayed(WebElement element) {
		try {
			// Check if the element is displayed
			return element.isDisplayed();
		} catch (Exception e) {
			// If element is not found or any exception occurs, return false
			return false;
		}
	}

	public void explicitWait(WebDriver driver, WebElement element, Duration timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
		}
	}
}
