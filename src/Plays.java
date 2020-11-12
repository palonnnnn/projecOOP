
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Plays extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
        public Image   bg;
        public Image   bg_win;
	public Image   bg_lose;
	public Image   mushroomy;
	public Image   timeclock;
        
	public Player  player;
        public Timer timer,timer2;
	
	public CtrlMonster1 c1 = new CtrlMonster1();
        public CtrlMonster2 c2 = new CtrlMonster2();
        public CtrlMonster3 c3 = new CtrlMonster3();
        public CtrlMonster4 c4 = new CtrlMonster4();
        public CtrlMonster5 c5 = new CtrlMonster5();

	public CtrlBlock1 block1 = new CtrlBlock1();
        public CtrlBlock2 block2 = new CtrlBlock2();
        public CtrlBlock3 block3 = new CtrlBlock3();
        public CtrlBlock4 block4 = new CtrlBlock4();
        public CtrlBlock5 block5 = new CtrlBlock5();
	
	public CtrlItem1 ite1 = new CtrlItem1();
        public CtrlItem2 ite2 = new CtrlItem2();
        public CtrlItem3 ite3 = new CtrlItem3();


	public CtrlDonut1 Donut1 = new CtrlDonut1();
        public CtrlDonut2 Donut2 = new CtrlDonut2();
        public CtrlDonut3 Donut3 = new CtrlDonut3();
        public CtrlDonut4 Donut4 = new CtrlDonut4();
        public CtrlDonut5 Donut5 = new CtrlDonut5();
	
        public static Clip cliplose;
        
	public static int n = 0;
	public static int timey = 100;
	
	

        int count = 0;
        
	public Plays(){
		timer = new Timer(10,this);
		timer2 = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timey--;
			}
		});


		timer.start();//เริ่มการเล่นเกม
		timer2.start();
                
           
		
		bg = new ImageIcon("images/m1.jpg").getImage();
		
		mushroomy = new ImageIcon("images/bdochoc.png").getImage();
		
		timeclock = new ImageIcon("images/timey.gif").getImage();
		
		player = new Player(0,110);//lv1
		
		addKeyListener(new Key(player));
		setFocusable(true);
                
              
	}
        
        public void playMusiclose() {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("Sound/lose.wav"));
                        cliplose = AudioSystem.getClip();
                        cliplose.open(audioIn);
                        cliplose.loop(Clip.LOOP_CONTINUOUSLY);

                    } catch (Exception exc) {
                        exc.printStackTrace(System.out);
                    }
                }
            }).start();
        }
        
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g.drawImage(bg,0,0,Main.WIDTH,Main.HIGHT,this);

		player.draw(g2d);
		
		g2d.setFont(new Font("Tahoma",Font.BOLD,30));//กำหนดFont และตัวหนังสือ
		g2d.setColor(Color.WHITE);//สีขาว
		g2d.drawString(" : " +Player.score+"/5",50,40);//จำนวนนับคะแนน
		g2d.drawImage(mushroomy,8,5,50,50,this);//ไอเทมนับคะแนน
		g2d.drawString(" : "+timey, 470, 40); //จำนวนนับเวลา
		g2d.drawImage(timeclock,430,10,35,35,this); //รูปเวลา
		
		if(Player.score == 5){
                    Main.frame.remove(Main.frame.plays);//ลบหน้าเกมออกแล้วไปหน้า win
                    if(Main.frame.win == null){//เช็คว่าสร้างหน้า win ยัง?
                            Main.frame.win = new Goodjob();//ถ้ายังให้สร้าง
                    }
                    Main.frame.add(Main.frame.win);//เอาหน้าจอของ win มาแสดงทั้งหมด
                    Main.frame.win.setSize(Main.WIDTH,Main.HIGHT);
                    Main.frame.win.requestFocusInWindow();
                    Home.clipHome.stop();
                    
			
		}
		
		if(timey <=0 ) {//เวลาหมดตาย
			Player.death = 1;
		}
		
		if(Player.timeboots <=0 ) {
			Player.speeditem = 0;
		}
		
		
		if(Player.death == 1) {
			Main.frame.remove(Main.frame.plays);//ลบหน้าเริ่มต้นออกแล้วไปหน้าถัดไป
			if(Main.frame.lose == null){//เช็คว่าสร้างหน้า play ยัง?
				Main.frame.lose = new Gameover();//ถ้ายังให้สร้าง
			}
			Main.frame.add(Main.frame.lose);//เอาหน้าจอของ play มาแสดงทั้งหมด
			Main.frame.lose.setSize(Main.WIDTH,Main.HEIGHT);
			Main.frame.lose.requestFocusInWindow();
			timer2.stop();
                        Home.clipHome.stop();
                        playMusiclose();
		}
		
		if (Player.lv == 1) {//วาดต้นไม้ แมว เห็ด ด่าที่1
			block1.draw(g2d);
			c1.draw(g2d);
			Donut1.draw(g2d);

		}
                
                if (Player.lv == 2) {		
			block2.draw(g2d);
			c2.draw(g2d);
			Donut2.draw(g2d);
			ite2.draw(g2d);
		}
                
		if (Player.lv == 3) {		
			block3.draw(g2d);
			c3.draw(g2d);
			Donut3.draw(g2d);
			ite1.draw(g2d);
		}
		if (Player.lv == 4) {		
			block4.draw(g2d);
			c4.draw(g2d);
			Donut4.draw(g2d);
			ite3.draw(g2d);
		}
		if (Player.lv == 5) {		
			block5.draw(g2d);
			c5.draw(g2d);
			Donut5.draw(g2d);

		}
		
	}
        
        
	public void actionPerformed(ActionEvent e) { //อัพเดตด่าน
		player.update();
			
		if(player.lv == 1) {
			bg = new ImageIcon("images/m1.png").getImage();
			block1.update();
			c1.update();
			Donut1.update();


		}
                
                if(player.lv == 2) {
			bg = new ImageIcon("images/m2.png").getImage();
			block2.update();
			c2.update();
			Donut2.update();
			ite2.update();
		}
                
                
                if(player.lv == 3) {
			bg = new ImageIcon("images/m3.png").getImage();
			block3.update();
			c3.update();
			Donut3.update();
			ite1.update();
		}
                
                if(player.lv == 4) {
			bg = new ImageIcon("images/m4.png").getImage();
			block4.update();
			c4.update();
			Donut4.update();
			ite3.update();
		}
                
                
                if(player.lv == 5) {
			bg = new ImageIcon("images/m5.png").getImage();
			block5.update();
			c5.update();
			Donut5.update();

		}
		
			
		repaint();//วาดเรื่อยๆ
		
	}
        
        
}
