package com.billing;

import com.database.StaticDatabase;

public class Billing
{
	
    public static void main(String args[])
    {
    	
    	StaticDatabase db = StaticDatabase.getInstance();
    	db.loadDatabase();
    }
    
    
}
    
    
    
   


