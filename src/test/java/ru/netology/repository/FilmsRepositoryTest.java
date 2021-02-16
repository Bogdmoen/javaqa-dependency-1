package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmUnit;


import static org.junit.jupiter.api.Assertions.*;

class FilmsRepositoryTest {
    FilmsRepository repository = new FilmsRepository();
    FilmUnit first = new FilmUnit(1, 1, "first", 44, "url", "date");
    FilmUnit second = new FilmUnit(2, 2, "first", 12, "url", "date");
    FilmUnit third = new FilmUnit(3, 3, "first", 5, "url", "date");
    FilmUnit forth = new FilmUnit(4, 3, "first", 19, "url", "date");
    FilmUnit fifth = new FilmUnit(5, 3, "first", 44, "url", "date");
    FilmUnit sixth = new FilmUnit(6, 3, "first", 44, "url", "date");

    @Test
    public void shouldSave() {

        repository.save(first);
        repository.save(second);
        repository.save(third);

        FilmUnit[] actual = repository.findAll();
        FilmUnit[] expected = new FilmUnit[] {first, second, third};

        assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldFindById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);

        FilmUnit[] actual = repository.findById(4);
        FilmUnit[] expected = new FilmUnit[] {forth};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldNotFindNonExistentId() {

        repository.save(first);

        FilmUnit[] actual = repository.findById(2);
        FilmUnit[] expected = null;

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveById() {

        repository.save(first);
        repository.save(second);
        repository.save(third);

        repository.removeById(2);

        FilmUnit[] actual = repository.findAll();
        FilmUnit[] expected = new FilmUnit[] {first, third};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotRemoveNonExistedId() {

        repository.save(first);
        repository.save(second);
        repository.save(third);

        repository.removeById(4);

        FilmUnit[] actual = repository.findAll();
        FilmUnit[] expected = new FilmUnit[] {first, second, third};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveAll() {

        repository.save(first);
        repository.save(second);

        FilmUnit[] actual = repository.removeAll();
        FilmUnit[] expected = new FilmUnit[0];

        assertArrayEquals(expected, actual);
    }

}