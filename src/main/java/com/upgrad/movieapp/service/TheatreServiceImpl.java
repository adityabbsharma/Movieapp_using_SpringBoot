package com.upgrad.movieapp.service;

import java.util.List;
import com.upgrad.movieapp.entities.Theatre;
import com.upgrad.movieapp.dao.TheatreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    private TheatreDao theatreDao;

    @Override
    public Theatre acceptTheatreDetails(Theatre theatre) {
        return theatreDao.save(theatre);
    }

    @Override
    public Theatre getTheatreDetails(int id)  {
        return theatreDao.findById(id).get();

    }

    @Override
    public Theatre updateTheatreDetails(int id, Theatre theatre) {
        Theatre savedTheatre = getTheatreDetails(id);

        if (isNotNullOrZero(theatre.getTheatreName())) {
            savedTheatre.setTheatreName(theatre.getTheatreName());
        }
        if (isNotNullOrZero(theatre.getTicketPrice())) {
            savedTheatre.setTicketPrice(theatre.getTicketPrice());
        }
        if (isNotNullOrZero(theatre.getCity())) {
            savedTheatre.setCity(theatre.getCity());
        }

        return theatreDao.save(theatre);
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }

    private boolean isNotNullOrZero(int val) {
        return val != 0;
    }

    private boolean isNotNullOrZero(float val) {
        return val >= 0.1f;
    }

    @Override
    public boolean deleteTheatre(int id){
        Theatre savedTheatre = getTheatreDetails(id);
        theatreDao.delete(savedTheatre);
        return true;
    }

    @Override
    public List<Theatre> getAllTheatreDetails() {
        return theatreDao.findAll();
    }
}
