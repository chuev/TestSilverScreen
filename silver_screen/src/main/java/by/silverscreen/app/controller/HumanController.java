package by.silverscreen.app.controller;

import by.silverscreen.app.pojo.Human;
import by.silverscreen.app.util.DateUtil;
import by.silverscreen.app.util.IdController;
import javafx.scene.control.Alert;

import java.util.Date;

public abstract class HumanController {

    protected MainController mainController;

    public Human saveHuman(String name, String age, Date birthday, Human human) {

        if (name == null || name.isEmpty()) {
            showWarning("Введите имя Human!");
        } else if (age == null || age.isEmpty()) {
            showWarning("Введите возраст Human!");
        } else if (!DateUtil.controlAge(age)) {
            showWarning("Введите корректный возраст Human!");
        } else if (birthday == null) {
            showWarning("Введите дату рождения Human!");
        } else if (birthday.after(new java.util.Date())) {
            showWarning("Human ещё не родился!");
        } else {
            human.setName(name);
            human.setBirthday(birthday);
            human.setAge(Integer.valueOf(age));
            return human;
        }
        return null;
    }

    public void showWarning(String text) {
        Alert warn = new Alert(Alert.AlertType.ERROR);
        warn.setTitle("Поле не заполнено!");
        warn.setHeaderText(text);
        warn.setContentText("");
        warn.showAndWait();
    }

    protected void addToList(Human human) {
        this.mainController.getHumans().add(human);
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
