package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage {

    public Login(WebDriver driver) {
        super(driver);
    }

    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By submit = By.xpath("//input[@type='submit']");

    public void enterEmail(String userEmail) {
        type(email, userEmail);
    }

    public void enterPassword(String userPassword) {
        type(password, userPassword);
    }


    public void submit() {
        click(submit);
    }
}
