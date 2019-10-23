package com.yangyang.turtle.eating.dto;

import java.util.Date;

public class SheetTurtleInfo {

    private Date eatDate;

    private String barCode;

    public SheetTurtleInfo() {
    }

    public SheetTurtleInfo(Date eatingDate, String barCodes) {
        this.eatDate = eatingDate;
        this.barCode = barCodes;
    }

    public Date getEatDate() {
        return eatDate;
    }

    public void setEatDate(Date eatDate) {
        this.eatDate = eatDate;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
