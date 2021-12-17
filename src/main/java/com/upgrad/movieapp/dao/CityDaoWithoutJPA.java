package com.upgrad.movieapp.dao;

import com.upgrad.movieapp.entities.City;

public interface CityDaoWithoutJPA {
    public City save(City city);
    public City findByCityId(int id);
    public City update(City city);
    public void delete(City city);
}
