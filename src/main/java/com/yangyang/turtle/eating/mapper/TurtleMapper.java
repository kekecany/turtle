package com.yangyang.turtle.eating.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Mapper
public interface TurtleMapper {

    @Delete("delete from bar_code_config")
    void deleteAllBarCodes();

    @InsertProvider(type = Provider.class, method = "batchInsertBarCodes")
    void batchInsertBarCodes(List<String> barCodes);

    class Provider {
        public String batchInsertBarCodes(Map<String, Object> map) {
            List<String> barCodes = (List<String>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO bar_code_config (bar_code) VALUES ");
            MessageFormat mf = new MessageFormat("(#'{'list[{0}]})");

            for (int i = 0; i < barCodes.size(); i++) {
                sb.append(mf.format(new Object[] {i}));
                sb.append(",");
            }
            sb.substring(0, sb.length() - 1);
            return sb.toString();
        }
    }


}
