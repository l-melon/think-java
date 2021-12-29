public class Langton extends Automaton{
    private int xpos;
    private int ypos;
    // {North, East, South, West}
    private int head; 

    public Langton(int rows, int cols) {
        grid = new GridCanvas(rows, cols, 5);
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

    public static void main(String[] args) {
        String title = "Langton's Ant";
        Langton game = new Langton(100, 100);
        game.run(title, 1000);
    }
}