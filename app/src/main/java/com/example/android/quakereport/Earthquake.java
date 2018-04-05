package com.example.android.quakereport;

/**
 * Created by vaibhav on 03-01-2018.
 */
public class Earthquake {
    private double magnitude;
    private CharSequence location;
    private long date;
    private String url;
    public Earthquake(double magnitude,CharSequence location,long date,String url)
    {
        this.magnitude=magnitude;
        this.location=location;
        this.date=date;
        this.url=url;
    }
    public double getMagnitude(){
        return magnitude;
    }

    public CharSequence getLocation() {
        return location;
    }

    public Long getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}
