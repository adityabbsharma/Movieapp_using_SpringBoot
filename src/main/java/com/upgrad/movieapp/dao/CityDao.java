package com.upgrad.movieapp.dao;

import com.upgrad.movieapp.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends JpaRepository<City,Integer> {
    public City findByCityName(String name);

}
