import javax.swing.*;
import java.awt.*;

public class SaperGame extends JFrame {

    // Панель внутри фрейма
    private JPanel panel;

    private final int COLS = 15;
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        new SaperGame();
    }

    // Конструктор текущего объекта
    private SaperGame () {
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
                // Вывод картинок
                g.drawImage(getImage("bomb"), 0, 0, this);
                g.drawImage(getImage("num1"), IMAGE_SIZE, 0, this);
            }
        };
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
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
    }

    /**
     * Реализация подгрузки картинки
     * @param name Имя картинки
     * @return ImageIcon
     */
    private Image getImage(String name) {
        String filename = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }
}
