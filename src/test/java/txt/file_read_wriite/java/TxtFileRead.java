package txt.file_read_wriite.java;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

public class TxtFileRead {
	
	@Test // read from written file
	public void fileRead() throws IOException{
		FileReader file=null;
		StringBuffer sb=new StringBuffer();
		
		try
		{
			file= new FileReader("textin.txt");
		}
	
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
		/*BufferedReader is a class in Java that reads text from a character-input stream, buffering
		characters so as to provide for the efficient reading of characters, lines and arrays. 
		The buffer size may be specified. If not, the default size, which is predefined, may be used.*/
		BufferedReader bf=new BufferedReader(file);
		String line=bf.readLine(); // Read next line
		while(line!=null)
		{
			System.out.println(line);
			sb.append(line).append(System.lineSeparator());
			line=bf.readLine();
		}
	
	}
	
	

}
