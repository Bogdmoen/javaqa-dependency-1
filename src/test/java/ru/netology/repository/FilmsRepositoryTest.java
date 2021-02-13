package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmUnit;


import static org.junit.jupiter.api.Assertions.*;

class FilmsRepositoryTest {

    @Test
    void save() {
        FilmsRepository repository = new FilmsRepository();
        FilmUnit first = new FilmUnit(1, 1, "first", 44, "url", "date");
        FilmUnit second = new FilmUnit(2, 2, "first", 12, "url", "date");
        FilmUnit third = new FilmUnit(3, 3, "first", 5, "url", "date");
        FilmUnit forth = new FilmUnit(4, 3, "first", 19, "url", "date");
        FilmUnit fifth = new FilmUnit(5, 3, "first", 44, "url", "date");
        FilmUnit sixth = new FilmUnit(6, 3, "first", 44, "url", "date");

        repository.save(first);
        repository.save(second);

        FilmUnit[] expected = repository.findAll();
        FilmUnit[]

    }

    @Test
    void findAll() {
    }

    @Test
    void removeById() {
    }
}