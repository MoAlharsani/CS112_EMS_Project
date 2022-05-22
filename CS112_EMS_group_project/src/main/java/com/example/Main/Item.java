package com.example.Main;


abstract public class Item {
    private int itemID;
    private String itemName;
    private double price;
   
    abstract String orderSummary(int quantity);

    public Item(int itemID, String itemName, double price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }
}
