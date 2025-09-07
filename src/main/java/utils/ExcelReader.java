package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    public static List<Map<String, String>> readExcel(String filePath, String sheetName) throws Exception {
        List<Map<String, String>> data = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row headerRow = sheet.getRow(0);
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            Map<String, String> rowData = new HashMap<>();
            for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
                String key = headerRow.getCell(j).getStringCellValue();
                Cell cell = row.getCell(j);
                String value = cell != null ? cell.toString() : "";
                rowData.put(key, value);
            }
            data.add(rowData);
        }

        workbook.close();
        fis.close();
        return data;
    }
}