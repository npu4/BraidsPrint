package com.github.npu4.braidpaint.braid;

import com.github.npu4.braidpaint.braid.stringCharcteristics.StringType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BraidString {
    StringType stringType;
    int index;
    public List<Point> points = new ArrayList<>(); // points for drawing braid

    public BraidString(StringType stringType) {
        this.stringType = stringType;
    }

    public StringType getStringType() {
        return stringType;
    }

    public void setStringType(StringType stringType) {
        this.stringType = stringType;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
