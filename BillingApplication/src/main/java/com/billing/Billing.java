package com.billing;



import java.io.IOException;
import java.util.Scanner;

import com.database.StaticDatabase;

public class Billing
{
	
    public static void main(String args[])throws IOException
    {
    	StaticDatabase db = StaticDatabase.getInstance();
    	db.loadDatabase();
    	System.out.println("Database loaded with the required data");

        	Scanner sc=new Scanner(System.in).useDelimiter("\n");
            System.out.println("Please enter the input file path for placing the order");
            String fPath="";
            try{
            	fPath=sc.next();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            Orders o=new Orders(fPath);
            if(o.startOrder()==true)
            {
                System.out.println("Processing your order");
                if(o.verifyOrderDetails()==true) 
                {
                    System.out.println("All Products are available in stock and under each category limit");
                    o.getTotalPrice();
                    o.checkoutOrder();
                    System.out.println("Success! Order has been placed.");
                    System.out.println("Please refer to successFile under Output folder of the project structure for more details");

                }
                else
                {
                        System.out.println("Error Occured, please check error file under Output folder of the project structure for more details");
                        o.showOutput();
                }
            }
            else
            {
                System.out.println("Please enter correct inuput file path");
            }
     }
    
    
}
    
    
    
   


