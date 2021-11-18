package project01;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
public class gameplay extends JPanel {
    int keyX;
    int keyY;
    int form = 1;
    int state = 1;
    ImageIcon imgover = new ImageIcon(this.getClass().getResource("bggameover.jpg"));
    ImageIcon imgwin = new ImageIcon(this.getClass().getResource("bgwin.jpg"));
    ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("state1.jpg"));
    ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("state2.jpg"));
    ImageIcon imgstate3 = new ImageIcon(this.getClass().getResource("state3.jpg"));
    ImageIcon pause = new ImageIcon(this.getClass().getResource("pause1.png"));
    ImageIcon resume = new ImageIcon(this.getClass().getResource("play-button.png"));
    ImageIcon close = new ImageIcon(this.getClass().getResource("logout.png"));
    ImageIcon close1 = new ImageIcon(this.getClass().getResource("exit3.png"));
    ImageIcon stitchlose = new ImageIcon(this.getClass().getResource("stitchlose.gif"));
    ImageIcon restart = new ImageIcon(this.getClass().getResource("restart111.png"));
    ImageIcon lilo = new ImageIcon(this.getClass().getResource("lilo.gif"));

    
    stitch st = new stitch();
    JLabel Tscore = new JLabel();
    ArrayList<itemice1> itemice11 = new ArrayList<itemice1>();
    ArrayList<itemice2> itemice21 = new ArrayList<itemice2>();
    ArrayList<itemice2> itemice31 = new ArrayList<itemice2>();
    ArrayList<itemball2> itemball21 = new ArrayList<itemball2>();
    ArrayList<itemball1> itemball11 = new ArrayList<itemball1>();
    ArrayList<bomb> bomb = new ArrayList<bomb>();
    ArrayList<heal> heal = new ArrayList<heal>();
    ArrayList<timeplus> timeplus = new ArrayList<timeplus>();
    boss b = new boss();
    int times;
    int HP;
    boolean timestart;
    boolean startball = false;
    boolean startf;
    int score = 0;
    int pauseg;
    Thread all = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        Thread.sleep(10000);
                    } catch (Exception e) {
                    }
                    repaint();
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread titemice1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (pauseg == 0) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        itemice11.add(new itemice1());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread titemball2 = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        itemball21.add(new itemball2());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread titemball1 = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        itemball11.add(new itemball1());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread titemice2 = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        itemice21.add(new itemice2());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread tbomb = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            if (state == 1) {
                                Thread.sleep(3000);
                            } else if (state == 2) {
                                Thread.sleep(2000);
                            } else if (state == 3) {
                                Thread.sleep(1500);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        bomb.add(new bomb());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread theal = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 30000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        heal.add(new heal());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread ttimeplus = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 20000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        timeplus.add(new timeplus());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread t = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    if (timestart == false) {
                        times = (times - 1);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    
    gameplay() {
        this.setFocusable(true);
        this.setLayout(null);
        this.add(Tscore);
        
         
        
       this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int a = e.getKeyCode();
                if(pauseg == 1){
                    System.out.println(pauseg);
                if (a == KeyEvent.VK_LEFT) {
                    st.x -= 10;
                    form = 1;
                } else if (a == KeyEvent.VK_RIGHT) {
                    st.x += 10;
                    form = 0;
                }
                if (st.count > 3) {
                    st.count = 0;
                }
                }
            }
            public void keyReleased(KeyEvent e) {
                st.count = 0;
            }
        });
        st.x = 400;
        all.start();
        t.start();
        titemice1.start();
        tbomb.start();
        titemball1.start();
        titemice2.start();
        theal.start();
        ttimeplus.start();
        titemball2.start();
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
                if (keyX >= 1290 && keyX <= 1350 && keyY >= 30 && keyY <= 70) {
                    System.exit(0);
                } 
                else if (keyX >= 1290 && keyX <= 1350 && keyY >= 100 && keyY <= 140) {
                    pauseg = 0;
                    setSize(1400, 840);
                    requestFocusInWindow();
                    System.out.println(pauseg);
                    t.suspend();
                    all.suspend();
                    titemice1.suspend();
                    titemball1.suspend();
                    titemice2.suspend();
                    tbomb.suspend();
                    theal.suspend();
                    ttimeplus.suspend();
                    titemball2.suspend();
                    if (!itemball11.isEmpty()) {
                        for (int i = 0; i < itemball11.size(); i++) {
                            itemball11.get(i).runner.suspend();
                        }
                    }
                    if (!itemice11.isEmpty()) {
                        for (int i = 0; i < itemice11.size(); i++) {
                            itemice11.get(i).runner.suspend();
                        }
                    }
                    if (!itemice21.isEmpty()) {
                        for (int i = 0; i < itemice21.size(); i++) {
                            itemice21.get(i).runner.suspend();
                        }
                    }
                    if (!bomb.isEmpty()) {
                        for (int i = 0; i < bomb.size(); i++) {
                            bomb.get(i).runner.suspend();
                        }
                    }
                    if (!heal.isEmpty()) {
                        for (int i = 0; i < heal.size(); i++) {
                            heal.get(i).runner.suspend();
                        }
                    }
                    if (!timeplus.isEmpty()) {
                        for (int i = 0; i < timeplus.size(); i++) {
                            timeplus.get(i).runner.suspend();
                        }
                    }
                    if (!itemball21.isEmpty()) {
                        for (int i = 0; i < itemball21.size(); i++) {
                            itemball21.get(i).runner.suspend();
                        }
                    }
                } else if (keyX >= 1290 && keyX <= 1350 && keyY >= 165 && keyY <= 210) {
                    setSize(1400, 840);
                    requestFocusInWindow();
                    pauseg = 1;
                    System.out.println(pauseg);
                    t.resume();
                    all.resume();
                    titemice1.resume();
                    titemball1.resume();
                    titemice2.resume();
                    tbomb.resume();
                    theal.resume();
                    ttimeplus.resume();
                    titemball2.resume();
                    if (!itemball11.isEmpty()) {
                        for (int i = 0; i < itemball11.size(); i++) {
                            itemball11.get(i).runner.resume();;
                        }
                    }
                    if (!itemice11.isEmpty()) {
                        for (int i = 0; i < itemice11.size(); i++) {
                            itemice11.get(i).runner.resume();;
                        }
                    }
                    if (!itemice21.isEmpty()) {
                        for (int i = 0; i < itemice21.size(); i++) {
                            itemice21.get(i).runner.resume();;
                        }
                    }
                    if (!bomb.isEmpty()) {
                        for (int i = 0; i < bomb.size(); i++) {
                            bomb.get(i).runner.resume();;
                        }
                    }
                    if (!heal.isEmpty()) {
                        for (int i = 0; i < heal.size(); i++) {
                            heal.get(i).runner.resume();;
                        }
                    }
                    if (!timeplus.isEmpty()) {
                        for (int i = 0; i < timeplus.size(); i++) {
                            timeplus.get(i).runner.resume();;
                        }
                    }
                    if (!itemball21.isEmpty()) {
                        for (int i = 0; i < itemball21.size(); i++) {
                            itemball21.get(i).runner.resume();;
                        }
                    }
                } else if (keyX >= 1000 && keyX <=1150 && keyY >= 590 && keyY <= 700) {
                    home bb = new home();
                    setSize(1400, 840);
                    add(bb);
                    bb.setBounds(0, 0, 1400, 840);
                    bb.setFocusable(true);
                    bb.requestFocusInWindow();
                } else if (keyX >= 1170 && keyX <= 1300 && keyY >= 590 && keyY <= 700) {
                    System.exit(0);
                }
            }
        });
    }
    
