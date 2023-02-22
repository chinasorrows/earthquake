package com.javarif.eartquake.client.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result{
    public String earthquake_id;
    public String title;
    public String date;
    public String lokasyon;
    public double lat;
    public double lng;
    public double mag;
    public double depth;
    public ArrayList<Double> coordinates;
    public Geojson geojson;
    public LocationProperties location_properties;
    public Object rev;
    public String date_stamp;
    public String date_day;
    public String date_hour;
    public String timestamp;
    public String location_tz;
}
