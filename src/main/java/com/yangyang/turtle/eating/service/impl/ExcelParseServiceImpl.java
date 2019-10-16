package com.yangyang.turtle.eating.service.impl;

import com.yangyang.turtle.eating.dto.SheetTurtleInfo;
import com.yangyang.turtle.eating.service.ExcelParseService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service("excelParseService")
public class ExcelParseServiceImpl implements ExcelParseService {

    @Override
    public List<List<SheetTurtleInfo>> getTurtleEatingInfo(String path) {
        return null;
    }

    @Override
    public List<String> allBarCodes(String path) {
        try (
                FileInputStream is = new FileInputStream("");
                Workbook wb = new HSSFWorkbook(is)
        ) {
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                Sheet sheet = wb.getSheetAt(i);
                System.out.println(wb.getSheetName(i));
                for (Row row : sheet) {
                    System.out.println("rownum: " + row.getRowNum());
                    for (Cell cell : row) {
                        System.out.println(cell);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
