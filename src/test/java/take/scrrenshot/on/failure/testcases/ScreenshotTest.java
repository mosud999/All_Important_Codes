package take.scrrenshot.on.failure.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ScreenshotTest extends BaseClass {

	@BeforeMethod
	public void openBrowser() {
		initialization();
	}
	
	@AfterMethod
	public void closeBrowser() {
		dr.quit();
	}

	@Test
	public void test1() {
		Assert.assertEquals(false, true);
	}

	@Test
	public void test2() {
		Assert.assertEquals(false, true);
	}

	@Test
	public void test3() {
		Assert.assertEquals(false, true);
	}

	

}
