package by.silverscreen.app.controller;

import by.silverscreen.app.pojo.Human;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Human> tableHumans;

    @FXML
    private TableColumn<Human, Integer> idColumn;

    @FXML
    private TableColumn<Human, String> nameColumn;

    @FXML
    private TableColumn<Human, Integer> ageColumn;

    @FXML
    private TableColumn<Human, Date> birthdayColumn;

    @FXML
    private void initialize() {
        initData();

        idColumn.setCellValueFactory(new PropertyValueFactory<Human, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Human, String>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Human, Integer>("age"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Human, Date>("birthday"));

        tableHumans.setItems(humans);
    }

    @FXML
    public void addNewHuman() throws IOException {
        String fxmlFile = "/fxml/add.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        Stage stage = new Stage();
        stage.setTitle("Add new human");
        stage.setScene(new Scene(root, 450, 450));
        stage.showAndWait();
    }

    public ObservableList<Human> getHumans() {
        return humans;
    }

    public void setHumans(ObservableList<Human> humans) {
        this.humans = humans;
    }

    private void initData() {
        humans.add(new Human(1, "Alex", 27, "1991-12-20"));
        humans.add(new Human(2, "Pavel", 27, "1992-01-01"));
    }
}
