import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlItem3 {

	static LinkedList<Item3> it3 = new LinkedList<>();
	Item3 temp;
	
	public CtrlItem3() {
		addItem3(new Item3(250,150));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< it3.size(); i++) {
			temp = it3.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< it3.size(); i++) {
			temp = it3.get(i);
			temp.update();
		}
	}
	
	public void addItem3(Item3 item3) {
		it3.add(item3);
	}
	
	public void removeItem3(Item3 item3) {
		it3.remove(item3);
	}
	
	public static LinkedList<Item3> getItem3Touch() {
		return it3;
	}

}
