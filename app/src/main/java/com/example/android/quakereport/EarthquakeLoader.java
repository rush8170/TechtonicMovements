package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhav on 31-03-2018.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    String url1;
    public EarthquakeLoader(Context context,String url){
        super(context);
        url1=url;
        //do something with the url
    }
    @Override
    public void onStartLoading(){
        forceLoad();
    }
    @Override
    public List<Earthquake> loadInBackground() {
        //return null;
        //List<Earthquake> earthquakes=new ArrayList<>();
        //earthquakes=QueryUtils.fetchEarthquakedata(url1);
        if(url1==null)
        {
            return null;
        }
        List<Earthquake> earth=QueryUtils.fetchEarthquakedata(url1);
        return earth;
    }
}
