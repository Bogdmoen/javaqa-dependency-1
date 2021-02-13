package ru.netology.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.FilmUnit;

@Data
@NoArgsConstructor

public class FilmsRepository {

    private FilmUnit[] films = new FilmUnit[0];


    public void save (FilmUnit film) {
        int length = films.length +1;
        FilmUnit[] tmp = new FilmUnit[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public FilmUnit[] findAll() {
        return films;
    }

    public void removeById(int id) {
        boolean ifId = false;
        int length;

        for (FilmUnit item : films) {
            if (item.getId() == id) {
                ifId = true;
                break;
            }
        }

        if (ifId) {
            length = films.length - 1;

            FilmUnit[] tmp = new FilmUnit[length];
            int index = 0;
            for (FilmUnit item : films) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            // меняем наши элементы
            films = tmp;
        }
        else {
            System.out.println("cannot delete, id is not present");
        }
    }
}

