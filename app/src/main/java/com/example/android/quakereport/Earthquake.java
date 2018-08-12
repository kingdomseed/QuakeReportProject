package com.example.android.quakereport;

public class Earthquake {

    private double magnitude;
    private String location;
    private long unixTime;

    public Earthquake(double mag, String loc, long time) {
        magnitude = mag;
        location = loc;
        unixTime = time;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getUnixTime() {
        return unixTime;
    }
}
