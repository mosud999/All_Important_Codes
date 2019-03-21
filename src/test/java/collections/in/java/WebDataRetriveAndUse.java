package collections.in.java;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebDataRetriveAndUse {
	WebDriver dr;
	
	public HashMap<String, String> actualValue(List<WebElement> key, List<WebElement> value)
	{
		HashMap<String, String> hp= new HashMap<String, String>();
		for(int i=0; i<2; i++)
		{
			String k=key.get(i).getText();
			String v=value.get(i).getText();
			hp.put(k, v);
		
		}
		return hp;
	}
	
	public HashMap<String, String> expectedValue()
	{
		HashMap<String, String> eh=new HashMap<String, String>();
		eh.put("john", "123456");
		eh.put("rihana", "156");
		
		return eh;
	}
	
	@Test
	public void test1()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.get("file:///C:/Users/User/Desktop/test.html");
		
		List<WebElement> e=dr.findElements(By.xpath("html/body/table/tbody/tr/td[1]"));
		List<WebElement> e1=dr.findElements(By.xpath("html/body/table/tbody/tr[1]/td[2]"));
		HashMap a=actualValue(e1, e1);	
		HashMap a1=expectedValue();
		Iterator i1=a.entrySet().iterator();
		Iterator i2=a1.entrySet().iterator();
		
		while(i1.hasNext() && i2.hasNext())
		{
			Map.Entry k=(Entry)i1.next();
			System.out.println(k.getKey() + " " +k.getValue());
			//Map.Entry k1=(Entry)i2.next();
			//System.out.println(k1.getKey() + " " +k1.getValue());
			
			/*System.out.println(k.getKey() + " is equal to " + k1.getKey());
			Assert.assertTrue(k.getKey().equals(k1.getKey()));
			//Assert.assertTrue(k.getKey().equals(k1.getKey()));
			System.out.println(k.getValue() + " is equal to " + k1.getValue());
			Assert.assertTrue(k.getValue().equals(k1.getValue()));*/
		}
		
		dr.quit();
		
	}
	
	

}
