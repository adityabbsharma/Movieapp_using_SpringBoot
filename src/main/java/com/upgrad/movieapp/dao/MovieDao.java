package com.upgrad.movieapp.dao;

import com.upgrad.movieapp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends JpaRepository<Movie,Integer> {

}
