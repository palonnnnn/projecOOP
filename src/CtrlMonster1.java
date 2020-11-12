import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlMonster1 {
	static LinkedList<Monster> mon1 = new LinkedList<>();//ประกาศลิ้งลิสไว้ในตัวแปร monster1
	Monster temp;//เรียกใช้คลาส moster
	
	public CtrlMonster1() {
		addMonster(new Monster(180,253));//เพิ่มตำแหน่งของ monster ,ใส่ค่าไปในลิ้งลิส
	}	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< mon1.size(); i++) {//เช็คในลิ้งลิส แล้วไปวาด
			temp = mon1.get(i);
			temp.draw(g2d);
		}
	}	
	public void update() {
		for(int i = 0; i< mon1.size(); i++) {//เช็คในลิ้งลิสแล้วไปอัพเดต
			temp = mon1.get(i);
			temp.update();
		}
	}	
	public void addMonster(Monster mon) {
		mon1.add(mon);
	}	
	public void removeMonster(Monster mon) {
		mon1.remove(mon);
	}	
	public static LinkedList<Monster> getMonsterTouch() {
		return mon1;		
	}

}
