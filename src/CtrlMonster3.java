import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlMonster3 {
	static LinkedList<Monster> mon3 = new LinkedList<>();//ประกาศลิ้งลิสไว้ในตัวแปร Monster
	Monster temp;//เรียกใช้คลาส Monster
	
	public CtrlMonster3() {
                addCat(new Monster(450,120));//เพิ่มตำแหน่งของ Monster ,ใส่ค่าไปในลิ้งลิส
		addCat(new Monster(220,370));
		
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< mon3.size(); i++) {//เช็คในลิ้งลิส แล้วไปวาด
			temp = mon3.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< mon3.size(); i++) {//เช็คในลิ้งลิสแล้วไปอัพเดต
			temp = mon3.get(i);
			temp.update();
		}
	}
	
	public void addCat(Monster mon) {
		mon3.add(mon);
	}
	
	public void removeCat(Monster mon) {
		mon3.remove(mon);
	}
	
	public static LinkedList<Monster> getMonsterTouch() {
		return mon3;
		
	}

}
