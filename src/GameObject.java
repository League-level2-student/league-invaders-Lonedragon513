import java.awt.Graphics;

public class GameObject {
	int x;
    int y;
    int width;
    int height;
    
    GameObject(int x, int y, int width, int height){
    	
    }
    
    void update() {
    	x++;
    	y++;
    	
    }
    
    public void draw(Graphics g){
		 g.fillRect(x, y, width, height);
      }
}