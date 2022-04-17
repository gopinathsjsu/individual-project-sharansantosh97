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
	
	public boolean verifyOrderDetails(){
        quantityLimit();
        categoryLimit();
        return outputMessage.isEmpty();
    }
    public void getTotalPrice(){
        itemList.forEach((item)->{
            totalAmount+= item.getItemQuantity()* item.getPrice();
        });
        currentInvoice.setTotalPrice(totalAmount);
    }



    public void checkoutOrder(){
        database.getOrders().add(currentInvoice);
        for(BillingItem currentItem:itemList){
            Item item=database.getItems().get(currentItem.getInvoiceItemName());
            item.setQuantityInInventory(item.getQuantityInInventory()-currentItem.getItemQuantity());

        }
        for(String creditCard:creditCards){
            if(!database.getCreditCards().contains(creditCard)){
                database.getCreditCards().add(creditCard);
            }
        }
        
        
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



    public boolean quantityLimit(){
        StringBuilder message=new StringBuilder();
        for(BillingItem currentItem:itemList){
            Item item=database.getItems().get(currentItem.getInvoiceItemName());
            if(item.getQuantityInInventory()<currentItem.getItemQuantity()){
                if(message.length()>0)
                    message.append("\n");
                message.append(currentItem.getInvoiceItemName()+" is not present in sufficient quantity in Database");
            }
            else{
                currentItem.setPrice(item.getItemPrice());
                if(!creditCards.contains(currentItem.getCreditCardInfo()))
                    creditCards.add(currentItem.getCreditCardInfo());
            }
        }
        if(message.length()>0){
            outputMessage.add("Incorrect item quantities.");
            outputMessage.add(message.toString());
        }

        return (message.length()==0);



    }
    
    public boolean categoryLimit()
    {
        final int luxuryCat = 4;
        final int essentialCat = 3;
        final int miscCat = 6;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        StaticDatabase database = StaticDatabase.getInstance();
        for(BillingItem orderItem:itemList){
            map.put(database.getItems().get(orderItem.getInvoiceItemName()).getCategory(),map.getOrDefault(database.getItems().get(orderItem.getInvoiceItemName()).getCategory(),0)+orderItem.getItemQuantity());
        }

        if(map.getOrDefault("Luxury",0)>luxuryCat){
            outputMessage.add("Only 4 Luxury items can be included in one order");
            return false;
        }

        else if(map.getOrDefault("Essentials",0)>essentialCat){
            outputMessage.add("Only 3 Essential items can be included in one order");
            return false;
        }

        else if(map.getOrDefault("Misc",0)>miscCat){
            outputMessage.add("Only 6 Misc items can be included in one order");
            return false;
        }

        return true;
    }



}
