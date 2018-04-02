package saper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {

    // Размер координаты
    private static Coord            size;
    // Список всех координат
    private static ArrayList<Coord> allCoords;
    // Случайная координата
    private static Random           random = new Random();

    /**
     * Getter for static property 'size'.
     *
     * @return Value for static property 'size'.
     */
    public static Coord getSize() {
        return size;
    }

    /**
     * Setter for static property 'size'.
     *
     * @param _size Value to set for static property 'size'.
     */
    static void setSize(Coord _size) {
        size = _size;

        // Перебираем все координаты
        allCoords = new ArrayList<Coord>();
        for (int y = 0; y < size.y; y++) {
            for (int x = 0; x < size.x; x++) {
                allCoords.add(new Coord(x, y));
            }
        }
    }

    /**
     * Получить список всех координат
     *
     * @return ArrayList<Coord>
     */
    public static ArrayList<Coord> getAllCoords() {
        return allCoords;
    }

    /**
     * Проверка: находимся ли мы в пределах наших координат
     *
     * @param coord Координата
     * @return Boolean
     */
    static boolean inRange(Coord coord) {
        return coord.x >= 0 && coord.x < size.x
                && coord.y >= 0 && coord.y < size.y;
    }

    /**
     * Возвращение случайной координаты
     *
     * @return
     */
    static Coord getRandomCoord() {
        return new Coord(random.nextInt(size.x), random.nextInt(size.y));
    }

    /**
     * Возвращаем координаты вокруг выбранной координаты
     *
     * @param coord Выбранная координата
     * @return ArrayList Список координат находящихся вокруг выбранной
     */
    static ArrayList<Coord> getCoordsAround(Coord coord) {
        Coord around;
        ArrayList<Coord> list = new ArrayList<>();

        // Багаем по соседним координатам
        for (int x = coord.x - 1; x <= coord.x + 1; x++) {
            for (int y = coord.y - 1; y <= coord.y + 1; y++) {
                around = new Coord(x, y);
                // Если данная координата присутствует на игровом поле
                if (inRange(around)) {
                    // Если данная координата не центральная, вокруг ведется поиск
                    if (!around.equals(coord)) {
                        list.add(around);
                    }
                }
            }
        }

        return list;
    }
}
