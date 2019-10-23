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
import java.util.Calendar;
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
            String sheetName = sheet.getSheetName();
            Date eatDate = eatDate(sheetName);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    SheetTurtleInfo sheetTurtleInfo = new SheetTurtleInfo(eatDate, cell.getStringCellValue());
                    lists.add(sheetTurtleInfo);
                }
            }
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
            for (Cell cell : row) {
                allBarCodes.add(cell.getStringCellValue().trim());
            }
        }
        return allBarCodes;
    }

    private Date eatDate(String sheetName) throws ParseException {
        Date date = DateUtils.parseDate(sheetName.substring(0, sheetName.length() - 1),
                DateConstant.DATE_PATTENS);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

}
