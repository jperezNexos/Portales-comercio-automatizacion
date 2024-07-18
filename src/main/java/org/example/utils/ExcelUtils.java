package org.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static java.sql.Types.BOOLEAN;
import static java.sql.Types.NUMERIC;


public class ExcelUtils {
 /*   private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        File file = new File(excelFilePath);
        FileInputStream inputStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet(sheetName);
        inputStream.close(); // Close input stream after use
    }

    public String getCellData(int rowNumber, int cellNumber) {
        Row row = sheet.getRow(rowNumber);
        if (row != null) {
            Cell cell = row.getCell(cellNumber);
            if (cell != null) {
                cell.setCellType(CellType.STRING); // Ensure it reads as string
                return cell.getStringCellValue();
            }
        }
        return ""; // Return empty string if cell is empty or null
    }

    public int getRowCountInSheet() {
        return sheet.getPhysicalNumberOfRows();
    }

    public void setCellValue(int rowNum, int cellNum, String cellValue, String excelFilePath) throws IOException {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        Cell cell = row.createCell(cellNum);
        cell.setCellValue(cellValue);

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
    }

    public void closeWorkbook() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }*/
 private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        try {
            File file = new File(excelFilePath);
            FileInputStream inputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo Excel: " + e.getMessage());
            throw e;
        }
    }

    public String getCellData(int rowNumber, int cellNumber) {
        Cell cell = sheet.getRow(rowNumber).getCell(cellNumber);

        if (cell != null) {
            cell.setCellType(CellType.STRING); // Asegura que se lea como texto
            return cell.getStringCellValue();
        } else {
            return ""; // Retorna cadena vacía si la celda está vacía
        }
    }

    public int getRowCountInSheet() {
        return sheet.getPhysicalNumberOfRows();
    }

    public void setCellValue(int rowNum, int cellNum, String cellValue, String excelFilePath) throws IOException {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        Cell cell = row.createCell(cellNum);
        cell.setCellValue(cellValue);

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
    }

    public void closeWorkbook() throws IOException {
        workbook.close();
    }
}