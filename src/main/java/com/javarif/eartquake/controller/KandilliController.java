package com.javarif.eartquake.controller;

import com.javarif.eartquake.dto.Earthquake;
import com.javarif.eartquake.service.KandilliService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("earthquakes/v1")
public class KandilliController {

    private final KandilliService kandilliService;

    @GetMapping()
    public List<Earthquake> getEarthQuakes() {
        List<Earthquake> earthquakeData = kandilliService.getEarthquakes();

        if (CollectionUtils.isNotEmpty(earthquakeData)) {
            return earthquakeData;
        }
        return Collections.emptyList();
    }

    @GetMapping(value = "/{city}")
    public List<Earthquake> getEarthquakesByCity(@PathVariable String city) {
        List<Earthquake> earthquakeListByCity = kandilliService.getEarthquakeListByCity(city);
        if (CollectionUtils.isNotEmpty(earthquakeListByCity)) {
            return earthquakeListByCity;
        }
        return Collections.emptyList();
    }
}
