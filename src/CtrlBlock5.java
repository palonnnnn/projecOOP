import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlBlock5 {
	static LinkedList<Things> block5 = new LinkedList<>();
	Things temp;
	
	public CtrlBlock5() {
		 for(int i=0 ,x=600; i<=x; i++){ //ด้านบน
                addWall(new Things(i,50)); //กำหนดวางรูป x,y
                i+=49;//ความห่างของรูปค่า x
            }

            for(int i=110 ,y=400; i<=y; i++){ //ด้านซ้าย
                addWall(new Things(-30,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            }
            
            for(int i=0 ,x=200; i<=x; i++){ //ด้านล่างซ้าย
                addWall(new Things(i,420)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า x
            }
             for(int i=400 ,x=600; i<=x; i++){ //ด้านล่าง
                addWall(new Things(i,420)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า x
            }
            
            for(int i=110 ,y=400; i<=y; i++){ //ด้านขวา
                addWall(new Things(570,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            }
            
            
	}
	
	
	public void draw(Graphics2D g2d) {
		for(int i=0 ; i<block5.size(); i++) {
			temp = block5.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i=0 ; i<block5.size(); i++) {
			temp = block5.get(i);
			temp.update();
		}
	}
	
	public void addWall(Things things) {
		block5.add(things);
	}
	
	public void removeWall(Things things) {
		block5.remove(things);
	}
	
	public static LinkedList<Things> getThingsTouch(){
		return block5;
	}
		
		
}


