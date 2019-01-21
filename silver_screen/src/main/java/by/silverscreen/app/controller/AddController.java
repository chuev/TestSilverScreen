package by.silverscreen.app.controller;

import by.silverscreen.app.pojo.Human;
import by.silverscreen.app.util.DateUtil;
import by.silverscreen.app.util.IdController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController extends HumanController{


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


    @FXML
    public void cancelAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void saveNewHuman() {
        Human human = new Human();
        human.setId(IdController.getNextId());
        human = saveHuman(name.getText(), age.getText(), DateUtil.convertLocalDateToDate(birthday.getValue()), human);
        if(human != null){
            addToList(human);
            cancelAction();
        }
    }
}
