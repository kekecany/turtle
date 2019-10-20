package com.yangyang.turtle.eating.service;

import com.yangyang.turtle.eating.dto.SheetTurtleInfo;
import org.apache.poi.ss.usermodel.Workbook;

import java.text.ParseException;
import java.util.List;

public interface ExcelParseService {

    List<SheetTurtleInfo> getTurtleEatingInfo(Workbook wb) throws ParseException;

    List<String> allBarCodes(Workbook wb);
}
