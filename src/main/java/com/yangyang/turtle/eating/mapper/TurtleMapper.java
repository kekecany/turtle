package com.yangyang.turtle.eating.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TurtleMapper {

    @Delete("delete from bar_code_config")
    void deleteAllBarCodes();


}
