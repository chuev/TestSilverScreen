package by.silverscreen.app.controller;

import by.silverscreen.app.pojo.Human;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainController extends Application {

    private Date today = new Date();
    private SimpleDateFormat simpleBithFormat = new SimpleDateFormat("MM-dd");
    private ObservableList<Human> humans = FXCollections.observableArrayList();
    private Human selected;


    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonDelete;
    @FXML
    private TableView<Human> tableHumans;
    @FXML
    private TableColumn<Human, String> nameColumn;
    @FXML
    private TableColumn<Human, Integer> ageColumn;
    @FXML
    private TableColumn<Human, Date> birthdayColumn;

    @FXML
    private void initialize() {
        initData();

        buttonEdit.setOnAction(event -> {
            if (selected == null) {
                Alert warn = new Alert(Alert.AlertType.ERROR);
                warn.setTitle("Предупреждение");
                warn.setHeaderText("Header Text");
                warn.setContentText("Content Text");
                warn.showAndWait();
            } else {
                try {
                    editHuman();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonAdd.setOnAction(event -> {
            try {
                addNewHuman();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        buttonDelete.setOnAction(event -> {
            if (selected == null) {
                Alert warn = new Alert(Alert.AlertType.ERROR);
                warn.setTitle("Delete");
                warn.setHeaderText("Выберите строку для удаления!");
                warn.setContentText("");
                warn.showAndWait();
            } else {
                deleteHuman();
            }
        });

        tableHumans.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (selected.getBithString(simpleBithFormat).equals(simpleBithFormat.format(today))) {
                        Alert success = new Alert(Alert.AlertType.ERROR);
                        success.setTitle("Happy Birthday!!!");
                        success.setHeaderText("Header Text OK");
                        success.setContentText("Content Text OK");
                        success.showAndWait();
                    }
                }
            }
        });

        tableHumans.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selected = (Human) newValue;
            }
        });
        nameColumn.setCellValueFactory(new PropertyValueFactory<Human, String>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Human, Integer>("age"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Human, Date>("birthday"));

        tableHumans.setItems(humans);
    }

    private void initData() {
        humans.add(new Human("Alex", 27, "1991-12-20"));
        humans.add(new Human("Pavel", 27, new Date()));
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/main.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("JavaFX and Maven");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void addNewHuman() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Add new human");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/add.fxml"));
        Parent root = loader.load();
        AddController controller = loader.getController();
        controller.setMainController(this);
        Scene scene = new Scene(root);
        stage.setScene(scene);
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

    public void deleteHuman() {
        humans.remove(selected);
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public ObservableList<Human> getHumans() {
        return humans;
    }
}
