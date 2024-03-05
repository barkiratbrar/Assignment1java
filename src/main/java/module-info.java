module com.example.finalassignment1java {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.finalassignment1java to javafx.fxml;
    exports com.example.finalassignment1java;
}