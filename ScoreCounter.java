import java.awt.*;

public class ScoreCounter {
    private Color color;
    private Font font;
    private final int x;
    private final int y;
    private int score;

    ScoreCounter(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.score = 0;
        this.font = new Font("Rebellion Squad", Font.BOLD, 40);
    }

    public void displayScore(Graphics2D pen2D, int score) {
        pen2D.setColor(this.color);
        pen2D.drawString(String.format("%02d", score), this.x, this.y);
    }

    public void moveUp() {
        this.score++;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
