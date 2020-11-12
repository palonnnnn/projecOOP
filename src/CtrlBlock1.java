import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlBlock1 {
	static LinkedList<Things> block1 = new LinkedList<>();
	Things temp;
        
	public CtrlBlock1() {

            for(int i=0 ,x=600; i<=x; i++){ //ด้านบน
                addWall(new Things(i,50)); //กำหนดวางรูป x,y
                i+=49;//ความห่างของรูปค่า x
            }

            for(int i=170 ,y=464; i<=y; i++){ //ด้านซ้าย
                addWall(new Things(0,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            }
            
            for(int i=49 ,x=588; i<=x; i++){ //ด้านล่าง
                addWall(new Things(i,420)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า x
            }
            
            for(int i=100 ,y=250; i<=y; i++){ //ด้านขวา
                addWall(new Things(550,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            }
            
            for(int i=100 ,y=250; i<=y; i++){ //ด้านกลางซ้าย
                addWall(new Things(150,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            }
            
            
            for(int i=400 ,x=600; i<=x; i++){ //ด้านกลางขวา
                addWall(new Things(i,200)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า x
            }
		
	}
	
	
	public void draw(Graphics2D g2d) {
            for(int i=0 ; i<block1.size(); i++) {
                temp = block1.get(i);
                temp.draw(g2d);
            }
	}
	
	public void update() {
            for(int i=0 ; i<block1.size(); i++) {
                temp = block1.get(i);
                temp.update();
            }
	}
	
	public void addWall(Things things) {
            block1.add(things);
	}
	
	public void removeWall(Things things) {
            block1.remove(things);
	}
	
	public static LinkedList<Things> getThingsTouch(){
            return block1;
	}
		
		
}


