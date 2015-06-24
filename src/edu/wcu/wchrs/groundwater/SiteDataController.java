package edu.wcu.wchrs.groundwater;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
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
    private RadioButton rg1LevelYes;
    @FXML
    private RadioButton rg1LevelNo;
    @FXML
    private RadioButton rg2LevelYes;
    @FXML
    private RadioButton rg2LevelNo;
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
    private RadioButton rg2BattDead;
    @FXML
    private RadioButton rg2BattOK;
    @FXML
    private TextArea siteNotesFld;


    @FXML
    public void pressButton() throws Exception
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
        if(!(this.rg1LevelYes.isSelected() || this.rg1LevelNo.isSelected())) {
           this.emptyFields = emptyFields + "Rain Gauge 1 Level\n";
           areFieldsEmpty = true;
        }

        if(!(this.rg1battOK.isSelected() || this.rg1battDead.isSelected())) {
           this.emptyFields = emptyFields + "Rain Gauge 1 Battery\n";
           areFieldsEmpty = true;
        }

        if(this.rg1CondFld.getText().isEmpty()) {
            this.emptyFields = emptyFields + "Rain Gauge 1 Condition\n";
            areFieldsEmpty = true;
        }

        if(this.rg1NotesFld.getText().isEmpty()) {
            this.emptyFields = emptyFields + "Rain Gauge 1 Notes\n";
            areFieldsEmpty = true;
        }

        if(!(this.rg2LevelYes.isSelected() || this.rg2LevelNo.isSelected())) {
           this.emptyFields = emptyFields + "Rain Gauge 2 Level\n";
           areFieldsEmpty = true;
        }

        if(!(this.rg2BattOK.isSelected() || this.rg2BattDead.isSelected())) {
           this.emptyFields = emptyFields + "Rain Gauge 2 Battery\n";
           areFieldsEmpty = true;
        }

        if(this.rg2CondFld.getText().isEmpty()) {
            this.emptyFields = emptyFields + "Rain Gauge 2 Condition\n";
            areFieldsEmpty = true;
        }

        if(this.rg2NotesFld.getText().isEmpty()) {
            this.emptyFields = emptyFields + "Rain Gauge 2 Notes\n";
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

    public void initialize(URL location, ResourceBundle resources) {
        this.timeOfArrivalFld.setText(getCurrentTime());
        this.timeOfArrivalFld.setDisable(true);
        this.timeOfArrivalFld.setEditable(false);
    }

    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        return dateFormat.format(new Date());
    }
}