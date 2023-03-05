package com.javarif.eartquake.controller;

import com.javarif.eartquake.dto.Earthquake;
import com.javarif.eartquake.service.KandilliService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("earthquakes/v1")
public class KandilliController {

    private final KandilliService kandilliService;

    @GetMapping
    public List<Earthquake> getEarthQuakes() {
        List<Earthquake> earthquakeData = kandilliService.getEarthquakes();

        if (CollectionUtils.isNotEmpty(earthquakeData)) {
            return earthquakeData;
        }
        return null;
    }
}
