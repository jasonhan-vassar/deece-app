package com.vcplusplus.deeceapp;

import java.util.Map;

public class Day {
    private String date;
    private Map<Integer, Cafe> cafes;
    
    public String getDate() {
        return date;
    }
    
    public Map<Integer, Cafe> getCafes() {
        return cafes;
    }

    public String toString() {
        return "date: " + date + "; " + cafes.toString();
    }
}
