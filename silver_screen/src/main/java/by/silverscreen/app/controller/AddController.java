package by.silverscreen.app.controller;

import by.silverscreen.app.pojo.Human;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class AddController {

    @FXML
    public void saveNewHuman(){
        MainController mainController = new MainController();
        ObservableList<Human> humans = mainController.getHumans();
        humans.add(new Human(34,"Nik",23,"1990-01-23"));
        mainController.setHumans(humans);
    }
}
