package org.swaeba;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.swaeba.dao.UniversityDAO;
import org.swaeba.model.University;
import org.swaeba.util.ExcelReader;

import java.io.FileInputStream;
import java.util.List;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     List<University> list= ExcelReader.readExcel("universities.xlsx");
        UniversityDAO.insertData(list);
        System.out.println("Data inserted successfully!");
    }
}