//===================================================================================================================================================================================================    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if ( HP <= 0) {
            this.setLayout(null);
            g.drawImage(imgover.getImage(), 0, 0, 1400, 840, this);
            g.setColor(Color.BLACK);
            
            
            //===========================================================================================================
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 40));
            g.drawString("SCORE   " + score, 600, 350);
            //===========================================================================================================
            //===========================================================================================================
            g.drawImage(stitchlose.getImage(), 100, 350, 450, 410, this);
            g.drawImage(restart.getImage(), 1050, 600, 100, 100, this);
            g.drawImage(close1.getImage(), 1200, 600, 100, 100, this);
          
        } 
        
        else if (times < 0 && HP>0 && score > 0) {
            this.setLayout(null);
            g.drawImage(imgwin.getImage(), 0, 0, 1400, 840, this);
            g.setColor(Color.BLACK);
            
            //===========================================================================================================
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 60));
            g.drawString("SCORE   " + score, 50, 100);
            //===========================================================================================================
            //===========================================================================================================
            g.drawImage(restart.getImage(), 1050, 600, 100, 100, this);
            g.drawImage(close1.getImage(), 1200, 600, 100, 100, this);
        } 
//=====================================state2====================================================================================================================================================        

        else if (score >= 100 && score < 300) {
            state = 2;
            g.drawImage(imgstate2.getImage(), 0, 0, 1400, 840, this);
             g.drawImage(pause.getImage(), 1300, 100, 40, 40, this);
            g.drawImage(resume.getImage(), 1300, 170, 40, 40, this);
            g.drawImage(close.getImage(), 1300, 30, 40, 40, this);
            g.drawImage(st.imstitch[form].getImage(), st.x, st.y, 160, 180, this);
            if (st.x <= -200) {
                st.x = this.getWidth() - 20;
            }
            if (st.x > this.getWidth() + 20) {
                st.x = -100;
            }
            //    ================================================itemice1===============================================================================================================================
            for (int i = 0; i < itemice11.size(); i++) {
                itemice11.get(i).state = 2;
                g.drawImage(itemice11.get(i).getImage(), itemice11.get(i).getX(), itemice11.get(i).getY(), 120, 120, this);
            }
            for (int i = 0; i < itemice11.size(); i++) {
                if (Intersect(st.getbound(), itemice11.get(i).getbound())) {
                    itemice11.remove(i);
                    score += 10;
                    g.drawString("+10", st.x + 10, 650);
                }
                if(itemice11.get(i).getX() > 800){
                    itemice11.remove(i);
                }
            }
            //===================================================itemball2========================================================================================================================================================
            for (int i = 0; i < itemball21.size(); i++) {
                itemball21.get(i).state = 2;
                g.drawImage(itemball21.get(i).getImage(), itemball21.get(i).getX(), itemball21.get(i).getY(), 120, 120, this);
            }
            for (int i = 0; i < itemball21.size(); i++) {
                if (Intersect(st.getbound(), itemball21.get(i).getbound())) {
                    itemball21.remove(i);
                    score += 50;
                    g.drawString("+50", st.x + 10, 650);
                }
                if(itemball21.get(i).getX() > 800){
                    itemball21.remove(i);
                }
            }
            //===================================================itemball1================================================================================================================================================================
            for (int i = 0; i < itemball11.size(); i++) {
                itemball11.get(i).state = 2;
                g.drawImage(itemball11.get(i).getImage(), itemball11.get(i).getX(), itemball11.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < itemball11.size(); j++) {
                if (Intersect(st.getbound(), itemball11.get(j).getbound())) {
                    itemball11.remove(j);
                    score += 20;
                    g.drawString("+20", st.x + 100, 650);
                }
                if(itemball11.get(j).getX() > 800){
                    itemball11.remove(j);
                }
            }
            //====================================================itemice21================================================================================================================================================================
            for (int i = 0; i < itemice21.size(); i++) {
                itemice21.get(i).state = 2;
                g.drawImage(itemice21.get(i).getImage(), itemice21.get(i).getX(), itemice21.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < itemice21.size(); j++) {
                if (Intersect(st.getbound(), itemice21.get(j).getbound())) {
                    itemice21.remove(j);
                    score += 30;
                    g.drawString("+30", st.x + 100, 650);
                }
                if(itemice21.get(j).getX() > 800){
                    itemice21.remove(j);
                }
            }
            //=======================================================bomb================================================================================================================================================
            for (int i = 0; i < bomb.size(); i++) {
                bomb.get(i).state = 2;
                g.drawImage(bomb.get(i).getImage(), bomb.get(i).getX(), bomb.get(i).getY(), 100, 110, this);
            }
            for (int j = 0; j < bomb.size(); j++) {
                if (Intersect(st.getbound(), bomb.get(j).getbound())) {
                    bomb.remove(j);
                    score -= 20;
                    HP -= 1;
                    g.drawString("-1HP", st.x + 100, 580);
                    g.drawString("-20", st.x + 100, 650);
                }
                if(bomb.get(j).getX() > 800){
                    bomb.remove(j);
                }
            }
     
            
            //=========================================================heal================================================================================================================================================
            for (int i = 0; i < heal.size(); i++) {
                heal.get(i).state = 2;
                g.drawImage(heal.get(i).getImage(), heal.get(i).getX(), heal.get(i).getY(), 110, 110, this);
            }
            for (int j = 0; j < heal.size(); j++) {
                if (Intersect(st.getbound(), heal.get(j).getbound())) {
                    heal.remove(j);
                    HP += 1;
                    g.drawString("+1HP", st.x + 100, 580);
                }
                if(heal.get(j).getX() > 800){
                    heal.remove(j);
                }
            }
            
            //========================================================timeplus===============================================================================================================
            for (int i = 0; i < timeplus.size(); i++) {
                timeplus.get(i).state = 2;
                g.drawImage(timeplus.get(i).getImage(), timeplus.get(i).getX(), timeplus.get(i).getY(), 110, 110, this);
            }
            for (int j = 0; j < timeplus.size(); j++) {
                if (Intersect(st.getbound(), timeplus.get(j).getbound())) {
                    timeplus.remove(j);
                    times += 20;
                }
                if(timeplus.get(j).getX() > 800){
                    timeplus.remove(j);
                }
            }

            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 50));
            g.setColor(Color.gray);
            g.drawString("SCORE =  " + score, 50, 100);
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 80));
            g.drawString("STATE " + 2, 550, 110);
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 65));
            g.drawString("Time " + times, 900, 200);
            g.drawString("HP  " + HP, 50, 200);
        } 
