package com.javarif.eartquake.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Earthquake {
    private String title;
    private double magnitude;
    private String date;
    private String earthquakeId;
}
