package com.upgrad.movieapp.service;

import com.upgrad.movieapp.entities.Theatre;
import java.util.List;

public interface TheatreService {
    public Theatre acceptTheatreDetails(Theatre theatre);
    public Theatre getTheatreDetails(int id);
    public Theatre updateTheatreDetails(int id, Theatre theatre);
    public boolean deleteTheatre(int id);
    public List<Theatre> getAllTheatreDetails();
}
