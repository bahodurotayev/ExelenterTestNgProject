package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;


public class ExcelUtility {
    //we need to import the Apache POI
    /* Order
        1.FilePath
        2.WorkBook
        3.Sheet
        4.Rows and Columns
        5.Cell
       (for each we will create a method)
    */
    public static String projectPath = System.getProperty("user.dir");
    private static FileInputStream fileInputStream;
    private static Workbook workbook;
    private static Sheet sheet;

    private static void getFilePath(String filePath) {
        try {
            fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
    }

    private static int rowCount() {
        return sheet.getPhysicalNumberOfRows();           // This method will return total count of rows.
    }

    private static int colsCount() {
        return sheet.getRow(0).getLastCellNum();       // This method will return total count of columns.
    }

    private static String getCell(int rowIndex, int columnIndex) {       // This method will read from a cell based on the index of given row and column.
        return sheet.getRow(rowIndex).getCell(columnIndex).toString();
    }

    public static Object[][] readFromExcel(String filePath, String sheetName) {
        getFilePath(filePath);
        getSheet(sheetName);

        int rows = rowCount();
        int cols = colsCount();
        Object[][] data = new Object[rows - 1][cols];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(getCell(i, j) != null) {
                data[i - 1][j] = getCell(i, j);
                }
            }
        }
        try {
            workbook.close();            // Closing part is optional, but highly recommended.
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
