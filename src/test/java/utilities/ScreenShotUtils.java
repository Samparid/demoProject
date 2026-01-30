package utilities;

import base.DriverFactory;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.OutputStream;

public class ScreenShotUtils {

    public static String takeScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            String path = "test-output/screenshots/" + testName + ".png";
            File dest = new File(path);
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath().toFile(), (OutputStream) dest.toPath());
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}
