import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlBlock2 {
	static LinkedList<Things> block2 = new LinkedList<>();
	Things temp;
	
	public CtrlBlock2() {
            for(int i=0 ,x=600; i<=x; i++){ //ด้านบน
                addWall(new Things(i,50)); //กำหนดวางรูป x,y
                i+=49;//ความห่างของรูปค่า x
            }

            for(int i=100 ,y=250; i<=y; i++){ //ด้านซ้าย
                addWall(new Things(0,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            }
            
            for(int i=0 ,x=588; i<=x; i++){ //ด้านล่าง
                addWall(new Things(i,420)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า x
            }
            
            for(int i=220 ,y=400; i<=y; i++){ //ด้านขวา
                addWall(new Things(550,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            }
            
            for(int i=172 ,y=400; i<=y; i++){ //ด้านกลางซ้าย
                addWall(new Things(152,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            }
            
            
            for(int i=300 ,x=500; i<=x; i++){ //ด้านกลางขวา
                addWall(new Things(i,220)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า x
            }
	}
	
	
	public void draw(Graphics2D g2d) {
		for(int i=0 ; i<block2.size(); i++) {
			temp = block2.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i=0 ; i<block2.size(); i++) {
			temp = block2.get(i);
			temp.update();
		}
	}
	
	public void addWall(Things things) {
		block2.add(things);
	}
	
	public void removeWall(Things things) {
		block2.remove(things);
	}
	
	public static LinkedList<Things> getThingsTouch(){
		return block2;
	}
		
		
}

