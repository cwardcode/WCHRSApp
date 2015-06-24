package edu.wcu.wchrs.groundwater;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends javafx.application.Application {
    private final double MINIMUM_WINDOW_HEIGHT = 500.0D;
    private final double MINIMUM_WINDOW_WIDTH = 300.0D;
    private Stage stage;

    public static String screen1ID = "Equipment Checklist";
    public static String screen1File = "EquipList.fxml";
    public static String screen2ID = "General Data";
    public static String screen2File = "GeneralData.fxml";
    public static String screen3ID = "Site Data";
    public static String screen3File = "SiteData.fxml";
    public static String screen4ID = "Well Data";
    public static String screen4File = "WellData.fxml";

    public void start(Stage primaryStage) throws Exception {
        ScreensController screens = new ScreensController();
        screens.loadScreen(screen1ID, screen1File);
        screens.loadScreen(screen2ID, screen2File);
        screens.loadScreen(screen3ID, screen3File);
        screens.loadScreen(screen4ID, screen4File);

        screens.setScreen(screen1ID);

        Group root = new Group();
        root.getChildren().addAll(new javafx.scene.Node[]{screens});
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
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

    public static void main(String[] args) {
        launch(args);
    }
}