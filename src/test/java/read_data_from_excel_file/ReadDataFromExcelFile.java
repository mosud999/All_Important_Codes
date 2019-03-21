package read_data_from_excel_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcelFile {
	
	@Test
	public void readDataFile() throws IOException
	{
	FileInputStream f=new FileInputStream(new File("C:\\Users\\User\\workspace\\TestNgImportantCodesFinal\\src\\test\\java\\read_data_from_excel_file\\xsheet.xlsx"));
	XSSFWorkbook w=new XSSFWorkbook(f); // verify the loaded file is an Excel file;
	XSSFSheet sheet=w.getSheetAt(0); // We can call the exact sheet by getSheetAt index method and getSheetAt string name method;
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
				}
				// to avoid java.lang.IllegalStateException: Cannot get a numeric value from a text cell error
				break; 
			case XSSFCell.CELL_TYPE_NUMERIC:
				{
					System.out.println(cell.getNumericCellValue()); // printing numeric type values only;
				}
				break; 
			}
			
		}
	}
	}

}
