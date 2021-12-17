package com.upgrad.movieapp.entities;


import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class Theatre {
    @Id
    @GeneratedValue
    private int theatreId;
    @Column(length = 20, nullable = false, unique = true)
    private String theatreName;
    @Column(nullable = false)
    private float ticketPrice = 150.00f;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @ManyToMany
//    @JoinTable
    @JoinTable(name="theatre_movieTable",joinColumns = @JoinColumn(name="theatre_count"),inverseJoinColumns = @JoinColumn(name =
    "movie_count"))
    private Set<Movie> movies;

    public int getTheatreId() {
        return theatreId;
    }

    private Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Theatre{" + "theatreId=" + theatreId + ", theatreName='" + theatreName + '\'' + ", ticketPrice="
                + ticketPrice + ", city=" + city.getCityName() + ", movies=" + this.getMovies().toString() + '}';
    }
}
