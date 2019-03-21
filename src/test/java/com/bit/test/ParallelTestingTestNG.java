package com.bit.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//Class one for chrome testing
public class ParallelTestingTestNG {
	WebDriver dr;
	@Test
	@Parameters({"browser","url"})
	public void fireFoTest(String browser, String url)
	{
		{
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
				dr=new ChromeDriver();
			}
			
			dr.get(url);
			
		}
	}

}
