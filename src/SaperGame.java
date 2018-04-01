import javax.swing.*;
import java.awt.*;

public class SaperGame extends JFrame {

    private JPanel panel;

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
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
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
}
