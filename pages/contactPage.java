package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactPage {

    @FindBy(id = "FullName")
    private WebElement nameInput;

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "Enquiry")
    private WebElement enquiryTextArea;

    @FindBy(name = "send-email")
    private WebElement submitButton;

    public WebDriver driver;
    public contactPage() {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ContactAs(String name, String email, String enquiry) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        enquiryTextArea.sendKeys(enquiry);
        submitButton.click();
    }
}
