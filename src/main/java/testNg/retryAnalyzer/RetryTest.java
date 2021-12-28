package testNg.retryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class RetryTest {
    @Test
    public void testRetry(){
        System.out.println("tetsiung Retry");
        Assert.assertTrue(false);
    }
}
