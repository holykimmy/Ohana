package project01;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class stitch {
    public ImageIcon[] imstitch = new ImageIcon[2];
    public int y = 550;
    public int x;
    public int count = 0;
    stitch() {
        for (int i = 0; i < imstitch.length; i++) {
            String imageLocation = (i + 1) + ".gif";
            imstitch[i] = new ImageIcon(this.getClass().getResource(imageLocation));
        }
    }
    public int getX() {
        
        return x;

    }
    public int getY() {
        return y;

    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(this.x+80,this.y+80,130,130));
    }
    
}
