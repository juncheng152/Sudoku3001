import java.awt.*;

public class Player {
    private Color color;
    private int score;
    private Dot dot;
    private boolean placed;

    Player(Color color) {
        this.color = color;
        this.score = 0;
        this.dot = new Dot(this.color);
        this.placed = false;
    }

    public void placeDot(Graphics2D pen2D, int x, int y) {
        if (this.dot.isVisible()) {
            pen2D.setColor(this.color);
            pen2D.fillRect(x, y, this.dot.getSIZE(), this.dot.getSIZE());
        }
    }

    public void pickUpDot() {
        this.dot.setVisible(false);
    }

    public void setDotPosition(int x, int y) {
        this.dot.setPosition(x, y);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Dot getDot() {
        return dot;
    }

    public void setDot(Dot dot) {
        this.dot = dot;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }
}
