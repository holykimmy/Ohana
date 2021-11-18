package project01;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class itemice3 {
    //1000,800
    int state = 1;
    int pasueg = 0;
    Image img;
    public int x =  (int) (Math.random() * 1390)+20;
    public int y =   100;
    public int count = 0;
    itemice3() {
        String imageLocation = "ice.gif";
        URL imageURL = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                if(state == 1){
                    y += 3;
                }
                else if(state==2){
                    y += 8;
                }
                else if(state == 3){
                    y += 12;
                }
                if (y > 800) {
                    img = null;
                    runner.stop();
                }
                try {
                    runner.sleep(25);
                } catch (InterruptedException e) {
                }
            }
        }
    });
    public Image getImage() {
        return img;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y,110,110));
    }
}
