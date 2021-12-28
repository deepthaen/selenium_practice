package testNg.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNg_Listerner implements ITestListener {

    /**
     * on start
     * on finish
     *
     */

    @Override
    public  void onTestStart(ITestResult result) {
        System.out.println("On Test Start :: "+result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("On test Success :: "+result.getStatus());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("On test Failure :: "+result.getStatus());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("On test Skipped :: "+result.getStatus());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        System.out.println("On test Start :: "+context.getStartDate());
    }

    public void onFinish(ITestContext context) {
        System.out.println("On finish :: "+context.getEndDate());
    }
}
