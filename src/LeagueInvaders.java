import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final static int width= 1900;
	final static int height=1000;
	GamePanel GameP = new GamePanel();
	
	
public static void main(String[] args) {
	new LeagueInvaders().setup();
	
}
LeagueInvaders(){
	frame = new JFrame();
}
void setup() {
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.add(GameP);
	frame.getContentPane().setPreferredSize(new Dimension(width, height));
	frame.pack();

	GameP.startGame();
	frame.addKeyListener(GameP);
	
}
}