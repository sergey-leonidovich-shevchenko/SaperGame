package saper;

public class Game {

    public Game(int cols, int rows) {
        Ranges.setSize(new Coord(cols, rows));
    }

    /**
     * Получение того, что находится в заданной координате
     *
     * @param coord заданная координата
     * @return Value for property 'box'.
     */
    public Box getBox(Coord coord) {
        return Box.values()[(coord.x + coord.y) % Box.values().length];
    }
}
