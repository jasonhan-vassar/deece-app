package com.vcplusplus.deeceapp;

import java.util.Map;

public class Item {
    private String label;
    private Map<Integer, String> cor_icon;
    
    public Map<Integer, String> getCorIcons() {
        return cor_icon;
    }

    public String toString() {
        return label;
    }
}
