package edu.wcu.wchrs.groundwater;

import java.io.FileOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class PrepController
        extends GridPane
        implements Initializable, ControlledScreen
{
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
  public void pressButton() throws Exception {
    if (emptyFieldsExist()) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error: Empty Fields");
      alert.setHeaderText("Please enter data into all fields");
      alert.setContentText(this.emptyFields);
      alert.showAndWait();
    }
    else {
        Iterator<Row> rowIterator = Main.sheet.rowIterator();
        while(rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()){
                Cell curCell = cellIterator.next();
                if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("Name:")) {
                    curCell.setCellValue(curCell.getStringCellValue() + " " + this.nameFld.getText());
                }
                if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("Date:")) {
                    curCell.setCellValue(curCell.getStringCellValue() + " " + this.dateFld.getText());
                }
                if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("Time:")) {
                    curCell.setCellValue(curCell.getStringCellValue() + " " + this.timeFld.getText());
                }
                if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("Weather:")) {
                    curCell.setCellValue(curCell.getStringCellValue() + " " + this.weatherFld.getText());
                }
                if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("Temperature:")) {
                    curCell.setCellValue(curCell.getStringCellValue() + " " + this.temperatureFld.getText());
                }

            }
        }
        FileOutputStream fos = new FileOutputStream(Main.outputFile);
        Main.book.write(fos);
      myController.loadScreen("site data", "SiteData.fxml");
      myController.setScreen("site data");
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