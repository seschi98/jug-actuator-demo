package com.example.actuatordemo.movie;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;


@AllArgsConstructor
public class MovieSearchSpecification {

    public static Specification<Movie> build(MovieSearchParameter search) {
        return Specification.allOf(
                hasGenre(search.getGenre()),
                wasPublishedIn(search.getYear())
        );
    }

    private static Specification<Movie> hasGenre(Genre genre) {
        return ((root, query, cb) -> {
            if(genre == null) return cb.conjunction();

            return cb.equal(root.get("genre"), genre);
        });
    }

    private static Specification<Movie> wasPublishedIn(String year) {
        return ((root, query, cb) -> {
            if(year == null) return cb.conjunction();

            return cb.equal(root.get("year"), year);
        });
    }
}
