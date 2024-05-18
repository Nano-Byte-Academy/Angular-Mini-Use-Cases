package com.ang.miniuse.service;

import com.ang.miniuse.dto.CityDto;
import com.ang.miniuse.dto.StateDto;
import com.ang.miniuse.entities.City;
import com.ang.miniuse.entities.Country;
import com.ang.miniuse.entities.State;

import java.util.List;

public interface CacheService {

    List<Country> getCountryList();
    List<StateDto> getStateList();
    List<CityDto> getCityList();

}
