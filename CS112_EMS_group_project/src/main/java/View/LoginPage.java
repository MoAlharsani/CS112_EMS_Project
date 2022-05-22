package View;

import com.example.Main.AppInitializer;
import com.example.Main.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;


public class LoginPage {

    // Login-page
    public LoginPage(Stage stage, ArrayList<User> users){
        Pane root = new Pane();
        root.setPadding(new Insets(15));




        Label lblheader = new Label("Log in.");
        lblheader.setFont(Font.font("Times New Roman", FontWeight.BOLD,30));
        lblheader.setTextFill(Color.BLACK);
        root.getChildren().add(lblheader);
        lblheader.relocate(30,70);





        Label lblUsername = new Label("Username");
        lblUsername.setFont(Font.font(20));
        root.getChildren().add(lblUsername);
        lblUsername.relocate(30,120);

        Label lblPassword = new Label("Password");
        lblPassword.setFont(Font.font(20));
        root.getChildren().add(lblPassword);
        lblPassword.relocate(30,210);

        TextField textFieldUsername = new TextField();
        textFieldUsername.setPrefSize(250,35);
        root.getChildren().add(textFieldUsername);
        textFieldUsername.relocate(30,150);


        PasswordField textFieldPassword = new PasswordField();
        textFieldPassword.setPrefSize(250,35);
        root.getChildren().add(textFieldPassword);
        textFieldPassword.relocate(30,240);

        // Moving to the next field when Enter is pressed
        textFieldUsername.setOnKeyPressed((e)->{
            if(e.getCode().equals(KeyCode.ENTER)){
                textFieldPassword.requestFocus();
            }
        });

        Label lblmessage = new Label("");
        lblmessage.setFont(Font.font(15));
        lblmessage.setTextFill(Color.rgb(240,7,7));
        root.getChildren().add(lblmessage);
        lblmessage.relocate(20,390);




        Button btnLogin = new Button("login");
        double btnLoginWidth = 260;
        double btnLoginHeight = 30;
        btnLogin.setPrefSize(btnLoginWidth,btnLoginHeight);
        btnLogin.setOnMouseEntered(e->{
            btnLogin.setStyle(
                    "-fx-background-color: rgba(91, 9, 154);" +
                            "-fx-background-radius: 0;" +
                            "-fx-padding: 10px 25px;" +
                            "-fx-text-align: center;"
            );
        });
        btnLogin.setOnMouseExited(e->{
            btnLogin.setStyle(
                    "-fx-background-color: rgba(91, 9, 154,0.3);" +
                            "-fx-background-radius: 0;" +
                            "-fx-padding: 10px 25px;" +
                            "-fx-text-align: center;"
            );
        });
        btnLogin.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        btnLogin.setTextFill(Color.WHITE);
        root.getChildren().add(btnLogin);
        btnLogin.relocate(25,320);


        // Moving to the Login button when Enter is pressed
        textFieldPassword.setOnKeyPressed((e)->{
            if(e.getCode().equals(KeyCode.ENTER)){
                btnLogin.requestFocus();
            }
        });

        // Login by right-click
        btnLogin.setOnMouseClicked(e->{
            new DashBoardPage(stage, textFieldUsername, textFieldPassword, users, lblmessage);
        });

        // Login by pressing Enter
        btnLogin.setOnKeyPressed((e)->{
            if(e.getCode().equals(KeyCode.ENTER)){
                new DashBoardPage(stage, textFieldUsername, textFieldPassword, users, lblmessage);
            }
        });



        File coverImage = new File("src/main/java/img/LoginCover.png");
        File logoImage = new File("src/main/java/img/logo.png");

        try {
            Image image = new Image(coverImage.toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(500);
            imageView.setFitWidth(350);
            root.getChildren().add(imageView);
            imageView.setX(270);

        } catch (Exception e){
            e.printStackTrace();
        }

        


        Scene layout = new Scene(root,600,500);
        layout.getStylesheets().add(AppInitializer.class.getResource("style.css").toExternalForm());
        stage.getIcons().add(new Image(logoImage.toURI().toString()));
        stage.setResizable(false);
        stage.setTitle("Login");
        stage.setScene(layout);
        stage.show();
    }



}
