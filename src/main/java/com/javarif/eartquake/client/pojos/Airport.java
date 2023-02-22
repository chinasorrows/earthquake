package com.javarif.eartquake.client.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Airport{
    public double distance;
    public String name;
    public String code;
    public Coordinates coordinates;
}