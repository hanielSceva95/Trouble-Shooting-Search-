package troubleShootSearch.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results {
	   public Results(String Output){
		   System.out.println(Output);
	    	try {
	    		File file = new File("output.txt");
	    		if (!file.exists()) {
	    		     file.createNewFile();
	    		  }
	    		FileWriter writer = new FileWriter(file,true);
	    		BufferedWriter bufferedWriter = new BufferedWriter(writer);
	    		bufferedWriter.write(Output);
	    		bufferedWriter.newLine();
	    		bufferedWriter.close();
	 		   }
	    	catch (IOException e) {
	    		System.out.println(e);
	    	}
		}
}
