

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



public class Home extends JPanel{
    
    private static final long serialVersionUID = 1L;
    private ImageIcon bg   = new ImageIcon("images/page1.gif"); //background
    private ImageIcon play = new ImageIcon("images/letplay1.png"); //ปุ่มเริ่ม
    private ImageIcon how  = new ImageIcon("images/howtoplay2.png"); //ปุ่ม HOW TO?
    private ImageIcon hnon   = new ImageIcon("images/Capture.png"); //hnon
    
    public JButton BPlay = new JButton(play);//ปุ่มเริ่ม
    public JButton Bhow  = new JButton(how); //ปุ่ม HOW TO?
    public static Clip clipHome;
    
    public Home(){
    setLayout(null);
         
        BPlay.setBounds(220,270,150,73); //สร้างปุ่มเริ่ม กำหนด  x,y,width,height
        add(BPlay);
        
        Bhow.setBounds(220,350,150,73);//สร้างปุ่ม how to? กำหนด  x,y,width,height
        add(Bhow);
        
        Bhow.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                Main.frame.remove(Main.frame.home);//ลบหน้าเริ่มต้นออกแล้วไปหน้าถัดไป
//                if(Main.frame.howto == null){//เช็คว่าสร้างหน้า howto ยัง?
                        Main.frame.howto = new Howto();//ถ้ายังให้สร้าง
//                }
                Main.frame.add(Main.frame.howto);//เอาหน้าจอของ howto มาแสดงทั้งหมด
                Main.frame.howto.setSize(Main.WIDTH,Main.HIGHT);
                Main.frame.howto.requestFocusInWindow();
            }
        });
        
        BPlay.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                playMusic();
                Main.frame.remove(Main.frame.home);//ลบหน้าเริ่มต้นออกแล้วไปหน้าถัดไป
                if(Main.frame.plays == null){//เช็คว่าสร้างหน้า play ยัง?
                        Main.frame.plays = new Plays();//ถ้ายังให้สร้าง
                }
                Main.frame.add(Main.frame.plays);//เอาหน้าจอของ paly มาแสดงทั้งหมด
                Main.frame.plays.setSize(Main.WIDTH,Main.HIGHT);
                Main.frame.plays.requestFocusInWindow();
            }
        });


}
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bg.getImage(),0,0,600,500,this);//กำหนด x,y,width,height background
        g.drawImage(hnon.getImage(), -20,110,600,300,this); //hnon
        
}

   public void playMusic() {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("Sound/Map.wav"));
                        clipHome = AudioSystem.getClip();
                        clipHome.open(audioIn);
                        clipHome.loop(Clip.LOOP_CONTINUOUSLY);

                    } catch (Exception exc) {
                        exc.printStackTrace(System.out);
                    }
                }
            }).start();
        }
    
    
}
