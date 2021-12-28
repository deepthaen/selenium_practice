package testNg.retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryCaptur implements IRetryAnalyzer {

    int initialcount=0;
    int retryCount=3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (initialcount<retryCount){
            System.out.println("Retrying my "+iTestResult.getTestName()+"_"+iTestResult);
            initialcount++;
            return true;
        }
        return false;
    }
}
