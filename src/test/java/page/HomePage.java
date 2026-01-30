package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By myAccount = By.xpath("//span[text()='My Account']");
    private By registerLink = By.xpath("//a[text()='Register']");
    private By loginLink = By.xpath("//a[text()='Login']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToRegistrationPage() {
        click(myAccount);
        click(registerLink);
    }

    public void goToLoginPage() {
        click(myAccount);
        click(loginLink);
    }
}
