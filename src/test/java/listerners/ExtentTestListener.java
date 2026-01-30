package listerners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentManager;
import utilities.ScreenShotUtils;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        String path = ScreenShotUtils.takeScreenshot(result.getMethod().getMethodName());
        if (path != null) {
            test.get().addScreenCaptureFromPath(path);
        }
    }

    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
