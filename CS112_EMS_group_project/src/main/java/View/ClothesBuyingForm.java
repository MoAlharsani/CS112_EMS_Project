package View;

import com.example.Main.AppInitializer;
import com.example.Main.Clothes;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ClothesBuyingForm {

    public ClothesBuyingForm(Stage stage){
        Pane root = new Pane();
        root.setPadding(new Insets(15));

        Label lblheader = new Label("Clothes Item Purchase form");
        lblheader.setFont(Font.font("Times New Roman", FontWeight.BOLD,30));
        lblheader.setTextFill(Color.rgb(91,9,154));
        root.getChildren().add(lblheader);
        lblheader.relocate(100,10);

        Label lblItemId = new Label("item ID*:");
        lblItemId.setFont(Font.font("",FontWeight.BOLD,20));
        root.getChildren().add(lblItemId);
        lblItemId.relocate(50,100);

        Label lblItemName = new Label("item Name:");
        lblItemName.setFont(Font.font(20));
        root.getChildren().add(lblItemName);
        lblItemName.relocate(50,150);

        Label lblColor = new Label("Color:");
        lblColor.setFont(Font.font(20));
        root.getChildren().add(lblColor);
        lblColor.relocate(50,200);

        Label lblDepart = new Label("Department:");
        lblDepart.setFont(Font.font(20));
        root.getChildren().add(lblDepart);
        lblDepart.relocate(50,250);

        Label lblSize = new Label("size");
        lblSize.setFont(Font.font(20));
        root.getChildren().add(lblSize);
        lblSize.relocate(50,300);
        Label lblQuantity = new Label("Quantity*:");
        lblQuantity.setFont(Font.font(20));
        root.getChildren().add(lblQuantity);
        lblQuantity.relocate(50,350);

        Label lblorderSummary = new Label();
        lblorderSummary.setFont(Font.font(20));
        lblorderSummary.setTextFill(Color.RED);
        root.getChildren().add(lblorderSummary);
        lblorderSummary.relocate(100,465);









        TextField textFieldItemId = new TextField();
        root.getChildren().add(textFieldItemId);
        textFieldItemId.setPrefSize(200,30);
        textFieldItemId.relocate(250,100);


        TextField textFieldItemName = new TextField();
        root.getChildren().add(textFieldItemName);
        textFieldItemName.setPrefSize(200,30);
        textFieldItemName.relocate(250,150);


        TextField textFieldColor = new TextField();
        root.getChildren().add(textFieldColor);
        textFieldColor.setPrefSize(200,30);
        textFieldColor.relocate(250,200);


        TextField textFieldDepart = new TextField();
        root.getChildren().add(textFieldDepart);
        textFieldDepart.setPrefSize(200,30);
        textFieldDepart.relocate(250,250);

        TextField textFieldSize = new TextField();
        root.getChildren().add(textFieldSize);
        textFieldSize.setPrefSize(200,30);
        textFieldSize.relocate(250,300);



        TextField textFieldQuantity = new TextField();
        root.getChildren().add(textFieldQuantity);
        textFieldQuantity.setPrefSize(200,30);
        textFieldQuantity.relocate(250,350);



        // Styling using Events in java
        textFieldItemId.setOnKeyPressed((e)->{
            if((e.getCode().equals(KeyCode.ENTER))||(e.getCode().equals(KeyCode.TAB))){
                // the next textfield should be bold
                lblItemId.setFont(Font.font(20));
                lblItemName.setFont(Font.font("",FontWeight.BOLD,20));
                textFieldItemName.requestFocus();
            }
        });

        textFieldItemName.setOnKeyPressed((e)->{
            if((e.getCode().equals(KeyCode.ENTER))||e.getCode().equals(KeyCode.TAB)){
                // the next textfield should be bold
                lblItemName.setFont(Font.font(20));
                lblColor.setFont(Font.font("",FontWeight.BOLD,20));
                textFieldColor.requestFocus();
            }
        });

        textFieldColor.setOnKeyPressed((e)->{
            if((e.getCode().equals(KeyCode.ENTER))||e.getCode().equals(KeyCode.TAB)){
                // the next textfield should be bold
                lblColor.setFont(Font.font(20));
                lblDepart.setFont(Font.font("",FontWeight.BOLD,20));
                textFieldDepart.requestFocus();
            }
        });

        textFieldDepart.setOnKeyPressed((e)->{
            if((e.getCode().equals(KeyCode.ENTER))||e.getCode().equals(KeyCode.TAB)){
                // the next textfield should be bold
                lblDepart.setFont(Font.font(20));
                lblSize.setFont(Font.font("",FontWeight.BOLD,20));
                textFieldSize.requestFocus();
            }
        });

        textFieldSize.setOnKeyPressed((e)->{
            if(e.getCode().equals(KeyCode.ENTER)){
                // the next textfield should be bold
                lblSize.setFont(Font.font(20));
                lblQuantity.setFont(Font.font("",FontWeight.BOLD,20));
                textFieldQuantity.requestFocus();
            }
        });










        Button btnBuy = new Button("Buy");
        btnBuy.setFont(Font.font(15));
        btnBuy.relocate(50,410);
        root.getChildren().add(btnBuy);
        btnBuy.setOnMouseEntered(e->{
            btnBuy.setStyle(
                    "-fx-background-color: rgba(91, 9, 154);" +
                            "-fx-background-radius: 0;" +
                            "-fx-padding: 10px 25px;" +
                            "-fx-text-align: center;"
            );
        });
        btnBuy.setOnMouseExited(e->{
            btnBuy.setStyle(
                    "-fx-background-color: rgba(91, 9, 154,0.3);" +
                            "-fx-background-radius: 0;" +
                            "-fx-padding: 10px 25px;" +
                            "-fx-text-align: center;"
            );
        });
        btnBuy.setOnAction((e)->{
            if(!textFieldItemId.getText().equals("")) {
                for (Clothes clothes :
                        AppInitializer.clothes) {
                    if (clothes.getItemID() == Integer.parseInt(textFieldItemId.getText())) {
                        lblorderSummary.setText(clothes.orderSummary(Integer.parseInt(textFieldQuantity.getText())));
                    }
                }
            } else {
                lblorderSummary.setLayoutX(130);
                lblorderSummary.setText("Please Enter a valid item ID");
            }
        });

        Button btnExit = new Button("Exit");
        btnExit.setFont(Font.font(15));
        btnExit.relocate(500,410);
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
        btnExit.setOnAction((e)->{
            System.exit(0);
        });
        root.getChildren().add(btnExit);

        Button btnBack = new Button("Back");
        btnBack.setFont(Font.font(15));
        btnBack.relocate(400,410);
        btnBack.setOnMouseEntered(e->{
            btnBack.setStyle(
                    "-fx-background-color: rgba(91, 9, 154);" +
                            "-fx-background-radius: 0;" +
                            "-fx-padding: 10px 25px;" +
                            "-fx-text-align: center;"
            );
        });
        btnBack.setOnMouseExited(e->{
            btnBack.setStyle(
                    "-fx-background-color: rgba(91, 9, 154,0.3);" +
                            "-fx-background-radius: 0;" +
                            "-fx-padding: 10px 25px;" +
                            "-fx-text-align: center;"
            );
        });
        btnBack.setOnAction(e->{
            new DashBoardPage(stage, false);
        });
        root.getChildren().add(btnBack);



        Scene layout = new Scene(root,600,500);
        layout.getStylesheets().add(AppInitializer.class.getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("Buying clothes");
        stage.setScene(layout);
        stage.show();
    }
}
