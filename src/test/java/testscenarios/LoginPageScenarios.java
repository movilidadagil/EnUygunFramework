package testscenarios;

import framework.ConfigReader;
import framework.DriverSetup;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.util.Properties;

public class LoginPageScenarios {
    LoginPage loginPage = new LoginPage(DriverSetup.getDriver());
    static WebDriver driver;
    static Properties properties;

    @BeforeClass
    public static void setup(){
        properties = ConfigReader.initialize_Properties();
        driver = DriverSetup.initialize_Driver("chrome");
    }

    @Ignore
    public void m6() {
        loginPage.clickLoginButton();
    }

    @Test(timeout = 10)
    public void m7() {
        System.out.println("Using @Test(timeout),it can be used to enforce timeout in JUnit4 test case");
        loginPage.clickLoginButton();
    }

    @Test(expected = ElementNotInteractableException.class)
    public void m8() {
        System.out.println("Using @Test(expected) ,it will check for specified exception during its execution");
        loginPage.loginEnterEmail("sdet@tester.com");
    }
}
