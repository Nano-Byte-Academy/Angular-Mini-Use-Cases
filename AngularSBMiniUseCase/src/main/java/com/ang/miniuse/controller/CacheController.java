package com.ang.miniuse.controller;

import com.ang.miniuse.dto.CityDto;
import com.ang.miniuse.dto.StateDto;
import com.ang.miniuse.entities.City;
import com.ang.miniuse.entities.Country;
import com.ang.miniuse.entities.State;
import com.ang.miniuse.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/getCountriesData")
    public ResponseEntity<List<Country>> getCountriesData() {
        return ResponseEntity.ok(cacheService.getCountryList());
    }

    @GetMapping("/getStatesData")
    public ResponseEntity<List<StateDto>> getStatesData() {
        return ResponseEntity.ok(cacheService.getStateList());
    }

    @GetMapping("/getCitiesData")
    public ResponseEntity<List<CityDto>> getCitiesData() {
        return ResponseEntity.ok(cacheService.getCityList());
    }

}
