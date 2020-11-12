import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlMonster2 {
	static LinkedList<Monster> mon2 = new LinkedList<>();//ประกาศลิ้งลิสไว้ในตัวแปร Monster1
	public Monster temp;//เรียกใช้คลาส Monster
	
	public CtrlMonster2() {
		addMonster(new Monster(250,165));//เพิ่มตำแหน่งของ Monster ,ใส่ค่าไปในลิ้งลิส
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< mon2.size(); i++) {//เช็คในลิ้งลิส แล้วไปวาด
			temp = mon2.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< mon2.size(); i++) {//เช็คในลิ้งลิสแล้วไปอัพเดต
			temp = mon2.get(i);
			temp.update();
		}
	}
	
	public void addMonster(Monster mon) {
		mon2.add(mon);
	}
	
	public void removeMonster(Monster mon) {
		mon2.remove(mon);
	}
	
	public static LinkedList<Monster> getMonsterTouch() {
		return mon2;
		
	}

}
