package com.yangyang.turtle.eating.service.impl;

import com.yangyang.turtle.eating.dto.TurtleEatingInfo;
import com.yangyang.turtle.eating.mapper.TurtleMapper;
import com.yangyang.turtle.eating.service.TurtleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("turtleDataService")
public class TurtleDataServiceImpl implements TurtleDataService {

    @Autowired
    private TurtleMapper turtleMapper;

    @Override
    public void batchInsertEatingInfo(List<TurtleEatingInfo> turtleEatingInfoList) {

    }

    @Override
    public void batchInsert(List<String> barCodes) {
        turtleMapper.deleteAllBarCodes();
        turtleMapper.batchInsertBarCodes(barCodes);
    }
}
