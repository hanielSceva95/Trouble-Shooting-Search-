package troubleShootSearch.driver;

import troubleShootSearch.util.*;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ProductBuilder class which creates instances for 4 products and assigns arraylist by parsing files
 *
 */
public class ProductBuilder{    
    public ProductBuilder()
    {
    	
    }
    
    private FileProcessor fp = null;
    int debugValue;
    public ProductBuilder(FileProcessor fp, int debugValueInteger) {
        this.fp = fp;
        debugValue = debugValueInteger;
    }
    

	public String toString() {
		String outputString = "ProductBuilder [fp=" + fp + ", product1=" + p1
				+ ", product2=" + p2 + ", product3=" + p3
				+ ", product4=" + p4 + "]";
		Results output = new Results(outputString);
		return outputString;
	}
    Product p1 = null;
    Product p2 = null;
    Product p3 = null;
    Product p4 = null;
    
    public List<String> synonym = null;
    public void setProduct(){
        p1 = new Product();
        p2 = new Product();
        p3 = new Product();
        p4 = new Product();
        synonym = new ArrayList<String>();
        this.assignData(p1, "userInput1.txt");
        this.assignData(p2, "userInput2.txt");
        this.assignData(p3, "userInput3.txt");
        this.assignData(p4, "userInput4.txt");
        synonym.addAll(this.getFileContent("synonym.txt"));
    }
    
    private void assignData(Product product, String name){
        product.setContentList(this.getFileContent(name));
    }
    private List<String> getFileContent( String name){
        BufferedReader reader;
        List<String> content = new ArrayList<String> ();

        try {
            String line;
            reader = fp.readerDesc(name);
            while ((line = fp.readLine(reader)) != null) {
                content.add(line);
            }
            

        }catch (Exception e){
        	if(debugValue == 0)
        		Logger.writeMessage("Exception occured while reading file", Logger.getDebugValue());
            //e.printStackTrace();
        }
        return  content;
    }

    public List<String> getSynonymList() {
        return synonym;
    }
    
    public Product getProduct1() {
        return p1;
    }

    public Product getProduct2() {
        return p2;
    }

    public Product getProduct3() {
        return p3;
    }

    public Product getProduct4() {
        return p4;
    }



	
}