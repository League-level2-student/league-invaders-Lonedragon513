import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer t;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont= new Font ("Arial", Font.PLAIN,48);
	Font midTitle= new Font ("Arial", Font.PLAIN,24);
	Font SpaceTitle= new Font ("Arial", Font.PLAIN,24);
	int xx= 250;
	int yy= 700;
	Rocketship MainRock = new Rocketship (xx,yy,50,50);

	GamePanel() {
		t = new Timer(1000 / 60, this);
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
	MainRock.update();
	
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
		MainRock.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);   

		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 90, 200);
		g.setFont(midTitle);
		g.drawString("You Killed"+" Enemies", 130, 400);
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
		if (e.getKeyCode()==10) {
			
			currentState++;
		if(currentState > END_STATE){
            currentState = MENU_STATE;
    }
	}
		if (e.getKeyCode()==37) {
			System.out.println("l");
			MainRock.x-=20;
		}
		if (e.getKeyCode()==38) {
			MainRock.y-=20;
			System.out.println("up");
		}
		if (e.getKeyCode()==39) {
			MainRock.x+=20;
			System.out.println("right");
		}
		if (e.getKeyCode()==40) {
			MainRock.y+=20;
			System.out.println("down");
}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
