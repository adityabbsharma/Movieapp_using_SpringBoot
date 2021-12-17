package com.upgrad.movieapp.dao;

import com.upgrad.movieapp.entities.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreDao extends JpaRepository<Theatre,Integer> {
    public Theatre findByTheatreName(String name);
}
