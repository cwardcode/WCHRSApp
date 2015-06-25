package edu.wcu.wchrs.groundwater;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class WellController extends GridPane implements Initializable, ControlledScreen {
    private String regex = "[0-9]+([,.][0-9]{1,2})?";
    @FXML
    private TextField gg1SFld;
    @FXML
    private TextField gg1IFld;
    @FXML
    private TextField gg1DFld;
    @FXML
    private TextField gg1DLongFld;
    @FXML
    private TextField gg2SFld;
    @FXML
    private TextField gg2IFld;
    @FXML
    private TextField gg2DFld;
    @FXML
    private TextField gg3SFld;
    @FXML
    private TextField gg3IFld;
    @FXML
    private TextField gg3DFld;
    @FXML
    private TextField gg4SFld;
    @FXML
    private TextField gg4IFld;
    @FXML
    private TextField gg4DFld;
    @FXML
    private TextField gg1SHist;
    @FXML
    private TextField gg1IHist;
    @FXML
    private TextField gg1DHist;
    @FXML
    private TextField gg1DLongHist;
    @FXML
    private TextField gg2SHist;
    @FXML
    private TextField gg2IHist;
    @FXML
    private TextField gg2DHist;
    @FXML
    private TextField gg3SHist;
    @FXML
    private TextField gg3IHist;
    @FXML
    private TextField gg3DHist;
    @FXML
    private TextField gg4SHist;
    @FXML
    private TextField gg4IHist;
    @FXML
    private TextField gg4DHist;
    @FXML
    private TextField gg1TempFld;
    @FXML
    private TextField gg1CondFld;
    @FXML
    private TextField gg1PHFld;
    @FXML
    private TextField gg2TempFld;
    @FXML
    private TextField gg2CondFld;
    @FXML
    private TextField gg2PHFld;
    @FXML
    private TextArea wellNotesFld;

    private String emptyFields;
    private ScreensController controller;

    public void setScreenParent(ScreensController screenPage)
    {
        this.controller = screenPage;
    }


    public void initialize(URL location, ResourceBundle resources) {
        this.gg1SFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                {
                    if (!gg1SFld.getText().isEmpty() && gg1SFld.getText().matches(regex)) {
                    double enteredData = Double.parseDouble(gg1SFld.getText());
                    String[] range = gg1SHist.getText().split("-");
                    if(enteredData < Double.parseDouble(range[0].trim())
                                                                 || enteredData > Double.parseDouble(range[1].trim())) {
                        showDataAlert();
                    }
                    } else {
                        showInputAlert();
                    }
                }
            }
        });
        this.gg1IFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                {
                    if (!gg1IFld.getText().isEmpty() && gg1IFld.getText().matches(regex)) {
                    double enteredData = Double.parseDouble(gg1IFld.getText());
                    String[] range = gg1IHist.getText().split("-");
                    if(enteredData < Double.parseDouble(range[0].trim())
                                                                 || enteredData > Double.parseDouble(range[1].trim())) {
                        showDataAlert();
                    }
                    } else {
                        showInputAlert();
                    }
                }
            }
        });
        this.gg1DFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                {
                    if (!gg1DFld.getText().isEmpty() && gg1DFld.getText().matches(regex)) {
                    double enteredData = Double.parseDouble(gg1DFld.getText());
                    String[] range = gg1DHist.getText().split("-");
                    if(enteredData < Double.parseDouble(range[0].trim())
                                                                 || enteredData > Double.parseDouble(range[1].trim())) {
                        showDataAlert();
                    }
                    } else {
                        showInputAlert();
                    }
                }
            }
        });
        this.gg1DLongFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                {
                    if (!gg1DLongFld.getText().isEmpty() && gg1DLongFld.getText().matches(regex)) {
                    double enteredData = Double.parseDouble(gg1DLongFld.getText());
                    String[] range = gg1DLongHist.getText().split("-");
                    if(enteredData < Double.parseDouble(range[0].trim())
                                                                 || enteredData > Double.parseDouble(range[1].trim())) {
                        showDataAlert();
                    }
                    } else {
                        showInputAlert();
                    }
                }
            }
        });
        this.gg2SFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                {
                    if (!gg2SFld.getText().isEmpty() && gg2SFld.getText().matches(regex)) {
                    double enteredData = Double.parseDouble(gg2SFld.getText());
                    String[] range = gg2SHist.getText().split("-");
                    if(enteredData < Double.parseDouble(range[0].trim())
                                                                 || enteredData > Double.parseDouble(range[1].trim())) {
                        showDataAlert();
                    }
                    } else {
                       showInputAlert();
                    }
                }
            }
        });
        this.gg2IFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                {
                    if (!gg2IFld.getText().isEmpty() && gg2IFld.getText().matches(regex)) {
                    double enteredData = Double.parseDouble(gg2IFld.getText());
                    String[] range = gg2IHist.getText().split("-");
                    if(enteredData < Double.parseDouble(range[0].trim())
                                                                 || enteredData > Double.parseDouble(range[1].trim())) {
                        showDataAlert();
                    }
                    } else {
                        showInputAlert();
                    }
                }
            }
        });
        this.gg2DFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                {
                    if (!gg2DFld.getText().isEmpty() && gg2DFld.getText().matches(regex)) {
                    double enteredData = Double.parseDouble(gg2DFld.getText());
                    String[] range = gg2DHist.getText().split("-");
                    if(enteredData < Double.parseDouble(range[0].trim())
                                                                 || enteredData > Double.parseDouble(range[1].trim())) {
                        showDataAlert();
                    }
                    } else {
                        showInputAlert();
                    }
                }
            }
        });
        this.gg3SFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                {
                    if (!gg3SFld.getText().isEmpty() && gg3SFld.getText().matches(regex)) {
                    double enteredData = Double.parseDouble(gg3SFld.getText());
                    String[] range = gg3SHist.getText().split("-");
                    if(enteredData < Double.parseDouble(range[0].trim())
                                                                 || enteredData > Double.parseDouble(range[1].trim())) {
                        showDataAlert();
                    }
                    } else {
                        showInputAlert();
                    }
                }
            }
        });
        this.gg3IFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                {
                    if (!gg3IFld.getText().isEmpty() && gg3IFld.getText().matches(regex)) {
                    double enteredData = Double.parseDouble(gg3IFld.getText());
                    String[] range = gg3IHist.getText().split("-");
                    if(enteredData < Double.parseDouble(range[0].trim())
                                                                 || enteredData > Double.parseDouble(range[1].trim())) {
                        showDataAlert();
                    }
                    } else {
                        showInputAlert();
                    }
                }
            }
        });
        this.gg3DFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                {
                    if (!gg3DFld.getText().isEmpty() && gg3DFld.getText().matches(regex)) {
                    double enteredData = Double.parseDouble(gg3DFld.getText());
                    String[] range = gg3DHist.getText().split("-");
                    if(enteredData < Double.parseDouble(range[0].trim())
                                                                 || enteredData > Double.parseDouble(range[1].trim())) {
                        showDataAlert();
                    }
                    } else {
                        showInputAlert();
                    }
                }
            }
        });
        this.gg4SFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                {
                    if (!gg4SFld.getText().isEmpty() && gg4SFld.getText().matches(regex)) {
                    double enteredData = Double.parseDouble(gg4SFld.getText());
                    String[] range = gg4SHist.getText().split("-");
                    if(enteredData < Double.parseDouble(range[0].trim())
                                                                 || enteredData > Double.parseDouble(range[1].trim())) {
                        showDataAlert();
                    }
                    } else {
                        showInputAlert();
                        System.out.println("Not A Number!!");
                    }
                }
            }
        });
        this.gg4IFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                {
                    if (!gg4IFld.getText().isEmpty() && gg4IFld.getText().matches(regex)) {
                    double enteredData = Double.parseDouble(gg4IFld.getText());
                    String[] range = gg4IHist.getText().split("-");
                    if(enteredData < Double.parseDouble(range[0].trim())
                                                                 || enteredData > Double.parseDouble(range[1].trim())) {
                        showDataAlert();
                    }
                    } else {
                        showInputAlert();
                    }
                }
            }
        });
        this.gg4DFld.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (!gg4DFld.getText().isEmpty() && gg4DFld.getText().matches(regex)) {
                        double enteredData = Double.parseDouble(gg4DFld.getText());
                        String[] range = gg4DHist.getText().split("-");
                        if (enteredData < Double.parseDouble(range[0].trim())
                                || enteredData > Double.parseDouble(range[1].trim())) {
                            showDataAlert();
                        }
                    } else {
                        showInputAlert();
                    }
                }
            }
        });
    }
    public void showInputAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning: Invalid entry");
        alert.setHeaderText("Invalid data entered");
        alert.setContentText("Please only enter numbers and decimals.");
        alert.showAndWait();
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
            this.controller.setScreen(Main.screen1ID);
        }
    }

    private boolean emptyFieldsExist()
    {
        boolean areFieldsEmpty = false;
        this.emptyFields = "Please enter the following fields: \n";
        if(this.gg1SFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG1S\n";
            areFieldsEmpty = true;
        }
        if(this.gg1IFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG1I\n";
            areFieldsEmpty = true;
        }

        if(this.gg1DFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG1D\n";
            areFieldsEmpty = true;
        }
        if(this.gg1DLongFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG1DLong\n";
            areFieldsEmpty = true;
        }
        if(this.gg2SFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG2S\n";
            areFieldsEmpty = true;
        }
        if(this.gg2IFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG2I\n";
            areFieldsEmpty = true;
        }
        if(this.gg2DFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG2D\n";
            areFieldsEmpty = true;
        }
        if(this.gg3SFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG3S\n";
            areFieldsEmpty = true;
        }
        if(this.gg3IFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG3I\n";
            areFieldsEmpty = true;
        }
        if(this.gg3DFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG3D\n";
            areFieldsEmpty = true;
        }
        if(this.gg4SFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG4S\n";
            areFieldsEmpty = true;
        }
        if(this.gg4IFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG4I\n";
            areFieldsEmpty = true;
        }
        if(this.gg4DFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG4D\n";
            areFieldsEmpty = true;
        }
        if(this.gg1TempFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG1 Multiprobe Temp\n";
            areFieldsEmpty = true;
        }
        if(this.gg1CondFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG1 Multiprobe Cond\n";
            areFieldsEmpty = true;
        }
        if(this.gg1PHFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG1 Multiprobe pH\n";
            areFieldsEmpty = true;
        }
        if(this.gg2TempFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG2 Multiprobe Temp\n";
            areFieldsEmpty = true;
        }
        if(this.gg2CondFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG2 Multiprobe Cond\n";
            areFieldsEmpty = true;
        }
        if(this.gg2PHFld.getText().isEmpty()) {
            emptyFields = emptyFields + "GG2 Multiprobe pH\n";
            areFieldsEmpty = true;
        }
        if(this.wellNotesFld.getText().isEmpty()) {
            emptyFields = emptyFields + "Well Notes\n";
            wellNotesFld.setEditable(true);
            areFieldsEmpty = true;
        }

        return areFieldsEmpty;
    }
}
