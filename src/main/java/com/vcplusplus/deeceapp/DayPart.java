package com.vcplusplus.deeceapp;

import java.util.List;

public class DayPart {
    private String label;
    private String starttime;
    private String endtime;
    private List<Station> stations;
    
    public String getLabel() {
        return label;
    }
    
    public List<Station> getStations() {
        return stations;
    }

    public String toString() {
        String str = label + " (" + starttime + " - " + endtime + ")\n";
        for (Station station : stations) {
            str += "\t\t" + station + "\n";
        }
        return str;
    }
}
