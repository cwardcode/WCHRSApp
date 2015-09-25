package edu.wcu.wchrs.groundwater;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class Main extends javafx.application.Application {

    public static String screen1ID = "Equipment Checklist";
    public static String screen1File = "screens/EquipList.fxml";
    public static String screen2ID = "General Data";
    public static String screen2File = "screens/GeneralData.fxml";
    public static String screen4ID = "Well Data";
    public static String screen4File = "screens/WellData.fxml";
    public static File inputFile;
    public static File outputFile;
    public static FileInputStream stream;
    public static XSSFWorkbook book;
    public static XSSFSheet sheet;
    public static String username;
    private static String osName;

    public static void main(String[] args) {
        launch(args);
    }

    private static boolean userHasDropbox() {
        boolean has_dropbox = false;
        Alert dropboxAlert = new Alert(Alert.AlertType.CONFIRMATION);
        dropboxAlert.setTitle("Dropbox Confirmation");
        dropboxAlert.setHeaderText("Do you have dropbox installed?");
        dropboxAlert.setContentText("If you have dropbox installed, you can automatically have the data file save in " +
                "the weekly rounds folder. Would you like to do this?");
        Optional<ButtonType> result = dropboxAlert.showAndWait();
        if (result.get() == ButtonType.OK) {
            has_dropbox = true;
        }
        System.out.println("User has dropbox: " + has_dropbox);
        return has_dropbox;
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM.dd.yy");
        Date date = new Date();
        return dateFormat.format(date);
  }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("WCHRS Groundwater Data Collection");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("gfx/water-droplet-icon.jpg")));
        ScreensController screens = new ScreensController();
        screens.loadScreen(screen1ID, screen1File);
        screens.loadScreen(screen2ID, screen2File);
        screens.loadScreen(screen4ID, screen4File);
        screens.setScreen(screen1ID);

        Group root = new Group();
        root.getChildren().addAll(screens);
        Scene scene = new Scene(root);

        try {
            //Get current user
            username = System.getProperty("user.name");
            osName = System.getProperty("os.name").split("\\s+")[0];

            //Prompt for dropbox installed dialog
            if (userHasDropbox()) {
                if (osName.equals("Windows")) {
                    outputFile = new File("C:\\users\\" + username + "\\Dropbox\\WCU-DENR MP\\Scanned Datasheets\\Weekly Rounds (GW Head Levels)\\2015\\WeeklyRounds_" + getCurrentDate() + ".xlsx");
                } else if (osName.toLowerCase().equals("linux")) {
                    outputFile = new File("/home/" + username + "/Dropbox/WCU-DENR MP/Scanned Datasheets/Weekly Rounds (GW Head Levels)/2015/WeeklyRounds_" + getCurrentDate() + ".xlsx");
                }
            } else {
                if (osName.equals("Windows")) {
                    outputFile = new File("C:\\users\\" + username + "\\desktop\\WeeklyRounds_" + getCurrentDate() + ".xlsx");
                } else if (osName.toLowerCase().equals("linux")) {
                    outputFile = new File("/home/" + username + "WeeklyRounds_" + getCurrentDate() + ".xlsx");
                }
            }

            OutputStream out = new FileOutputStream(outputFile);
            InputStream is = Main.class.getResourceAsStream("files/rounds.xlsx");
            IOUtils.copy(is, out);
            inputFile = outputFile;
            stream = new FileInputStream(inputFile);
            book = new XSSFWorkbook(stream);
            sheet = book.getSheetAt(0);
        } catch (IOException fnf) {
            System.out.println("Couldn't find file! Error: " + fnf.getMessage());
        }
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}