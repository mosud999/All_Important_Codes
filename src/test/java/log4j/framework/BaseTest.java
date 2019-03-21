package log4j.framework;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	// in the logger your class has been registered; 
	private static final Logger logger = Logger.getLogger(BaseTest.class.getName());
	
	@BeforeTest
	// Before register the configuration of the log4j setup; getLogger is used to get the log;
	public void loadlog4J(){
		String log4jConfPath = System.getProperty("C:\\Users\\User\\workspace\\TestNgImportantCodesFinal\\src\\test\\java\\log4j\\framework\\log4j.properties");
		PropertyConfigurator.configure(log4jConfPath);
	}

	
/*	# Define the root logger with appender file
	log4j.rootLogger = INFO, FILE,stdout,HTML
	------Appender means what are the way you want to print the log?------
	
	# Define the file appender
	log4j.appender.FILE=org.apache.log4j.FileAppender //to print the log as text file you have to use FileAppender class 
	log4j.appender.FILE.File=selenium.out // what name you want you want to print the log;
	log4j.appender.FILE.Append=false
	log4j.appender.FILE.layout=org.apache.log4j.PatternLayout
	log4j.appender.FILE.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n // what format you want to do the log;
	log4j.appender.file.MaxFileSize=4MB //max file size
	log4j.appender.file.MaxBackupIndex=9 //max number of file we can keep


	log4j.appender.HTML=org.apache.log4j.FileAppender
	log4j.appender.HTML.File=application.html
	log4j.appender.HTML.layout=org.apache.log4j.HTMLLayout // html layout;
	log4j.appender.HTML.layout.Title=Application log // html layout page title;
	log4j.appender.HTML.layout.LocationInfo=true
	log4j.appender.HTML.Append=false // when false for every run it will generate new html; will overwrite the previous one;


	# Direct log messages to stdout
	log4j.appender.stdout=org.apache.log4j.ConsoleAppender // to print in eclipse console;
	log4j.appender.stdout.Target=System.out // where you want to print;
	log4j.appender.stdout.layout=org.apache.log4j.PatternLayout // what is the layout-convetion layout
	log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n*/

}
