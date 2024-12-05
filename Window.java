import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener {
    private String title;
    private Stage stage;

    Window(Dimension size, String title) {
        this.title = title;
        this.stage = new Stage(new Dimension(900, 900));
        this.add(this.stage);
        this.setSize(size);
        this.addKeyListener(this);
        this.setTitle(this.title);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.stage.reset();
            this.stage.evaluate(this.stage.getRgbScreen().getCodeDot(), this.stage.getPlayer1().getDot(), this.stage.getPlayer2().getDot());
            this.stage.getRgbScreen().hideCodeDot();
            this.stage.setTurn(Stage.Players.PLAYER1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
