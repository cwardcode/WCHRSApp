package edu.wcu.wchrs.groundwater;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Main extends javafx.application.Application {

    public static String screen1ID = "Equipment Checklist";
    public static String screen1File = "EquipList.fxml";
    public static String screen2ID = "General Data";
    public static String screen2File = "GeneralData.fxml";
    public static String screen4ID = "Well Data";
    public static String screen4File = "WellData.fxml";
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
            outputFile = new File("rounds.xlsx");
            stream = new FileInputStream(outputFile);
            book = new XSSFWorkbook(stream);
            sheet = book.getSheetAt(0);
            /* Just to test functionality of Apache POI TODO: remove*/
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();
                 Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        default:

                    }
                }
                System.out.println("");
            }

        } catch (IOException fnf) {
            System.out.println("Couldn't find file! Tried looking in: " + outputFile.getAbsolutePath() + "Full dump: "
                    + fnf.getMessage());
        }
        launch(args);
    }
}