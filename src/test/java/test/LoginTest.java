package test;

import base.BaseTest;
import listerners.ExtentTestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.HomePage;
import page.Login;

@Listeners(ExtentTestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void LoginTest() {
        HomePage home = new HomePage(driver);
        Login login = new Login(driver);
        System.out.println(driver);
        home.goToLoginPage();
        login.enterEmail("samrat.keshri.24@gmail.com");
        login.enterPassword("SilentKiller@12345");
        login.submit();

    }
}
