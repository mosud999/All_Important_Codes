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

public class DataProviderAnnotation {
	
	WebDriver dr;
	@Test(dataProvider="xl")
	public void login(Object uname, Object pass)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.get("https://www.eshopper24.com/login");
		dr.findElement(By.xpath("//input[@id='Email']")).sendKeys(uname.toString());
		dr.findElement(By.xpath("//input[@id='Password']")).sendKeys(pass.toString());
	}
	
	@DataProvider(name="xl")
	public Object[][] readFromFile() throws IOException
	{
		FileInputStream f= new FileInputStream(new File("C:\\Users\\User\\workspace\\SampleTestNgFrameworkClass30\\src\\test\\java\\dataProviderAnnotation\\xsheet.xlsx"));//File loading
		// when we load a file we dont know what kind of file it is; to make it excel file
		// we used XSSFWorkbook make it excel and give the sheet index(0);
		XSSFWorkbook w=new XSSFWorkbook(f);// to confirm its an xl file
		XSSFSheet sheet=w.getSheetAt(0);// go to index 0 sheet
		
		Object [][] datas= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=1; i<=sheet.getLastRowNum(); i++) // row starts from one because header stays on row(0);
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				XSSFCell cell=sheet.getRow(i).getCell(j);
				switch(cell.getCellType())
				{
				case XSSFCell.CELL_TYPE_STRING:
				{
					System.out.println(cell.getStringCellValue());
					datas[i-1][j]=cell.getStringCellValue();
					break;
				}
				
				case XSSFCell.CELL_TYPE_NUMERIC:
				{
					System.out.println(cell.getNumericCellValue());
					datas[i-1][j]=cell.getNumericCellValue();
					break;
				}
				}
				
				
			
				}
			
			}
		
		return datas;
		}
		
	}


