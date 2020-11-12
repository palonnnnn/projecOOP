import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlDonut1 {

	static LinkedList<Donut> do1 = new LinkedList<>();
	Donut temp;
	
	public CtrlDonut1() {
		addDonut(new Donut(450,120)); //วางโดนัท x,
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< do1.size(); i++) {
			temp = do1.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< do1.size(); i++) {
			temp = do1.get(i);
			temp.update();
		}
	}
	
	public void addDonut(Donut donut) {
		do1.add(donut);
	}
	
	public void removeDonut(Donut donut) {
		do1.remove(donut);
	}
	
	public static LinkedList<Donut> getDonutTouch() {
		return do1;
	}

}
