import javax.swing.JFrame;

public class Conway {
   private GridCanvas grid;
   
   public Conway() {
       grid = new GridCanvas(20, 20, 20);
       grid.turnOn(2, 1);
       grid.turnOn(2, 2);
       grid.turnOn(2, 3);
       grid.turnOn(5, 1);
       grid.turnOn(6, 2);
       grid.turnOn(7, 3);
       grid.turnOn(7, 4);
   }

   private void mainloop() {
       while (true) {
           this.update();
           grid.repaint();
           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
               // do nothing
           }
       }
   }
   
   private int countAlive(int r, int c) {
    int count = 0;
    count += grid.test(r - 1, c - 1);
    count += grid.test(r - 1, c);
    count += grid.test(r - 1, c + 1);
    count += grid.test(r, c - 1);
    count += grid.test(r, c);
    count += grid.test(r, c + 1);
    count += grid.test(r + 1, c - 1);
    count += grid.test(r + 1, c);
    count += grid.test(r + 1, c + 1);
    return count;
    }

    public void update() {
        int[][] counts = countNeghbors();
        updateGrid(counts);
    }

    private int[][] countNeghbors() {
        int rows = grid.numRows();
        int cols = grid.numCols();

        int[][] counts = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                counts[r][c] = countAlive(r, c);
            }
        }
        return counts;
    }

    private void updateGrid(int[][] counts) {
        int rows = grid.numRows();
        int cols = grid.numCols();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = grid.getCell(r, c);
                updateCell(cell, counts[r][c]);
            }
        }
    }

    private static void updateCell(Cell cell, int count) {
        if (cell.isOn()) {
            if (count < 2 || count > 3) {
                cell.turnOff();
            }
        } else {
            if (count == 3) {
                cell.turnOn();
            }
        }
    }

   public static void main(String[] args) {
       String title = "Conway's Game of Life";
       Conway game = new Conway();
       JFrame frame = new JFrame(title);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(false);
       frame.add(game.grid);
       frame.pack();
       frame.setVisible(true);
       game.mainloop();
   }
}
