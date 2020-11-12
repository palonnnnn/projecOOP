
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Player extends JPanel {
	
	private static final long serialVersionUID = 1L;  //  ผู้เล่นเริ่มต้นด่านที่ 1 สามารถโผล่ด่านไหนก็ได้
	public static int lv = 1;      
	public static int death = 0;
	public static int score = 0;
	
	public static int speeditem = 0;
	
	
	public static int timeboots = 5;
	
	private int speedx = 0;	//เก็บความเร็วแนวแกน x
	private int speedy = 0;	//เก็บความเร็วแนวแกน y
	
	private int x;
	private int y;
	
	

	private LinkedList<Item1> item1 = CtrlItem1.getItem1Touch();
        private LinkedList<Item2> item2 = CtrlItem2.getItem2Touch();
	private LinkedList<Item3> item3 = CtrlItem3.getItem3Touch();

	
	private LinkedList<Monster> mon1 = CtrlMonster1.getMonsterTouch();
	private LinkedList<Monster> mon2 = CtrlMonster2.getMonsterTouch();
	private LinkedList<Monster> mon3 = CtrlMonster3.getMonsterTouch();
	private LinkedList<Monster> mon4 = CtrlMonster4.getMonsterTouch();
        private LinkedList<Monster> mon5 = CtrlMonster5.getMonsterTouch();
	
	private LinkedList<Things> block1 = CtrlBlock1.getThingsTouch();
	private LinkedList<Things> block2 = CtrlBlock2.getThingsTouch();
	private LinkedList<Things> block3 = CtrlBlock3.getThingsTouch();
	private LinkedList<Things> block4 = CtrlBlock4.getThingsTouch();
	private LinkedList<Things> block5 = CtrlBlock5.getThingsTouch();
	
	private LinkedList<Donut> do1 = CtrlDonut1.getDonutTouch();
	private LinkedList<Donut> do2 = CtrlDonut2.getDonutTouch();
	private LinkedList<Donut> do3 = CtrlDonut3.getDonutTouch();
	private LinkedList<Donut> do4 = CtrlDonut4.getDonutTouch();
	private LinkedList<Donut> do5 = CtrlDonut5.getDonutTouch();
        
    
        
        
        Image player_stand ;
        Image player_up ;
        Image player_left;
        Image player_right;
        Image player_down ;
                    
	
	Timer timer2;
	
	
	
	public Player(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void update() {
        
            for(int i=1;i<=5;i++){
                
                if(Player.lv == i){
                     player_stand   = new ImageIcon("images/Charater/level"+i+"gif/stop_lv"+i+".png").getImage(); //ดึงรูปมาใช้
                     player_up      = new ImageIcon("images/Charater/level"+i+"gif/up_lv"+i+".gif").getImage(); //ดึงรูปมาใช้
                     player_left    = new ImageIcon("images/Charater/level"+i+"gif/left_lv"+i+".gif").getImage(); //ดึงรูปมาใช้
                     player_right   = new ImageIcon("images/Charater/level"+i+"gif/right_lv"+i+".gif").getImage(); //ดึงรูปมาใช้
                     player_down    = new ImageIcon("images/Charater/level"+i+"gif/down_lv"+i+".gif").getImage(); //ดึงรูปมาใช้
             
                }
                

                
            }
               
            
            
               
               
		timer2 = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeboots--;//เวลาของไอเทมรองเท้า
			}
		});
		
		
		x += speedx;//เปลี่ยนค่า speed ในแนวนอน เดิม พอหยุดจะอยู่ตำแหน่งนั้น
		y += speedy;//เปลี่ยนค่า speed ในแนวตั้ง เดิม พอหยุดจะอยู่ตำแหน่งนั้น
		
		if(x <= 0) {//เช็คขอบเขตที่สามารถเดินได้ในแต่ละเลเวล สามารถเดินทะลุได้
			if(lv == 1) {
				x = 0;
			}
			
			if(lv == 2) {
				x = 590;
				lv--;
			}
                        
                        if(lv == 3) {
				x = 540;
                                y = 130;
                                lv++;
			}
                       
			
		}else if(x >= 590) {//ทะลุไปด่าน2
			if(lv == 1) {
				x = 7;
				lv++;
			}
                        
                        if(lv == 3) {
				x = 540;
                                y = 130;
                                
				lv--;
			}
                        
		}else if(x >= 550) {//ทะลุไปด่าน3
                        if(lv == 2) {
				x = 560;
                                y = 320;
				lv++;
			}
                        
                        if(lv == 4) {
				x = 7;
                              
				lv--;
			}
		}else if(y >= 430){
                    if(lv == 4){
                        x = 300;
                        y = 400;
                        lv++;
                    }else if(lv == 5){
                        x = 100;
                        y = 400;
                        lv--;
                    }
                }
                		
		Touch();
	}
	

	
	public void draw(Graphics2D g2d) {
		if(Plays.n == 0) {
			g2d.drawImage(player_stand,x,y,50,50,this);//วาดรูปบนพื้นที่ที่กำหนดไว้
		}
		if(Plays.n == 1) {
			g2d.drawImage(player_right,x,y,50,50,this);
		}
		if(Plays.n == 2) {
			g2d.drawImage(player_left,x,y,50,50,this);
		}
		if(Plays.n == 3) {
			g2d.drawImage(player_down,x,y,50,50,this);
		}
		if(Plays.n == 4) {
			g2d.drawImage(player_up,x,y,50,50,this);
		}

	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT) {//กดขวา เดินขวาทีละ 1
			if(speeditem == 1) {//เช็คว่าโดนไอเทมรองเท้ายัง
				speedx = 3;
                                Plays.n = 1;
			}else {
				speedx = 1;
                                Plays.n = 1;
			}
		}
		if(key == KeyEvent.VK_LEFT) {
			if(speeditem == 1) {
				speedx = -3;
                                Plays.n = 2;
			}else {
				speedx = -1;
				Plays.n = 2;
			}
		}
		if(key == KeyEvent.VK_DOWN) {
			if(speeditem == 1) {
				speedy = 3;
                                Plays.n = 3;
                        }else {
				speedy = 1;
				Plays.n = 3;

			}
		}
		if(key == KeyEvent.VK_UP) {
			if(speeditem == 1) {
				speedy = -3;
                                Plays.n = 4;
			}else {
				speedy = -1;
				Plays.n = 4;

			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT) {//ถ้าปล่อยจากปุ่มจะหยุดเดิน
			speedx = 0;
                        Plays.n = 0;
		}
		if(key == KeyEvent.VK_LEFT) {
			speedx = 0;
                        Plays.n = 0;
		}
		if(key == KeyEvent.VK_DOWN) {
			speedy = 0;
                        Plays.n = 0;
		}
		if(key == KeyEvent.VK_UP) {
			speedy = 0;
                        Plays.n = 0;
		}
	}
	
	public Rectangle getTouch() {//area ของผู้เล่น
		return new Rectangle(x+2, y+1, 40, 40);
	}
	
	public void Touch() {//เช็คการชน
		if(Player.lv == 1) {
			for(int i = 0; i < mon1.size(); i++) {//ชนแมว ให้ตาย
                            
				if(getTouch().intersects(mon1.get(i).getTouch())) {
                                       
					death = 1;
                                        Home.clipHome.stop();
                                        
					Main.frame.remove(Main.frame.plays);//ลบหน้าเกมออกแล้วไปหน้า lose
					if(Main.frame.lose == null){//เช็คว่าสร้างหน้า lose ยัง?
						Main.frame.lose = new Gameover();//ถ้ายังให้สร้าง
					}
					Main.frame.add(Main.frame.lose);//เอาหน้าจอของ lose มาแสดงทั้งหมด
					Main.frame.lose.setSize(Main.WIDTH,Main.HIGHT);
					Main.frame.lose.requestFocusInWindow();
                                        
                                        
				}
			}
			for(int i = 0; i < block1.size(); i++) {//ชนต้นไม้ ให้หยุด
				if(getTouch().intersects(block1.get(i).getTouch())) {
					speedx = 0;
					speedy = 0;
					
					if (Plays.n == 1) {//แล้วถอยหลังกลับ
						x--;
					}
					if (Plays.n == 2) {
						x++;
					}
					if (Plays.n == 3) {
						y--;
					}
					if (Plays.n == 4) {
						y++;
					}
				}	
			}
                        
			for(int i = 0; i < do1.size(); i++) {//ชนเห็ด ให้เพิ่มคะแนน
				if(getTouch().intersects(do1.get(i).getTouch())) {
					do1.remove(i);
					score++;
				}
			}
			
		} else if(Player.lv == 2) {
			for(int i = 0; i < mon2.size(); i++) {//ชนแมว ให้ตาย
				if(getTouch().intersects(mon2.get(i).getTouch())) {
					death = 1;
                                        Home.clipHome.stop();
                                      
					Main.frame.remove(Main.frame.plays);//ลบหน้าเกมออกแล้วไปหน้า lose
					if(Main.frame.lose == null){//เช็คว่าสร้างหน้า lose ยัง?
						Main.frame.lose = new Gameover();//ถ้ายังให้สร้าง
					}
					Main.frame.add(Main.frame.lose);//เอาหน้าจอของ lose มาแสดงทั้งหมด
					Main.frame.lose.setSize(Main.WIDTH,Main.HIGHT);
					Main.frame.lose.requestFocusInWindow();
                                        
                                        
				}
			}
			for(int i = 0; i < block2.size(); i++) {//ชนต้นไม้ ให้หยุด
				if(getTouch().intersects(block2.get(i).getTouch())) {
					speedx = 0;
					speedy = 0;
					
					if (Plays.n == 1) {//แล้วถอยหลังกลับ
						x--;
					}
					if (Plays.n == 2) {
						x++;
					}
					if (Plays.n == 3) {
						y--;
					}
					if (Plays.n == 4) {
						y++;
					}
				}	
			}
			for(int i = 0; i < do2.size(); i++) {//โดนัท ให้เพิ่มคะแนน
				if(getTouch().intersects(do2.get(i).getTouch())) {
					do2.remove(i);
					score++;
				}
			}
                        
                        for(int i = 0; i < item2.size(); i++) {	//ชนรองเท้าเดินเร็วขึ้น
				if(getTouch().intersects(item2.get(i).getTouch())) {
					item2.remove(i);
					timer2.start(); 	
					speeditem = 1;
				}
			}
			
		}else if(Player.lv == 3) {
			for(int i = 0; i < mon3.size(); i++) {//ชนมอนเตอร์ ให้ตาย
				if(getTouch().intersects(mon3.get(i).getTouch())) {
					death = 1;
                                         Home.clipHome.stop();
                                  
					Main.frame.remove(Main.frame.plays);//ลบหน้าเกมออกแล้วไปหน้า lose
					if(Main.frame.lose == null){//เช็คว่าสร้างหน้า lose ยัง?
						Main.frame.lose = new Gameover();//ถ้ายังให้สร้าง
					}
					Main.frame.add(Main.frame.lose);//เอาหน้าจอของ lose มาแสดงทั้งหมด
					Main.frame.lose.setSize(Main.WIDTH,Main.HIGHT);
					Main.frame.lose.requestFocusInWindow();
                                        
                                       
				}
			}
			for(int i = 0; i < block3.size(); i++) {//ชนมอนเตอร์ ให้หยุด
				if(getTouch().intersects(block3.get(i).getTouch())) {
					speedx = 0;
					speedy = 0;
					
						if (Plays.n == 1) {//แล้วถอยหลังกลับ
							x--;
						}
						if (Plays.n == 2) {
							x++;
						}
						if (Plays.n == 3) {
							y--;
						}
						if (Plays.n == 4) {
							y++;
						}
					
				}	
			}
			for(int i = 0; i < do3.size(); i++) {	//ชนเห็ด ให้เพิ่มคะแนน
				if(getTouch().intersects(do3.get(i).getTouch())) {
					do3.remove(i);
					score++;
				}
			}
	
			for(int i = 0; i < item1.size(); i++) {//ชนนาฬิกา เพิ่มเวลา
				if(getTouch().intersects(item1.get(i).getTouch())) {
					item1.remove(i);
					Plays.timey += 100;
				}
			}
                        
                        
		}else if(Player.lv == 4) {
			for(int i = 0; i < mon4.size(); i++) {//ชนแมว ให้ตาย
				if(getTouch().intersects(mon4.get(i).getTouch())) {
					death = 1;
                                         Home.clipHome.stop();
                                       
					Main.frame.remove(Main.frame.plays);//ลบหน้าเกมออกแล้วไปหน้า lose
					if(Main.frame.lose == null){//เช็คว่าสร้างหน้า lose ยัง?
						Main.frame.lose = new Gameover();//ถ้ายังให้สร้าง
					}
					Main.frame.add(Main.frame.lose);//เอาหน้าจอของ lose มาแสดงทั้งหมด
					Main.frame.lose.setSize(Main.WIDTH,Main.HIGHT);
					Main.frame.lose.requestFocusInWindow();
                                        
                                         
				}
			}
			for(int i = 0; i < block4.size(); i++) {//ชนต้นไม้ ให้หยุด
				if(getTouch().intersects(block4.get(i).getTouch())) {
					speedx = 0;
					speedy = 0;
					if (Plays.n == 1) {//แล้วถอยหลังกลับ
						x--;
					}
					if (Plays.n == 2) {
						x++;
					}
					if (Plays.n == 3) {
						y--;
					}
					if (Plays.n == 4) {
						y++;
					}
				}	
			}
			for(int i = 0; i < do4.size(); i++) {//ชนdo ให้เพิ่มคะแนน
				if(getTouch().intersects(do4.get(i).getTouch())) {
					do4.remove(i);
					score++;
				}
			}
                        
			for(int i = 0; i < item3.size(); i++) {	//ชนหัวกะโหลกลดเวลา		
				if(getTouch().intersects(item3.get(i).getTouch())) {
                                    
					item3.remove(i);
                                        Plays.timey -= 20;
				}
			}
			
		}else if(Player.lv == 5) {
			for(int i = 0; i < block5.size(); i++) {//ชนwall ให้หยุด
				if(getTouch().intersects(block5.get(i).getTouch())) {
					speedx = 0;
					speedy = 0;
					
					if (Plays.n == 1) {//แล้วถอยหลังกลับ
						x--;
					}
					if (Plays.n == 2) {
						x++;
					}
					if (Plays.n == 3) {
						y--;
					}
					if (Plays.n == 4) {
						y++;
					}
				}	
			}
			for(int i = 0; i < do5.size(); i++) {//ชนdo ให้เพิ่มคะแนน
				if(getTouch().intersects(do5.get(i).getTouch())) {
					do5.remove(i);
					score++;
				}
			}
			for(int i = 0; i < mon5.size(); i++) {//ชนบอส
				if(getTouch().intersects(mon5.get(i).getTouch())) {

                                    death = 1;
                                    Home.clipHome.stop();
                                   
                                    Main.frame.remove(Main.frame.plays);//ลบหน้าเกมออกแล้วไปหน้า lose
                                    if(Main.frame.lose == null){//เช็คว่าสร้างหน้า lose ยัง?
                                            Main.frame.lose = new Gameover();//ถ้ายังให้สร้าง
                                    }
                                    Main.frame.add(Main.frame.lose);//เอาหน้าจอของ lose มาแสดงทั้งหมด
                                    Main.frame.lose.setSize(Main.WIDTH,Main.HIGHT);
                                    Main.frame.lose.requestFocusInWindow();
						
				
				}
			}
                        
                       
		
            }
            
	}
}