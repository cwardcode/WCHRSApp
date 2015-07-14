package edu.wcu.wchrs.groundwater.controller;

import edu.wcu.wchrs.groundwater.ControlledScreen;
import edu.wcu.wchrs.groundwater.Main;
import edu.wcu.wchrs.groundwater.ScreensController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;

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
    private RadioButton smAYes;
    @FXML
    private RadioButton smANo;
    @FXML
    private RadioButton smBYes;
    @FXML
    private RadioButton smBNo;
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
    private TextField ggRC1;
    @FXML
    private TextField ggRC2;
    @FXML
    private TextField ggRC3;
    @FXML
    private TextField ggRCAvg;
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
            Iterator<Row> rowIterator = Main.sheet.rowIterator();
            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()){
                    Cell curCell = cellIterator.next();
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGArrivTime")) {
                        curCell.setCellValue(this.timeOfArrivalFld.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGDistIn")) {
                        curCell.setCellValue(this.distInside.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGDistOut")) {
                        curCell.setCellValue(this.distOutside.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGDistStaff")) {
                        curCell.setCellValue(this.distStaff.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGStage")) {
                        curCell.setCellValue(this.stage.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGNotes")) {
                        curCell.setCellValue(this.siteNotesFld.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGRG1Level")) {
                        if(rg1LevelYes.isSelected()) {
                            curCell.setCellValue("Yes");
                        } else {
                            curCell.setCellValue("No");
                        }
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGRG1Cond")) {
                        curCell.setCellValue(this.rg1CondFld.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGRG1Batt")) {
                        if(rg1battOK.isSelected()) {
                            curCell.setCellValue("Ok");
                        } else {
                            curCell.setCellValue("Dead");
                        }
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGRG1Notes")) {
                        curCell.setCellValue(this.rg1NotesFld.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGRG2Level")) {
                        if(rg2LevelYes.isSelected()) {
                            curCell.setCellValue("Yes");
                        } else {
                            curCell.setCellValue("No");
                        }
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGRG2Cond")) {
                        curCell.setCellValue(this.rg2CondFld.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGRG2Batt")) {
                         if(rg2BattOK.isSelected()) {
                            curCell.setCellValue("Ok");
                        } else {
                            curCell.setCellValue("Dead");
                        }
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("ggSMR")) {
                        if (smBYes.isSelected()) {
                            curCell.setCellValue("Yes");
                        } else {
                            curCell.setCellValue("No");
                        }
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("ggSML")) {
                        if (smAYes.isSelected()) {
                            curCell.setCellValue("Yes");
                        } else {
                            curCell.setCellValue("No");
                        }
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GGRG2Notes")) {
                        curCell.setCellValue(this.rg2NotesFld.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("RC1Depth")) {
                        curCell.setCellValue(this.ggRC1.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("RC2Depth")) {
                        curCell.setCellValue(this.ggRC2.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("RC3Depth")) {
                        curCell.setCellValue(this.ggRC3.getText());
                    }
                    if(curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("RCAverage")) {
                        curCell.setCellValue(this.ggRCAvg.getText());
                    }
                }
            }
            FileOutputStream fos = new FileOutputStream(Main.outputFile);
            Main.book.write(fos);
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

        if (!(this.smAYes.isSelected() || this.smANo.isSelected())) {
            this.emptyFields = emptyFields + "Soil Moisture - Left\n";
            areFieldsEmpty = true;
        }
        if (!(this.smBYes.isSelected() || this.smBNo.isSelected())) {
            this.emptyFields = emptyFields + "Soil Moisture - Right\n";
            areFieldsEmpty = true;
        }
        if(this.rg2NotesFld.getText().isEmpty()) {
            this.emptyFields = emptyFields + "Rain Gauge 2 Notes\n";
            areFieldsEmpty = true;
        }

        if(this.ggRC1.getText().isEmpty()) {
            this.emptyFields = emptyFields + "Rain Catcher 1\n";
            areFieldsEmpty = true;
        }

        if(this.ggRC2.getText().isEmpty()) {
            this.emptyFields = emptyFields + "Rain Catcher 2\n";
            areFieldsEmpty = true;
        }

        if(this.ggRC3.getText().isEmpty()) {
            this.emptyFields = emptyFields + "Rain Catcher 3\n";
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
        this.ggRC1.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    try {
                        ggRCAvg.setText("" + ((Double.parseDouble(ggRC1.getText()) + Double.parseDouble(ggRC2.getText()) + Double.parseDouble(ggRC3.getText())) / 3));
                    } catch (NumberFormatException nfe) {
                       System.out.println("");
                    }
                }
            }
        });
        this.ggRC2.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    try {
                        ggRCAvg.setText("" + ((Double.parseDouble(ggRC1.getText()) + Double.parseDouble(ggRC2.getText()) + Double.parseDouble(ggRC3.getText())) / 3));
                    } catch(NumberFormatException nfe) {
                        System.out.println("");
                    }
                }
            }
        });
        this.ggRC3.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    try{
                        ggRCAvg.setText("" + ((Double.parseDouble(ggRC1.getText()) + Double.parseDouble(ggRC2.getText()) + Double.parseDouble(ggRC3.getText())) / 3));
                    } catch (NumberFormatException nfe) {
                        System.out.println("");
                    }
                }
            }
        });
    }

    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        return dateFormat.format(new Date());
    }
}