import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlItem1 {

	static LinkedList<Item1> it1 = new LinkedList<>();
	Item1 temp;
	
	public CtrlItem1() {
		addItem1(new Item1(80,350));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< it1.size(); i++) {
			temp = it1.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< it1.size(); i++) {
			temp = it1.get(i);
			temp.update();
		}
	}
	
	public void addItem1(Item1 item1) {
		it1.add(item1);
	}
	
	public void removeItem1(Item1 item1) {
		it1.remove(item1);
	}
	
	public static LinkedList<Item1> getItem1Touch() {
		return it1;
	}

}
