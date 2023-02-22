package com.javarif.eartquake.client.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates{
    public String type;
    public ArrayList<Double> coordinates;
}
