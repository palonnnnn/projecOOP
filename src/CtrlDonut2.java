import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlDonut2 {

	static LinkedList<Donut> do2 = new LinkedList<>();
	Donut temp;
	
	public CtrlDonut2() {
		addDonut(new Donut(500,350));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< do2.size(); i++) {
			temp = do2.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< do2.size(); i++) {
			temp = do2.get(i);
			temp.update();
		}
	}
	
	public void addDonut(Donut donut) {
		do2.add(donut);
	}
	
	public void removeDonut(Donut donut) {
		do2.remove(donut);
	}
	
	public static LinkedList<Donut> getDonutTouch() {
		return do2;
	}

}