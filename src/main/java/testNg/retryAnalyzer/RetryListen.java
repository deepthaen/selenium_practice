package testNg.retryAnalyzer;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListen implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation,
                          Class testClass,
                          Constructor testConstructor, Method testMethod) {
        annotation.getRetryAnalyzerClass();
        if(retry==null){
            annotation.setRetryAnalyzer(RetryCaptur.class);
        }
    }
}
