package troubleShootSearch.conditionModule;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.driver.ProductBuilder;
import troubleShootSearch.util.*;

/**
 * 
 * SemanticMatch class which checks for semantics for last entered word by user and finds the exact match with the available reocrds
 *
 */
public class Semantic implements Visitor {

	ProductBuilder productBuilder = null;
	List<String> inputList = null;
	FileProcessor fp = null;
    public List<String> syn = null;
    int debugVal;
    
    public Semantic() {
        
    }

    public Semantic(ProductBuilder productBuilderIn, String inputFileNameIn, FileProcessor fp, int debugValIn) {
		this.productBuilder = productBuilderIn;
		this.inputList = new ArrayList<String>();
		this.syn = new ArrayList<String>();
		this.fp =  fp;
		this.setInputList(inputFileNameIn);
		Logger.setDebugValue(debugValIn);
		debugVal = debugValIn;
	}
    
    @Override
	public String toString() {
		return "SemanticMatch [productBuilder=" + productBuilder
				+ ", inputList=" + inputList + ", fp=" + fp + ", syn=" + syn
				+ "]";
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

    

    public void semanticMatchFinding(List<String> listIn,List<String> synonymIn) {
    	
    	List<String> file = new ArrayList<String>();
       
    	file.addAll(this.getInputList());
    	
        	for(int i=0;i<this.getInputList().size();i++)
        	{
        		String lastWord = this.getInputList().get(i).substring(this.getInputList().get(i).lastIndexOf(" ") + 1);	
        		for (String line: synonymIn){
    				if(line.contains((lastWord))){
    					String str[] = line.split(":");
    					file.set(i,file.get(i).replaceAll(str[0], str[1]));
    	                               				
    				}
    				
    			}
        	}
        	
        	

        
        for (String inputLine: listIn){ //Does the Exact Match
			for (String line: this.getInputList()){
				//if(inputLine.toLowerCase().contains((line.toLowerCase()))){
				if(inputLine.contains((line))){
					//System.out.println("SEMANTIC MATCH: "+inputLine);
					String outputString = "SEMANTIC: "+inputLine;
					Results output = new Results(outputString);
					if(debugVal==4 || debugVal==1) {
						Logger.writeMessage("SEMANTIC: "+inputLine, Logger.getDebugValue());
					}
				}
			}
		}

    }
    @Override
    public void visit(Productversion pro1v1) {
    	semanticMatchFinding(productBuilder.getProduct1().getContentList(),productBuilder.getSynonymList());
    	semanticMatchFinding(productBuilder.getProduct2().getContentList(),productBuilder.getSynonymList());
    	semanticMatchFinding(productBuilder.getProduct3().getContentList(),productBuilder.getSynonymList());
    	semanticMatchFinding(productBuilder.getProduct4().getContentList(),productBuilder.getSynonymList());
    }

	

	
}