package com.upgrad.movieapp.service;
        import com.upgrad.movieapp.dao.MovieDao;
        import com.upgrad.movieapp.entities.Movie;
        import java.util.ArrayList;
        import java.util.List;
        import javax.transaction.Transactional;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.stereotype.Service;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    public MovieDao _movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        return _movieDao.save(movie);
    }

    @Override
    @Transactional
    public List<Movie> acceptMultipleMovieDetails(List<Movie> movies) {
        List<Movie> savedMovies = new ArrayList<>();
        for(Movie movie : movies){
            savedMovies.add(acceptMovieDetails(movie));
        }
        return savedMovies;
    }

    @Override
    public Movie getMovieDetails(int id) {
        return _movieDao.findById(id).get();
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) {

        Movie savedMovie = getMovieDetails(id);

        savedMovie.setMovieName(movie.getMovieName());
        savedMovie.setDuration(movie.getDuration());
        savedMovie.setTrailerUrl(movie.getTrailerUrl());
        savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        savedMovie.setReleaseDate(movie.getReleaseDate());
        savedMovie.setMovieDescription(movie.getMovieDescription());
        return _movieDao.save(savedMovie);
    }

    @Override
    public boolean deleteMovie(int id) {

        Movie savedMovie = getMovieDetails(id);

        if(savedMovie ==null){
            return false ;
        }
        _movieDao.delete(savedMovie);
        return true ;
    }

    @Override
    public List<Movie> getAllMovies() {
        return _movieDao.findAll();
    }

    @Override
    public Page<Movie> getPaginatedMovieDetails(Pageable pageRequest) {
        return _movieDao.findAll(pageRequest);
    }
}
