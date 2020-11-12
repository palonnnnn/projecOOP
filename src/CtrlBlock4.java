import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlBlock4 {
	static LinkedList<Things> block4 = new LinkedList<>();
	Things temp;
	
	public CtrlBlock4() {
	 for(int i=200 ,x=600; i<=x; i++){ //ด้านบน
                addWall(new Things(i,50)); //กำหนดวางรูป x,y
                i+=49;//ความห่างของรูปค่า x
            }

            for(int i=200 ,y=450; i<=y; i++){ //ด้านซ้าย
                addWall(new Things(0,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            }
            
            for(int i=200 ,x=450; i<=x; i++){ //ด้านล่าง
                addWall(new Things(i,420)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า x
            }
            
            for(int i=220 ,y=350; i<=y; i++){ //ด้านขวา
                addWall(new Things(550,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            }
           
            
            
            for(int i=450 ,x=500; i<=x; i++){ //ด้านกลางขวา
                addWall(new Things(i,220)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า x
            }
	}
	
	
	public void draw(Graphics2D g2d) {
		for(int i=0 ; i<block4.size(); i++) {
			temp = block4.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i=0 ; i<block4.size(); i++) {
			temp = block4.get(i);
			temp.update();
		}
	}
	
	public void addWall(Things things) {
		block4.add(things);
	}
	
	public void removeWall(Things things) {
		block4.remove(things);
	}
	
	public static LinkedList<Things> getThingsTouch(){
		return block4;
	}
		
		
}


