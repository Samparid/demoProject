package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By privacyPolicy = By.xpath("//input[@type='checkbox']");
    private By continueBtn = By.xpath("//input[@type='submit']");


    public void registerUser(String fName, String lName, String emailId, String phone, String pass) {
        type(firstName, fName);
        type(lastName, lName);
        type(email, emailId);
        type(telephone, phone);
        type(password, pass);
        type(confirmPassword, pass);
        click(privacyPolicy);
        click(continueBtn);
    }
}
