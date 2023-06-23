package com.example.actuatordemo.movie;

import com.example.actuatordemo.movie.dto.MovieCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listMovies(@RequestParam(defaultValue = "0") Integer pageNo,
                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                        @RequestParam(required = false) Genre genre,
                                        @RequestParam(required = false) String year) {
        var searchParams = new MovieSearchParameter();
        searchParams.setGenre(genre);
        searchParams.setYear(year);

        return ResponseEntity.ok(service.search(pageNo, pageSize, searchParams));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMovieById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getMovieById(id));
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createMovie(@RequestBody @Valid MovieCreateRequest request) {
        return ResponseEntity.ok(service.createMovie(request.getTitle(), request.getYear(), request.getGenre(), request.getImdbId()));
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMovie(@PathVariable UUID id, @RequestBody @Valid MovieCreateRequest request) {
        return ResponseEntity.ok(service.updateMovie(id, request.getTitle(), request.getYear(), request.getGenre(), request.getImdbId()));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteMovie(@PathVariable UUID id) {
        service.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

}
