package com.example.finalassignment1java;
import com.example.finalassignment1java.CountryEmission;
import com.example.finalassignment1java.DatabaseConnector;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;




import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Controller class
public class HelloController {

    // Stage and scene fields for scene transitions.
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Database connector instance for SQL operations.
    private DatabaseConnector dbConnector = new DatabaseConnector();


    @FXML
    private TableView<CountryEmission> tableView;

    @FXML
    private TableColumn<CountryEmission, Number> rankColumn;

    @FXML
    private TableColumn<CountryEmission, String> countryNameColumn;

    @FXML
    private TableColumn<CountryEmission, String> regionColumn;
    @FXML
    private TableColumn<CountryEmission, Number> totalEmissionsColumn;

    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;

    @FXML
    private void initialize() {
        // Initialize table view and bar chart if they are present.
        if (tableView != null) {
            initializeTableView();
        }
        if (barChart != null) {
            initializeBarChart();
        }
    }

    // Initializes the table view with emissions data.
    private void initializeTableView() {
        ObservableList<CountryEmission> data = getEmissionsData();
        tableView.setItems(data);

        // Linking table columns with the CountryEmission properties.
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        countryNameColumn.setCellValueFactory(new PropertyValueFactory<>("countryName"));
        regionColumn.setCellValueFactory(new PropertyValueFactory<>("region"));
        totalEmissionsColumn.setCellValueFactory(new PropertyValueFactory<>("totalEmissions"));

        System.out.println("TableView initialized.");
    }

    // Fetches emissions data from the database.
    private ObservableList<CountryEmission> getEmissionsData() {
        ObservableList<CountryEmission> emissionsData = FXCollections.observableArrayList();
        // Example data fetch implementation
        String query = "SELECT id, countryName, region, totalEmissions FROM CountryEmissions\n";

        // Execute SQL query and populate the ObservableList with the results.
        try (Connection conn = dbConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String countryName = rs.getString("countryName");
                String region = rs.getString("region");
                double totalEmissions = rs.getDouble("totalEmissions");
                emissionsData.add(new CountryEmission(id, countryName, region, totalEmissions)); // Assuming 'id' is not used, set to 0 or adjust as necessary
            }
        } catch (SQLException e) {
            System.err.println("Error fetching emissions data: " + e.getMessage());
        }
        return emissionsData;
    }


    // Initializes the bar chart with emissions data.
    private void initializeBarChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Total Emissions");
        // Add data to the series from the emissions data.
        for (CountryEmission emission : getEmissionsData()) {
            series.getData().add(new XYChart.Data<>(emission.getCountryName(), emission.getTotalEmissions()));
        }
        barChart.getData().add(series);
    }


    // Handles scene transition to the table view scene.
    public void switchtoscene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("table-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    // Handles scene transition to the bar chart view scene.
    public void switchtoscene2(ActionEvent event) throws IOException{
        System.out.println("Switching to scene 2...");
        Parent root = FXMLLoader.load(getClass().getResource("barchart-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}