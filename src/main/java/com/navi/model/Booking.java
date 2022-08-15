package com.navi.model;


class Booking{
    public Booking(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }
    private Integer start;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    private Integer end;
}