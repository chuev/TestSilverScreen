package by.silverscreen.app.controller;

import by.silverscreen.app.pojo.Human;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddController {

    private MainController mainController;

    @FXML
    public void saveNewHuman() {

    }

    @FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private DatePicker birthday ;

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private void addToList(Human human){
        this.mainController.getHumans().add(human);
    }
}
