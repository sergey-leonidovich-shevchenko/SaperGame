package saper;

class Bomb {

    // Расположение бомб
    private Matrix bombMap;
    // Количество бомб на поле
    private int    totalBombs;

    /**
     * Конструктор
     *
     * @param totalBombs
     */
    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
        maxBombsCount();
    }

    /**
     * Размещение бомб на поле
     */
    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    }

    /**
     * Установка максимального количества бомб для установки на текущем размере поля
     */
    private void maxBombsCount() {
        int maxBombs = Ranges.getSize().x * Ranges.getSize().y / 2;
        if (totalBombs > maxBombs) {
            totalBombs = maxBombs;
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
        while (true) {
            Coord coord = Ranges.getRandomCoord();

            // Если в текущей координате уже есть бомба, то пропускаем ее
            if (bombMap.get(coord) == Box.BOMB) {
                continue;
            }
            // Устанавливаем бомбу
            bombMap.set(coord, Box.BOMB);
            incrementNumbersAroundBomb(coord);
            break;
        }
    }

    /**
     * Увеличение счетчика в поле, если рядом находится более одной бомбы
     *
     * @param coord
     */
    private void incrementNumbersAroundBomb(Coord coord) {
        // Размещаем вокруг бомбы цифру с количеством находящихся рядом бомб
        for (Coord around : Ranges.getCoordsAround(coord)) {
            // Если в текущей координате находится бомба, то ставить цифру не нужно
            if (bombMap.get(around) != Box.BOMB) {
                bombMap.set(around, bombMap.get(around).getNextNumberBombs());
            }
        }
    }
}
