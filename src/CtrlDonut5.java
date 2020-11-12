import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlDonut5 {

	static LinkedList<Donut> do5 = new LinkedList<>();
	Donut temp;
	
	public CtrlDonut5() {
		addDonut(new Donut(270,175));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< do5.size(); i++) {
			temp = do5.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< do5.size(); i++) {
			temp = do5.get(i);
			temp.update();
		}
	}
	
	public void addDonut(Donut donut) {
		do5.add(donut);
	}
	
	public void removeDonut(Donut donut) {
		do5.remove(donut);
	}
	
	public static LinkedList<Donut> getDonutTouch() {
		return do5;
	}

}