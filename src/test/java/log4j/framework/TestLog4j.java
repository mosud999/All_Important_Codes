package log4j.framework;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestLog4j extends BaseTest {
	
private static final Logger logger = Logger.getLogger(TestLog4j.class.getName());
	
	@Test
	public void testLogin(){
		logger.info("staring login test");
		logger.info("clicked on sign in button");
		logger.info("enter user name");
		logger.info("enter password");
		logger.info("click on submit button");
	}

}
