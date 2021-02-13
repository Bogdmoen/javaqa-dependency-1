package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmUnit {
    private int id;
    private int filmId;
    private String name;
    private int genreId;
    private String imageUrl;
    private String releaseDate;
}
