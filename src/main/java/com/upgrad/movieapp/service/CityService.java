package com.upgrad.movieapp.service;

import com.upgrad.movieapp.entities.City;

import java.util.List;

public interface CityService {
    public City acceptCityDetails(City city);
    public List<City> acceptMultipleCityDetails(List<City> cities);
    public City updateCityDetails(int id, City city);
    public City getCityDetails(int id);
    public City getCityDetailsByCityName(String cityName);
    public boolean deleteCity(int id);
    public List<City> getAllCityDetails();
}
