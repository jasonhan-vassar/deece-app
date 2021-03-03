package com.vcplusplus.deeceapp;

import java.util.List;

public class Station {
    private String label;
    private List<Integer> items;
    
    public String getLabel() {
        return label;
    }
    
    public List<Integer> getItems() {
        return items;
    }

    public String toString() {
        String str = label + "\n";
        for (Integer item : items) {
            str += "\t\t\t" + item + "\n";
        }
        return str;
    }
}
