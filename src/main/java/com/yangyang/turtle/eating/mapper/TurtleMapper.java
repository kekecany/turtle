package com.yangyang.turtle.eating.mapper;

import com.yangyang.turtle.eating.dto.SheetTurtleInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Mapper
public interface TurtleMapper {

    @Delete("truncate bar_code_config")
    void deleteAllBarCodes();

    @InsertProvider(type = Provider.class, method = "batchInsertBarCodes")
    void batchInsertBarCodes(List<String> barCodes);

    @InsertProvider(type = Provider.class, method = "batchInsertEatingInfo")
    void batchInsertEatingInfo(List<SheetTurtleInfo>  turtleEatingInfoList);

    class Provider {
        public String batchInsertBarCodes(Map<String, Object> map) {
            List<String> barCodes = (List<String>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO bar_code_config (bar_code) VALUES ");
            MessageFormat mf = new MessageFormat("(#'{'list[{0,number,#}]})");

            for (int i = 0; i < barCodes.size(); i++) {
                sb.append(mf.format(new Object[] {i}));
                sb.append(",");
            }
            return sb.substring(0, sb.length() - 1);
        }

        public String batchInsertEatingInfo(Map<String, Object> map) {
            List<SheetTurtleInfo>  turtleEatingInfoList = (List<SheetTurtleInfo> ) map.get("list");

            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO eating_info (eat_date,bar_code) VALUES ");
            MessageFormat mf = new MessageFormat("(#'{'list[{0,number,#}].eatDate}, #'{'list[{0,number,#}].barCode})");

            for (int i = 0; i < turtleEatingInfoList.size(); i++) {
                sb.append(mf.format(new Object[] {i}));
                sb.append(",");
            }
            return sb.substring(0, sb.length() - 1);
        }
    }


}
