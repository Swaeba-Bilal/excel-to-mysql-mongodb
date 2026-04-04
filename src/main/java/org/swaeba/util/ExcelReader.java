package org.swaeba.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.swaeba.model.University;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<University> readExcel(String filePath) {

        List<University> list = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                // Skip header row
                if (row.getRowNum() == 0)
                    continue;

                int id = getIntCell(row, 0);
                String name = getStringCell(row, 1);
                String program = getStringCell(row, 2);
                String city = getStringCell(row, 3);
                String country = getStringCell(row, 4);
                int ranking = getIntCell(row, 5);
                int fee = getIntCell(row, 6);
                int duration = getIntCell(row, 7);

                // Optional: skip invalid rows
                if (id == 0 || name.isEmpty()) {
                    System.out.println("⚠Skipping invalid row: " + row.getRowNum());
                    continue;
                }

                University uni = new University(
                        id, name, program,
                        city, country,
                        ranking, fee, duration
                );

                list.add(uni);
            }

        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }

        return list;
    }


    private static String getStringCell(Row row, int index) {
        Cell cell = row.getCell(index);

        if (cell == null)
            return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            default:
                return "";
        }
    }


    private static int getIntCell(Row row, int index) {
        Cell cell = row.getCell(index);

        if (cell == null) return 0;

        switch (cell.getCellType()) {
            case NUMERIC:
                return (int) cell.getNumericCellValue();

            case STRING:
                try {
                    return Integer.parseInt(cell.getStringCellValue());
                } catch (NumberFormatException e) {
                    return 0;
                }

            default:
                return 0;
        }
    }
}