package assertions.java;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTypesInJava {
	
	@Test
	public void test1() //Hard assertion
	{
		Assert.assertEquals(12, 12);
		System.out.println("test one passed");
	}
	
	@Test
	public void test2()//Hard assertion
	{
		// For second number it will show error message in console; if the test case file
		//then the error 
		//message willl come;
		System.out.println("test one started");
		Assert.assertEquals(12, 13,"Second number did not match"); 
		System.out.println("test one completed");
		
	}
	
	@Test
	public void test3()//Hard assertion
	{
		String name="mosud ahmed";
		Assert.assertTrue(name.contains("ahmed"),"If error show this message");
		
	}
	
	@Test
	public void test4()//Soft assertion
	{
	System.out.println("test four started");
	SoftAssert assertion=new SoftAssert();
	assertion.assertEquals(12, 13,"message will show when the assertion fails");
	System.out.println("test four completed");
	assertion.assertAll();
	}


}
