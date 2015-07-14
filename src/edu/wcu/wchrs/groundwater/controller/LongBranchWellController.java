package edu.wcu.wchrs.groundwater.controller;

import edu.wcu.wchrs.groundwater.ControlledScreen;
import edu.wcu.wchrs.groundwater.Main;
import edu.wcu.wchrs.groundwater.ScreensController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class LongBranchWellController extends GridPane implements Initializable, ControlledScreen {
    private String regex = "[0-9]+([,.][0-9]{1,3})?";
    @FXML
    private TextField lb1SFld;
    @FXML
    private TextField lb1IFld;
    @FXML
    private TextField lb1DFld;
    @FXML
    private TextField lb1StreamFld;
    @FXML
    private TextField lb2SFld;
    @FXML
    private TextField lb2IFld;
    @FXML
    private TextField lb2S1Fld;
    @FXML
    private TextField lb2S2Fld;
    @FXML
    private TextField lb2S3Fld;
    @FXML
    private TextField lb2StreamFld;
    @FXML
    private TextField lb3SFld;
    @FXML
    private TextField lb3IFld;
    @FXML
    private TextField lb3DFld;
    @FXML
    private TextField lb1SHist;
    @FXML
    private TextField lb1IHist;
    @FXML
    private TextField lb1DHist;
    @FXML
    private TextField lb1StreamHist;
    @FXML
    private TextField lb2SHist;
    @FXML
    private TextField lb2IHist;
    @FXML
    private TextField lb2S1Hist;
    @FXML
    private TextField lb2S2Hist;
    @FXML
    private TextField lb2S3Hist;
    @FXML
    private TextField lb2StreamHist;
    @FXML
    private TextField lb3SHist;
    @FXML
    private TextField lb3IHist;
    @FXML
    private TextField lb3DHist;
    @FXML
    private TextField mp1Temp;
    @FXML
    private TextField mp1Cond;
    @FXML
    private TextField mp1PH;
    @FXML
    private TextField mp2Temp;
    @FXML
    private TextField mp2Cond;
    @FXML
    private TextField mp2PH;
    @FXML
    private TextArea wellNotesFld;

    private String emptyFields;
    private ScreensController controller;

    public void setScreenParent(ScreensController screenPage) {
        this.controller = screenPage;
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.lb1SFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb1SFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb1SFld.getText());
                        String[] range = lb1SHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.lb1IFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb1IFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb1IFld.getText());
                        String[] range = lb1IHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.lb1DFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb1DFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb1DFld.getText());
                        String[] range = lb1DHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.lb1StreamFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb1StreamFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb1StreamFld.getText());
                        String[] range = lb1StreamHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.lb2SFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb2SFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb2SFld.getText());
                        String[] range = lb2SHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.lb2IFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb2IFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb2IFld.getText());
                        String[] range = lb2IHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.lb2S1Fld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb2S1Fld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb2S1Fld.getText());
                        String[] range = lb2S1Hist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.lb2S2Fld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb2S2Fld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb2S2Fld.getText());
                        String[] range = lb2S2Hist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.lb2S3Fld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb2S3Fld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb2S3Fld.getText());
                        String[] range = lb2S3Hist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.lb2StreamFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb2StreamFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb2StreamFld.getText());
                        String[] range = lb2StreamHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.lb3SFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb3SFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb3SFld.getText());
                        String[] range = lb3SHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.lb3IFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb3IFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb3IFld.getText());
                        String[] range = lb3IHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.lb3DFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (lb3DFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(lb3DFld.getText());
                        String[] range = lb3DHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
    }

    public void showDataAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning: Possible erroneous data");
        alert.setHeaderText("Please ensure the data entered is correct");
        alert.setContentText("The entered data is out of the historic range, please be sure that it is correct.");
        alert.showAndWait();
    }

    @FXML
    public void pressButton()
            throws Exception {
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
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB1SDepth")) {
                        curCell.setCellValue(this.lb1SFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB1iDepth")) {
                        curCell.setCellValue(this.lb1IFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB1DDepth")) {
                        curCell.setCellValue(this.lb1DFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB1StreamDepth")) {
                        curCell.setCellValue(this.lb1StreamFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB2SDepth")) {
                        curCell.setCellValue(this.lb2SFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB2iDepth")) {
                        curCell.setCellValue(this.lb2IFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB2S1Depth")) {
                        curCell.setCellValue(this.lb2S1Fld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB2S2Depth")) {
                        curCell.setCellValue(this.lb2S2Fld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB2S3Depth")) {
                        curCell.setCellValue(this.lb2S3Fld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB2StreamDepth")) {
                        curCell.setCellValue(this.lb2StreamFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB3SDepth")) {
                        curCell.setCellValue(this.lb3SFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB3iDepth")) {
                        curCell.setCellValue(this.lb3IFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB3DDepth")) {
                        curCell.setCellValue(this.lb3DFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB1MPTemp")) {
                        curCell.setCellValue(this.mp1Temp.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB1MPCond")) {
                        curCell.setCellValue(this.mp1Cond.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB1MPPH")) {
                        curCell.setCellValue(this.mp1PH.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB2MPTemp")) {
                        curCell.setCellValue(this.mp2Temp.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB2MPCond")) {
                        curCell.setCellValue(this.mp2Cond.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LB2MPPH")) {
                        curCell.setCellValue(this.mp2PH.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("LBWellNotes")) {
                        curCell.setCellValue(this.wellNotesFld.getText());
                    }
                }
            }
            FileOutputStream fos = new FileOutputStream(Main.outputFile);
            Main.book.write(fos);
            controller.loadScreen("ccreek", "screens/CullowheeCreekWell.fxml");
            this.controller.setScreen("ccreek");
        }
    }

    private boolean emptyFieldsExist() {
        boolean areFieldsEmpty = false;
        this.emptyFields = "Please enter the following fields: \n";
        if (this.lb1SFld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB1S\n";
            areFieldsEmpty = true;
        }
        if (this.lb1IFld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB1I\n";
            areFieldsEmpty = true;
        }

        if (this.lb1DFld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB1D\n";
            areFieldsEmpty = true;
        }
        if (this.lb1StreamFld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB1Stream\n";
            areFieldsEmpty = true;
        }
        if (this.lb2SFld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB2S\n";
            areFieldsEmpty = true;
        }
        if (this.lb2IFld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB2I\n";
            areFieldsEmpty = true;
        }
        if (this.lb2S1Fld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB2S1\n";
            areFieldsEmpty = true;
        }
        if (this.lb2S2Fld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB2S2\n";
            areFieldsEmpty = true;
        }
        if (this.lb2S3Fld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB2S3\n";
            areFieldsEmpty = true;
        }
        if (this.lb2StreamFld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB2Stream\n";
            areFieldsEmpty = true;
        }
        if (this.lb3SFld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB3S\n";
            areFieldsEmpty = true;
        }
        if (this.lb3IFld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB3I\n";
            areFieldsEmpty = true;
        }
        if (this.lb3DFld.getText().isEmpty()) {
            emptyFields = emptyFields + "LB3D\n";
            areFieldsEmpty = true;
        }
        if (this.mp1Temp.getText().isEmpty()) {
            emptyFields = emptyFields + "LB1 Multiprobe Temp\n";
            areFieldsEmpty = true;
        }
        if (this.mp1Cond.getText().isEmpty()) {
            emptyFields = emptyFields + "LB1 Multiprobe Cond\n";
            areFieldsEmpty = true;
        }
        if (this.mp1PH.getText().isEmpty()) {
            emptyFields = emptyFields + "LB1 Multiprobe pH\n";
            areFieldsEmpty = true;
        }
        if (this.mp2Temp.getText().isEmpty()) {
            emptyFields = emptyFields + "LB2 Multiprobe Temp\n";
            areFieldsEmpty = true;
        }
        if (this.mp2Cond.getText().isEmpty()) {
            emptyFields = emptyFields + "LB2 Multiprobe Cond\n";
            areFieldsEmpty = true;
        }
        if (this.mp2PH.getText().isEmpty()) {
            emptyFields = emptyFields + "LB2 Multiprobe pH\n";
            areFieldsEmpty = true;
        }
        if (this.wellNotesFld.getText().isEmpty()) {
            emptyFields = emptyFields + "Well Notes\n";
            wellNotesFld.setEditable(true);
            areFieldsEmpty = true;
        }

        return areFieldsEmpty;
    }
}
