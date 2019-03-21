package take.scrrenshot.on.failure.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver dr;

	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.google.com/");
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	// Screenshot methods
	public void screentshotCaptureMethod(String failedMethods) {
		File src = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(
					"C:\\Users\\User\\workspace\\TestNgImportantCodesFinal\\Screenshot" + failedMethods + ".jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
