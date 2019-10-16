package com.yangyang.turtle.eating.dto;

import java.util.Date;
import java.util.List;

public class SheetTurtleInfo {

    private Date eatingDate;

    private List<String> barcodeList;

    public Date getEatingDate() {
        return eatingDate;
    }

    public void setEatingDate(Date eatingDate) {
        this.eatingDate = eatingDate;
    }

    public List<String> getBarcodeList() {
        return barcodeList;
    }

    public void setBarcodeList(List<String> barcodeList) {
        this.barcodeList = barcodeList;
    }
}
