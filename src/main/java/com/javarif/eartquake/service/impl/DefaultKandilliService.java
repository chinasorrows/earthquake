package com.javarif.eartquake.service.impl;

import com.javarif.eartquake.client.KandilliClient;
import com.javarif.eartquake.client.pojos.Result;
import com.javarif.eartquake.dto.Earthquake;
import com.javarif.eartquake.service.KandilliService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultKandilliService implements KandilliService {
    private final KandilliClient kandilliClient;

    @Override
    public List<Earthquake> getEarthquakes() {

        List<Result> earthquakes = kandilliClient.getEarthquakeData();
        List<Earthquake> earthquakeList = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(earthquakes)) {
            for (Result earthquakeData : earthquakes) {
                Earthquake earthquake = new Earthquake();
                earthquake.setEarthquakeId(earthquakeData.getEarthquake_id());
                earthquake.setTitle(earthquakeData.getTitle());
                earthquake.setMagnitude(earthquakeData.getMag());
                earthquake.setDate(earthquakeData.getDate());
                earthquakeList.add(earthquake);
            }
        }
        return earthquakeList;
    }
}
