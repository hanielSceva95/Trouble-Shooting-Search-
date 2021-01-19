package troubleShootSearch.conditionModule;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.driver.ProductBuilder;
import troubleShootSearch.util.*;

/**
 * 
 * Exact Match class which checks the user input for exact match in records
 *
 */
public class Exact implements Visitor {

	public Exact()
	{
		
	}
    ProductBuilder productBuilder = null;
    List<String> inputList = null;
    FileProcessor fp = null;
	int debugVal;

	public Exact(ProductBuilder productBuilder, String inputFileName, FileProcessor fp, int debugValIn) {
		this.productBuilder = productBuilder;
		this.inputList = new ArrayList<String>();
		this.fp =  fp;
		this.setInputList(inputFileName);
		Logger.setDebugValue(debugValIn);
		debugVal = debugValIn;
	}

	public String toString() {
		return "ExactMatch [productBuilder=" + productBuilder + ", inputList="
				+ inputList + ", fp=" + fp + "]";
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

	public void exactMatchFinding(List<String> listIn)
	{
		for (String inputLine: listIn){
			for (String line: this.getInputList()){
				//if(inputLine.toLowerCase().contains((line.toLowerCase()))){
				if(inputLine.contains((line))){
					//System.out.println("EXACT MATCH: "+inputLine);
					String outputString = "EXACT MATCH: "+inputLine;
					Results output = new Results(outputString);
					if(debugVal==2 || debugVal==1) {
					Logger.writeMessage("EXACT MATCH: "+inputLine, Logger.getDebugValue());
					}
				}
			}
		}
	}
	@Override
	public void visit(Productversion productversion)
	{
		exactMatchFinding(productBuilder.getProduct1().getContentList());
		exactMatchFinding(productBuilder.getProduct2().getContentList());
		exactMatchFinding(productBuilder.getProduct3().getContentList());
		exactMatchFinding(productBuilder.getProduct4().getContentList());
	}

	
}