// ====================================================================state 3===============================================================================================================
        
        else if (score >= 300) {
            state = 3;
            g.drawImage(imgstate3.getImage(), 0, 0, 1400, 840, this);
            g.drawImage(pause.getImage(), 1300, 100, 40, 40, this);
            g.drawImage(resume.getImage(), 1300, 170, 40, 40, this);
            g.drawImage(close.getImage(), 1300, 30, 40, 40, this);
            g.drawImage(lilo.getImage(), 1150, 470, 200, 175, this);
            g.drawImage(st.imstitch[form].getImage(),st.x, st.y, 160, 180, this);
            if (st.x <= -200) {
                st.x = this.getWidth() - 20;
            }
            if (st.x > this.getWidth() + 20) {
                st.x = -100;
            }
            //========================================================itemice11==========================================================================================
            for (int i = 0; i < itemice11.size(); i++) {
                itemice11.get(i).state = 3;
                g.drawImage(itemice11.get(i).getImage(), itemice11.get(i).getX(), itemice11.get(i).getY(), 120, 120, this);
            }
            for (int i = 0; i < itemice11.size(); i++) {
                if (Intersect(st.getbound(), itemice11.get(i).getbound())) {
                    itemice11.remove(i);
                    score += 100;
                    g.drawString("+10", st.x + 100, 650);
                }
                if(itemice11.get(i).getX() > 800){
                    itemice11.remove(i);
                }
            }
            // =======================================================itemball2==========================================================================================
            for (int i = 0; i < itemball21.size(); i++) {
                itemball21.get(i).state = 3;
                g.drawImage(itemball21.get(i).getImage(), itemball21.get(i).getX(), itemball21.get(i).getY(), 120, 120, this);
            }
            for (int i = 0; i < itemball21.size(); i++) {
                if (Intersect(st.getbound(), itemball21.get(i).getbound())) {
                    itemball21.remove(i);
                    score += 50;
                    g.drawString("+50", st.x + 10, 650);
                }
                if(itemball21.get(i).getX() > 800){
                    itemball21.remove(i);
                }
            }
            //=======================================================itemball1==========================================================================================
            for (int i = 0; i < itemball11.size(); i++) {
                itemball11.get(i).state = 3;
                g.drawImage(itemball11.get(i).getImage(), itemball11.get(i).getX(), itemball11.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < itemball11.size(); j++) {
                if (Intersect(st.getbound(), itemball11.get(j).getbound())) {
                    itemball11.remove(j);
                    score += 20;
                    g.drawString("+20", st.x + 100, 650);
                }
                if(itemball11.get(j).getX() > 800){
                    itemball11.remove(j);
                }
            }
            //========================================================itemice2==========================================================================================
            for (int i = 0; i < itemice21.size(); i++) {
                itemice21.get(i).state = 3;
                g.drawImage(itemice21.get(i).getImage(), itemice21.get(i).getX(), itemice21.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < itemice21.size(); j++) {
                if (Intersect(st.getbound(), itemice21.get(j).getbound())) {
                    itemice21.remove(j);
                    score += 30;
                    g.drawString("+30", st.x + 100, 650);
                }
                if(itemice21.get(j).getX() > 800){
                    itemice21.remove(j);
                }
            }
            //===========================================================bomb===============================================================================================================
            for (int i = 0; i < bomb.size(); i++) {
                bomb.get(i).state = 3;
                g.drawImage(bomb.get(i).getImage(), bomb.get(i).getX(), bomb.get(i).getY(), 100, 110, this);
            }
            for (int j = 0; j < bomb.size(); j++) {
                if (Intersect(st.getbound(), bomb.get(j).getbound())) {
                    bomb.remove(j);
                    score -= 20;
                    HP -= 1;
                    g.drawString("-1HP", st.x + 100, 580);
                    g.drawString("-20", st.x + 100, 650);
                }
                if(bomb.get(j).getX() > 800){
                    bomb.remove(j);
                }
            }
           
            //===========================================================heal============================================================================================================
            for (int i = 0; i < heal.size(); i++) {
                heal.get(i).state = 3;
                g.drawImage(heal.get(i).getImage(), heal.get(i).getX(), heal.get(i).getY(), 110, 110, this);
            }
            for (int j = 0; j < heal.size(); j++) {
                if (Intersect(st.getbound(), heal.get(j).getbound())) {
                    heal.remove(j);
                    HP += 1;
                    g.drawString("+1HP", st.x + 100, 580);
                }
                if(heal.get(j).getX() > 800){
                    heal.remove(j);
                }
            }
            //========================================================timeplus============================================================================================================
            for (int i = 0; i < timeplus.size(); i++) {
                timeplus.get(i).state = 3;
                g.drawImage(timeplus.get(i).getImage(), timeplus.get(i).getX(), timeplus.get(i).getY(), 110, 110, this);
            }
            for (int j = 0; j < timeplus.size(); j++) {
                if (Intersect(st.getbound(), timeplus.get(j).getbound())) {
                    timeplus.remove(j);
                    times += 20;
                }
                if(timeplus.get(j).getX() > 800){
                    timeplus.remove(j);
                }
            }           
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 50));
            g.setColor(Color.gray);
            g.drawString("SCORE =  " + score, 50, 100);
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 80));
            g.drawString("STATE " + 3, 550, 110);
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 65));
            g.drawString("Time " + times, 900, 200);
            g.drawString("HP  " + HP, 50, 200);
        } 
