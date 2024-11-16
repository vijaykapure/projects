package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionclass.Action;
import base.Baseclass;

public class Homepage extends Baseclass {
	public WebDriver driver;
	Action act = new Action();

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement EmailFeild;

	@FindBy(xpath = "//*[@id=\"enterimg\"]")
	private WebElement EmailBtn;

	@FindBy(id = "#btn2")
	private WebElement SkipSignBtn;

	@FindBy(xpath = "//*[@id=\"logo\"]")
	private WebElement Mylogo;

	public void LoginWithEmail() {
		act.Type(EmailFeild, "kapurevijay6@gmail.com");
		act.click(EmailBtn);
	}

	public WebElement SkipSignIn() {
		act.click(SkipSignBtn);
		return SkipSignBtn;
	}

	public void loginWithEmailOrSkip(boolean useEmailLogin) {
		if (useEmailLogin) {
			// Login with email
			act.Type(EmailFeild, "kapurevijay6@gmail.com");
			act.click(EmailBtn);
		} else {
			// Skip sign-in
			act.click(SkipSignBtn);
		}
	}

	public boolean ValidateLogo() {
		act.fluentWait(driver, Mylogo, 15);
		return act.isDisplayed(Mylogo);
	}
	
	public String ValidateTitle() {
		String title=driver.getTitle();
		return title;
	}

}
