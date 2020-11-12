import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Monster extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int speedx = 1;
	private int speedy = 1;
	
	int n = 0;
	
	Image cat_left;
	Image cat_right;
	Image cat_down;
	Image cat_up;

	public Monster(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		
            for(int i=1;i<=5;i++){
                
                if(Player.lv == i){
                     cat_left   = new ImageIcon("images/Charater/level"+i+"gif/monster_left_lv"+i+".gif").getImage(); //ดึงรูปมาใช้
                     cat_right  = new ImageIcon("images/Charater/level"+i+"gif/monster_right_lv"+i+".gif").getImage(); //ดึงรูปมาใช้
                     cat_down   = new ImageIcon("images/Charater/level"+i+"gif/monster_down_lv"+i+".gif").getImage(); //ดึงรูปมาใช้
                     cat_up     = new ImageIcon("images/Charater/level"+i+"gif/monster_up_lv"+i+".gif").getImage(); //ดึงรูปมาใช้
                     
             
                }
                

                
            }
		if(Player.death == 1 || Player.score == 5) {
			speedx = 0;
			speedy = 0;
		}
		
		if(Player.lv == 1) {//ชนกรอบ เดินกลับ
			x += speedx;
			if(x < 190) {
				speedx = 1;
				n = 1;
			}
			if(x > 450) {
				speedx = -1;
				n = 3;
			}
		}else if(Player.lv == 2) {
			y += speedy;
			if(y < 100) {
				speedy = 1;
				n = 2;
			}
			if(y > 360) {
				speedy = -1;
				n = 4;
			}
		}else if(Player.lv == 3) {//ชนกรอบ เดินกลับ
			x += speedx;
			if(x < 190) {
				speedx = 1;
				n = 1;
			}
			if(x > 500) {
				speedx = -1;
				n = 3;
			}
                        
		}else if(Player.lv == 4) {//ชนกรอบ เดินกลับ
			x += speedx;
			if(x < 52) {
				speedx = 2;
				n = 1;
			}
			if(x > 400) {
				speedx = -2;
				n = 3;
			}
		}else if(Player.lv == 5){
                    
                    if(Player.death == 1 || Player.score == 5) {
			speedx = 0;
		}
			x += speedx;
			if(x < 24) {
				speedx = 2;
				n = 1;
			}
			if(x > 450) {
				speedx = -2;
				n = 3;
			}
                }
		
		
	}
	public void draw(Graphics2D g2d) {
		if(n == 0) {
			if(Player.lv == 1 || Player.lv == 3 || Player.lv == 4  || Player.lv == 5) {
				g2d.drawImage(cat_right,x,y,50,50,this);
			}
			if(Player.lv == 2 ) {
				g2d.drawImage(cat_down,x,y,50,50,this);
			}
		}
		if(n == 1) {
			g2d.drawImage(cat_right,x,y,50,50,this);
		}
		if(n == 2) {
			g2d.drawImage(cat_down,x,y,50,50,this);
		}
		if(n == 3) {
			g2d.drawImage(cat_left,x,y,50,50,this);
		}
		if(n == 4) {
			g2d.drawImage(cat_up,x,y,50,50,this);
		}
	}
	
	public Rectangle getTouch() {
		return new Rectangle(x, y, 28, 28);
	}
}
