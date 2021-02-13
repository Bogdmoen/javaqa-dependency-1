package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmUnit;

import static org.junit.jupiter.api.Assertions.*;

class FilmFeedManagerTestCustom {

    FilmFeedManager manager = new FilmFeedManager(5, 44);
    private FilmUnit first = new FilmUnit(1, 1, "first", 44, "url", "date");
    private FilmUnit second = new FilmUnit(2, 2, "first", 12, "url", "date");
    private FilmUnit third = new FilmUnit(3, 3, "first", 5, "url", "date");
    private FilmUnit forth = new FilmUnit(4, 3, "first", 19, "url", "date");
    private FilmUnit fifth = new FilmUnit(5, 3, "first", 44, "url", "date");
    private FilmUnit sixth = new FilmUnit(6, 3, "first", 44, "url", "date");
    private FilmUnit seventh = new FilmUnit(7, 3, "first", 50, "url", "date");
    private FilmUnit eighth = new FilmUnit(8, 3, "first", 44, "url", "date");
    private FilmUnit ninth = new FilmUnit(9, 3, "first", 44, "url", "date");
    private FilmUnit tenth = new FilmUnit(10, 3, "first", 46, "url", "date");

    @Test
    void shouldGetFilmListWithCustomLimit() {
        FilmFeedManager manager = new FilmFeedManager(5);
        FilmUnit first = new FilmUnit(1, 1, "first", 44, "url", "date");
        FilmUnit second = new FilmUnit(2, 2, "first", 12, "url", "date");
        FilmUnit third = new FilmUnit(3, 3, "first", 5, "url", "date");
        FilmUnit forth = new FilmUnit(4, 3, "first", 19, "url", "date");
        FilmUnit fifth = new FilmUnit(5, 3, "first", 44, "url", "date");
        FilmUnit sixth = new FilmUnit(6, 3, "first", 44, "url", "date");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);

        FilmUnit[] expected = manager.getFilmList();
        FilmUnit[] actual = new FilmUnit[] {sixth, fifth, forth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetFilmListWithGenreFilter() {
        FilmFeedManager manager = new FilmFeedManager(5, 44);
        FilmUnit first = new FilmUnit(1, 1, "first", 44, "url", "date");
        FilmUnit second = new FilmUnit(2, 2, "first", 12, "url", "date");
        FilmUnit third = new FilmUnit(3, 3, "first", 5, "url", "date");
        FilmUnit forth = new FilmUnit(4, 3, "first", 19, "url", "date");
        FilmUnit fifth = new FilmUnit(5, 3, "first", 44, "url", "date");
        FilmUnit sixth = new FilmUnit(6, 3, "first", 44, "url", "date");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);

        FilmUnit[] expected = manager.getFilmList();
        FilmUnit[] actual = new FilmUnit[]{sixth, fifth, first};

        assertArrayEquals(expected, actual);

    }
}