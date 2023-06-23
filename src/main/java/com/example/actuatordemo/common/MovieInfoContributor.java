package com.example.actuatordemo.common;

import com.example.actuatordemo.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieInfoContributor implements InfoContributor {

    private final MovieService service;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("test", "abc");
        builder.withDetail("movieCount", service.getMovieCount());
    }
}
