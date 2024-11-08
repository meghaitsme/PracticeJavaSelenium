package com.mk.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginDataProvider {

    public Map<String, String> readExcelData(String filePath, String sheetName, int rowNumber) {
        Map<String, String> data = new HashMap<>();
        try (FileInputStream file = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {
             
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(rowNumber);
            int colCount = row.getLastCellNum();

            for (int i = 0; i < colCount; i++) {
                String key = sheet.getRow(0).getCell(i).getStringCellValue(); // Header as key
                XSSFCell cell = row.getCell(i);
                String value = getCellValue(cell);
                data.put(key, value);
            }

        } catch (IOException e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
        }
        return data;
    }

    public int getRowCount(String filePath, String sheetName) {
        try (FileInputStream file = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {
             
            XSSFSheet sheet = workbook.getSheet(sheetName);
            return sheet.getLastRowNum();
        } catch (IOException e) {
            System.out.println("Error reading row count from Excel: " + e.getMessage());
        }
        return 0;
    }

    private String getCellValue(XSSFCell cell) {
        if (cell == null) return ""; // Handle null cells
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}