package org.swaeba.util;

import org.swaeba.model.University;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<University> readExcel(String filePath) {

        List<University> list = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                // Skip header row
                if (row.getRowNum() == 0) continue;

                int id = (int) row.getCell(0).getNumericCellValue();
                String name = row.getCell(1).getStringCellValue();
                String program = row.getCell(2).getStringCellValue();
                String city = row.getCell(3).getStringCellValue();
                String country = row.getCell(4).getStringCellValue();
                int ranking = (int) row.getCell(5).getNumericCellValue();
                int fee = (int) row.getCell(6).getNumericCellValue();
                int duration = (int) row.getCell(7).getNumericCellValue();

                // Create object
                University uni = new University(
                        id, name, program,
                        city, country,
                        ranking, fee, duration
                );

                // Add to list
                list.add(uni);
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}