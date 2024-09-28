package utilities;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.NoInjection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ReadXLSFile {

    @DataProvider(name = "testdata")
    public static Object[][] getData(Method m) throws IOException{

        // Get the method name to match the sheet name
        String fileName = m.getName();

        // define the xls file path
        File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\tsetdata\\testdata.xlsx");
        // create input stream for the file path
        FileInputStream fis = new FileInputStream(f);
        // get the workbook
        Workbook wb = WorkbookFactory.create(fis);
        // get the sheet from the workbook
        Sheet sheetName = wb.getSheet(fileName);

        // Check if the sheet exists
        if (sheetName == null) {
            throw new RuntimeException("Sheet with name '" + fileName + "' does not exist in the Excel file.");
        }

        int totalRows = sheetName.getPhysicalNumberOfRows();
        Row rowCells = sheetName.getRow(0);
        int totalColumns =  rowCells.getLastCellNum();

        DataFormatter formatter = new DataFormatter();

        String[][] testData = new String[totalRows - 1][totalColumns];


        for(int i =1; i < totalRows; i++){
            Row row = sheetName.getRow(i);
            for(int j =0; j < totalColumns; j++){
                Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                testData[i-1][j] = formatter.formatCellValue(cell).trim();
            }
        }

        // Close the input stream and workbook
        fis.close();
        wb.close();

        return testData;

    }
}
