module com.example.Main.AppInitializer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.example.Main to javafx.fxml;
    exports com.example.Main;
}