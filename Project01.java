package project01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Project01 extends JFrame {
    home homegames1 = new home();
    gameplay playgame = new gameplay();
    int keyX;
    int keyY;
    Project01() {
        this.setSize(1400, 840);
        this.add(homegames1);
}
    public static void main(String[] args) {
        Project01 jf = new Project01();
        jf.setSize(1400, 840);
        jf.setTitle("Ohana");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
}
