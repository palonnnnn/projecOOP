import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlDonut3 {

	static LinkedList<Donut> do3 = new LinkedList<>();
	Donut temp;
	
	public CtrlDonut3() {
		addDonut(new Donut(450,100));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< do3.size(); i++) {
			temp = do3.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< do3.size(); i++) {
			temp = do3.get(i);
			temp.update();
		}
	}
	
	public void addDonut(Donut donut) {
		do3.add(donut);
	}
	
	public void removeDonut(Donut donut) {
		do3.remove(donut);
	}
	
	public static LinkedList<Donut> getDonutTouch() {
		return do3;
	}

}