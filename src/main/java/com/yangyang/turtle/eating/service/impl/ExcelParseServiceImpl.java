package com.yangyang.turtle.eating.service.impl;

import com.yangyang.turtle.eating.constants.DateConstant;
import com.yangyang.turtle.eating.dto.SheetTurtleInfo;
import com.yangyang.turtle.eating.service.ExcelParseService;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("excelParseService")
public class ExcelParseServiceImpl implements ExcelParseService {

    @Override
    public List<SheetTurtleInfo> getTurtleEatingInfo(Workbook wb) throws ParseException {
        if (wb == null) return null;
        int sheetsNum = wb.getNumberOfSheets();
        List<SheetTurtleInfo> lists = new ArrayList<>(sheetsNum - 1);
        for (int i = 1; i < sheetsNum; i++) {
            Sheet sheet = wb.getSheetAt(i);
            List<String> barCodes = new ArrayList<>();
            for (Row row : sheet) {
                System.out.println("rowNum: " + row.getRowNum());
                for (Cell cell : row) {
                    System.out.println(cell);
                    barCodes.add(cell.getStringCellValue());
                }
            }
            String sheetName = sheet.getSheetName();
            Date eatDate = DateUtils.parseDate(sheetName.substring(0, sheetName.length() - 1),
                    DateConstant.DATE_PATTENS);
            SheetTurtleInfo sheetTurtleInfo = new SheetTurtleInfo(eatDate, barCodes);
            lists.add(sheetTurtleInfo);
        }
        return lists;
    }

    @Override
    public List<String> allBarCodes(Workbook wb) {
        if (wb == null) return null;
        // 获取到第一个sheet，即总的甲鱼数据
        Sheet sheet = wb.getSheetAt(0);
        if (sheet == null) return null;
        System.out.println(sheet.getSheetName());
        List<String> allBarCodes = new ArrayList<>();
        for (Row row : sheet) {
            System.out.println("rowNum: " + row.getRowNum());
            for (Cell cell : row) {
                System.out.println(cell);
                allBarCodes.add(cell.getStringCellValue());
            }
        }
        return allBarCodes;
    }

}
