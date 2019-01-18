package by.silverscreen.app.controller;

import by.silverscreen.app.pojo.Human;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class MainController {

    private ObservableList<Human> humans = FXCollections.observableArrayList();

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TreeTableView<Human> tableHumans;

    @FXML
    private TreeTableColumn<Human, String> nameColumn;

    @FXML
    private TreeTableColumn<Human, Integer> ageColumn;

    @FXML
    private TreeTableColumn<Human, Date> birthdayColumn;

    @FXML
    private void initialize() {

    }

    @FXML
    public void addNewHuman() throws IOException {
        String fxmlFile = "/fxml/add.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        Stage stage = new Stage();
        stage.setTitle("Add new human");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    public void editHuman() throws IOException {
        String fxmlFile = "/fxml/edit.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        Stage stage = new Stage();
        stage.setTitle("Edit human");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
