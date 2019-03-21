package read_data_from_excel_file;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RepLog {
	
	@Test(groups={"group 1"})
	public void test1()
	{
		System.out.println("test 1");
		Reporter.log("Test 1 started");
	}
	
	@Test(groups={"group 1"})
	public void test2()
	{
		System.out.println("test 1");
		Reporter.log("Test 2 started");
		Assert.assertFalse(8>3);
	}
	
	@Test(groups={"group 1"})
	public void test3()
	{
		System.out.println("test 1");
		Reporter.log("Test 3 started");
	}
	
	@Test(groups={"group 1"})
	public void test4()
	{
		System.out.println("test 1");
		Reporter.log("Test 4 started");
	}

}
