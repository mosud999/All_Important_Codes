package test.ITest.listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(test.ITest.listener.TestNgITestListeners.class)

public class BaseTest {
	
	@Test
	public void test1(){
		
		System.out.println("test1");
	}
	
	@Test
	public void test2(){
			
			System.out.println("test3");
			Assert.assertTrue(false);
		}
	
	@Test(dependsOnMethods={"test2"})
	public void test3(){
			
			System.out.println("test3");
		
		}

}
