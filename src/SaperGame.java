import javax.swing.*;
import java.awt.*;

import saper.Box;
import saper.Coord;
import saper.Ranges;

public class SaperGame extends JFrame {

    // Панель внутри фрейма
    private JPanel panel;

    private final int COLS       = 9;
    private final int ROWS       = 9;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        new SaperGame();
    }

    // Конструктор текущего объекта
    private SaperGame() {
        Ranges.setSize(new Coord(COLS, ROWS));
        setImages();
        initPanel();
        initFrame();
    }

    // Инициализируем панель внутри фрейма с заданными размерами
    private void initPanel() {
        panel = new JPanel() {
            /**
             * Рисуем графику в панели
             * @param g Графика для рисования изображения
             */
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Вывод всех картинок
                for (Coord coord : Ranges.getAllCoords()) {
                    g.drawImage(
                            (Image) Box.values()[(coord.x + coord.y) % Box.values().length].image,
                            coord.x * IMAGE_SIZE,
                            coord.y * IMAGE_SIZE,
                            this
                    );
                }
            }
        };

        panel.setPreferredSize(new Dimension(
                Ranges.getSize().x * IMAGE_SIZE,
                Ranges.getSize().y * IMAGE_SIZE
        ));

        add(panel);
    }

    // Инициализируем фрейм программы
    private void initFrame() {
        // Устанавливаем такой минимальный размер фрейма, который достаточен для отображения всех элементов
        pack();
        // Закрытие программы по крестику окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Устанавливаем заголовок окна
        setTitle("Saper Game");
        // Делаем окно программы по центру
        setLocationRelativeTo(null);
        // Делаем запрет на изменение размера окна
        setResizable(Boolean.parseBoolean("false"));
        // Делаем программу видимой
        setVisible(true);
        // Ставим иконку программы (отображается на панели задач)
        setIconImage(getImage("icon"));
    }

    // Установка всех картинок
    private void setImages() {
        // Перебираем все картинки
        for (Box box : Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }

    /**
     * Реализация подгрузки картинки
     *
     * @param name Имя картинки
     * @return ImageIcon
     */
    private Image getImage(String name) {
        String filename = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }
}
