package com.example.actuatordemo.common;

import com.example.actuatordemo.movie.MovieService;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MovieMetrics {

    @Bean
    public MeterBinder movieCount(MovieService movieService) {
        return (meterRegistry) -> Gauge.builder("movies.count", movieService::getMovieCount).register(meterRegistry);
    }



}
