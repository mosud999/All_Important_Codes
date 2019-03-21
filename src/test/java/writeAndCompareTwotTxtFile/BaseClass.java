package writeAndCompareTwotTxtFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	WebDriver dr;
	@Parameters({"browser","url"})
	@BeforeClass
	
	public void openBrowser(String browser, String url)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			dr.get(url);
			dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
	}
	
	@AfterClass
	public void tearDown()
	{
		dr.quit();
	}

}
