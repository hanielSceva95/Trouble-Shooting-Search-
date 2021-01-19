package troubleShootSearch.driver;

import troubleShootSearch.conditionModule.Exact;
import troubleShootSearch.conditionModule.NaiveStemming;
import troubleShootSearch.conditionModule.Semantic;
import troubleShootSearch.conditionModule.Visitor;
import troubleShootSearch.util.*;
/**
 * 
 * @author Haniel Sceva
 *
 */
public class Driver {

    /**
     * Driver class for visitor pattern
     * @param args
     */
    public static void main(String[] args) {
    	int debugValueInt = 0;
        if (args.length == 1) {
            if (args[0].length() < 1) {
                System.out.println("Please provide a valid debug level");
            } else {
            	debugValueInt = Integer.parseInt(args[0]);
            }
        }else{
            System.err.println("Please provide a debug level");
            System.exit(1);
        }
    	
        FileProcessor fp = null;
        fp = new FileProcessor(debugValueInt);
        ProductBuilder productBuilder = new ProductBuilder(fp,debugValueInt);
        productBuilder.setProduct();
//        FileHelperI fp = new FileHelper(debugVal);
        
        Productversion productversion = new Productversion();
        Visitor EM = new Exact(productBuilder,"userInputs.txt",fp,debugValueInt);
        Visitor NSM = new NaiveStemming(productBuilder, "userInputs.txt", fp,debugValueInt);
        Visitor SM = new Semantic(productBuilder, "userInputs.txt", fp,debugValueInt);
       
        productversion.accept(EM);
        productversion.accept(NSM);
        productversion.accept(SM);
    }
}