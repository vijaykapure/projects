package sampletest;

import base.Baseclass;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Homepage;

import java.io.IOException;


public class HomePageaTest extends Baseclass {
    Homepage getHomepage;

    @BeforeMethod
    public static void setup() {

        launchApp("chrome");
        System.out.println("karan has update the project");
        System.out.println("sachin has update the project");

    }

    @Test
    public void Varifylogo() {
        getHomepage = new Homepage(driver);
        boolean result = getHomepage.ValidateLogo();
        AssertJUnit.assertTrue(result);
    }

    @Severity(SeverityLevel.NORMAL)
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
    public void teardown() throws IOException
    {
        System.out.println("krish has update the 21nd code line");
        driver.close();
    }
}
