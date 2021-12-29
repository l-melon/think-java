import javax.swing.JFrame;

public abstract class Automaton {
    protected GridCanvas grid;

    public abstract void update();

    public void run(String title, int rate) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this.grid);
        frame.pack();
        frame.setVisible(true);
        this.mainloop(rate);
    }

    private void mainloop(int rate) {
        while (true) {
            
            this.update();
            grid.repaint();

            try {
                Thread.sleep(1000 / rate);
            } catch (InterruptedException e) {
                // do notihng
            }
        }
    }
}