 package sample;
 
 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.control.Alert;
 import javafx.scene.control.Alert.AlertType;
 import javafx.scene.control.TextArea;
 import javafx.scene.control.TextField;
 import javafx.scene.layout.GridPane;
 
 public class WellDataController
   extends GridPane
   implements Initializable, ControlledScreen
 {
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
       this.controller.setScreen(Main.screen2ID);
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