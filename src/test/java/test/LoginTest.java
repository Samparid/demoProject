package test;

import base.BaseTest;
import org.testng.annotations.Test;
import page.HomePage;
import page.Login;

public class LoginTest extends BaseTest {

    @Test
    public void LoginTest() {
        HomePage home = new HomePage(driver);
        Login login = new Login(driver);
        System.out.println(driver);
        home.goToLoginPage();
        login.enterEmail("samrat.keshri.24@gmail.com");
        login.enterPassword("Welcome@24");
        login.submit();

    }
}
