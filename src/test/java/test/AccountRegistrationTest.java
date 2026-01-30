package test;

import base.BaseTest;
import listerners.ExtentTestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.AccountRegistrationPage;
import page.HomePage;

import static utilities.Utility.generateEmail;

@Listeners(ExtentTestListener.class)
public class AccountRegistrationTest extends BaseTest {

    @Test
    public void registerAccountTest() {

        HomePage home = new HomePage(driver);
        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        System.out.println(driver);

        home.goToRegistrationPage();

        regPage.registerUser(
                "Samrat",
                "Parida",
                generateEmail(),
                "9876543210",
                "Welcome@24"
        );
    }
}
