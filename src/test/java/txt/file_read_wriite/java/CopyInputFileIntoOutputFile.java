package txt.file_read_wriite.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class CopyInputFileIntoOutputFile {
	
	@Test
	public void copy() throws IOException{
		FileReader in=null;
		FileWriter out=null;
		
		try{
			in=new FileReader("textin.txt");
			out=new FileWriter("some.txt");
			
			int c;
			while((c=in.read())!=-1) // last value for read() is -1;
			{
				out.write(c);
				
			}
		}finally
			{
				if(in!=null)
				{
					in.close();
				}
				
				if(out!=null)
				{
					out.close();
				}
				
			}
		}
	}


