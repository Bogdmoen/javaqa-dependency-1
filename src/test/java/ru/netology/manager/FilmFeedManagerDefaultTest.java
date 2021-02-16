package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmUnit;
import ru.netology.repository.FilmsRepository;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
public class FilmFeedManagerDefaultTest {
    @Mock
    private FilmsRepository repository;
    @InjectMocks
    private FilmFeedManager manager;
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

    @Test
    public void shouldGetFilmFeed() {
        FilmUnit[] returned = new FilmUnit[] {first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth};
        doReturn(returned).when(repository).findAll();

        FilmUnit[] actual = manager.getFilmList();
        FilmUnit[] expected = new FilmUnit[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldGetFilmFeedBelowLimit() {
        FilmUnit[] returned = new FilmUnit[] {tenth, eleventh, twelfth};
        doReturn(returned).when(repository).findAll();

        FilmUnit[] actual = manager.getFilmList();
        FilmUnit[] expected = new FilmUnit[]{twelfth, eleventh, tenth};

        assertArrayEquals(expected, actual);
    }




}