
import javax.swing.*;

public class Main extends JFrame{

	private static final long serialVersionUID = 1L;
	static Main frame; //สร้างตัวแปร frame ไว้ใช้เรียก main
	public static final int WIDTH = 600;
        public static final int HIGHT = 500;
        Home home;
        Plays plays;
        Howto howto;
        Gameover lose;
        Goodjob win;
       
        
        
	public static void main(String args []) {
            new Main();
	}
	public Main() {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH,HIGHT);//ขนาดความยาวของกรอบเกม
		setLocationRelativeTo(null);
		setResizable(false);//ห้ามขยายจอเกม
		home = new Home();
		add(home);
		setVisible(true);//ขึ้นกรอบ
		setTitle("PJ OOP");//หัวชื่อเกม
	}

}
