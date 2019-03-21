package writeAndCompareTwotTxtFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HowToStoreWebDataInTxtFile extends BaseClass {
	
	// Writing text file 1 from web menus
	@Test 
	public void writeFileOne() throws IOException {

		BufferedWriter writer = null;

		try {

			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("homework1.txt")));

			List<WebElement> menu = dr
					.findElements(By.xpath("//ul[@class='category-navigation-list sticky-flyout']/li"));
			String actualValue[] = new String[menu.size()];

			int i = 0;
			for (WebElement m : menu) {
				String list = actualValue[i] = m.getText();
				// System.out.println(list);
				writer.write(list + "\n");
			}

			// System.out.println(actualValue);

		} finally {
			writer.close();
		}

	}

	// Writing text file 2 from manually
	@Test
	public void writeFiletwo() {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("homework1-expected.txt")));
			String strs[] = { "com", "exe", "doc" };

			for (int j = 0; j < strs.length; j++) {

				writer.write(strs[j] + "\n");
				System.out.println(strs[j]);

			}

		} catch (IOException e) {
			// reprt
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
			}

		}
	}

	// comparing contents for both text file
	@Test
	public void fileRead() throws IOException {
		try {
			FileReader f1 = new FileReader("homework1.txt");
			FileReader f2 = new FileReader("homework1-expected.txt");
			int characte1 = f1.read();
			int characte2 = f2.read();

			while (characte1 != -1 && characte2 != -1) {

				if (characte1 == characte2) {
					System.out.println("Test failed");
					break;
				} else {
					System.out.println("Test passed");
					break;
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
