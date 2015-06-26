package edu.wcu.wchrs.groundwater;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends javafx.application.Application {

    public static String screen1ID = "Equipment Checklist";
    public static String screen1File = "EquipList.fxml";
    public static String screen2ID = "General Data";
    public static String screen2File = "GeneralData.fxml";
    public static String screen4ID = "Well Data";
    public static String screen4File = "WellData.fxml";
    public static File inputFile;
    public static File outputFile;
    public static FileInputStream stream;
    public static XSSFWorkbook book;
    public static XSSFSheet sheet;
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
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        try {
            //Get current user
            String username = System.getProperty("user.name");
            String osName = System.getProperty("os.name").split("\\s+")[0];

            if(osName.equals("Windows")) {
                outputFile = new File("C:\\users\\" + username + "\\desktop\\WeeklyRounds_" + getCurrentDate() + ".xlsx");
            } else if(osName.toLowerCase() == "linux") {
                outputFile = new File("/home/" + username + "WeeklyRounds_" + getCurrentDate() + ".xlsx");
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
        launch(args);
    }
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM.dd.yy");
        Date date = new Date();
        return dateFormat.format(date);
  }
}