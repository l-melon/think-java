import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class DrawablePolygon extends Polygon{

    protected Color color;

    public DrawablePolygon() {
        super();
        color = Color.BLUE;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillPolygon(this);
    }

    public static void main(String[] args) {
        DrawablePolygon p = new DrawablePolygon();
        p.addPoint(57, 110);
        p.addPoint(100, 35);
        p.addPoint(143, 110);
        p.color = Color.GREEN;
    }
}