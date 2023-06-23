package com.example.actuatordemo.movie;

import com.example.actuatordemo.movie.exception.MovieNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public Movie getMovieById(UUID uuid) {
        return repository.findById(uuid).orElseThrow(MovieNotFoundException::new);
    }

    @Transactional
    public Movie createMovie(String title, String year, Genre genre, String imdbId) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setGenre(genre);
        movie.setImdbId(imdbId);

        return repository.save(movie);
    }

    @Transactional
    public Movie updateMovie(UUID id, String title, String year, Genre genre, String imdbId) {
        Movie movieById = getMovieById(id);

        movieById.setTitle(title);
        movieById.setYear(year);
        movieById.setGenre(genre);
        movieById.setImdbId(imdbId);

        return repository.save(movieById);
    }

    public Page<Movie> search(Integer pageNo, Integer pageSize, MovieSearchParameter params) {
        Pageable page = PageRequest.of(pageNo, pageSize);
        Specification<Movie> spec = MovieSearchSpecification.build(params);

        return repository.findAll(spec, page);
    }

    @Transactional
    public void deleteMovie(UUID id) {
        Movie movieById = getMovieById(id);
        repository.delete(movieById);
    }

    public long getMovieCount() {
        return repository.count();
    }
}
