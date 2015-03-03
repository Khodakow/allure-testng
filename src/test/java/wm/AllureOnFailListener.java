package wm;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import setup.WebDriverSteps;

/**
 * Created by s.lugovskiy on 03.03.2015 13:56.
 */
public class AllureOnFailListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onTestSuccess(ITestResult result) {}

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriverSteps.takeScreenShoot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        WebDriverSteps.takeScreenShoot();
    }

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}
}
