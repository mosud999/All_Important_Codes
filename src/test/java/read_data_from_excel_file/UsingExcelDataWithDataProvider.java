package read_data_from_excel_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingExcelDataWithDataProvider {
	
	WebDriver dr;
	
	@Test(dataProvider="xl_file")
	public void loginWithDataProviderDatas(Object uname, Object pass) // Object type variable declared in readDataFile method;
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.get("https://www.eshopper24.com/login");
		dr.findElement(By.xpath("//input[@id='Email']")).sendKeys(uname.toString()); // sendkeys only accept string datas;toStrin();
		dr.findElement(By.xpath("//input[@id='Password']")).sendKeys(pass.toString());
	}
	
	@DataProvider(name="xl_file")
	public Object[][] readDataFile() throws IOException
	{
	FileInputStream f=new FileInputStream(new File("C:\\Users\\User\\workspace\\TestNgImportantCodesFinal\\src\\test\\java\\read_data_from_excel_file\\xsheet.xlsx"));
	XSSFWorkbook w=new XSSFWorkbook(f); // verify the loaded file is an Excel file;
	XSSFSheet sheet=w.getSheetAt(0); // We can call the exact sheet by getSheetAt index method and getSheetAt string name method;
	
	Object [][] datas= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];// declared on multi dimesional array for @DataProvider;
	// Loop to start count from first row;
	for(int i=1; i<=sheet.getLastRowNum(); i++)
	{
		for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) // Loop to start count from first first cell/column;
		{
			XSSFCell cell=sheet.getRow(i).getCell(j); // to get the index by iteration;
			
			switch(cell.getCellType()) // to check the type of the excel values;
			{
			case XSSFCell.CELL_TYPE_STRING: // XSSFCell is the type; In case you have to give the type always;
				{
					System.out.println(cell.getStringCellValue()); // printing string type values only;
					/*Storing datas into an array; i-1 because rows start from index(0);Usually
					heading stays on row 0 position;*/
					datas[i-1][j]=cell.getStringCellValue(); 
				}
				// to avoid java.lang.IllegalStateException: Cannot get a numeric value from a text cell error
				break; 
			case XSSFCell.CELL_TYPE_NUMERIC:
				{
					System.out.println(cell.getNumericCellValue()); // printing numeric type values only;
					/*Storing datas into an array; i-1 because rows start from index(0);Usually
					heading stays on row 0 position;*/
					datas[i-1][j]=cell.getNumericCellValue();
				}
				break; 
				}
			
			}
		}
		return datas;
	}

}
