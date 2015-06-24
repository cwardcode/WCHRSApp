package edu.wcu.wchrs.groundwater;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class SiteDataController extends GridPane implements Initializable, ControlledScreen {

    private String emptyFields;
    private ScreensController controller;
    @FXML
    private TextField siteName;
    @FXML
    private TextField timeOfArrivalFld;
    @FXML
    private TextField distInside;
    @FXML
    private TextField distOutside;
    @FXML
    private TextField distStaff;
    @FXML
    private TextField stage;
    @FXML
    private ToggleGroup rg1Level;
    @FXML
    private RadioButton rg1LevelYes;
    @FXML
    private RadioButton rg1LevelNo;
    @FXML
    private RadioButton rg2LevelYes;
    @FXML
    private RadioButton rg2LevelNo;
    @FXML
    private ToggleGroup rg2Level;
    @FXML
    private ToggleGroup rg1Battery;
    @FXML
    private RadioButton rg1battOK;
    @FXML
    private RadioButton rg1battDead;
    @FXML
    private TextField rg1CondFld;
    @FXML
    private TextArea rg1NotesFld;
    @FXML
    private TextArea rg2NotesFld;
    @FXML
    private TextField rg2CondFld;
    @FXML
    private ToggleGroup rg2Battery;
    @FXML
    private RadioButton rg2BattDead;
    @FXML
    private RadioButton rg2BattOK;
    @FXML
    private TextArea siteNotesFld;


    @FXML
    public void pressButton(ActionEvent event) throws Exception
    {
        if (emptyFieldsExist()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: Empty Fields");
            alert.setHeaderText("Please enter data into all fields");
            alert.setContentText(this.emptyFields);
            alert.showAndWait();
        }
        else {
            this.controller.setScreen(Main.screen4ID);
        }
    }




    private boolean emptyFieldsExist()
    {
        boolean areFieldsEmpty = false;
        this.emptyFields = "Please enter the following fields: \n";
        if (this.siteName.getText().isEmpty()) {
            this.emptyFields += "Site Name\n";
            areFieldsEmpty = true;
        }
        if (this.timeOfArrivalFld.getText().isEmpty()) {
            this.emptyFields += "Time of Arrival\n";
            areFieldsEmpty = true;
        }
        if (this.distInside.getText().isEmpty()) {
            this.emptyFields += "Distance Inside\n";
            areFieldsEmpty = true;
        }
        if (this.distOutside.getText().isEmpty()) {
            this.emptyFields += "Distance Outside\n";
            areFieldsEmpty = true;
        }
        if (this.distStaff.getText().isEmpty()) {
            this.emptyFields += "Staff\n";
            areFieldsEmpty = true;
        }
        if (this.stage.getText().isEmpty()) {
            this.emptyFields += "Stage\n";
            areFieldsEmpty = true;
        }
        if (this.siteNotesFld.getText().isEmpty()) {
            this.emptyFields += "SiteNotes\n";
            areFieldsEmpty = true;
        }

        return areFieldsEmpty;
    }

    public void setScreenParent(ScreensController screenPage)
    {
        this.controller = screenPage;
    }

    public void initialize(URL location, ResourceBundle resources) {}
}