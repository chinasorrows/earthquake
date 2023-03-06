package com.javarif.eartquake.client.impl;

import com.google.gson.Gson;
import com.javarif.eartquake.client.KandilliClient;
import com.javarif.eartquake.client.pojos.Result;
import com.javarif.eartquake.client.pojos.Root;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.javarif.eartquake.util.ClientConstants.BASE_API_URL;

@Component
public class DefaultKandilliClient implements KandilliClient {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultKandilliClient.class);


    @Override
    public List<Result> getEarthquakeData() {

        URL url;
        InputStreamReader reader = null;
        try {

            url = new URL(BASE_API_URL);
            reader = new InputStreamReader(url.openStream());

            Root root = new Gson().fromJson(reader, Root.class);

            int responseCode = root.getHttpStatus();
            if (!Objects.equals(200,responseCode)) {
                LOG.error("Http Response -> " + responseCode);
                return null;
            } else {
                return root.getResult();
            }

        } catch (Exception e) {
            LOG.error("Exception Occurred while getting Earthquake data! Exception message: " + e.getMessage(), e);
            //do Nothing
        }
        return null;
    }
}
