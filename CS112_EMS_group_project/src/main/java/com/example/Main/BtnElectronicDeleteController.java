package com.example.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class BtnElectronicDeleteController implements EventHandler <ActionEvent> {
    TextField textFieldItemId;
    Label lblConfirmMessage;


    public BtnElectronicDeleteController(TextField textField, Label lblConfirmMessage){
        this.textFieldItemId = textField;
        this.lblConfirmMessage = lblConfirmMessage;

    }

    @Override
    public void handle(ActionEvent event) {
        String id = "";
        int IndexOfBegOfTheLine = 0;
        int IndexOfEndOfTheLine = 0;
        File electronics = new File("src/main/java/txt/Electronic.txt");

        // An algorithm that deletes a line in an item text files
        // Each item must have an id so the algorithm can work
        try{
            FileWriter writer = new FileWriter(electronics,true);
            StringBuilder stringBuilder = new StringBuilder();

            Scanner reader = new Scanner(electronics);
            while (reader.hasNext()){
                stringBuilder.append(reader.nextLine()+"\n");
            }

            for(int i=0;i<AppInitializer.electronics.size();i++){
                if(AppInitializer.electronics.get(i).getItemID() == Integer.parseInt(textFieldItemId.getText())){
                    if(i<AppInitializer.electronics.size() -1){
                        id = AppInitializer.electronics.get(i).getItemID()+"";
                        IndexOfBegOfTheLine = stringBuilder.indexOf(id);
                        id = AppInitializer.electronics.get(i+1).getItemID()+"";
                        IndexOfEndOfTheLine = stringBuilder.indexOf(id);
                        stringBuilder.delete(IndexOfBegOfTheLine, IndexOfEndOfTheLine);
                    } else {
                        id = AppInitializer.electronics.get(i).getItemID()+"";
                        stringBuilder.delete(stringBuilder.indexOf(id), stringBuilder.length()-1);
                    
                    }
                } else {
                }
            }

            writer = new FileWriter(electronics);
            writer.append(stringBuilder);

            writer.close();
            reader.close();
            lblConfirmMessage.setTextFill(Color.RED);
            lblConfirmMessage.setText("The item with id: "+textFieldItemId.getText()+" is deleted successfully");

        } catch (Exception e){
            System.out.println(e);
        }
        for(int i=0;i<AppInitializer.electronics.size();i++){
                if(AppInitializer.electronics.get(i).getItemID() == Integer.parseInt(textFieldItemId.getText())){
                    AppInitializer.electronics.remove(i);
                }
        }
    }






}
