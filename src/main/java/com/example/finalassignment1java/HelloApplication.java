package com.example.finalassignment1java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

// Define the main class of the application
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML layout
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("table-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 660, 660);
        // Set the title of the application window
        stage.setTitle("Global Carbon Emissions");
        // Add an icon
        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("java_icon.webp")));
        // Set the scene for this stage and show the application window.
        stage.setScene(scene);
        stage.show();
    }

    // The main method that launches the application.
    public static void main(String[] args) {
        launch();
    }
}