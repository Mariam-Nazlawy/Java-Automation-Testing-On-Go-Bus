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

        int totalRows = sheetName.getLastRowNum();
        Row rowCells = sheetName.getRow(0);
        int totalColumns =  rowCells.getLastCellNum();

        DataFormatter formatter = new DataFormatter();

        String[][] testData = new String[totalRows][totalColumns];

        int dataRowIndex = 0;
        for(int i =1; i < totalRows; i++){
            for(int j =0; j < totalColumns; j++){
                Cell cell = sheetName.getRow(i).getCell(j);
                testData[dataRowIndex][j] = formatter.formatCellValue(cell).trim();
            }
            dataRowIndex++;
        }

        // Close the input stream and workbook
        fis.close();
        wb.close();

        return testData;

    }
}
