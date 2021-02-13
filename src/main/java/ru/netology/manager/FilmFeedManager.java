package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.FilmUnit;
import ru.netology.repository.FilmsRepository;

@Data
@NoArgsConstructor

public class FilmFeedManager {
    private FilmsRepository repository;

    private int elementsLimit = 10; // определяет максимальное количество фильмов в блоке по умолчанию 10
    private int filterGenreId = 0;  // фильтр жанра, по умолчанию 0

    public FilmFeedManager(int elementsLimit, int filterGenreId) {
        this.elementsLimit = elementsLimit;
        this.filterGenreId = filterGenreId;
    }

    public FilmFeedManager(int elementsLimit) {
        this.elementsLimit = elementsLimit;
    }

    public FilmFeedManager(FilmsRepository repository) {
        this.repository = repository;
    }

    public void add(FilmUnit film) {
        repository.save(film);
    }

    public FilmUnit[] getAll() {
        FilmUnit[] films = repository.findAll();
        FilmUnit[] result = new FilmUnit[films.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    // отдает список всех фильмов согласно фильтру по жанру

    public FilmUnit[] getFilmByGenre() {
        FilmUnit[] films = repository.findAll();
        int length = films.length;
        FilmUnit[] list = getAll();
        FilmUnit[] filmsByGenre = new FilmUnit[length];

        int index = 0;
        for (FilmUnit item : list) {

            if (item.getGenreId() == filterGenreId) {
                filmsByGenre[index] = item;
                index++;
            }
        }
        return filmsByGenre;
    }

    // отдает фильмы для построения блока, можно применить фильтр по жанру

    public FilmUnit[] getFilmList() {
        int size = elementsLimit;
        int length;
        FilmUnit[] list;

        if (filterGenreId > 0) {
            list = getFilmByGenre();
        } else {
            list = getAll();
        }

        int index = 0;
        for (FilmUnit film : list) {
            if (film == null) {
                break;
            }
            if (index < size) {
                index++;
            }

        }
        length = index;

        FilmUnit[] filmList = new FilmUnit[length];

        System.arraycopy(list, 0, filmList, 0, length);

        return filmList;
    }


    // удаляет элемент из массива по id, возвращает неизмененный массив, если id не существует

    public void removeById(int id) {
       repository.removeById(id);
    }
}