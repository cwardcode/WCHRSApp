 package edu.wcu.wchrs.groundwater;
 
 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.control.Alert;
 import javafx.scene.control.CheckBox;
 import javafx.scene.layout.GridPane;
 
 
 public class EquipController
   extends GridPane
   implements Initializable, ControlledScreen
 {
   @FXML
   private CheckBox bucket;
   @FXML
   private CheckBox tape;
   @FXML
   private CheckBox key;
   @FXML
   private CheckBox ruler;
   @FXML
   private CheckBox pen;
   String emptyFields;
   ScreensController controller;
   
   public void setScreenParent(ScreensController screenPage)
   {
     this.controller = screenPage;
   }
   
 
   public void initialize(URL location, ResourceBundle resources) {}
   
   @FXML
   public void pressButton(ActionEvent event)
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
     if (!this.pen.isSelected()) {
       this.emptyFields += "Pen\n";
       areFieldsEmpty = true;
     }
     
     return areFieldsEmpty;
   }
 }