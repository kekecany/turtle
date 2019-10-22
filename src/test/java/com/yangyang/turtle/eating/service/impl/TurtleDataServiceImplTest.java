package com.yangyang.turtle.eating.service.impl;

import com.yangyang.turtle.eating.TurtleEatingApplicationTests;
import com.yangyang.turtle.eating.service.ExcelParseService;
import com.yangyang.turtle.eating.service.TurtleDataService;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class TurtleDataServiceImplTest extends TurtleEatingApplicationTests {

    @Autowired
    private ExcelParseService excelParseService;
    @Autowired
    private TurtleDataService turtleDataService;

    @Test
    public void batchInsertEatingInfo() {
    }

    @Test
    public void batchInsert() throws IOException {
        String path = "C:/Users/kekec/Desktop/turtle.xlsx";
        FileInputStream is = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(is);
        List<String> allBarCodes = excelParseService.allBarCodes(wb);
        turtleDataService.batchInsert(allBarCodes);
    }
}