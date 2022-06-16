package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {
    RegisterPage registerPage;
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        registerPage = new RegisterPage(driver);
    }
    @Test
    //(Smoke Test) Check if we can register using valid credentials
    public void canRegisterWithValidCredentials(){
        registerPage.RegisterAs("Male", "asd", "asdasd", "1", "1", "3", "apsitl1@mailnesia.com", "asd", "true", "123123", "123123");
        RegisterPage registerPage = new RegisterPage(driver);
        assertEquals(registerPage.getValidMessage(), "Your registration completed");
    }
    @Test
    //(Negative Test) Check if we cannot register with an already existing email adress
    public void cantRegisterWithAnAlreadyExistentEmail(){
        registerPage.RegisterAs("Male", "asd", "asdasd", "1", "1", "3", "apsitl1@mailnesia.com", "asd", "true", "123123", "123123");
        RegisterPage registerPage = new RegisterPage(driver);
        assertEquals(registerPage.geterrorMessage(), "The specified email already exists");
    }
    @Test//(Negative Test) Check if we cannot register without specifying first name
    public void cantRegisterWithoutFirstName(){
        registerPage.RegisterAs("Male", "","asdasd", "1", "1", "3", "apsitl1@mailnesia.com", "asd", "true", "123123", "123123");
        RegisterPage registerPage = new RegisterPage(driver);
        assertEquals(registerPage.geterrorFirstNameMessage(), "First name is required.");
    }
    @Test//(Negative Test) Check if we cannot register if passwords don't match
    public void cantRegisterIfPasswordsDontMatch(){
        registerPage.RegisterAs("Male", "asd","asdasd", "1", "1", "3", "apsitl1@mailnesia.com", "asd", "true", "123123", "123123a");
        RegisterPage registerPage = new RegisterPage(driver);
        assertEquals(registerPage.geterrorWrongPassMessage(), "The password and confirmation password do not match.");
    }


    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
