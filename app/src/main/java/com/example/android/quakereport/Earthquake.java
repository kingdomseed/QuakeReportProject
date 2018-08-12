package com.example.android.quakereport;

public class Earthquake {

    private double magnitude;
    private String location;
    private long unixTime;
    private String url;

    public Earthquake(double mag, String loc, long time, String web) {
        magnitude = mag;
        location = loc;
        unixTime = time;
        url = web;
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

    public String getURL() {
        return url;
    }
}
