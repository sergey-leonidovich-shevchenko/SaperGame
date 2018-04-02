package saper;

class Bomb {

    // Расположение бомб
    private Matrix bombMap;
    // Количество бомб на поле
    private int    totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
    }

    // Размещение бомб на поле
    void start() {
        bombMap = new Matrix(Box.ZERO);
        placeBomb();
    }

    /**
     * Узнаем что у нас находится в той или иной клетке(координате)
     *
     * @param coord
     * @return Box|null
     */
    Box get(Coord coord) {
        return bombMap.get(coord);
    }

    private void placeBomb() {
        bombMap.set(new Coord(4, 4), Box.BOMB);
    }
}
