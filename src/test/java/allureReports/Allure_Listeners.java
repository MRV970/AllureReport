package allureReports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class Allure_Listeners implements ITestListener,ISuiteListener{
	//returns the name of the method
private static String getTestMethodName(ITestResult iTestResult) {
	return iTestResult.getMethod().getConstructorOrMethod().getName();
	
}

@Attachment
public byte[] saveFailureScreenshot(WebDriver driver) {
	return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
}

@Attachment(value= "{0}",type="text/plain")
public static String saveTextLog(String message) {
	return message;
}
public void onStart(ISuite suite) {
	System.out.print("on start Method:"+suite.getName());
	suite.setAttribute("WebDriver", BaseClass.getDriver());
	
}

@Override
public void onTestStart(ITestResult result) {
System.out.println("On Test Start"+ getTestMethodName(result)+"Started");
}

@Override
public void onTestSuccess(ITestResult result) {
	System.out.println("On Test Success"+ result.getName());
}

@Override
public void onTestFailure(ITestResult result) {
	System.out.println("On Test failure"+ result.getName());
	Object testclass= result.getInstance();
	WebDriver driver=BaseClass.getDriver();
	//Allure screenshot and save TestLog
	if(driver instanceof WebDriver) {
		System.out.println("On Test Failure"+getTestMethodName(result)+"Failed");
		saveFailureScreenshot(driver);
	}
	saveTextLog(getTestMethodName(result)+"Failed and screenshot taken");
}

@Override
public void onTestSkipped(ITestResult result) {
	System.out.println("On Test Skipped"+getTestMethodName(result)+"skipped");

}

@Override
public void onFinish(ITestContext context) {
	System.out.println("On Finish method"+context.getName());
	
}
}
