import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Drawing extends Canvas {
    private ArrayList<Actor> list;
    
    public Drawing(int width, int height) {
        setSize(width, height);
        setBackground(Color.WHITE);
        list = new ArrayList<>();
    }

    public void add(Actor actor) {
        list.add(actor);
    }

    public Object[] getActors() {
        return list.toArray();
    }
    
    @Override
    public void paint(Graphics g) {
        for (Actor actor : list) {
            actor.draw(g);
        }
    }

    public void step() {
        for (Actor actor : list) {
            actor.step();
        }
        repaint();
    }
}
