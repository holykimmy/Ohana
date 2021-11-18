package project01;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
//import sun.audio.*;//
public class home extends JPanel {
    ImageIcon homebackground = new ImageIcon(this.getClass().getResource("bghome.jpg"));
    ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.gif"));
    ImageIcon SS = new ImageIcon(this.getClass().getResource("namegame.gif"));
    ImageIcon starts = new ImageIcon(this.getClass().getResource("start.gif"));
    ImageIcon stitch = new ImageIcon(this.getClass().getResource("stitchb.gif"));
    gameplay playgame = new gameplay();
    int keyX;
    int keyY;

    home() {
        setLayout(null);
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                keyX = e.getX();
                keyY = e.getY();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (keyX >= 390 && keyX <= 610 && keyY >= 590 && keyY <= 810) {
                    setSize(1400, 840);
                    add(playgame);
                    playgame.setBounds(0, 0, 1400, 840);
                    playgame.requestFocusInWindow();
                    playgame.timestart = false;
                    playgame.score = 0;
                    playgame.HP = 3;
                    playgame.times = 80;
                    playgame.startf = false;
                    playgame.timestart = false;
                    playgame.pauseg = 1;
                } else if (keyX >= 890 && keyX <= 1110 && keyY >= 610 && keyY <=830 ) {
                    System.exit(0);
                }
            }
        });
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(homebackground.getImage(), 0, 0, 1400, 840, this);
        g.drawImage(SS.getImage(), 410, 10, 600, 380, this);
        g.drawImage(exit.getImage(), 900, 620, 200, 130, this);
        g.drawImage(stitch.getImage(), 100, 400, 400, 400, this);
        g.drawImage(starts.getImage(), 400, 600, 200, 200, this);
    }
}
