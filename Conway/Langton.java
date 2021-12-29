import javax.swing.JFrame;

public class Langton {
    private GridCanvas grid;
    private int xpos;
    private int ypos;
    // {North, East, South, West}
    private int head; 

    public Langton(int rows, int cols) {
        grid = new GridCanvas(rows, cols, 10);
        xpos = rows / 2;
        ypos = cols / 2;
    }

    public void update() {
        flipCell();
        moveAnt();
    }

    private void flipCell() {
        Cell cell = grid.getCell(xpos, ypos);
        if (cell.isOff()) {
            head = (head  + 1) % 4;
            cell.turnOn();
        } else {
            head = (head + 3) % 4;
            cell.turnOff();
        }
    }

    private void moveAnt() {
        switch (head) {
            case 0:
            ypos--;
            break;
            case 1:
            xpos++;
            break;
            case 2:
            ypos++;
            break;
            case 3:
            xpos--;
            break;
        }
    }

    private void mainloop() {
        while (true) {
            this.update();
            grid.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

    public static void main(String[] args) {
        String title = "Langton's Ant";
        Langton game = new Langton(100, 100);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game.grid);
        frame.pack();
        frame.setVisible(true);
        game.mainloop();
        
    }
}