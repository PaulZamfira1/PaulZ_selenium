package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterPage {
    //Gender
    @FindBy(name = "Gender")
    List<WebElement> genderRadioButtons;
    //First Name
    @FindBy(id = "FirstName")
    private WebElement FirstNameInput;
    //Last Name
    @FindBy(id = "LastName")
    private WebElement LastNameInput;
    //Date of birth
    @FindBy(name = "DateOfBirthDay")
    private WebElement dobDropdown;
    //Email
    @FindBy(id = "Email")
    private WebElement emailInput;
    //Company Name
    @FindBy(id = "Company")
    private WebElement CompanyInput;
    //Newsletter
    @FindBy(id = "Newsletter")
    private WebElement checkbox;
    //Password
    @FindBy(id = "Password")
    private WebElement passwordInput;
    //Confirm password
    @FindBy(id = "ConfirmPassword")
    private WebElement ConfirmPasswordInput;
    //Register
    @FindBy(name = "register-button")
    private WebElement registerButton;

    public void selectGender(String gender){
        if(gender.equals("Male")) {
            genderRadioButtons.get(0).click();

        }else {
            genderRadioButtons.get(1).click();
        }
    }
    public void selectDayOfBirth(String day) {
        Select select = new Select(dobDropdown);
        select.selectByVisibleText(day);
    }
    public void selectMonthOfBirth(String month) {
        Select select = new Select(dobDropdown);
        select.selectByVisibleText(month);
    }
    public void selectYearOfBirth(String year) {
        Select select = new Select(dobDropdown);
        select.selectByVisibleText(year);
    }
    public void checkbox(boolean checkbox){
        driver.findElement(By.id("Newsletter")).isSelected();

    }
    public WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void RegisterAs(String gender, String firstName, String lastName, String day, String month, String year ,String email ,String company, String newsletter,String password, String confirmPassword ) {
        selectGender(gender);
        FirstNameInput.sendKeys(firstName);
        LastNameInput.sendKeys(lastName);
        selectDayOfBirth(day);
        selectMonthOfBirth(month);
        selectYearOfBirth(year);
        checkbox(true);
        emailInput.sendKeys(email);
        CompanyInput.sendKeys(company);
        passwordInput.sendKeys(password);
        ConfirmPasswordInput.sendKeys(confirmPassword);
        registerButton.click();
    }
    @FindBy(xpath = "//div[@class='result']")
    private WebElement confirmationMessage;
    public String getValidMessage(){
        return confirmationMessage.getText();
    }
    @FindBy(xpath = "//li[contains(text(),'The specified email already exists')]")
    private WebElement errorMessage;

    public String geterrorMessage(){
        return errorMessage.getText();
    }
    @FindBy(xpath = "//*[@id=\"FirstName-error\"]")
    private WebElement errorFirstNameMessage;

    public String geterrorFirstNameMessage() {
        return errorFirstNameMessage.getText();
    }

    @FindBy(xpath = "//*[@id=\"ConfirmPassword-error\"]")
    private WebElement errorWrongPassMessage;

    public String geterrorWrongPassMessage() {
        return errorWrongPassMessage.getText();
    }
}
