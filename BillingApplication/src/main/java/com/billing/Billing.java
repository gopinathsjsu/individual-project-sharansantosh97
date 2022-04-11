package com.billing;

import java.util.Scanner;

import com.database.StaticDatabase;

public class Billing
{
	
    public static void main(String args[])
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
            
        }
        else
        {
            System.out.println("Please enter correct inuput file path");
        }
    }
    
    
}
    
    
    
   


