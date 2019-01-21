package by.silverscreen.app.controller;

import by.silverscreen.app.pojo.Human;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @FXML
    public void cancelAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void saveNewHuman() {
        if ("".equals(name.getText())) {
            showWarning("Введите имя Human!");
        } else if ("".equals(age.getText())) {
            showWarning("Введите возраст Human!");
        } else if (!controlAge(age.getText())) {
            showWarning("Введите корректный возраст Human!");
        } else if (birthday.getValue() == null) {
            showWarning("Введите дату рождения Human!");
        } else if (Date.valueOf(birthday.getValue()).after(new java.util.Date())) {
            showWarning("Human ещё не родился!");
        } else {
            Human human = new Human(
                    name.getText(),
                    Integer.valueOf(age.getText()),
                    Date.valueOf(birthday.getValue())
            );
            addToList(human);
            cancelAction();
        }
    }

    private void addToList(Human human) {
        this.mainController.getHumans().add(human);
    }

    public void showWarning(String text) {
        Alert warn = new Alert(Alert.AlertType.ERROR);
        warn.setTitle("Поле не заполнено!");
        warn.setHeaderText(text);
        warn.setContentText("");
        warn.showAndWait();
    }

    public boolean controlAge(String string) {
        Pattern pattern = Pattern.compile("[0-9]{1,3}");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
