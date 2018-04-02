package saper;

public class Game {

    Matrix bombMap;

    public Game(int cols, int rows) {
        Ranges.setSize(new Coord(cols, rows));
    }

    public void start() {
        bombMap = new Matrix(Box.ZERO);
    }

    /**
     * Получение того, что находится в заданной координате
     *
     * @param coord заданная координата
     * @return Value for property 'box'.
     */
    public Box getBox(Coord coord) {
        return bombMap.get(coord);
    }
}
