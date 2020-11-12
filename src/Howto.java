import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Howto extends JPanel {

	private static final long serialVersionUID = 1L;
        private ImageIcon bg   = new ImageIcon("images/howto.jpg"); //background
        private ImageIcon home = new ImageIcon("images/back.png"); //ปุ่มกลับหน้าแรก
        private ImageIcon play  = new ImageIcon("images/play.png"); //ปุ่มเริ่ม
    
        public JButton BPlay = new JButton(play);//ปุ่มเริ่ม
        public JButton Bhome  = new JButton(home); //ปุ่มกลับหน้าแรก
        
        public Home Home = new Home();
        
	public Howto(){
            
            setLayout(null); 
		Bhome.setBounds(0,400,150,73);
		add(Bhome);
                
		BPlay.setBounds(450,400,150,73);
		add(BPlay);

                Bhome.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e){
                            Main.frame.remove(Main.frame.howto);//ลบหน้าเริ่มต้นออกแล้วไปหน้าถัดไป
                            if(Main.frame.home == null){//เช็คว่าสร้างหน้า win ยัง?
                                    Main.frame.home = new Home();//ถ้ายังให้สร้าง
                            }
                            Main.frame.add(Main.frame.home);//เอาหน้าจอของ home มาแสดงทั้งหมด
                            Main.frame.home.setSize(Main.WIDTH,Main.HIGHT);
                            Main.frame.home.requestFocusInWindow();
                    }
		});
                
                
                BPlay.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e){
                        Home.playMusic();
                        Main.frame.remove(Main.frame.howto);//ลบหน้าเริ่มต้นออกแล้วไปหน้าถัดไป
                        if(Main.frame.plays == null){//เช็คว่าสร้างหน้า howto ยัง?
                                Main.frame.plays = new Plays();//ถ้ายังให้สร้าง
                        }
                        Main.frame.add(Main.frame.plays);//เอาหน้าจอของ howto มาแสดงทั้งหมด
                        Main.frame.plays.setSize(Main.WIDTH,Main.HIGHT);
                        Main.frame.plays.requestFocusInWindow();                    }
		});
                
	}
	
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bg.getImage(),0,0,600,500,this);//กำหนด x,y,width,height background
        }
}