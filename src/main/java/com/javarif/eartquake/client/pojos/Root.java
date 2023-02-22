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
public class Root{
    public boolean status;
    public int httpStatus;
    public int serverloadms;
    public String desc;
    public Metadata metadata;
    public ArrayList<Result> result;
}