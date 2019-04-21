import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final static int width= 500;
	final static int height=800;
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
	frame.getContentPane().setPreferredSize(new Dimension(500, 1000));
	frame.pack();

	GameP.startGame();
	frame.addKeyListener(GameP);
	
}
}