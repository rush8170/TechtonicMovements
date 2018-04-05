package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by vaibhav on 03-01-2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View ConvertView, ViewGroup parent) {
        View listItemView = ConvertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }
        Earthquake currentEarthquake = getItem(position);
        TextView MagnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        String output=decimalFormat.format(currentEarthquake.getMagnitude());
        GradientDrawable magnitudeCircle=(GradientDrawable)MagnitudeView.getBackground();
        int magnitudeColor=getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        MagnitudeView.setText(output);

        String completeLocation= (String) currentEarthquake.getLocation();
        String primaryLocation,OffsetLocation;
        if(completeLocation.contains(" of "))
        {
            String[] parts=completeLocation.split(" of ");
            primaryLocation=parts[0]+"  of ";
            OffsetLocation=parts[1];
        }
        else
        {
            primaryLocation="Near the";
            OffsetLocation=completeLocation;
        }
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);
        TextView offsetLocationView = (TextView) listItemView.findViewById(R.id.offset_location);
        offsetLocationView.setText(OffsetLocation);

        TextView DateView = (TextView) listItemView.findViewById(R.id.date);
        long timeInMilliSec=currentEarthquake.getDate();
        Date dateObj=new Date(timeInMilliSec);
        String formatteddate=formatDate(dateObj);
        DateView.setText(formatteddate);
        TextView timeView=(TextView)listItemView.findViewById(R.id.time);
        String formattedtime=formatTime(dateObj);
        timeView.setText(formattedtime);
        return listItemView;
    }
    public String formatDate(Date dateobj)
    {
        SimpleDateFormat dateFormat=new SimpleDateFormat("LLL dd,yyyy");
        return dateFormat.format(dateobj);
    }
    public String formatTime(Date dateobj)
    {
        SimpleDateFormat timeFormat=new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateobj);
    }
    public int getMagnitudeColor(double magnitude)
    {
        switch((int)magnitude)
        {
            case 1: return ContextCompat.getColor(getContext(),R.color.magnitude1);

            case 2: return ContextCompat.getColor(getContext(),R.color.magnitude2);

            case 3: return ContextCompat.getColor(getContext(),R.color.magnitude3);

            case 4: return ContextCompat.getColor(getContext(),R.color.magnitude4);

            case 5: return ContextCompat.getColor(getContext(),R.color.magnitude5);

            case 6: return ContextCompat.getColor(getContext(),R.color.magnitude6);

            case 7: return ContextCompat.getColor(getContext(),R.color.magnitude7);

            case 8: return ContextCompat.getColor(getContext(),R.color.magnitude8);

            case 9: return ContextCompat.getColor(getContext(),R.color.magnitude9);

            case 10: return ContextCompat.getColor(getContext(),R.color.magnitude10);

            default:return R.color.colorPrimary;
        }
    }
}