package edu.wcu.wchrs.groundwater.controller;

import edu.wcu.wchrs.groundwater.ControlledScreen;
import edu.wcu.wchrs.groundwater.Main;
import edu.wcu.wchrs.groundwater.ScreensController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;
 
 
 public class EquipController
   extends GridPane
   implements Initializable, ControlledScreen
 {
   String emptyFields;
   ScreensController controller;
   @FXML
   private CheckBox bucket;
   @FXML
   private CheckBox tape;
   @FXML
   private CheckBox key;
   @FXML
   private CheckBox ruler;
   @FXML
   private CheckBox atomic;
   
   public void setScreenParent(ScreensController screenPage)
   {
     this.controller = screenPage;
   }
   
 
   public void initialize(URL location, ResourceBundle resources) {}
   
   @FXML
   public void pressButton()
     throws Exception
   {
     if (emptyFieldsExist()) {
       Alert alert = new Alert(Alert.AlertType.ERROR);
       alert.setTitle("Error: Empty Fields");
       alert.setHeaderText("Please enter data into all fields");
       alert.setContentText(this.emptyFields);
       alert.showAndWait();
     }
     else {
       this.controller.setScreen(Main.screen2ID);
     }
   }

   private boolean emptyFieldsExist()
   {
     boolean areFieldsEmpty = false;
     this.emptyFields = "Please enter the following fields: \n";
     if (!this.atomic.isSelected()) {
       this.emptyFields += "Atomic Time\n";
       areFieldsEmpty = true;
     }
     if (!this.bucket.isSelected()) {
       this.emptyFields += "Bucket\n";
       areFieldsEmpty = true;
     }
     if (!this.ruler.isSelected()) {
       this.emptyFields += "Folding Ruler\n";
       areFieldsEmpty = true;
     }
     if (!this.tape.isSelected()) {
       this.emptyFields += "Water Level Tape\n";
       areFieldsEmpty = true;
     }
     if (!this.key.isSelected()) {
       this.emptyFields += "Well Key\n";
       areFieldsEmpty = true;
     }

     return areFieldsEmpty;
   }
 }