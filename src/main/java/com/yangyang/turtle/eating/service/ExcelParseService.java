package com.yangyang.turtle.eating.service;

import com.yangyang.turtle.eating.dto.SheetTurtleInfo;

import java.util.List;

public interface ExcelParseService {

    List<List<SheetTurtleInfo>> getTurtleEatingInfo(String path);

    List<String> allBarCodes(String path);
}
