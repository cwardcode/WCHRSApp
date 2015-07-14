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

public class CullowheeCreekWellController extends GridPane implements Initializable, ControlledScreen {
    private String regex = "[0-9]+([,.][0-9]{1,3})?";
    @FXML
    private TextField CC1SFld;
    @FXML
    private TextField CC1IFld;
    @FXML
    private TextField CC1DFld;
    @FXML
    private TextField CC1D2Fld;
    @FXML
    private TextField CC1I2Fld;
    @FXML
    private TextField CC2SFld;
    @FXML
    private TextField CC2IFld;
    @FXML
    private TextField CC2DFld;
    @FXML
    private TextField CC3I2Fld;
    @FXML
    private TextField CC3IFld;
    @FXML
    private TextField CC4SFld;
    @FXML
    private TextField CC4IFld;
    @FXML
    private TextField CC5S1Fld;
    @FXML
    private TextField CC5S2Fld;
    @FXML
    private TextField CC5IFld;
    @FXML
    private TextField CC5DFld;
    @FXML
    private TextField CCOldFld;
    @FXML
    private TextField psFld;
    @FXML
    private TextField stFld;
    @FXML
    private TextField CC1SHist;
    @FXML
    private TextField CC1IHist;
    @FXML
    private TextField CC1DHist;
    @FXML
    private TextField CC1I2Hist;
    @FXML
    private TextField CC1D2Hist;
    @FXML
    private TextField CC2SHist;
    @FXML
    private TextField CC2IHist;
    @FXML
    private TextField CC2DHist;
    @FXML
    private TextField CC3I2Hist;
    @FXML
    private TextField CC3IHist;
    @FXML
    private TextField CC4SHist;
    @FXML
    private TextField CC4IHist;
    @FXML
    private TextField CC5S1Hist;
    @FXML
    private TextField CC5S2Hist;
    @FXML
    private TextField CC5IHist;
    @FXML
    private TextField CC5DHist;
    @FXML
    private TextArea wellNotesFld;

    private String emptyFields;
    private ScreensController controller;

