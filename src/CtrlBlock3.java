import java.awt.Graphics2D;
import java.util.LinkedList;

public class CtrlBlock3 {
	static LinkedList<Things> block3 = new LinkedList<>();
	Things temp;
	
	public CtrlBlock3() {
            for(int i=0 ,x=600; i<=x; i++){ //ด้านบน
                addWall(new Things(i,50)); //กำหนดวางรูป x,y
                i+=49;//ความห่างของรูปค่า x
            }

            for(int i=230 ,y=464; i<=y; i++){ //ด้านซ้าย
                addWall(new Things(0,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            }
            
            for(int i=0 ,x=588; i<=x; i++){ //ด้านล่าง
                addWall(new Things(i,420)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า x
            }
            
              for(int i=100 ,y=250; i<=y; i++){ //ด้านขวา
                addWall(new Things(550,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            } 
              
            for(int i=100 ,y=200; i<=y; i++){ //ด้านกลางซ้าย
                addWall(new Things(152,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า y
            }
            
             for(int i=320 ,x=400; i<=x; i++){ //ด้านกลางซ้ายล่าง
                addWall(new Things(152,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า x
            }
            
            for(int i=200 ,x=300; i<=x; i++){ //ด้านกลางขวา
                addWall(new Things(350,i)); //กำหนดวางรูป x,y
                i+=49; //ความห่างของรูปค่า x
            }
              
              
		
		
	}
	
	
	public void draw(Graphics2D g2d) {
		for(int i=0 ; i<block3.size(); i++) {
			temp = block3.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i=0 ; i<block3.size(); i++) {
			temp = block3.get(i);
			temp.update();
		}
	}
	
	public void addWall(Things things) {
		block3.add(things);
	}
	
	public void removeWal(Things things) {
		block3.remove(things);
	}
	
	public static LinkedList<Things> getThingsTouch(){
		return block3;
	}
		
		
}


