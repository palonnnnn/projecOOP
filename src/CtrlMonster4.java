import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlMonster4 {
	static LinkedList<Monster> mon4 = new LinkedList<>();//ประกาศลิ้งลิสไว้ในตัวแปร mon4
	Monster temp;//เรียกใช้คลาส แคท
	
	public CtrlMonster4() {
		addMonster(new Monster(50,200));//เพิ่มตำแหน่งของ แคท ,ใส่ค่าไปในลิ้งลิส
		addMonster(new Monster(400,260));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< mon4.size(); i++) {//เช็คในลิ้งลิส แล้วไปวาด
			temp = mon4.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< mon4.size(); i++) {//เช็คในลิ้งลิสแล้วไปอัพเดต
			temp = mon4.get(i);
			temp.update();
		}
	}
	
	public void addMonster(Monster mon) {
		mon4.add(mon);
	}
	
	public void removeMonster(Monster mon) {
		mon4.remove(mon);
	}
	
	public static LinkedList<Monster> getMonsterTouch() {
		return mon4;
		
	}

}
