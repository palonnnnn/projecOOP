import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlDonut4 {

	static LinkedList<Donut> do4 = new LinkedList<>();
	Donut temp;
	
	public CtrlDonut4() {
		addDonut(new Donut(150,350));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< do4.size(); i++) {
			temp = do4.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< do4.size(); i++) {
			temp = do4.get(i);
			temp.update();
		}
	}
	
	public void addDonut(Donut donut) {
		do4.add(donut);
	}
	
	public void removeDonut(Donut donut) {
		do4.remove(donut);
	}
	
	public static LinkedList<Donut> getDonutTouch() {
		return do4;
	}

}