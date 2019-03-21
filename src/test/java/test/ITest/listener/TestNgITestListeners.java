package test.ITest.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgITestListeners implements ITestListener{

	public void onFinish(ITestContext result) {
		System.out.println("Context finished" +result.getClass());
		
	}

	public void onStart(ITestContext result) {
		System.out.println("Context started" +result.getClass());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test case failed and details are " +result.getMethod());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed and details are " +result.getTestName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped and details are " +result.getTestName());
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test case started " +result.getTestName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case details are " +result.getTestName());
		
	}

}
