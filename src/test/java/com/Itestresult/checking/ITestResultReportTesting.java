package com.Itestresult.checking;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//Class one for chrome testing
public class ITestResultReportTesting {
	WebDriver dr;
	@Test
	public void Test1()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.get("https://www.google.com/");	
		Assert.assertFalse(8>5);
	}
	
	@Test
	public void Test2()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.get("http://www.bdjobs.com/");			
	}
	
	@AfterMethod
	public void closingReport(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println(result.getMethod() + " IS PASSED");
		}
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			// Take screenshot and store as a file format
			
			File src= ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
			try {
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\User\\Desktop\\failed\\failed.png"));
			}
			 
			catch (IOException e)
			 {
			  System.out.println(e.getMessage());
			 
			 }
			 }
			System.out.println(result.getMethod() + " IS FAILED");
		}
	}
	
    

