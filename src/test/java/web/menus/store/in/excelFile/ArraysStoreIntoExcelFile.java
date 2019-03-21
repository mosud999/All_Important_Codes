package web.menus.store.in.excelFile;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ArraysStoreIntoExcelFile {
	
	/*@Test
	public void write() throws IOException
	{
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("web");
		
		String []name={"Mosud", "Ahmed", "Lavon"};
		
		for(int i=0; i<name.length; i++)
		{
			Row row=sheet.createRow(i);
			row.createCell(i).setCellValue(name[i]);
		}
		
		FileOutputStream fout=new FileOutputStream("C:\\Users\\User\\Desktop\\test.xlsx");
		workbook.write(fout);
		workbook.close();
		
		
	}*/
	
	@Test
	public void write() throws IOException
	{
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("web");
		
		String []name={"Mosud", "Ahmed", "Lavon"};
		int i=0;
		for(Row row:sheet){
			sheet.createRow(i).createCell(0).setCellValue(name[i]);
			i++;
			
		}
		
		FileOutputStream fout=new FileOutputStream("C:\\Users\\User\\Desktop\\test.xlsx");
		workbook.write(fout);
		workbook.close();
		
		
	}

}
