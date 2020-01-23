package watch;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    private SwingWatchDisplay display;

    public static void main(String[] args) {
        new Main().execute();
    }

    public Main() {
        setTitle("Watch");
        setSize(500,500);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        add(display());
    }
    
    

    private void execute() {
        new WatchPresenter(new Watch(), display);
        setVisible(true);
    }

    private JPanel display() {
        display = new SwingWatchDisplay();
        return display;
    }
    
}
