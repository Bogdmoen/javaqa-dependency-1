package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmUnit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FilmFeedManagerDefaultTest {

    FilmFeedManager manager = new FilmFeedManager();
    private FilmUnit first = new FilmUnit(1, 1, "first", 44, "url", "date");
    private FilmUnit second = new FilmUnit(2, 2, "first", 44, "url", "date");
    private FilmUnit third = new FilmUnit(3, 3, "first", 44, "url", "date");
    private FilmUnit forth = new FilmUnit(4, 3, "first", 44, "url", "date");
    private FilmUnit fifth = new FilmUnit(5, 3, "first", 44, "url", "date");
    private FilmUnit sixth = new FilmUnit(6, 3, "first", 44, "url", "date");
    private FilmUnit seventh = new FilmUnit(7, 3, "first", 44, "url", "date");
    private FilmUnit eighth = new FilmUnit(8, 3, "first", 44, "url", "date");
    private FilmUnit ninth = new FilmUnit(9, 3, "first", 44, "url", "date");
    private FilmUnit tenth = new FilmUnit(10, 3, "first", 46, "url", "date");
    private FilmUnit eleventh = new FilmUnit(11, 3, "first", 45, "url", "date");
    private FilmUnit twelfth = new FilmUnit(12, 3, "first", 44, "url", "date");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 4;
        manager.removeById(idToRemove);

        FilmUnit[] actual = manager.getAll();
        FilmUnit[] expected = new FilmUnit[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, third, second, first};


        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 15;

        manager.removeById(idToRemove);

        FilmUnit[] actual = manager.getAll();
        FilmUnit[] expected = new FilmUnit[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetFilmFeed() {

        FilmUnit[] actual = manager.getFilmList();
        FilmUnit[] expected = new FilmUnit[] {twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third};

        assertArrayEquals(expected, actual);
    }


}