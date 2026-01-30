package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver(String browser) {
        try {
            String runMode = System.getProperty("runMode", "local");

            if (runMode.equalsIgnoreCase("grid")) {

                if (browser.equalsIgnoreCase("chrome")) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    driver.set(new RemoteWebDriver(
                            new URL("http://localhost:4444/"), options));
                } else if (browser.equalsIgnoreCase("firefox")) {
                    FirefoxOptions options = new FirefoxOptions();
                    driver.set(new RemoteWebDriver(
                            new URL("http://localhost:4444/"), options));
                }
            } else {
                // Local execution
                if (browser.equalsIgnoreCase("chrome")) {
                    driver.set(new org.openqa.selenium.chrome.ChromeDriver());
                } else if (browser.equalsIgnoreCase("firefox")) {
                    driver.set(new org.openqa.selenium.firefox.FirefoxDriver());
                }
            }

            getDriver().manage().window().maximize();
            return getDriver();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        driver.remove();
    }
}