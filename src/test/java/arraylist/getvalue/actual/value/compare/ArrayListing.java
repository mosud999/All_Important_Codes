package arraylist.getvalue.actual.value.compare;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArrayListing {

	WebDriver dr;

	// To Open Browser and go to the url;
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.eshopper24.com");
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void valueComparing() {
		// get the menus from website;
		List<WebElement> elements = dr
				.findElements(By.xpath("//ul[@class='category-navigation-list sticky-flyout']/li"));
		// get the actual values from client;
		String[] actualValue = { "Cotton Saree", "Gas Silk Saree", "Half Silk Saree", "Moslin Jamdani Saree",
				"Katan Saree", "Pure Silk Saree", };
		// call the getWebValue() and actualValues() methods and keep them in an ArrayList; 
		ArrayList a = getWebValue(elements);
		ArrayList a1 = actualValues(actualValue);

		// To get the sizes getvalues and actual values;
		int getValueSize = a.size();
		System.out.println(getValueSize);
		
		int actualValueSize = a1.size();
		System.out.println(actualValueSize);

		// To check if both the values sizes are same or not;
		if (getValueSize == actualValueSize) {
			Iterator i = a.iterator(); // Iterate the ArrayList values
			Iterator i1 = a1.iterator(); // Iterate the ArrayList values

			// Condition to check if there is any value or not; if condition is true then go get the first value
			//  check is it same with the actual value or not;
			while (i.hasNext() && i1.hasNext()) {
				if (i.next().equals(i1.next())) {
					System.out.println("Website menu " + i.next() + " is equal to actual value " + i1.next());
				} else {
					System.out.println("Attention: Test case fail");
				}
			}
		} else {
			System.out.println("Attention: Test case fail");
		}

	}

	// To keep the web menus in an ArrayList;
	public ArrayList<String> getWebValue(List<WebElement> w_value) {
		ArrayList<String> web_list = new ArrayList();
		for (WebElement e : w_value) {
			String s = e.getText();
			web_list.add(s);
			System.out.println(s);
		}
		return web_list;
	}

	// To keep the actual values in an ArrayList;
	public ArrayList<String> actualValues(String[] a_value) {
		ArrayList<String> list1 = new ArrayList();
		for (String s1 : a_value) {
			list1.add(s1);
		}
		return list1;
	}

	@AfterMethod
	public void tearDown() {
		dr.quit();
	}

}
