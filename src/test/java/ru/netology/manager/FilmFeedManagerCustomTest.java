package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmUnit;
import ru.netology.repository.FilmsRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;



@ExtendWith(MockitoExtension.class)
public class FilmFeedManagerCustomTest {
    @Mock
    private FilmsRepository repository;
    @InjectMocks
    private FilmFeedManager manager = new FilmFeedManager(5, 44);

    FilmUnit first = new FilmUnit(1, 1, "first", 44, "url", "date");
    FilmUnit second = new FilmUnit(2, 2, "first", 55, "url", "date");
    FilmUnit third = new FilmUnit(3, 3, "first", 49, "url", "date");
    FilmUnit forth = new FilmUnit(4, 3, "first", 19, "url", "date");
    FilmUnit fifth = new FilmUnit(5, 3, "first", 44, "url", "date");
    FilmUnit sixth = new FilmUnit(6, 3, "first", 44, "url", "date");
    FilmUnit seventh = new FilmUnit(7, 3, "first", 44, "url", "date");
    FilmUnit eights = new FilmUnit(8, 3, "first", 44, "url", "date");
    FilmUnit ninth = new FilmUnit(9, 3, "first", 44, "url", "date");
    FilmUnit tenth = new FilmUnit(10, 3, "first", 44, "url", "date");

    @Test
   public void shouldGetFilmListWithCustomLimit() {


        FilmUnit[] returned = new FilmUnit[] {first, fifth, sixth, seventh, eights, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        FilmUnit[] expected = manager.getFilmList();
        FilmUnit[] actual = new FilmUnit[]{tenth, ninth, eights, seventh, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetFilmListWithGenreFilter() {

        FilmUnit[] returned = new FilmUnit[] {first, second, third, forth, fifth, sixth};
        doReturn(returned).when(repository).findAll();

        FilmUnit[] expected = manager.getFilmList();
        FilmUnit[] actual = new FilmUnit[]{sixth, fifth, first};

        assertArrayEquals(expected, actual);

    }
}