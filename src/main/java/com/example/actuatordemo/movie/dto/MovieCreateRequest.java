package com.example.actuatordemo.movie.dto;

import com.example.actuatordemo.movie.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MovieCreateRequest {

    @NotBlank
    private String title;

    @NotBlank
    @Pattern(regexp = "^\\d{4,}$")
    private String year;

    @NotNull
    private Genre genre;

    private String imdbId;

}
