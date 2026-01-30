package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        driver = DriverFactory.initDriver(browser);
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
