package com.javarif.eartquake.client.impl;

import com.google.gson.Gson;
import com.javarif.eartquake.client.KandilliClient;
import com.javarif.eartquake.client.pojos.Root;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultKandilliClient implements KandilliClient {

    private static final String API_URL = "https://api.orhanaydogdu.com.tr/deprem/kandilli/live?limit=1";
    private static final Logger LOG = LoggerFactory.getLogger(DefaultKandilliClient.class);

    @Override
    public Root getEarthquakeData() {

        URL url;
        InputStreamReader reader = null;
        try {

            url = new URL(API_URL);
            reader = new InputStreamReader(url.openStream());

        } catch (Exception e) {
            LOG.error("Exception Occurred while getting Earthquake data! Exception message: " + e.getMessage(),e);
            //do Nothing
        }
        if (Objects.nonNull(reader)) {
            return new Gson().fromJson(reader, Root.class);
        }
        return null;
    }
}
