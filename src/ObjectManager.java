import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {

	Rocketship RanShip;
	ArrayList<Projectile> Pro = new ArrayList<Projectile>();
	ObjectManager (Rocketship RanShip){
		this.RanShip=RanShip;
	}
	ArrayList<Aliens> ALi = new ArrayList<Aliens>();
	void update() {
		RanShip.update();
		for(int i = 0; i < Pro.size(); i++){
			Projectile s = Pro.get(i);
			s.update();
		}

	}
void addProjectile(Projectile projectile) {
		Pro.add(projectile);
	}
void addAliens(Aliens Aliens) {
	ALi.add(Aliens);
}

	
	public void draw(Graphics g){
		RanShip.draw(g);
		for(int i = 0; i < Pro.size(); i++){
			Projectile s = Pro.get(i);
			s.draw(g);
		}
	}
}