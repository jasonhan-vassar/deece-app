package com.vcplusplus.deeceapp;

import java.util.List;
import java.util.Map;

public class Response {
    private Day[] days;
    private Map<Integer, Item> items;
    private int version;

    public Day[] getDays() {
        return days;
    }

    public Map<Integer, Item> getItems() {
        return items;
    }
    
    public int getVersion() {
        return version;
    }

    public String toString() {
        String str = "";
        for (Day day : days) {
            str += day + "\n";
        }
        // for (Integer key : items.keySet()) {
        //     System.out.println(key + " = " + items.get(key));
        // }
        str += "\nversion = " + version;
        return str;
    }
}
