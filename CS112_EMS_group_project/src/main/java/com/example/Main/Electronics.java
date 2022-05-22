package com.example.Main;


import java.io.File;
import java.io.FileWriter;

public class Electronics extends Item {
  private int year;
  private String brand;
  private String model;

  
   @Override
   public String orderSummary(int quantity){
       // A method that shows the purchase summary to the customer after buying an item
       String summary = "Purchased items: "+getItemID()+", QTY="+quantity+", Price="+(quantity*getPrice());
       return  summary;
   }

    public Electronics(int itemID, String itemName, double price) {
        super(itemID, itemName, price);
        File electronicsFile = new File("src/main/java/txt/Electronic.txt");
        try {
            FileWriter writer = new FileWriter(electronicsFile,true);
            writer.append("\n"+String.valueOf((itemID))+","+(itemName)+","+String.valueOf(price));
            writer.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Electronics(int itemID, String itemName, double price, int year, String brand, String model) {
            super(itemID, itemName, price);
            this.year = year;
            this.brand = brand;
            this.model = model;
            File electronicsFile = new File("src/main/java/txt/Electronic.txt");
            try {
                FileWriter writer = new FileWriter(electronicsFile,true);
                writer.append("\n"+String.valueOf((itemID))+","+(itemName)+","+(brand)+","+model+","+String.valueOf(year+","+price));
                writer.close();


            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public Electronics(int itemID, String itemName, double price, int year, String brand, String model, boolean NoAppendingTxt) {
            // This constructor is used to add the default items to the arraylist, but not in the text file.
            super(itemID, itemName, price);
            this.year = year;
            this.brand = brand;
            this.model = model;
       }
}
