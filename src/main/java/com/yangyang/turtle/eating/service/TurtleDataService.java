package com.yangyang.turtle.eating.service;

import com.yangyang.turtle.eating.dto.SheetTurtleInfo;

import java.util.List;

public interface TurtleDataService {

    void batchInsertEatingInfo(List<SheetTurtleInfo> list);

    void batchInsert(List<String> barCodes);
}
