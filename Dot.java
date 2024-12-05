import java.awt.*;

public class Dot {
    private Color color;
    private final int SIZE;
    private boolean visible;
    private int x, y;

    Dot(Color color) {
        this.color = color;
        this.SIZE = 10;
        this.visible = false;
        this.x = 0;
        this.y = 0;
    }

    public void draw(Graphics2D pen2D) {
        pen2D.setColor(this.color);
        pen2D.fillRect(this.x, this.y, this.SIZE, this.SIZE);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSIZE() {
        return this.SIZE;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
