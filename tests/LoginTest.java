package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.LoginPage;

import java.sql.Driver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    LoginPage loginPage;
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void canLoginWithValidCredentials(){


        loginPage.loginAs("vrajeala@mailnesia.com", "123123" );
        AccountPage accountPage = new AccountPage(driver);
        assertEquals(accountPage.getLogoutLinkText(), "Log out");




    }
    @Test
    public void cannotLoginWithIncorrect(){


        loginPage.loginAs("vrajeala@mailnesia.com", "123456" );
        assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" +
        "The credentials provided are incorrect");

    }
    @Test
    public void cannotLogInWithInexistentAccount() {


        loginPage.loginAs("gwdsfgdg@asdadsa.com", "123456");
        assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
