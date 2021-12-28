import java.awt.Color;
import java.awt.Graphics;

public class Cell {
    private final int x;
    private final int y;
    private final int size;
    private int state;

    public Cell(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.state = 0;
    } 

    public static final Color[] COLOR = {Color.white, Color.BLACK};

    public void draw(Graphics g) {
        g.setColor(COLOR[state]);
        g.fillRect(x + 1, y + 1, size - 1, size - 1);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(x, y, size, size);
    }

    public boolean isOff() {
        return state == 0;
    }

    public boolean isOn() {
        return state == 1;
    }

    public void turnOff() {
        state = 0;
    }

    public void turnOn() {
        state = 1;
    }
}
