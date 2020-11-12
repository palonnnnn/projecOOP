import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Things extends JPanel{

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	public Image bg;
	public Image bg1;
	public Image bg2;
	
	public Things(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public void draw(Graphics2D g2d) {
		if(Player.lv==4) {
			g2d.drawImage(bg1,0,50,220,149,this);
			g2d.drawImage(bg2,470,300,127,150,this);
		}
		g2d.drawImage(bg,x,y,50,50,this);
		
	}

	
	public void update() {
		if(Player.lv==1) {
			bg = new ImageIcon("images/w1.png").getImage();
		}
		else if(Player.lv==2){
			bg = new ImageIcon("images/w2.png").getImage();
		}
		else if(Player.lv==3){
			bg = new ImageIcon("images/w3.png").getImage();
		}
		else if(Player.lv==4){
			bg1 = new ImageIcon("images/snow.png").getImage();
			bg = new ImageIcon("images/w4.png").getImage();
			bg2 = new ImageIcon("images/snow1.png").getImage();
		}
		else if(Player.lv==5){
			bg = new ImageIcon("images/w5.png").getImage();
		}
	}
	
	public Rectangle getTouch() {
		return new Rectangle(x, y, 50,50);
	}

}
