/*
  Final project for CS112
  Students:
  Omar Alharbi -- 42
  Abulaziz Alfifi -- 42
  Mohammed Alharbi -- 42
  Rayan Alharbi

  supervised by:
  Dr.Musfa Qarah

*/
package com.example.Main;

import View.LoginPage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class AppInitializer extends Application {
    static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Electronics> electronics = new ArrayList<>();
    public static ArrayList<Clothes> clothes = new ArrayList();




    @Override
    public void start(Stage stage) throws IOException {
        new LoginPage(stage, users);
    }

    public static void main(String[] args) {
        // Default Users and entities to test the program
        users.add(new User(1,"Omar","Alharbi","2","2","Omar@gmail.com",true));
        users.add(new User(2,"Ahmed","Alharbi","ahmed43","ahmed1234","ahmed43@yahoo.com",false));
        users.add(new User(2,"Ahmed","Alharbi","1","1","ahmed43@yahoo.com",false));
        electronics.add(new Electronics(1001,"Mobil_phone",1500,2018,"Apple","iphone", true));
        electronics.add(new Electronics(1002,"Laptop",1850,2020,"Dell","XPS",true));
        electronics.add(new Electronics(1003,"TV",2000,2019,"LG","OLED",true));
        clothes.add(new Clothes(2001, "Shirt", 12,"Blue", "Men","M",true));
        clothes.add(new Clothes(2002, "Dress", 500,"Green", "Women","XL",true));
        clothes.add(new Clothes(2003, "Pants", 31,"Yellow", "Men","M",true));
        launch();
    }
}