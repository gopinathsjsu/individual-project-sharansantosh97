package com.modelclasses;

import java.util.HashSet;

public class Bill {
private double totalPrice;
private HashSet<Item> itemList= new HashSet<Item>();
public Bill(){};

    public HashSet<Item> getItemList() {
        return itemList;
    }

    public void setItemList(HashSet<Item> itemList) {
        this.itemList = itemList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
