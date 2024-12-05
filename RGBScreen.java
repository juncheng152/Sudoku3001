import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class RGBScreen {
    private int[] rgbScreen;
    private Font codeFont;
    private Color[] colorPalette;
    private Random generator;
    private final int VALUE_DISTANCE;
    private final int LEFT_PADDING;
    private Dot codeDot;

    RGBScreen() {
        this.generator = new Random();
        this.rgbScreen = this.getRandomCode();
        this.codeFont = new Font("Rebellion Squad", Font.BOLD, 40);
        this.colorPalette = new Color[]{Color.RED, Color.GREEN, Color.BLUE};
        this.VALUE_DISTANCE = 50;
        this.LEFT_PADDING = 310;
        this.codeDot = new Dot(new Color(this.getRgbScreen()[0], this.getRgbScreen()[1], this.getRgbScreen()[2]));
        this.codeDot.setPosition(this.rgbTo2D(this.getRgbScreen()[0], this.getRgbScreen()[1], this.getRgbScreen()[2])[0], this.rgbTo2D(this.getRgbScreen()[0], this.getRgbScreen()[1], this.getRgbScreen()[2])[1]);
        this.codeDot.setVisible(false);
    }

    public void drawCode(Graphics2D pen2D, Color[] code) {
        pen2D.setFont(this.codeFont);
        for (int index=0; index<3; index++) {
            pen2D.setColor(code[index]);
            pen2D.drawString(String.format("%03d", this.rgbScreen[index]), index*this.VALUE_DISTANCE + this.LEFT_PADDING + index*this.VALUE_DISTANCE, 60);
        }
    }

    public void drawCodeDot(Graphics2D pen2D) {
        if (this.codeDot.isVisible()) {
            pen2D.setColor(new Color(this.getRgbScreen()[0], this.getRgbScreen()[1], this.getRgbScreen()[2]));
            pen2D.fillRect(this.codeDot.getX(), this.codeDot.getY(), this.codeDot.getSIZE(), this.codeDot.getSIZE());
        }
    }

    public void hideCodeDot() {
        this.rgbScreen = this.getRandomCode();
        this.codeDot.setColor(new Color(this.getRgbScreen()[0], this.getRgbScreen()[1], this.getRgbScreen()[2]));
        this.codeDot.setVisible(false);
    }

    public int[] rgbTo2D(int r, int g, int b) {
        int x = (int) ((r + g) / 2) * 799 / 255;
        int y = (int) ((g + b) / 2) * 599 / 255;

        return new int[] { x, y };
    }

    public int[] getRandomCode() {
        int r = this.generator.nextInt(0, 256);
        int g = this.generator.nextInt(0, 256);
        int b = this.generator.nextInt(0, 256);
        return new int[]{r, g, b};
    }

    public int[] getRgbScreen() {
        return rgbScreen;
    }

    public void setRgbScreen(int[] rgbScreen) {
        this.rgbScreen = rgbScreen;
    }

    public Random getGenerator() {
        return generator;
    }

    public void setGenerator(Random generator) {
        this.generator = generator;
    }

    public Color[] getColorPalette() {
        return colorPalette;
    }

    public void setColorPalette(Color[] colorPalette) {
        this.colorPalette = colorPalette;
    }

    public Font getCodeFont() {
        return codeFont;
    }

    public void setCodeFont(Font codeFont) {
        this.codeFont = codeFont;
    }

    public int getVALUE_DISTANCE() {
        return this.VALUE_DISTANCE;
    }

    public int getLEFT_PADDING() {
        return this.LEFT_PADDING;
    }

    public Dot getCodeDot() {
        return codeDot;
    }

    public void setCodeDot(Dot codeDot) {
        this.codeDot = codeDot;
    }
}
