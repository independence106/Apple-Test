
//*********************************

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Main extends JPanel implements Runnable{

	static final int GAME_WIDTH = 600;
	static final int GAME_HEIGHT = 600;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	int x = 0;
	int y = 0;
	int playerX = 300;
	int playerY = 300;
	boolean translate = true;
	
	
	Main(){
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	public void paint(Graphics g) {
		g.translate(x, y);
		//shoudl start 1 TILE BACK!!!
		g.clearRect(-1000, -1000, 10000, 10000);
		for (int i = 10; i < 400 / 20; i++) {
			g.setColor(Color.PINK);
			for (int e = 0; e < 800 / 20; e++) {
				g.drawRect(e*20, i*20, 20, 20);
				g.fillRect(e*20, i*20, 20, 20);
			}
		}
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(300, 400, 20, 20);
		g.drawRect(350, 400, 20, 20);
		g.drawRect(0, 400, 20, 20);
		g.drawRect(790, 400, 20, 20);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(playerX, playerY, 20, 20);
		
		
		
		
		
		
		
		
		
		
		
		
	
		System.out.println("translate" + x);
		System.out.println(playerX);
		Toolkit.getDefaultToolkit().sync(); 


		
	}
	
	public void draw(Graphics g) {
		

	}
	public void move(int dir) {
		if (playerX <= 300 || playerX >= 500) {
			translate = false;
		} else {
			translate = true;
		}
		if (translate) {
			if (playerX == 300 || playerX == 500) {
				
			} else {
				x += dir;
			}
			
			playerX = -x + 300;
		} else {
			playerX -= dir;
		}
		
		
		
		
	}
	
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			
				
				repaint();
				delta--;
			

		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_W) {
				move(10);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				move(-10);
			}
		}
		public void keyReleased(KeyEvent e) {
			
		}
	}
}
//*********************************

