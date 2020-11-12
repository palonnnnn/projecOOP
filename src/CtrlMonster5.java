import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlMonster5 {
	static LinkedList<Monster> mon5 = new LinkedList<>();		//ประกาศลิ้งลิสไว้ในตัวแปร mon5
	Monster temp;		//เรียกใช้คลาส Monster
	
	public CtrlMonster5() {
		addMonster(new Monster(20,150));		//เพิ่มตำแหน่งของ Monster ,ใส่ค่าไปในลิ้งลิส
		addMonster(new Monster(449,260));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< mon5.size(); i++) {		//เช็คในลิ้งลิส แล้วไปวาด
			temp = mon5.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< mon5.size(); i++) {		//เช็คในลิ้งลิสแล้วไปอัพเดต
			temp = mon5.get(i);
			temp.update();
		}
	}
	
	public void addMonster(Monster mon) {
		mon5.add(mon);
	}
	
	public void removeMonster(Monster mon) {
		mon5.remove(mon);
	}
	
	public static LinkedList<Monster> getMonsterTouch() {
		return mon5;
		
	}

}
