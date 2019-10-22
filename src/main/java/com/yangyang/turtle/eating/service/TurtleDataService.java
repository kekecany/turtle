package com.yangyang.turtle.eating.service;

import com.yangyang.turtle.eating.dto.TurtleEatingInfo;

import java.util.List;

public interface TurtleDataService {

    void batchInsertEatingInfo(List<TurtleEatingInfo> turtleEatingInfoList);

    void batchInsert(List<String> barCodes);
}
