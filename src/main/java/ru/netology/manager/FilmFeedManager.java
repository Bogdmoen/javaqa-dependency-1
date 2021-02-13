package ru.netology.manager;

import ru.netology.domain.FilmUnit;

public class FilmFeedManager {
    private FilmUnit[] films = new FilmUnit[0];

    public void add(FilmUnit item) {
        // создаём новый массив размером на единицу больше
        int length = films.length + 1;
        FilmUnit[] tmp = new FilmUnit[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < films.length; i++) {
        //   tmp[i] = films[i];
        // }
        System.arraycopy(films, 0, tmp, 0, films.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        films = tmp;
    }

    public FilmUnit[] getAll() {
        FilmUnit[] result = new FilmUnit[films.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    // наивная реализация
    public void removeById(int id) {
        int length = films.length - 1;
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
}