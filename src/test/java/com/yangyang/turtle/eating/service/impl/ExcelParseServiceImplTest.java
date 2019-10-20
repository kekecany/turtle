package com.yangyang.turtle.eating.service.impl;

import com.yangyang.turtle.eating.TurtleEatingApplicationTests;
import com.yangyang.turtle.eating.dto.SheetTurtleInfo;
import com.yangyang.turtle.eating.service.ExcelParseService;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class ExcelParseServiceImplTest extends TurtleEatingApplicationTests {

    @Autowired
    private ExcelParseService excelParseService;

    @Test
    public void allBarCodes() throws IOException, ParseException {
        String path = "C:/Users/kekec/Desktop/turtle.xlsx";
        FileInputStream is = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(is);
        List<String> allBarCodes = excelParseService.allBarCodes(wb);
        List<SheetTurtleInfo> list = excelParseService.getTurtleEatingInfo(wb);


    }
}