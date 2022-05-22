package View;

import com.example.Main.AppInitializer;
import com.example.Main.Electronics;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ElectronicBuyingForm {
    public ElectronicBuyingForm(Stage stage){
        Pane root = new Pane();
        root.setPadding(new Insets(15));

        Label lblheader = new Label("Electronic Item Purchase form");
        lblheader.setFont(Font.font("Times New Roman", FontWeight.BOLD,30));
        lblheader.setTextFill(Color.rgb(91,9,154));
        root.getChildren().add(lblheader);
        lblheader.relocate(100,10);

        Label lblItemId = new Label("item ID*:");
        lblItemId.setFont(Font.font("",FontWeight.BOLD, 20));
        root.getChildren().add(lblItemId);
        lblItemId.relocate(50,100);

        Label lblItemName = new Label("item Name:");
        lblItemName.setFont(Font.font(20));
        root.getChildren().add(lblItemName);
        lblItemName.relocate(50,150);

        Label lblBrand = new Label("Brand:");
        lblBrand.setFont(Font.font(20));
        root.getChildren().add(lblBrand);
        lblBrand.relocate(50,200);

        Label lblModel = new Label("Model:");
        lblModel.setFont(Font.font(20));
        root.getChildren().add(lblModel);
        lblModel.relocate(50,250);

        Label lblYear = new Label("Year");
        lblYear.setFont(Font.font(20));
        root.getChildren().add(lblYear);
        lblYear.relocate(50,300);
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

        TextField textFieldBrand = new TextField();
        root.getChildren().add(textFieldBrand);
        textFieldBrand.setPrefSize(200,30);
        textFieldBrand.relocate(250,200);

        TextField textFieldModel = new TextField();
        root.getChildren().add(textFieldModel);
        textFieldModel.setPrefSize(200,30);
        textFieldModel.relocate(250,250);

        TextField textFieldYear = new TextField();
        root.getChildren().add(textFieldYear);
        textFieldYear.setPrefSize(200,30);
        textFieldYear.relocate(250,300);

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
                lblBrand.setFont(Font.font("",FontWeight.BOLD,20));
                textFieldBrand.requestFocus();
            }
        });

        textFieldBrand.setOnKeyPressed((e)->{
            if((e.getCode().equals(KeyCode.ENTER))||e.getCode().equals(KeyCode.TAB)){
                // the next textfield should be bold
                lblBrand.setFont(Font.font(20));
                lblModel.setFont(Font.font("",FontWeight.BOLD,20));
                textFieldModel.requestFocus();
            }
        });

        textFieldModel.setOnKeyPressed((e)->{
            if((e.getCode().equals(KeyCode.ENTER))||e.getCode().equals(KeyCode.TAB)){
                // the next textfield should be bold
                lblModel.setFont(Font.font(20));
                lblYear.setFont(Font.font("",FontWeight.BOLD,20));
                textFieldYear.requestFocus();
            }
        });

        textFieldYear.setOnKeyPressed((e)->{
            if(e.getCode().equals(KeyCode.ENTER)){
                // the next textfield should be bold
                lblYear.setFont(Font.font(20));
                lblQuantity.setFont(Font.font("",FontWeight.BOLD,20));
                textFieldQuantity.requestFocus();
            }
        });






        Button btnBuy = new Button("Buy");
        btnBuy.setFont(Font.font(20));
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
            for (Electronics electronics:
                    AppInitializer.electronics) {
                if(electronics.getItemID() == Integer.parseInt(textFieldItemId.getText())){
                    lblorderSummary.setText(electronics.orderSummary(Integer.parseInt(textFieldQuantity.getText())));
                }
            }
        });

        Button btnExit = new Button("Exit");
        btnExit.setFont(Font.font(20));
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
        btnBack.setFont(Font.font(20));
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
        stage.setTitle("Buying Electronics");
        stage.setScene(layout);
        stage.show();
    }
}
