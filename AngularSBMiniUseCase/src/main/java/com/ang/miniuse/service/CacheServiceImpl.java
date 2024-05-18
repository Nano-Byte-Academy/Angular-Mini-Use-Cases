package com.ang.miniuse.service;

import com.ang.miniuse.dto.CityDto;
import com.ang.miniuse.dto.StateDto;
import com.ang.miniuse.entities.City;
import com.ang.miniuse.entities.Country;
import com.ang.miniuse.entities.State;
import com.ang.miniuse.repository.CityRepository;
import com.ang.miniuse.repository.CountryRepository;
import com.ang.miniuse.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CacheServiceImpl implements CacheService {

    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    public CacheServiceImpl(CountryRepository countryRepository,
                            StateRepository stateRepository,
                            CityRepository cityRepository) {
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
    }

    public List<Country> getCountryList() {
        return countryRepository.findAll();
    }

    public List<StateDto> getStateList() {
        List<State> stateList = stateRepository.findAll();
        List<StateDto> stateJsonList = stateList.stream()
                .map(state -> {
                    StateDto stateDto = new StateDto();
                    stateDto.setId(state.getId());
                    stateDto.setName(state.getName());
                    stateDto.setCountry_id(state.getCountry().getId());
                    return stateDto;
                })
                .collect(Collectors.toList());
        return stateJsonList;
    }

    public List<CityDto> getCityList() {
        List<City> cityList = cityRepository.findAll();
        List<CityDto> cityJsonList = cityList.stream()
                .map(city -> {
                    CityDto cityDto = new CityDto();
                    cityDto.setId(city.getId());
                    cityDto.setName(city.getName());
                    cityDto.setState_id(city.getState().getId());
                    return cityDto;
                })
                .collect(Collectors.toList());
        return cityJsonList;
    }

}
