package com.yangyang.turtle.eating.service.impl;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DateUtilsTest {

    @Test
    public void dateTrans() throws ParseException {
        String str = "9.24";
        String[] DATE_PATTENS = {"yyyy-MM-dd", "yyyy.MM.dd", "MM.dd"};
        Date date = DateUtils.parseDate(str, DATE_PATTENS);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, year);
        System.out.println(calendar.getTime());
    }
}
