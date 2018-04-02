package saper;

class Matrix {

    // Двумерный массив с сущностями (нижний слой где хранятся бомбы)
    // верхний слой с флагами (по правой кнопки мыши)
    private Box[][] matrix;

    /**
     * Конструктор заполняющий всю матрицу поля
     *
     * @param defaultBox Сущность по умолчанию
     */
    Matrix(Box defaultBox) {
        matrix = new Box[Ranges.getSize().x][Ranges.getSize().y];
        for (Coord coord : Ranges.getAllCoords()) {
            matrix[coord.x][coord.y] = defaultBox;
        }
    }

    Box get(Coord coord) {
        // Что бы не было переполнения массива,
        // его нужно проверить, находимся ли мы в пределах экрана
        if (Ranges.inRange(coord)) {
            return matrix[coord.x][coord.y];
        }

        return null;
    }

    void set(Coord coord, Box box) {
        // Что бы не было переполнения массива,
        // его нужно проверить, находимся ли мы в пределах экрана
        if (Ranges.inRange(coord)) {
            matrix[coord.x][coord.y] = box;
        }
    }

}
