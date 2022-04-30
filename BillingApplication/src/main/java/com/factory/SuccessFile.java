package com.factory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.billing.Orders;
import com.modelclasses.BillingItem;
import com.opencsv.CSVWriter;


public class SuccessFile implements FileInterface {
    private ArrayList<String> filetext = new ArrayList<String>();
    @Override
    public void setContent(ArrayList<String> orderDetails)
    {
    	
        filetext=orderDetails;
        
    }
    @Override
    public void FileWriter(Path filePath, ArrayList<BillingItem> itemList)throws IOException 
    {
   
    	Path p = Paths.get(""); 
        String directoryName = p.toAbsolutePath().toString();
        
       
        File f = new File(directoryName+"/src/main/java/Output/"+"/successFile.csv");
        FileWriter q = new FileWriter(f);
        CSVWriter writer = new CSVWriter(q);

        String[] data1 = { "Item", "Quantity", "Price","TotalPrice" };
        writer.writeNext(data1);
        double totalprice = 0;
        for(int i=0;i<itemList.size();i++)
        {
        	totalprice += itemList.get(i).getItemQuantity() * itemList.get(i).getPrice();
        }
        for(int i=0;i<itemList.size();i++)
        {
        	if(i==0)
        	{
        		String[] s = new String[4];
            	s[0]=itemList.get(i).getInvoiceItemName();
            	s[1]=String.valueOf(itemList.get(i).getItemQuantity());
            	s[2]=String.valueOf(itemList.get(i).getPrice());
            	s[3]=String.valueOf(totalprice);
            	writer.writeNext(s);
        	}else
        	{
        		String[] s = new String[3];
            	s[0]=itemList.get(i).getInvoiceItemName();
            	s[1]=String.valueOf(itemList.get(i).getItemQuantity());
            	s[2]=String.valueOf(itemList.get(i).getPrice());
            	writer.writeNext(s);
        	}
        	
        }
        

        writer.close();
        
        
        
    }

}
