package com.example.actuatordemo.movie;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

interface MovieRepository extends Repository<Movie, UUID>, JpaSpecificationExecutor<Movie> {

    Movie save(Movie movie);

    void delete(Movie movie);

    Optional<Movie> findById(UUID uuid);

    Long count();

}
