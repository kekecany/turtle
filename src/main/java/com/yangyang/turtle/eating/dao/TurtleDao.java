package com.yangyang.turtle.eating.dao;

import com.yangyang.turtle.eating.dto.TurtleEatingInfo;

import java.util.List;

public interface TurtleDao {

    void batchInsertEatingInfo(List<TurtleEatingInfo> turtleEatingInfoList);

    void batchInsert(List<String> barCodes);
}
