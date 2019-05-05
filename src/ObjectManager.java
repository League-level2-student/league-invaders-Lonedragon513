import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship RanShip;
	ArrayList<Projectile> Pro = new ArrayList<Projectile>();

	long enemyTimer = 0;
	int enemySpawnTime = 12345;

	ObjectManager(Rocketship RanShip) {
		this.RanShip = RanShip;
	}

	ArrayList<Aliens> ALi = new ArrayList<Aliens>();

	void update() {
		RanShip.update();
		for (int i = 0; i < Pro.size(); i++) {
			Projectile s = Pro.get(i);
			s.update();
		}
		for (int i = 0; i < ALi.size(); i++) {
			Aliens s = ALi.get(i);
			s.update();
		}
		
	}

	void addProjectile(Projectile projectile) {
		Pro.add(projectile);System.out.println(" ®†ƒ√∫˙"+Pro.size());

	}

	void addAliens(Aliens Aliens) {
		ALi.add(Aliens);
	}

	public void draw(Graphics g) {
		RanShip.draw(g);	
		for (int i = 0; i < Pro.size(); i++) {
			Projectile s = Pro.get(i);
			s.draw(g);
			
		}
		for (int i = 0; i < ALi.size(); i++) {
			Aliens s = ALi.get(i);
			s.draw(g);
		}
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAliens(new Aliens(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();

		}
	}

	void purgeObjects() {
		for (int i = ALi.size() - 1; i > 0 - 1; i--) {
			Aliens s = ALi.get(i);
			if (s.isAlive == false) {
				ALi.remove(s);
			}
		}
	}
	
	void checkCollision (){

for(Aliens a : ALi){
        if(RanShip.collisionBox.intersects(a.collisionBox)){
        	RanShip.isAlive = false;
        }
    	for (int i = ALi.size() - 1; i > 0 - 1; i--) {
			Aliens s = ALi.get(i);
			//A#WEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhfWEROKPJidhgwirehgksldhf
}


	}

}
}
