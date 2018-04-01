import javax.swing.*;

public class SaperGame extends JFrame {
    public static void main(String[] args) {
        new SaperGame();
    }

    private SaperGame () {
        initFrame();
    }

    private void initFrame() {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Saper Game");
        setLocationRelativeTo(null);
        setResizable(Boolean.parseBoolean("false"));
        setVisible(true);
    }
}
