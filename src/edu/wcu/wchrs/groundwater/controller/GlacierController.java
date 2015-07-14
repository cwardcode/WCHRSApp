package edu.wcu.wchrs.groundwater.controller;

import edu.wcu.wchrs.groundwater.ControlledScreen;
import edu.wcu.wchrs.groundwater.Main;
import edu.wcu.wchrs.groundwater.ScreensController;
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

public class GlacierController extends GridPane implements Initializable, ControlledScreen {
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
    private RadioButton rg1battOK;
    @FXML
    private RadioButton rg1battDead;
    @FXML
    private TextField rg1CondFld;
    @FXML
    private TextArea rg1NotesFld;
    @FXML
    private TextArea siteNotesFld;
    @FXML
    private RadioButton smAYes;
    @FXML
    private RadioButton smANo;
    @FXML
    private RadioButton smBYes;
    @FXML
    private RadioButton smBNo;
    @FXML
    private RadioButton smCYes;
    @FXML
    private RadioButton smCNo;
    @FXML
    private TextField wellDepth;
    @FXML
    private TextField mpTemp;
    @FXML
    private TextField mpCond;
    @FXML
    private TextField mpPh;

    @FXML
    public void pressButton() throws Exception {
        if (emptyFieldsExist()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: Empty Fields");
            alert.setHeaderText("Please enter data into all fields");
            alert.setContentText(this.emptyFields);
            alert.showAndWait();
        } else {
            Iterator<Row> rowIterator = Main.sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell curCell = cellIterator.next();
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierArrivTime")) {
                        curCell.setCellValue(this.timeOfArrivalFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierDistIn")) {
                        curCell.setCellValue(this.distInside.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierDistOut")) {
                        curCell.setCellValue(this.distOutside.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierStaff")) {
                        curCell.setCellValue(this.distStaff.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierStage")) {
                        curCell.setCellValue(this.stage.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierNotes")) {
                        curCell.setCellValue(this.siteNotesFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierRGLevel")) {
                        if (rg1LevelYes.isSelected()) {
                            curCell.setCellValue("Yes");
                        } else {
                            curCell.setCellValue("No");
                        }
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("gSMA")) {
                        if (smAYes.isSelected()) {
                            curCell.setCellValue("Yes");
                        } else {
                            curCell.setCellValue("No");
                        }
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("gSMB")) {
                        if (smBYes.isSelected()) {
                            curCell.setCellValue("Yes");
                        } else {
                            curCell.setCellValue("No");
                        }
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("gSMC")) {
                        if (smCYes.isSelected()) {
                            curCell.setCellValue("Yes");
                        } else {
                            curCell.setCellValue("No");
                        }
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierRGCond")) {
                        curCell.setCellValue(this.rg1CondFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierRGBatt")) {
                        if (rg1battOK.isSelected()) {
                            curCell.setCellValue("Ok");
                        } else {
                            curCell.setCellValue("Dead");
                        }
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierRGNotes")) {
                        curCell.setCellValue(this.rg1NotesFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierWellDepth")) {
                        curCell.setCellValue(wellDepth.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierMPTemp")) {
                        curCell.setCellValue(mpTemp.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierMPCond")) {
                        curCell.setCellValue(mpCond.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("GlacierMPPH")) {
                        curCell.setCellValue(mpPh.getText());
                    }
                }
            }
            FileOutputStream fos = new FileOutputStream(Main.outputFile);
            Main.book.write(fos);
            controller.loadScreen("gribble", "screens/SiteData.fxml");
            controller.setScreen("gribble");
        }
    }

    private boolean emptyFieldsExist() {
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

        if (!(this.rg1LevelYes.isSelected() || this.rg1LevelNo.isSelected())) {
            this.emptyFields = emptyFields + "Rain Gauge 1 Level\n";
            areFieldsEmpty = true;
        }

        if (!(this.rg1battOK.isSelected() || this.rg1battDead.isSelected())) {
            this.emptyFields = emptyFields + "Rain Gauge 1 Battery\n";
            areFieldsEmpty = true;
        }

        if (this.rg1CondFld.getText().isEmpty()) {
            this.emptyFields = emptyFields + "Rain Gauge 1 Condition\n";
            areFieldsEmpty = true;
        }

        if (this.rg1NotesFld.getText().isEmpty()) {
            this.emptyFields = emptyFields + "Rain Gauge 1 Notes\n";
            areFieldsEmpty = true;
        }
        if (!(this.smAYes.isSelected() || this.smANo.isSelected())) {
            this.emptyFields = emptyFields + "Soil Moisture A\n";
            areFieldsEmpty = true;
        }
        if (this.wellDepth.getText().isEmpty()) {
            this.emptyFields += "Glacier 1 Well\n";
            areFieldsEmpty = true;
        }
        if (!(this.smBYes.isSelected() || this.smBNo.isSelected())) {
            this.emptyFields = emptyFields + "Soil Moisture B\n";
            areFieldsEmpty = true;
        }
        if (!(this.smCYes.isSelected() || this.smCNo.isSelected())) {
            this.emptyFields = emptyFields + "Soil Moisture C\n";
            areFieldsEmpty = true;
        }
        if (this.mpTemp.getText().isEmpty()) {
            this.emptyFields += "Multiprobe - temp\n";
            areFieldsEmpty = true;
        }
        if (this.mpCond.getText().isEmpty()) {
            this.emptyFields += "Multiprobe - Cond\n";
            areFieldsEmpty = true;
        }
        if (this.mpPh.getText().isEmpty()) {
            this.emptyFields += "Multiprobe - PH\n";
            areFieldsEmpty = true;
        }
        if (this.siteNotesFld.getText().isEmpty()) {
            this.emptyFields += "SiteNotes\n";
            areFieldsEmpty = true;
        }
        return areFieldsEmpty;
    }

    public void setScreenParent(ScreensController screenPage) {
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
