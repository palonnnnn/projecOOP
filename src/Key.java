import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Key extends KeyAdapter {
	Player p;
		
	public Key(Player p) {
		this.p = p;
	}
		
	public void keyPressed(KeyEvent e) {
		p.keyPressed(e);
	}
		
	public void keyReleased(KeyEvent e) {
		p.keyReleased(e);
	}

}
