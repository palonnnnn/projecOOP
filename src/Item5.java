
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Item5 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	Image item1;
	
	public Item5(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		item1 = new ImageIcon("Image/Hourglass.gif").getImage();
	}
			
	
	public void draw(Graphics2D g2d) {
			g2d.drawImage(item1,x,y,50,50,this);
	}
	
	public Rectangle getTouch() {
		return new Rectangle(x, y, 50, 50);
	}
}