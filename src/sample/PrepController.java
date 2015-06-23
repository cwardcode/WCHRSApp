 package sample;
 
 import java.net.URL;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.ResourceBundle;
 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.control.Alert;
 import javafx.scene.control.Alert.AlertType;
 import javafx.scene.control.TextField;
 import javafx.scene.layout.GridPane;
 
 
 
 public class PrepController
   extends GridPane
   implements Initializable, ControlledScreen
 {
   private Main application;
   @FXML
   private TextField nameFld;
   @FXML
   private TextField dateFld;
   @FXML
   private TextField timeFld;
   @FXML
   private TextField weatherFld;
   @FXML
   private TextField temperatureFld;
   private ScreensController myController;
   private String emptyFields;
   
   public void initialize(URL location, ResourceBundle resources)
   {
     this.dateFld.setText(getCurrentDate());
     this.dateFld.setDisable(true);
     
     this.timeFld.setText(getCurrentTime());
     this.timeFld.setDisable(true);
   }
   
   @FXML
   public void pressButton(ActionEvent event) throws Exception {
     if (emptyFieldsExist()) {
       Alert alert = new Alert(Alert.AlertType.ERROR);
       alert.setTitle("Error: Empty Fields");
       alert.setHeaderText("Please enter data into all fields");
       alert.setContentText(this.emptyFields);
       alert.showAndWait();
     }
     else {
       this.myController.setScreen(Main.screen2ID);
     }
   }

   private boolean emptyFieldsExist()
   {
     boolean areFieldsEmpty = false;
     this.emptyFields = "Please enter the following fields: \n";
     if (this.nameFld.getText().isEmpty()) {
       this.emptyFields += "Name\n";
       areFieldsEmpty = true;
     }
     if (this.weatherFld.getText().isEmpty()) {
       this.emptyFields += "Weather\n";
       areFieldsEmpty = true;
     }
     if (this.temperatureFld.getText().isEmpty()) {
       this.emptyFields += "Temperature\n";
       areFieldsEmpty = true;
     }
     
     return areFieldsEmpty;
   }
   
   public void setApp(Main app) {
     this.application = app;
   }
   
   public void setScreenParent(ScreensController screenParent)
   {
     this.myController = screenParent;
   }
   
   public String getCurrentTime() {
     DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
     Date date = new Date();
     return dateFormat.format(date);
   }
   
   public String getCurrentDate() {
     DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
     Date date = new Date();
     return dateFormat.format(date);
   }
 }