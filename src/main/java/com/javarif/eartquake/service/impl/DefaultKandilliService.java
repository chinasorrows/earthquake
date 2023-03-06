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
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultKandilliService implements KandilliService {
    private final KandilliClient kandilliClient;

    private List<Earthquake> getAllEarthquakes() {
        List<Result> earthquakes = kandilliClient.getEarthquakeData();
        List<Earthquake> earthquakeList = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(earthquakes)) {
            populateEarthquakes(earthquakes, earthquakeList);
        }
        return earthquakeList;
    }

    @Override
    public List<Earthquake> getEarthquakes() {
        return getAllEarthquakes();
    }

    @Override
    public List<Earthquake> getEarthquakeListByCity(String city) {
        List<Earthquake> earthquakeList = getAllEarthquakes();

        return earthquakeList.stream()
                .filter(earthquake -> Pattern.compile(Pattern.quote(city), Pattern.CASE_INSENSITIVE)
                        .matcher(earthquake.getTitle())
                        .find())
                .collect(Collectors.toList());
    }

    private void populateEarthquakes(List<Result> earthquakes, List<Earthquake> earthquakeList) {
        for (Result earthquakeData : earthquakes) {
            Earthquake earthquake = new Earthquake();
            earthquake.setEarthquakeId(earthquakeData.getEarthquake_id());
            earthquake.setTitle(earthquakeData.getTitle());
            earthquake.setMagnitude(earthquakeData.getMag());
            earthquake.setDate(earthquakeData.getDate());
            earthquakeList.add(earthquake);
        }
    }
}
