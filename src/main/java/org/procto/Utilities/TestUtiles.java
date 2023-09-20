package org.procto.Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestUtiles {
    public static long Implicit_wait = 10;
    public static  String Sheet_path ="C:\\Users\\NTS-Asmita Raut\\Downloads\\demospring\\Hybridframework\\src\\main\\java\\org\\procto\\Testdata\\Datadriven.xlsx";
    static Workbook book;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(Sheet_path);
            book = WorkbookFactory.create(file);
            sheet = book.getSheet(sheetName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }

        }
        return data;
    }
}
