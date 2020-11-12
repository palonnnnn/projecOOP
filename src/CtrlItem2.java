import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlItem2 {

	static LinkedList<Item2> it2 = new LinkedList<>();
	Item2 temp;
	
	public CtrlItem2() {
		addItem2(new Item2(80,230));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< it2.size(); i++) {
			temp = it2.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< it2.size(); i++) {
			temp = it2.get(i);
			temp.update();
		}
	}
	
	public void addItem2(Item2 item2) {
		it2.add(item2);
	}
	
	public void removeItem2(Item2 item2) {
		it2.remove(item2);
	}
	
	public static LinkedList<Item2> getItem2Touch() {
		return it2;
	}

}
