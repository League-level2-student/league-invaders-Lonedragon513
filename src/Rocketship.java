import java.awt.Color;
import java.awt.Graphics;


public class Rocketship extends GameObject {
	boolean right;
	boolean left;
	boolean down;
	boolean  up;
//	int speed;
	   Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	//	speed=5;
	   }

	void update() {
		  super.update();
			if (right) {
	    		x++;
	    	}
	     	if (left) {
	    		x--;
	    	}
	     	if (up) {
	    		y--;
	    	}
	     	if (down) {
	    		y++;
	    	}
	    }
	    
	    public void draw(Graphics g){
	    	  g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

	    }
   }

