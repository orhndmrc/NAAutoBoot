package main.java.TestNGclassess;

import main.java.junitClass.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.io.File;

//ITestListener interface which implements Tng listeners
public class Listeners implements ITestListener {
    @Override
    public void onFinish(ITestContext result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        System.out.println("onStart= "+context.getName());
        ITestNGMethod methods[] = context.getAllTestMethods();
        for ( ITestNGMethod method: methods) {
            System.out.println(method.getMethodName());
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("onTestFailedButWithinSuccessPercentag= "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
//screenshot code
  //response if API is failed
        System.out.println("I failed the execution "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("OnTestStart= "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        //it will be executed if the test is a success
        System.out.println("Passed");
    }

}
