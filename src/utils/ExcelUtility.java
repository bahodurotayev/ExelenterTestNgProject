package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//we need to import the Apache POI
public class ExcelUtility {
    /* Order
        1.FilePath
        2.WorkBook
        3.Sheet
        4.Rows and Columns
        5.Cell
       (for each we will create a method)
    */
     String projectPath = System.getProperty("user.dir");
    FileInputStream fileInputStream;
    Workbook workbook;
    Sheet sheet;

    void getFilePath(String filePath){
        try {
             fileInputStream = new FileInputStream(filePath);
             workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void getSheet(String sheetName){
        sheet = workbook.getSheet(sheetName);
    }
    int rowCount(){
        return sheet.getPhysicalNumberOfRows(); //This method return count of rows
    }
    int colsCount(){
        return sheet.getRow(0).getLastCellNum(); //This method return count of columns.
    }
}
