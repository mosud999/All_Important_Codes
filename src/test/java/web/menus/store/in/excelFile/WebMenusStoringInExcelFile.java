package web.menus.store.in.excelFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebMenusStoringInExcelFile extends BaseClass {

	// this program is for storing the web menus into an excel file;
	// run this program from run.xml;
	List<WebElement> elements;
	List<String> webMenus;
	XSSFWorkbook workbook;

	@Test(priority = 0)
	public void getWebMenus() {
		elements = dr.findElements(By.xpath("//ul[@class='category-navigation-list sticky-flyout']/li"));
		webMenus = new ArrayList<String>();
		for (int i = 0; i < elements.size(); i++) {
			String list = elements.get(i).getText();
			System.out.println(list);
			webMenus.add(list);

		}

	}

	@Test(priority = 1)
	public void storeWebMenusInArray() throws IOException {
		workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("web");

		for (int j = 0; j < elements.size(); j++) {
			sheet.createRow(j).createCell(0).setCellValue(webMenus.get(j));
			//sheet.createRow(j).createCell(0, CellType.STRING).setCellValue(webMenus.get(j));
			
		}

		FileOutputStream f = new FileOutputStream("C:\\Users\\User\\Desktop\\test.xlsx");
		workbook.write(f);
		workbook.close();
	}

}
