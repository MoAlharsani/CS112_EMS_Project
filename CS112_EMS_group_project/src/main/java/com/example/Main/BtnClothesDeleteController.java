package com.example.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class BtnClothesDeleteController implements EventHandler<ActionEvent> {
    TextField textFieldItemId;
    Label lblConfirmMessage;

    public BtnClothesDeleteController(TextField textFieldItemId, Label lblConfirmMessage) {
        this.textFieldItemId = textFieldItemId;
        this.lblConfirmMessage = lblConfirmMessage;
    }


    @Override
    public void handle(ActionEvent event) {
        String id = ""; // This variable is used to store the id which the admin wants to delete from text file.
        int IndexOfBegOfTheLine = 0;
        int IndexOfEndOfTheLine = 0;
        File clothesTextFile = new File("src/main/java/txt/Clothes.txt");

        // An algorithm that deletes a line in an item text files
        // Each item must have an id so the algorithm can work
        try{
            FileWriter writer = new FileWriter(clothesTextFile,true);
            StringBuilder stringBuilder = new StringBuilder();

            Scanner reader = new Scanner(clothesTextFile);
            while (reader.hasNext()){
                stringBuilder.append(reader.nextLine()+"\n");
            }

            for(int i=0;i<AppInitializer.clothes.size();i++){
                if(AppInitializer.clothes.get(i).getItemID() == Integer.parseInt(textFieldItemId.getText())){
                    if(i<AppInitializer.clothes.size() -1){
                        id = AppInitializer.clothes.get(i).getItemID()+"";
                        IndexOfBegOfTheLine = stringBuilder.indexOf(id);
                        id = AppInitializer.clothes.get(i+1).getItemID()+"";
                        IndexOfEndOfTheLine = stringBuilder.indexOf(id);
                        stringBuilder.delete(IndexOfBegOfTheLine, IndexOfEndOfTheLine);
                    } else {
                        id = AppInitializer.clothes.get(i).getItemID()+"";
                        stringBuilder.delete(stringBuilder.indexOf(id), stringBuilder.length()-1);
                    }
                } else {
                }
            }

            writer = new FileWriter(clothesTextFile);
            writer.append(stringBuilder);

            writer.close();
            reader.close();
            lblConfirmMessage.setTextFill(Color.RED);
            lblConfirmMessage.setText("The item with id: "+textFieldItemId.getText()+" is deleted successfully");
            
            

        } catch (Exception e){
            System.out.println(e);
        }
        
        for(int i=0;i<AppInitializer.clothes.size();i++){
                if(AppInitializer.clothes.get(i).getItemID() == Integer.parseInt(textFieldItemId.getText())){
                    AppInitializer.clothes.remove(i);
                }
        }
        }
    }

