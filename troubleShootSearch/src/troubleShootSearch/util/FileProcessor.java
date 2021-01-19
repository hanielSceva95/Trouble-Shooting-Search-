package troubleShootSearch.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileProcessor {
	int debugValue;
		public FileProcessor(int debugValueInteger) throws IOException
		{
			debugValue = debugValueInteger;
			System.out.println(debugValue);
			File file = new File("output.txt");
			FileWriter writer = new FileWriter(file,true);
			 BufferedWriter out = new BufferedWriter (writer);
	         out.close();
	         boolean success = (new File("output.txt")).delete();
		}
		@Override
	    public String toString() {
	        return "FileProcessor{}";
	    }
		
		public BufferedReader readerDesc(String name) {
	        BufferedReader reader = null;
	        try {
	        	FileInputStream fp = new FileInputStream(name);
	            reader = new BufferedReader(new InputStreamReader(fp));
	        } catch (FileNotFoundException e) {
	        	if(debugValue == 0)
//	        		Logger.writeMessage("File Not found, please make sure the input file available", Logger.getDebugValue());
	            System.exit(0);
	        } finally {

	        }
	        return reader;
	    }
		public String readLine(BufferedReader reader) {
	        if (reader == null) {
	            return null;
	        }
	        String line = null;
	        try {
	            line = reader.readLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	            //System.out.println("Read a line error");
	            if(debugValue == 0)
//	        		Logger.writeMessage("File Not found, please make sure the input file available", Logger.getDebugValue());
	           
	            System.exit(0);
	        } finally {

	        }
	        return line;
	    }

}