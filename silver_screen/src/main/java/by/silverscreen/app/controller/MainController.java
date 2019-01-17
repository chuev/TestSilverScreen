package by.silverscreen.app.controller;

import by.silverscreen.app.pojo.Human;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class MainController {

    private ObservableList<Human> humans = FXCollections.observableArrayList();

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

    private void initData() {
        humans.add(new Human(1, "Alex", 27, "1991-12-20"));
        humans.add(new Human(2, "Pavel", 27, "1992-01-01"));
    }
}
