package testNg;

import org.testng.annotations.Test;

public class TestNg_Parallel {

    @Test
    public void chromeTest() throws InterruptedException {
        System.out.println("launching chrome");
        Thread.sleep(4000);
    }

    @Test
    public void firefoxTest() throws InterruptedException {
        System.out.println("Launching firefox");
        Thread.sleep(4000);
    }

    @Test
    public void safariTest() throws InterruptedException {
        System.out.println("Launching Safari");
        Thread.sleep(4000);
    }
}
