package com.billing;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.database.StaticDatabase;
import com.factory.FileUtil;
import com.modelclasses.Bill;
import com.modelclasses.BillingItem;
import com.modelclasses.Item;

public class Orders {
    private StaticDatabase database=StaticDatabase.getInstance();
    private FileUtil file;
    private ArrayList<String> outputMessage=new ArrayList<String>();
    private HashSet<String> creditCards=new HashSet<String>();
    private ArrayList<BillingItem> itemList=new ArrayList<BillingItem>();
    

	

	private Bill currentInvoice=new Bill();
    private double totalAmount=0;
    public Orders(String filePath)
    {
        file=new FileUtil(filePath);
    }
    
	

	public boolean startOrder()
	{
        try{
            file.reader(true);
        }catch(Exception e){
            return false;
        }
        getItems(file.getFileContent());
        return true;
    }
	
    public void getItems(ArrayList<String> fileContent){
    	String firstLine = fileContent.get(0);
        String[] firstItem = firstLine.split(",");
        for(String contentLine:fileContent) {
            String[] item = contentLine.split(",");
         
            if (database.getItems().containsKey(item[0].toLowerCase())) {
            	double priceItem = database.getItems().get(item[0].toLowerCase()).getItemPrice();

            	try
            	{
            		itemList.add(new BillingItem(item[0].toLowerCase(), Integer.parseInt(item[1]), firstItem[2].replaceAll("\\s+", ""), priceItem));
            	}
            	catch(Exception e)
            	{
            		System.out.println("Error Occured, please check error file under Output folder of the project structure for more details");
            		outputMessage.add("Incorrect input file format");
            		break;
            	}
                
            } else {
            	outputMessage.add(item[0].toLowerCase() + " not present in the Database");
            }

        }
        if(!outputMessage.isEmpty()){
            itemList.clear();
        }
        
        
    }







}
