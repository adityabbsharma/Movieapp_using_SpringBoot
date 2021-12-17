package com.upgrad.movieapp.service;

import java.util.List;
import com.upgrad.movieapp.entities.City;
import com.upgrad.movieapp.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    public CityDao cityDao;

    @Override
    public City acceptCityDetails(City city) {
        return cityDao.save(city);
    }

    @Override
    public List<City> acceptMultipleCityDetails(List<City> cities) {
        for (int i=0; i<cities.size(); i++) {
            cities.set(
                    i,
                    acceptCityDetails(cities.get(i))
            );
        }
        return cities;
    }

    @Override
    public City updateCityDetails(int id, City city) {
        City savedCity = getCityDetails(id);
        savedCity.setCityName(city.getCityName());
        acceptCityDetails(savedCity);
        return savedCity;
    }

    @Override
    public City getCityDetails(int id)  {
        return cityDao.findById(id).get();
    }

    @Override
    public City getCityDetailsByCityName(String cityName) {
        City savedCity = cityDao.findByCityName(cityName);
        return savedCity;
    }

    @Override
    public boolean deleteCity(int id){
        City savedCity = getCityDetails(id);
        cityDao.delete(savedCity);
        return true;
    }

    @Override
    public List<City> getAllCityDetails() {
        return cityDao.findAll();
    }
}