package com.database;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.modelclasses.Bill;
import com.modelclasses.Item;

public class StaticDatabase {
    
    private static StaticDatabase instance;
    private HashMap<String, Item> inventoryDatabase=new HashMap<String, Item>();
    private HashSet<String> ccList=new HashSet<String>();
    private ArrayList<Bill> orders=new ArrayList<Bill>();
    private StaticDatabase(){}; 
    
    public static StaticDatabase getInstance()
    {
        if(instance == null)
            instance=new StaticDatabase();
        return instance;
    }
    public HashMap<String, Item> getItems() {
        return inventoryDatabase;
    }

    public ArrayList<Bill> getOrders() {
        return orders;
    }

    public HashSet<String> getCreditCards() {
        return ccList;
    }
    
    public void loadDatabase()
    {
    	inventoryDatabase.put("clothes", new Item("Essentials","clothes",100, 20));
    	inventoryDatabase.put("soap", new Item("Essentials","soap",200, 5));
    	inventoryDatabase.put("shampoo", new Item("Essentials","shampoo",200, 10));
    	inventoryDatabase.put("milk", new Item("Essentials","milk",100,5));
    	
    	inventoryDatabase.put("perfume", new Item("Luxury","perfume",50,50));
    	inventoryDatabase.put("chocolates", new Item("Luxury","chocolates",300, 3));
    	inventoryDatabase.put("handbag", new Item("Luxury","handbag",75, 150));
    	inventoryDatabase.put("wallet", new Item("Luxury","wallet",100,100));
    	
    	inventoryDatabase.put("bedsheet", new Item("Misc","bedsheet",150, 75));
    	inventoryDatabase.put("footware", new Item("Misc","footware",200, 25));
    	inventoryDatabase.put("homedecorpiece", new Item("Misc","homedecorpiece",100, 40));
    	inventoryDatabase.put("pen", new Item("Misc","pen",400, 3));
    	inventoryDatabase.put("pencil", new Item("Misc","pencil",400, 3));
    	
    	ccList.add("5410000000000000");
    	ccList.add("4120000000000");
    	ccList.add("341000000000000");
    	ccList.add("6010000000000000");
    	
    }
}
