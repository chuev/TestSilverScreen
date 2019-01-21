package by.silverscreen.app.controller;

import by.silverscreen.app.pojo.Human;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;

public class AddController {

    private MainController mainController;

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private DatePicker birthday;

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void saveNewHuman() {
        Human human = new Human(
                name.getText(),
                Integer.valueOf(age.getText()),
                Date.valueOf(birthday.getValue())
        );
        addToList(human);
    }

    private void addToList(Human human) {
        this.mainController.getHumans().add(human);
    }
}
