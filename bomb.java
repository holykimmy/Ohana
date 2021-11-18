package project01;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class bomb {
    Image img;
    public int x =  (int) (Math.random() * 1300)+20;
    public int y =   100;
    public int count = 0;
    int state = 1;
    bomb(){
        String imageLocation = "bomb.gif";
        URL imageURL = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        runner.start();
        //this.state = s;
    }
    Thread runner = new Thread(new Runnable() {
	public void run() {
            while(true){
		if(state == 1){
                    y += 2;
                }
                else if(state==2){
                    y += 5;
                }
                else if(state == 3){
                    y += 10;
                }
		if(y > 800){
                    img = null;
                    runner.stop();
                }
                try{
                    runner.sleep(25);
                }catch(InterruptedException e){}
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
        return (new Rectangle2D.Double(x, y,50,50));
    }
}
