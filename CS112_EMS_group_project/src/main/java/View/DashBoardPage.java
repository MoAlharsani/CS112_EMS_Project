package View;

import com.example.Main.AppInitializer;
import com.example.Main.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DashBoardPage {
    private Label lblmessage;
    private double btnLoginWidth = 400;
    private double btnLoginHeight = 100;
    private static String firstName;
    private static String lastName;
    private File logoImage = new File("src/main/java/img/signoutlogo.png");

    // Dashboards for customers and admins
    public DashBoardPage(Stage stage, TextField textFieldUsername, TextField textFieldPassword, ArrayList<User> users, Label lblmessage){
        this.lblmessage = lblmessage;

        for (User user:
                users) {


            if(user.getUserName().equals(textFieldUsername.getText())){

                if(user.getPassword().equals(textFieldPassword.getText())){
                    this.firstName = user.getFirstName();
                    this.lastName = user.getLastName();
                    if(user.isAdmin()){
                        // admin interface
                        Pane root = new Pane();


                        root.setPadding(new Insets(15));

                        Label lblAdminMenu = new Label("Admin Menu");
                        lblAdminMenu.setFont(Font.font("Times New Roman", FontWeight.BOLD,30));
                        lblAdminMenu.setTextFill(Color.rgb(91,9,154));
                        root.getChildren().add(lblAdminMenu);
                        lblAdminMenu.relocate(220,30);

                        Label lblAdmin = new Label("Hello, "+user.getFirstName() +" "+user.getLastName());
                        lblAdmin.setTextFill(Color.WHITE);
                        lblAdmin.setPadding(new Insets(0,10,0,10));
                        lblAdmin.setFont(Font.font("Times New Roman", FontWeight.BOLD,20));
                        lblAdmin.setStyle(
                                "-fx-background-color: rgba(91,9,154);"
                        );
                        root.getChildren().add(lblAdmin);
                        lblAdmin.relocate(0,10);


                        Button electronicsModifying = new Button("Electronics Modifying");
                        electronicsModifying.setPrefSize(btnLoginWidth,btnLoginHeight);
                        electronicsModifying.setFont(Font.font("Arial",FontWeight.BOLD,30));
                        electronicsModifying.setTextFill(Color.WHITE);
                        electronicsModifying.setOnAction((e)->{
                            new ElectronicModifyingForm(stage);
                        });
                        electronicsModifying.setOnMouseEntered(e->{
                            electronicsModifying.setStyle(
                                    "-fx-background-color: rgba(91, 9, 154);" +
                                            "-fx-background-radius: 0;" +
                                            "-fx-padding: 10px 25px;" +
                                            "-fx-text-align: center;"
                            );
                        });
                        electronicsModifying.setOnMouseExited(e->{
                            electronicsModifying.setStyle(
                                    "-fx-background-color: rgba(91, 9, 154,0.3);" +
                                            "-fx-background-radius: 0;" +
                                            "-fx-padding: 10px 25px;" +
                                            "-fx-text-align: center;"
                            );
                        });
                        root.getChildren().add(electronicsModifying);
                        electronicsModifying.relocate(100,100);


                        Button clothesModifying = new Button("Clothes Modifying");
                        clothesModifying.setPrefSize(btnLoginWidth,btnLoginHeight);
                        clothesModifying.setFont(Font.font("Arial",FontWeight.BOLD,30));
                        clothesModifying.setOnAction((e)->{
                            new ClothesModifyingForm(stage);
                        });
                        clothesModifying.setOnMouseEntered(e->{
                            clothesModifying.setStyle(
                                    "-fx-background-color: rgba(91, 9, 154);" +
                                            "-fx-background-radius: 0;" +
                                            "-fx-padding: 10px 25px;" +
                                            "-fx-text-align: center;"
                            );
                        });
                        clothesModifying.setOnMouseExited(e->{
                            clothesModifying.setStyle(
                                    "-fx-background-color: rgba(91, 9, 154,0.3);" +
                                            "-fx-background-radius: 0;" +
                                            "-fx-padding: 10px 25px;" +
                                            "-fx-text-align: center;"
                            );
                        });
                        root.getChildren().add(clothesModifying);
                        clothesModifying.relocate(100,220);

                        Button btnExit = new Button("Exit");
                        btnExit.setPrefSize(btnLoginWidth,btnLoginHeight);
                        btnExit.setFont(Font.font("Arial",FontWeight.BOLD,30));
                        btnExit.setOnAction((e)->{
                            System.exit(0);
                        });
                        btnExit.setOnMouseEntered(e->{
                            btnExit.setStyle(
                                    "-fx-background-color: rgba(91, 9, 154);" +
                                            "-fx-background-radius: 0;" +
                                            "-fx-padding: 10px 25px;" +
                                            "-fx-text-align: center;"
                            );
                        });
                        btnExit.setOnMouseExited(e->{
                            btnExit.setStyle(
                                    "-fx-background-color: rgba(91, 9, 154,0.3);" +
                                            "-fx-background-radius: 0;" +
                                            "-fx-padding: 10px 25px;" +
                                            "-fx-text-align: center;"
                            );
                        });
                        root.getChildren().add(btnExit);
                        btnExit.relocate(100,340);
                        





                        // this method will print the items into the console window
                        itemsPrinter();


                        Scene layout = new Scene(root,600,500);
                        layout.getStylesheets().add(AppInitializer.class.getResource("style.css").toExternalForm());
                        stage.setResizable(false);
                        stage.setTitle("Admin Dashboard");
                        stage.setScene(layout);
                        stage.show();
                    } else {
                        // coustomer interface
                        Pane root = new Pane();
                        root.setPadding(new Insets(15));

                        Label lblCustomerMenu = new Label("Customer Menu");
                        lblCustomerMenu.setFont(Font.font("Times New Roman", FontWeight.BOLD,30));
                        lblCustomerMenu.setTextFill(Color.rgb(91,9,154));
                        root.getChildren().add(lblCustomerMenu);
                        lblCustomerMenu.relocate(210,30);

                        Label lblCustomer = new Label("Hello, "+user.getFirstName() +" "+user.getLastName());
                        lblCustomer.setTextFill(Color.WHITE);
                        lblCustomer.setPadding(new Insets(0,10,0,10));
                        lblCustomer.setFont(Font.font("Times New Roman", FontWeight.BOLD,20));
                        lblCustomer.setStyle(
                                "-fx-background-color: rgba(91,9,154);"
                        );
                        root.getChildren().add(lblCustomer);
                        lblCustomer.relocate(0,10);


                        Button btnElectronic = new Button("Electronics");
                        btnElectronic.setPrefSize(btnLoginWidth, btnLoginHeight);
                        btnElectronic.setFont(Font.font("Arial",FontWeight.BOLD,30));
                        btnElectronic.setOnAction((e)->{
                            new ElectronicBuyingForm(stage);
                        });
                        btnElectronic.setOnMouseEntered(e->{
                            btnElectronic.setStyle(
                                    "-fx-background-color: rgba(91, 9, 154);" +
                                            "-fx-background-radius: 0;" +
                                            "-fx-padding: 10px 25px;" +
                                            "-fx-text-align: center;"
                            );
                        });
                        btnElectronic.setOnMouseExited(e->{
                            btnElectronic.setStyle(
                                    "-fx-background-color: rgba(91, 9, 154,0.3);" +
                                            "-fx-background-radius: 0;" +
                                            "-fx-padding: 10px 25px;" +
                                            "-fx-text-align: center;"
                            );
                        });
                        root.getChildren().add(btnElectronic);
                        btnElectronic.relocate(100,100);

                        Button btnClothes = new Button("Clothes");
                        btnClothes.setPrefSize(btnLoginWidth,btnLoginHeight);
                        btnClothes.setFont(Font.font("Arial",FontWeight.BOLD,30));
                        btnClothes.setOnAction((e)->{
                            new ClothesBuyingForm(stage);
                        });
                        btnClothes.setOnMouseEntered(e->{
                            btnClothes.setStyle(
                                    "-fx-background-color: rgba(91, 9, 154);" +
                                            "-fx-background-radius: 0;" +
                                            "-fx-padding: 10px 25px;" +
                                            "-fx-text-align: center;"
                            );
                        });
                        btnClothes.setOnMouseExited(e->{
                            btnClothes.setStyle(
                                    "-fx-background-color: rgba(91, 9, 154,0.3);" +
                                            "-fx-background-radius: 0;" +
                                            "-fx-padding: 10px 25px;" +
                                            "-fx-text-align: center;"
                            );
                        });
                        root.getChildren().add(btnClothes);
                        btnClothes.relocate(100,220);

                        Button btnExit = new Button("Exit");
                        btnExit.setPrefSize(btnLoginWidth, btnLoginHeight);
                        btnExit.setFont(Font.font("Arial",FontWeight.BOLD,30));
                        btnExit.setOnAction((e)->{
                            System.exit(0);
                        });
                        btnExit.setOnMouseEntered(e->{
                            btnExit.setStyle(
                                    "-fx-background-color: rgba(91, 9, 154);" +
                                            "-fx-background-radius: 0;" +
                                            "-fx-padding: 10px 25px;" +
                                            "-fx-text-align: center;"
                            );
                        });
                        btnExit.setOnMouseExited(e->{
                            btnExit.setStyle(
                                    "-fx-background-color: rgba(91, 9, 154,0.3);" +
                                            "-fx-background-radius: 0;" +
                                            "-fx-padding: 10px 25px;" +
                                            "-fx-text-align: center;"
                            );
                        });
                        root.getChildren().add(btnExit);
                        btnExit.relocate(100,340);

                        // This method will print the items into the console window
                        itemsPrinter();

                        Scene layout = new Scene(root,600,500);
                        layout.getStylesheets().add(AppInitializer.class.getResource("style.css").toExternalForm());
                        stage.setResizable(false);
                        stage.setTitle("Customer Dashboard");
                        stage.setScene(layout);
                        stage.show();
                    }
                } else {
                    lblmessage.setText("❌ Username/Passowrd is not correct");
                }
            }else {
                lblmessage.setText("❌ Username/Passowrd is not correct");
            }

        }

    }

    public DashBoardPage(Stage stage, boolean isAdmin){
        // back-buttom logic
        if(isAdmin){
            // admin interface
            Pane root = new Pane();


            root.setPadding(new Insets(15));

            Label lblAdminMenu = new Label("Admin Menu");
            lblAdminMenu.setFont(Font.font("Times New Roman", FontWeight.BOLD,30));
            lblAdminMenu.setTextFill(Color.rgb(91,9,154));
            root.getChildren().add(lblAdminMenu);
            lblAdminMenu.relocate(220,30);

            Label lblAdmin = new Label("Hello, "+firstName +" "+lastName);
            lblAdmin.setTextFill(Color.WHITE);
            lblAdmin.setPadding(new Insets(0,10,0,10));
            lblAdmin.setFont(Font.font("Times New Roman", FontWeight.BOLD,20));
            lblAdmin.setStyle(
                    "-fx-background-color: rgba(91,9,154);"
            );
            root.getChildren().add(lblAdmin);
            lblAdmin.relocate(0,10);


            Button electronicsModifying = new Button("Electronics Modifying");
            electronicsModifying.setPrefSize(btnLoginWidth,btnLoginHeight);
            electronicsModifying.setFont(Font.font("Arial",FontWeight.BOLD,30));
            electronicsModifying.setTextFill(Color.WHITE);
            electronicsModifying.setOnAction((e)->{
                new ElectronicModifyingForm(stage);
            });
            electronicsModifying.setOnMouseEntered(e->{
                electronicsModifying.setStyle(
                        "-fx-background-color: rgba(91, 9, 154);" +
                                "-fx-background-radius: 0;" +
                                "-fx-padding: 10px 25px;" +
                                "-fx-text-align: center;"
                );
            });
            electronicsModifying.setOnMouseExited(e->{
                electronicsModifying.setStyle(
                        "-fx-background-color: rgba(91, 9, 154,0.3);" +
                                "-fx-background-radius: 0;" +
                                "-fx-padding: 10px 25px;" +
                                "-fx-text-align: center;"
                );
            });
            root.getChildren().add(electronicsModifying);
            electronicsModifying.relocate(100,100);


            Button clothesModifying = new Button("Clothes Modifying");
            clothesModifying.setPrefSize(btnLoginWidth,btnLoginHeight);
            clothesModifying.setFont(Font.font("Arial",FontWeight.BOLD,30));
            clothesModifying.setOnAction((e)->{
                new ClothesModifyingForm(stage);
            });
            clothesModifying.setOnMouseEntered(e->{
                clothesModifying.setStyle(
                        "-fx-background-color: rgba(91, 9, 154);" +
                                "-fx-background-radius: 0;" +
                                "-fx-padding: 10px 25px;" +
                                "-fx-text-align: center;"
                );
            });
            clothesModifying.setOnMouseExited(e->{
                clothesModifying.setStyle(
                        "-fx-background-color: rgba(91, 9, 154,0.3);" +
                                "-fx-background-radius: 0;" +
                                "-fx-padding: 10px 25px;" +
                                "-fx-text-align: center;"
                );
            });
            root.getChildren().add(clothesModifying);
            clothesModifying.relocate(100,220);

            Button btnExit = new Button("Exit");
            btnExit.setPrefSize(btnLoginWidth,btnLoginHeight);
            btnExit.setFont(Font.font("Arial",FontWeight.BOLD,30));
            btnExit.setOnAction((e)->{
                System.exit(0);
            });
            btnExit.setOnMouseEntered(e->{
                btnExit.setStyle(
                        "-fx-background-color: rgba(91, 9, 154);" +
                                "-fx-background-radius: 0;" +
                                "-fx-padding: 10px 25px;" +
                                "-fx-text-align: center;"
                );
            });
            btnExit.setOnMouseExited(e->{
                btnExit.setStyle(
                        "-fx-background-color: rgba(91, 9, 154,0.3);" +
                                "-fx-background-radius: 0;" +
                                "-fx-padding: 10px 25px;" +
                                "-fx-text-align: center;"
                );
            });
            root.getChildren().add(btnExit);
            btnExit.relocate(100,340);



            // this method will print the items into the console window
            itemsPrinter();


            Scene layout = new Scene(root,600,500);
            layout.getStylesheets().add(AppInitializer.class.getResource("style.css").toExternalForm());
            stage.setResizable(false);
            stage.setTitle("Admin Dashboard");
            stage.setScene(layout);
            stage.show();
        } else {
            // coustomer interface
            Pane root = new Pane();
            root.setPadding(new Insets(15));

            Label lblCustomerMenu = new Label("Customer Menu");
            lblCustomerMenu.setFont(Font.font("Times New Roman", FontWeight.BOLD,30));
            lblCustomerMenu.setTextFill(Color.rgb(91,9,154));
            root.getChildren().add(lblCustomerMenu);
            lblCustomerMenu.relocate(210,30);

            Label lblCustomer = new Label("Hello, "+firstName +" "+lastName);
            lblCustomer.setTextFill(Color.WHITE);
            lblCustomer.setPadding(new Insets(0,10,0,10));
            lblCustomer.setFont(Font.font("Times New Roman", FontWeight.BOLD,20));
            lblCustomer.setStyle(
                    "-fx-background-color: rgba(91,9,154);"
            );
            root.getChildren().add(lblCustomer);
            lblCustomer.relocate(0,10);


            Button btnElectronic = new Button("Electronics");
            btnElectronic.setPrefSize(btnLoginWidth, btnLoginHeight);
            btnElectronic.setFont(Font.font("Arial",FontWeight.BOLD,30));
            btnElectronic.setOnAction((e)->{
                new ElectronicBuyingForm(stage);
            });
            btnElectronic.setOnMouseEntered(e->{
                btnElectronic.setStyle(
                        "-fx-background-color: rgba(91, 9, 154);" +
                                "-fx-background-radius: 0;" +
                                "-fx-padding: 10px 25px;" +
                                "-fx-text-align: center;"
                );
            });
            btnElectronic.setOnMouseExited(e->{
                btnElectronic.setStyle(
                        "-fx-background-color: rgba(91, 9, 154,0.3);" +
                                "-fx-background-radius: 0;" +
                                "-fx-padding: 10px 25px;" +
                                "-fx-text-align: center;"
                );
            });
            root.getChildren().add(btnElectronic);
            btnElectronic.relocate(100,100);

            Button btnClothes = new Button("Clothes");
            btnClothes.setPrefSize(btnLoginWidth,btnLoginHeight);
            btnClothes.setFont(Font.font("Arial",FontWeight.BOLD,30));
            btnClothes.setOnAction((e)->{
                new ClothesBuyingForm(stage);
            });
            btnClothes.setOnMouseEntered(e->{
                btnClothes.setStyle(
                        "-fx-background-color: rgba(91, 9, 154);" +
                                "-fx-background-radius: 0;" +
                                "-fx-padding: 10px 25px;" +
                                "-fx-text-align: center;"
                );
            });
            btnClothes.setOnMouseExited(e->{
                btnClothes.setStyle(
                        "-fx-background-color: rgba(91, 9, 154,0.3);" +
                                "-fx-background-radius: 0;" +
                                "-fx-padding: 10px 25px;" +
                                "-fx-text-align: center;"
                );
            });
            root.getChildren().add(btnClothes);
            btnClothes.relocate(100,220);

            Button btnExit = new Button("Exit");
            btnExit.setPrefSize(btnLoginWidth, btnLoginHeight);
            btnExit.setFont(Font.font("Arial",FontWeight.BOLD,30));
            btnExit.setOnAction((e)->{
                System.exit(0);
            });
            btnExit.setOnMouseEntered(e->{
                btnExit.setStyle(
                        "-fx-background-color: rgba(91, 9, 154);" +
                                "-fx-background-radius: 0;" +
                                "-fx-padding: 10px 25px;" +
                                "-fx-text-align: center;"
                );
            });
            btnExit.setOnMouseExited(e->{
                btnExit.setStyle(
                        "-fx-background-color: rgba(91, 9, 154,0.3);" +
                                "-fx-background-radius: 0;" +
                                "-fx-padding: 10px 25px;" +
                                "-fx-text-align: center;"
                );
            });
            root.getChildren().add(btnExit);
            btnExit.relocate(100,340);

            // This method will print the items into the console window
            itemsPrinter();

            Scene layout = new Scene(root,600,500);
            layout.getStylesheets().add(AppInitializer.class.getResource("style.css").toExternalForm());
            stage.setResizable(false);
            stage.setTitle("Customer Dashboard");
            stage.setScene(layout);
            stage.show();
        }

    }
    
    public void itemsPrinter(){
      File ClothesTextFile = new File("C:\\Users\\0ooom\\OneDrive\\Documents\\NetBeansProjects\\HHHHHHHHHH\\src\\txt\\Clothes.txt");
      File electronicsFile = new File("C:\\Users\\0ooom\\OneDrive\\Documents\\NetBeansProjects\\HHHHHHHHHH\\src\\txt\\Electronic.txt");
      try{
          Scanner read = new Scanner(ClothesTextFile);
          while(read.hasNext()){
              System.out.println(read.nextLine());
          }
          
          read = new Scanner(electronicsFile);
          while(read.hasNext()){
              System.out.println(read.nextLine());
          }
      } catch(Exception e){
      
      }


    }
}
