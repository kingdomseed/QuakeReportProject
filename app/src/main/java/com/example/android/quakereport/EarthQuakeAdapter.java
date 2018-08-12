package com.example.android.quakereport;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.graphics.drawable.GradientDrawable;

public class EarthQuakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthQuakeAdapter(Activity context, List<Earthquake> earthquakes) {

        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }

        Earthquake currentEarthquake = getItem(position);

        // Magnitude
        DecimalFormat formatter = new DecimalFormat("0.0");
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        String magnitudeFormat = formatter.format(currentEarthquake.getMagnitude());
        magnitudeTextView.setText(magnitudeFormat);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Location and Offset
        String location = currentEarthquake.getLocation();
        String primaryLocation;
        String offsetLocation;
        if(location.contains(" of "))
        {
            String[] locations = location.split(" of ");
            offsetLocation = locations[0] + " of ";
            primaryLocation = locations[1];

        } else
        {
            primaryLocation = location;
            offsetLocation = "Near the ";
        }
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        locationTextView.setText(primaryLocation);

        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.offset);
        offsetTextView.setText(offsetLocation);

        // Date and Time
        Date dateObject = new Date(currentEarthquake.getUnixTime());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

    private String formatDate(Date dateObject)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject)
    {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(double magnitude)
    {
        int magColor = 0;
        switch ((int)magnitude){
            case 1:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            case 10:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
            default:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
        }

        return magColor;
    }
}