    public void setScreenParent(ScreensController screenPage) {
        this.controller = screenPage;
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.CC1SFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC1SFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC1SFld.getText());
                        String[] range = CC1SHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC1IFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC1IFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC1IFld.getText());
                        String[] range = CC1IHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC1I2Fld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC1I2Fld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC1I2Fld.getText());
                        String[] range = CC1I2Hist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC1DFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC1DFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC1DFld.getText());
                        String[] range = CC1DHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC1D2Fld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC1D2Fld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC1D2Fld.getText());
                        String[] range = CC1D2Hist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC2SFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC2SFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC2SFld.getText());
                        String[] range = CC2SHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC2IFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC2IFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC2IFld.getText());
                        String[] range = CC2IHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC2DFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC2DFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC2DFld.getText());
                        String[] range = CC2DHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC3I2Fld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC3I2Fld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC3I2Fld.getText());
                        String[] range = CC3I2Hist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC3IFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC3IFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC3IFld.getText());
                        String[] range = CC3IHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC4SFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC4SFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC4SFld.getText());
                        String[] range = CC4SHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC4IFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC4IFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC4IFld.getText());
                        String[] range = CC4IHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC5S1Fld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC5S1Fld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC5S1Fld.getText());
                        String[] range = CC5S1Hist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC5S1Fld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC5S1Fld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC5S1Fld.getText());
                        String[] range = CC5S1Hist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC5S1Fld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC5S1Fld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC5S1Fld.getText());
                        String[] range = CC5S1Hist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC5S2Fld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC5S2Fld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC5S2Fld.getText());
                        String[] range = CC5S2Hist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC5IFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC5IFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC5IFld.getText());
                        String[] range = CC5IHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    }
                }
            }
        });
        this.CC5DFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (CC5DFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(CC5DFld.getText());
                        String[] range = CC5DHist.getText().split("-");
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
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC1SDepth")) {
                        curCell.setCellValue(this.CC1SFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC1iDepth")) {
                        curCell.setCellValue(this.CC1IFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC1i2Depth")) {
                        curCell.setCellValue(this.CC1I2Fld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC1DDepth")) {
                        curCell.setCellValue(this.CC1DFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC1D2Depth")) {
                        curCell.setCellValue(this.CC1D2Fld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC2SDepth")) {
                        curCell.setCellValue(this.CC2SFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC2iDepth")) {
                        curCell.setCellValue(this.CC2IFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC2DDepth")) {
                        curCell.setCellValue(this.CC2DFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC3i2Depth")) {
                        curCell.setCellValue(this.CC3I2Fld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC3iDepth")) {
                        curCell.setCellValue(this.CC3IFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC4SDepth")) {
                        curCell.setCellValue(this.CC4SFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC4iDepth")) {
                        curCell.setCellValue(this.CC4IFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC5S1Depth")) {
                        curCell.setCellValue(this.CC5S1Fld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC5S2Depth")) {
                        curCell.setCellValue(this.CC5S2Fld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC5iDepth")) {
                        curCell.setCellValue(this.CC5IFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CC5DDepth")) {
                        curCell.setCellValue(this.CC5DFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CCOldWellDepth")) {
                        curCell.setCellValue(this.CCOldFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("PS1WellDepth")) {
                        curCell.setCellValue(this.psFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("ST1WellDepth")) {
                        curCell.setCellValue(this.stFld.getText());
                    }
                    if (curCell.getCellType() == Cell.CELL_TYPE_STRING && curCell.getStringCellValue().equals("CCWellNotes")) {
                        curCell.setCellValue(this.wellNotesFld.getText());
                    }
                }
            }
            FileOutputStream fos = new FileOutputStream(Main.outputFile);
            Main.book.write(fos);
            this.controller.setScreen(Main.screen1ID);
        }
    }

    private boolean emptyFieldsExist() {
        boolean areFieldsEmpty = false;
        this.emptyFields = "Please enter the following fields: \n";
        if (this.CC1SFld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC1S\n";
            areFieldsEmpty = true;
        }
        if (this.CC1IFld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC1I\n";
            areFieldsEmpty = true;
        }

        if (this.CC1I2Fld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC1I2\n";
            areFieldsEmpty = true;
        }
        if (this.CC1DFld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC1D\n";
            areFieldsEmpty = true;
        }
        if (this.CC1D2Fld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC1D2\n";
            areFieldsEmpty = true;
        }
        if (this.CC2SFld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC2S\n";
            areFieldsEmpty = true;
        }
        if (this.CC2IFld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC2I\n";
            areFieldsEmpty = true;
        }
        if (this.CC2DFld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC2D\n";
            areFieldsEmpty = true;
        }
        if (this.CC3I2Fld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC3I2\n";
            areFieldsEmpty = true;
        }
        if (this.CC3IFld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC3I\n";
            areFieldsEmpty = true;
        }
        if (this.CC4SFld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC4S\n";
            areFieldsEmpty = true;
        }
        if (this.CC4IFld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC4I\n";
            areFieldsEmpty = true;
        }
        if (this.CC5S1Fld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC5S1\n";
            areFieldsEmpty = true;
        }
        if (this.CC5S2Fld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC5S2\n";
            areFieldsEmpty = true;
        }
        if (this.CC5IFld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC5I\n";
            areFieldsEmpty = true;
        }
        if (this.CC5DFld.getText().isEmpty()) {
            emptyFields = emptyFields + "CC5D\n";
            areFieldsEmpty = true;
        }
        if (this.CCOldFld.getText().isEmpty()) {
            emptyFields = emptyFields + "CCOld\n";
            areFieldsEmpty = true;
        }
        if (this.psFld.getText().isEmpty()) {
            emptyFields = emptyFields + "Print Shop\n";
            areFieldsEmpty = true;
        }
        if (this.stFld.getText().isEmpty()) {
            emptyFields = emptyFields + "StillWell\n";
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
