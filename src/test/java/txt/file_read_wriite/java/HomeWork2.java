package txt.file_read_wriite.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork2 {
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.eshopper24.com/");
		
	}
	
	@Test
	public void textWriter()
	{
		
		BufferedWriter writer=null;
		try
		{
			writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("some.txt")));
			
			List<WebElement> menu = driver
					.findElements(By.xpath("//ul[@class='category-navigation-list sticky-flyout']//li"));
			// Declaring an array with array size=menu size;
			String actualValue[] = new String[menu.size()]; 
			int i = 0; // Initialize variable i=0;
			
			// For each loop to print all links text using getText method;
			for (WebElement m : menu) 
			{
				//Storing links text into String array
				actualValue[i] = m.getText();
				System.out.println(actualValue[i]); // Printing all links text;
				i++; // Incrementing i's value and passing links text to actualValue[];

			}
			
			for(String a:actualValue)
			{
				writer.write(a + "\n");
			}
			
			
		}
		catch(IOException e)
		{
			//reprt
		} finally {
			try{writer.close();
			} catch(Exception ex){}
			
		}
	}

	
}
