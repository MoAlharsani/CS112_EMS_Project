package com.example.Main;


import java.io.File;
import java.io.FileWriter;

public class Clothes extends Item {
   private String color;
   private String department;
   private String size;
    
   @Override
   public String orderSummary(int quantity){
       // A method that shows the purchase summary to the customer after buying an item
       String summary = "Purchased items: "+getItemID()+", QTY="+quantity+", Price="+(quantity*getPrice());
       return  summary;
    }

    public Clothes(int itemID, String itemName, double price) {
        super(itemID, itemName, price);
        File ClothesTextFile = new File("src/main/java/txt/Clothes.txt");
        try {
            FileWriter writer = new FileWriter(ClothesTextFile,true);
            writer.append("\n"+String.valueOf((itemID))+","+(itemName)+","+String.valueOf(price));
            writer.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Clothes(int itemID, String itemName, double price, String color, String department, String size) {
        super(itemID, itemName, price);
        this.color = color;
        this.department = department;
        this.size = size;
        File ClothesTextFile = new File("src/main/java/txt/Clothes.txt");
        try {
            FileWriter writer = new FileWriter(ClothesTextFile,true);
            writer.append("\n"+String.valueOf((itemID))+","+(itemName)+","+(color)+","+department+","+size+","+String.valueOf(price));
            writer.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Clothes(int itemID, String itemName, double price, String color, String department, String size, boolean NoAppendingTxt) {
        // This constructor is used to add the default items to the arraylist, but not in the text file.
        super(itemID, itemName, price);
        this.color = color;
        this.department = department;
        this.size = size;
    }
}