// =====================================state 1===============================================================================================================        
        else {
            g.drawImage(imgstate1.getImage(), 0, 0, 1400, 840, this);
            g.drawImage(pause.getImage(), 1300, 100, 40, 40, this);
            g.drawImage(resume.getImage(), 1300, 170, 40, 40, this);
            g.drawImage(close.getImage(), 1300, 30, 40, 40, this);
            g.drawImage(st.imstitch[form].getImage(), st.x, st.y, 160, 180, this);

            if (st.x <= -200) {
                st.x = this.getWidth() - 20;
            }
            if (st.x > this.getWidth() + 20) {
                st.x = -100;
            }
            //=====================================================itemball11============================================================================================================================
            for (int i = 0; i < itemball11.size(); i++) {
                g.drawImage(itemball11.get(i).getImage(), itemball11.get(i).getX(), itemball11.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < itemball11.size(); j++) {
                if (Intersect(st.getbound(), itemball11.get(j).getbound())) {
                    itemball11.remove(j);
                    score += 50;
                    g.drawString("+50", st.x + 100, 650);
                }
            }
            //=======================================================itemball2=============================================================================================================================
            for (int i = 0; i < itemball21.size(); i++) {
                itemball21.get(i).state = 1;
                g.drawImage(itemball21.get(i).getImage(), itemball21.get(i).getX(), itemball21.get(i).getY(), 120, 120, this);
            }
            for (int i = 0; i < itemball21.size(); i++) {
                if (Intersect(st.getbound(), itemball21.get(i).getbound())) {
                    itemball21.remove(i);
                    score += 50;
                    g.drawString("+50", st.x + 10, 650);
                }
            }
            //=========================================================itemice2============================================================================================================================
            for (int i = 0; i < itemice21.size(); i++) {
                g.drawImage(itemice21.get(i).getImage(), itemice21.get(i).getX(), itemice21.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < itemice21.size(); j++) {
                if (Intersect(st.getbound(), itemice21.get(j).getbound())) {
                    itemice21.remove(j);
                    score += 30;
                    g.drawString("+30", st.x + 100, 650);
                }
            }
            //========================================================itemice11============================================================================================================================
            for (int i = 0; i < itemice11.size(); i++) {
                g.drawImage(itemice11.get(i).getImage(), itemice11.get(i).getX(), itemice11.get(i).getY(), 120, 120, this);
            }
            for (int i = 0; i < itemice11.size(); i++) {
                if (Intersect(st.getbound(), itemice11.get(i).getbound())) {
                    itemice11.remove(i);
                    score += 10;
                    g.drawString("+10", st.x + 100, 650);
                }
            }
            //=============================================================bomb===============================================================================================================
            for (int i = 0; i < bomb.size(); i++) {
                g.drawImage(bomb.get(i).getImage(), bomb.get(i).getX(), bomb.get(i).getY(), 100, 110, this);
            }
            for (int j = 0; j < bomb.size(); j++) {
                if (Intersect(st.getbound(), bomb.get(j).getbound())) {
                    bomb.remove(j);
                    score -= 20;
                    HP -= 1;
                    g.drawString("-1HP", st.x + 100, 580);
                    g.drawString("-20", st.x + 100, 650);
                }
            }
            
            //=============================================================heal===============================================================================================================
            for (int i = 0; i < heal.size(); i++) {
                g.drawImage(heal.get(i).getImage(), heal.get(i).getX(), heal.get(i).getY(), 200, 200, this);
            }
            for (int j = 0; j < heal.size(); j++) {
                if (Intersect(st.getbound(), heal.get(j).getbound())) {
                    heal.remove(j);
                    HP += 1;
                    g.drawString("+1HP", st.x + 100, 580);
                }
            }
            
            //========================================================timeplus===============================================================================================================
            for (int i = 0; i < timeplus.size(); i++) {
                g.drawImage(timeplus.get(i).getImage(), timeplus.get(i).getX(), timeplus.get(i).getY(), 110, 110, this);
            }
            for (int j = 0; j < timeplus.size(); j++) {
                if (Intersect(st.getbound(), timeplus.get(j).getbound())) {
                    timeplus.remove(j);
                    times += 20;
                }
            }
            
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 50));
            g.setColor(Color.gray);
            g.drawString("SCORE =  " + score, 50, 100);
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 80));
            g.drawString("STATE " + 1, 550, 110);
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 65));
            g.drawString("Time " + times, 900, 200);
            g.drawString("HP  " + HP, 50, 200);
        }
    }
    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }
}