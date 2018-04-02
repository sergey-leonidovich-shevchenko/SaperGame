package saper;

public class Game {

    private Bomb bomb;

    /**
     * Конструктор
     *
     * @param cols      Количество колонок в игровом поле
     * @param rows      Количество строк в игровом поле
     * @param countBomb Общее количество бомб на поле
     */
    public Game(int cols, int rows, int countBomb) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(countBomb);
    }

    // Размещение бомб на поле
    public void start() {
        bomb.start();
    }

    /**
     * Получение того, что находится в заданной координате
     *
     * @param coord заданная координата
     * @return Value for property 'box'.
     */
    public Box getBox(Coord coord) {
        return bomb.get(coord);
    }
}
