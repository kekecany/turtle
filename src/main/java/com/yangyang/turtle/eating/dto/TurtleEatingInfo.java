package com.yangyang.turtle.eating.dto;

import java.util.Date;

public class TurtleEatingInfo {
    /**
     * 甲鱼条形码
      */
    private String barCode;
    /**
     * 1：进食，2：吃药
     */
	private String eatType;
    /**
     * 进食日期
     */
	private Date eatDate;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getEatType() {
        return eatType;
    }

    public void setEatType(String eatType) {
        this.eatType = eatType;
    }

    public Date getEatDate() {
        return eatDate;
    }

    public void setEatDate(Date eatDate) {
        this.eatDate = eatDate;
    }
}
