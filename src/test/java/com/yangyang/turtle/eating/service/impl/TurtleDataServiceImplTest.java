package com.yangyang.turtle.eating.service.impl;

import com.yangyang.turtle.eating.TurtleEatingApplicationTests;
import com.yangyang.turtle.eating.dto.SheetTurtleInfo;
import com.yangyang.turtle.eating.service.ExcelParseService;
import com.yangyang.turtle.eating.service.TurtleDataService;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

public class TurtleDataServiceImplTest extends TurtleEatingApplicationTests {

    @Autowired
    private ExcelParseService excelParseService;
    @Autowired
    private TurtleDataService turtleDataService;

    @Test
    public void batchInsertEatingInfo() throws IOException, ParseException {
        List<SheetTurtleInfo> list = excelParseService.getTurtleEatingInfo(workbook());
        turtleDataService.batchInsertEatingInfo(list);
    }

    @Test
    public void batchInsert() throws IOException {
        List<String> allBarCodes = excelParseService.allBarCodes(workbook());
        turtleDataService.batchInsert(allBarCodes);
    }

    private Workbook workbook() throws IOException {
        String path = "C:/Users/kekec/Desktop/turtle.xlsx";
        FileInputStream is = new FileInputStream(path);
        return new XSSFWorkbook(is);
    }
}