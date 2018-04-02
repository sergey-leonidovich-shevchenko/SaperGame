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
        for (int i = 0; i <= totalBombs; i++) {
            placeBomb();
        }
    }

    /**
     * Узнаем что у нас находится в той или иной клетке(координате)
     *
     * @param coord Координата
     * @return Box|null Сущность, распологаемая на узнаваемой координате
     */
    Box get(Coord coord) {
        return bombMap.get(coord);
    }

    /**
     * Размещаем бомбу в случайной координате
     */
    private void placeBomb() {
        Coord coord = Ranges.getRandomCoord();
        bombMap.set(coord, Box.BOMB);
    }
}
