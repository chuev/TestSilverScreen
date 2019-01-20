package by.silverscreen.app.controller;

import by.silverscreen.app.pojo.Human;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainController extends Application {

    List<Human> humans = Arrays.<Human>asList(
            new Human("Alex", 27, "1991-12-20"),
            new Human("Pavel", 27, "1992-01-01")
    );

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

    @Override
    public void start(Stage stage) throws Exception {
        TreeItem<Human> root = new TreeItem<>();

        root.setExpanded(true);
        humans.stream().forEach((human) -> {
            root.getChildren().add(new TreeItem<>(human));
        });
        stage.setTitle("JavaFX and Maven, Tree Table View");
        stage.setScene(new Scene(
                new FXMLLoader()
                        .load(getClass().getResourceAsStream("/fxml/main.fxml"))));
        Human pavel = new Human("Pavel", 27, "1992-01-01");
        root.getChildren().add(new TreeItem<>(pavel));

        stage.show();
    }

    @FXML
    public void addNewHuman() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Add new human");
        stage.setScene(new Scene(
                new FXMLLoader()
                        .load(getClass().getResourceAsStream("/fxml/add.fxml")))
        );
        stage.showAndWait();
    }

    @FXML
    public void editHuman() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Edit human");
        stage.setScene(new Scene(
                new FXMLLoader()
                        .load(getClass().getResourceAsStream("/fxml/edit.fxml")))
        );
        stage.showAndWait();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
