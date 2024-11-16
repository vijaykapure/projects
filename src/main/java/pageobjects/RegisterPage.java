package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.reporters.jq.Main;

public class RegisterPage {
	public static WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void main(String[] args) {

		WebElement ele = driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]"));
		ele.getText();
		System.out.println(ele.getText());
	}

}
