package troubleShootSearch.conditionModule;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.driver.ProductBuilder;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Productversion;
import troubleShootSearch.util.Results;

/**
 * 
 * NaiveStemmingMatch class which checks the exact match for the first word of the user input with the available records
 *
 */
public class NaiveStemming implements Visitor {

	ProductBuilder productBuilder = null;
	List<String> inputList = null;
	FileProcessor fp = null;
    int debugVal;

    public NaiveStemming()
    {
    	
    }
    
    public NaiveStemming(ProductBuilder productBuilderIn, String inputFileNameIn, FileProcessor fpIn, int debugValIn) {
		this.productBuilder = productBuilderIn;
		this.inputList = new ArrayList<String>();
		this.fp =  fpIn;
		this.setInputList(inputFileNameIn);
		Logger.setDebugValue(debugValIn);
		debugVal = debugValIn;
	}
    
    
    public List<String> getInputList() {
		return inputList;
	}

	public void setInputList(String name) {
		BufferedReader reader;
		
		String line;
		
			reader = this.fp.readerDesc(name);
			while ((line = this.fp.readLine(reader)) != null) {
				inputList.add(line);
			}
	}
	
    public void naiveStemmingMatchFinding(List<String> listIn) {
    	
    	for (String inputLine: listIn){
    		for(int i=0; i< this.getInputList().size();i++){
    			String ip[] = this.getInputList().get(i).split(" ", 2);
    			
				//if(inputLine.toLowerCase().contains((ip[0].toLowerCase())))
    			if(inputLine.contains((ip[0])))
				{
    				String outputString = "NAIVE STEMMING: "+inputLine;
					Results output = new Results(outputString);
					//System.out.println("NAIVE STEMMING MATCH: "+inputLine);
					if(debugVal==3 || debugVal==1) {
						Logger.writeMessage("NAIVE STEMMING: "+inputLine, Logger.getDebugValue());
					}
				}
				
			}
		}
    	
    }


    
    public void visit(Productversion pro1v1) {
    	naiveStemmingMatchFinding(productBuilder.getProduct1().getContentList());
    	naiveStemmingMatchFinding(productBuilder.getProduct2().getContentList());
    	naiveStemmingMatchFinding(productBuilder.getProduct3().getContentList());
    	naiveStemmingMatchFinding(productBuilder.getProduct4().getContentList());
       
    }
	

}