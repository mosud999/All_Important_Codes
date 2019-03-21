package broken.all.links.checking;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import gherkin.lexer.It;


public class BrokenAllLinksChecking {
	WebDriver dr;
	
	/*	
	 * URL class in Java with Examples. The URL class is the gateway to any of the resource available on 
	 * internet. A Class URL 
	 * represents a Uniform Resource Locator, which is a pointer to a “resource” on the World Wide Web.
	 * 
	 * HttpURLConnection class is an abstract class directly extending from URLConnection class. 
		It includes all the functionality of its parent class with additional HTTP specific features. 
		HttpsURLConnection is another class which is used for the more secured HTTPS protocol.
		
		getResponseCode() : Used to retrieve the response status from server.
		
		CONNECT method method starts two-way communications with the requested resource.
		
		URLConnections Class Methods. The openConnection() method returns a java.net.URLConnection, 
		an abstract class whose subclasses represent the various types of URL connections. For example
		 If you connect to a URL whose protocol isHTTP, the openConnection() method returns an HttpURLConnection 
		 object.
		 
		 https://www.youtube.com/watch?v=WyheLWhk6QE ->MUKESH VIDEO
		*/
	
	@Test
	public void openB()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.google.com/");
		brokenLinksCheking();
	}
	
	
	public void brokenLinksCheking()
	{
		List<WebElement> links=dr.findElements(By.tagName("a"));
		links.addAll(dr.findElements(By.tagName("img")));
		System.out.println("Total links are: " +links.size());
		
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		
		for(int i=0; i<links.size();i++)
		{
			if(links.get(i).getAttribute("href")!=null && 
					(! links.get(i).getAttribute("href").contains("javascript"))) 
				/*some linkse may blank and some links may joined with javascripts, so that is why why we keep a condition
				if anything contains javascript we will ignore It.class we used(!)-not sign;*/
			{
				activeLinks.add(links.get(i));
			}
		}
		System.out.println("Active links are: " +activeLinks.size());
		
		for(int j=0; j<activeLinks.size();j++)
		{
			
			
			try
			{
				String linkUrl=activeLinks.get(j).getAttribute("href");
				URL url=new URL(linkUrl);
				HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
				httpURLConnection.setConnectTimeout(3000);
				httpURLConnection.connect();
				String response=httpURLConnection.getResponseMessage();
				
				System.out.println(activeLinks.get(j).getAttribute("href")+ " ----> " +response);
				httpURLConnection.disconnect();
			}catch (Exception e)
			{
				
			}
		}
		
	}

	/*public static void verifyLinkActive(String linkUrl)
	{
		try
		{
			URL url=new URL(linkUrl);
			HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();
			if(httpURLConnection.getResponseCode()==200)
			{
				System.out.println(linkUrl+ " - " +httpURLConnection.getResponseCode());
			}else if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
			{
				System.out.println(linkUrl+ " - " +HttpURLConnection.HTTP_NOT_FOUND);
			}
		}catch (Exception e)
		{
			
		}
	}*/

}
