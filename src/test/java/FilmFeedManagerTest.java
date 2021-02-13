import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmUnit;
import ru.netology.manager.FilmFeedManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FilmFeedManagerTest {

    FilmFeedManager manager = new FilmFeedManager();
    FilmUnit first = new FilmUnit(1, 1, "first", 44, "url", "date");
    FilmUnit second = new FilmUnit(2, 2, "second", 44, "url", "date");
    FilmUnit third = new FilmUnit(3, 3, "third", 44, "url", "date");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);

        FilmUnit[] actual = manager.getAll();
        FilmUnit[] expected = new FilmUnit[]{third, second};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Disabled
    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        manager.removeById(idToRemove);

        FilmUnit[] actual = manager.getAll();
        FilmUnit[] expected = new FilmUnit[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}