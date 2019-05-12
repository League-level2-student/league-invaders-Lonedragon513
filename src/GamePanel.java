import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer t;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font midTitle = new Font("Arial", Font.PLAIN, 24);
	Font SpaceTitle = new Font("Arial", Font.PLAIN, 24);
	int xx = 250;
	int yy = 700;
	Rocketship MainRock = new Rocketship(xx, yy, 50, 50);
	ObjectManager ObjMan1 = new ObjectManager(MainRock);
	public static BufferedImage alienImg;
    public static BufferedImage rocketImg;
    public static BufferedImage bulletImg;
    public static BufferedImage spaceImg;

	GamePanel() {
		// WEUIKUYXESDFGVHBDISOHGSDIUUIDSGIWEUIKUYXESDFGVHBDISOHGSDIUUIDSGIWEUIKUYXESDFGVHBDISOHGSDIUUIDSGIWEUIKUYXESDFGVHBDISOHGSDIUUIDSGIWEUIKUYXESDFGVHBDISOHGSDIUUIDSGIWEUIKUYXESDFGVHBDISOHGSDIUUIDSGIWEUIKUYXESDFGVHBDISOHGSDIUUIDSGIWEUIKUYXESDFGVHBDISOHGSDIUUIDSGIWEUIKUYXESDFGVHBDISOHGSDIUUIDSGIWEUIKUYXESDFGVHBDISOHGSDIUUIDSGIWEUIKUYXESDFGVHBDISOHGSDIUUIDSGIWEUIKUYXESDFGVHBDISOHGSDIUUIDSGIWEUIKUYXESDFGVHBDISOHGSDIUUIDSGI
		t = new Timer(1000 / 600, this);
		try {

            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

    } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.print();

		repaint();

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		ObjMan1.update();
		ObjMan1.manageEnemies();
		ObjMan1.checkCollision();
		ObjMan1.purgeObjects();
		if (MainRock.isAlive == false) {
			currentState = END_STATE;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 20, 200);
		g.setFont(midTitle);
		g.drawString("Press ENTER to start", 120, 400);
		g.setFont(SpaceTitle);
		g.drawString("Press SPACE for instructions", 90, 600);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		ObjMan1.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);

		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 90, 200);
		g.setFont(midTitle);
		g.drawString("You Killed " + ObjMan1.scoreGetter() + " Enemies", 130, 400);
		g.setFont(SpaceTitle);
		g.drawString("Press ENTER To Restart", 90, 600);
	}

	void startGame() {
		t.start();

	}

	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		System.out.println(e.getKeyChar());
		System.out.println(e.getKeyLocation());
		System.out.println(e.getModifiers());

		if (e.getKeyCode() == 10) {

			
		if (currentState == END_STATE) {
				MainRock = new Rocketship(xx, yy, 50, 50);
				ObjMan1 = new ObjectManager(MainRock);
			}currentState++;	if (currentState > END_STATE) {
				currentState = MENU_STATE;
		}
			}
			
		if (e.getKeyCode() == 37) {
			MainRock.left = true;
			System.out.println("left+");
		}
		if (e.getKeyCode() == 38) {
			MainRock.up = true;
			System.out.println("up+");
		}
		if (e.getKeyCode() == 39) {
			MainRock.right = true;
			System.out.println("right+");
		}
		if (e.getKeyCode() == 40) {
			MainRock.down = true;
			System.out.println("down+");
		}

		if (e.getKeyCode() == 8) {
			ObjMan1.addProjectile(new Projectile(MainRock.x + 20, MainRock.y, 10, 10));

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 37) {
			MainRock.left = false;
			System.out.println("left-");
		}
		if (e.getKeyCode() == 38) {
			MainRock.up = false;
			System.out.println("up-");
		}
		if (e.getKeyCode() == 39) {
			MainRock.right = false;
			System.out.println("right-");
		}
		if (e.getKeyCode() == 40) {
			MainRock.down = false;
			System.out.println("down-");
		}
	}
}
