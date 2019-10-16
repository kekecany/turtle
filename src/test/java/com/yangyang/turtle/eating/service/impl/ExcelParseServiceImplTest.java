package com.yangyang.turtle.eating.service.impl;

import com.yangyang.turtle.eating.TurtleEatingApplicationTests;
import com.yangyang.turtle.eating.service.ExcelParseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ExcelParseServiceImplTest extends TurtleEatingApplicationTests {

    @Autowired
    private ExcelParseService excelParseService;

    @Test
    public void allBarCodes() {
        String path = "C:/Users/kekec/Desktop/Turtle.xls";
        excelParseService.allBarCodes(path);

    }
}