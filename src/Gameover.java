
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Gameover extends JPanel{
    
	private static final long serialVersionUID = 1L;
	private ImageIcon feildover = new ImageIcon("images/page6.jpg");
        
	private ImageIcon exit = new ImageIcon("images/exit.png");
        
	
	public JButton Bexit  = new JButton(exit);
	
	public Gameover(){
		
		setLayout(null);
                
		Bexit.setBounds(425,350,150,73);
		add(Bexit);
                
                
               Bexit.addMouseListener(new MouseAdapter() {
                    
                        public void mouseClicked(MouseEvent e){
                                    System.exit(0);
                                }		

                    
                });
		
	}
	public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  g.drawImage(feildover.getImage(),0,0,600,500,this);
		  
		  
	      
	  }
}
