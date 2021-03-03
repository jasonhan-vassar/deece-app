package com.vcplusplus.deeceapp;

import java.util.List;

public class Cafe {
    private String name;
    private List<List<DayPart>> dayparts;
    
    public List<DayPart> getDayParts() {
        // TODO: fix this terrible method :(
        // solve the double list formatting
        if (!dayparts.isEmpty()) {
            return dayparts.get(0);
        }
        return null;
    }

    public String toString() {
        if (dayparts.size() == 0) {
            return "\n    " + name + "\n";
        }

        String str = "\n    " + name + "\n";
        for (DayPart daypart : dayparts.get(0)) {
            str += "\t" + daypart.toString() + "\n";
        }
        return str;
    }
}
