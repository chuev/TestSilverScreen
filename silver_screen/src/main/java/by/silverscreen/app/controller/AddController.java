package by.silverscreen.app.controller;

import by.silverscreen.app.pojo.Human;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

public class AddController {

    private MainController mainController;

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

    public void addNewHuman() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Add new human");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/add.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
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
