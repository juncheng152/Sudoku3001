import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stage extends JPanel implements MouseListener {
    private Timer fpsRegulator;
    private final int FPS;
    private RGBScreen rgbScreen;
    private Player player1, player2;

    public enum Players {
        PLAYER1,
        PLAYER2
    };
    private Players turn;
    private ScoreCounter counter1, counter2;


    Stage(Dimension size) {
        this.FPS = 60;
        this.fpsRegulator = new Timer(1_000/this.FPS, null);
        this.rgbScreen = new RGBScreen();
        this.setSize(size);
        this.player1 = new Player(Color.RED);
        this.counter1 = new ScoreCounter(Color.RED, 30, 70);
        this.player2 = new Player(Color.BLUE);
        this.counter2 = new ScoreCounter(Color.BLUE, 900-100, 70);
        this.turn = Players.PLAYER1;
        this.addMouseListener(this);
        this.fpsRegulator.start();
    }

    public void paintComponent(Graphics pen) {
        Graphics2D pen2D = (Graphics2D) pen;
        this.drawBackground(pen2D);
        this.rgbScreen.drawCode(pen2D, this.rgbScreen.getColorPalette());
        if (this.player1.isPlaced()) {
            this.player1.placeDot(pen2D, this.player1.getDot().getX(), this.player1.getDot().getY());
        }
        if (this.player2.isPlaced()) {
            this.player2.placeDot(pen2D, this.player2.getDot().getX(), this.player2.getDot().getY());
        }
        this.rgbScreen.drawCodeDot(pen2D);
        this.counter1.displayScore(pen2D, this.player1.getScore());
        this.counter2.displayScore(pen2D, this.player2.getScore());
        repaint();
    }

    public void drawBackground(Graphics2D pen2D) {
        pen2D.setColor(Color.BLACK);
        pen2D.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void reset() {
        this.player1.pickUpDot();
        this.player2.pickUpDot();
    }

    public double calculateDistanceBetweenDots(Dot dot1, Dot dot2) {
        return Math.sqrt(Math.pow(dot2.getX()-dot1.getX(), 2) + Math.pow(dot2.getY()-dot1.getY(), 2));
    }

    public Timer getFpsRegulator() {
        return fpsRegulator;
    }

    public void setFpsRegulator(Timer fpsRegulator) {
        this.fpsRegulator = fpsRegulator;
    }

    public int getFPS() {
        return this.FPS;
    }

    public RGBScreen getRgbScreen() {
        return rgbScreen;
    }

    public void setRgbScreen(RGBScreen rgbScreen) {
        this.rgbScreen = rgbScreen;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Players getTurn() {
        return turn;
    }

    public void setTurn(Players turn) {
        this.turn = turn;
    }

    public ScoreCounter getCounter1() {
        return counter1;
    }

    public void setCounter1(ScoreCounter counter1) {
        this.counter1 = counter1;
    }

    public ScoreCounter getCounter2() {
        return counter2;
    }

    public void setCounter2(ScoreCounter counter2) {
        this.counter2 = counter2;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.turn == Players.PLAYER1) {
            this.handlePlayerClick(e, this.player1, Players.PLAYER2);
        } else if (this.turn == Players.PLAYER2) {
            this.handlePlayerClick(e, this.player2, Players.PLAYER1);
            this.rgbScreen.getCodeDot().setVisible(true);

        }
    }

    public void handlePlayerClick(MouseEvent e, Player player, Players newTurn) {
        player.getDot().setVisible(true);
        player.setPlaced(true);
        player.setDotPosition(e.getX(), e.getY());
        this.setTurn(newTurn);
    }

    public void evaluate(Dot codeDot, Dot dot1, Dot dot2) {
        if (this.calculateDistanceBetweenDots(codeDot, dot1) > this.calculateDistanceBetweenDots(codeDot, dot2)) {
            this.player2.setScore(this.player2.getScore()+1);
        } else {
            this.player1.setScore(this.player1.getScore()+1);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
