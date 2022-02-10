
//*********************************

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;

public class Main extends JPanel implements Runnable{

	static final int GAME_WIDTH = 600;
	static final int GAME_HEIGHT = 600;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	BufferedImage imag2;
	Random random;
	int x = 0;
	int y = 0;
	int playerX = 300;
	int playerY = 300;
	int imag2x;
	int imag2y;
	boolean translateX = true;
	boolean translateY = true;
	
	
	public Main() {
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		loadImg();
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void loadImg() {
		try {
			imag2 = ImageIO.read(new File("map.jpg"));

		} catch (Exception e) {
			//TODO: handle exception
		}
		imag2x = imag2.getWidth();
		imag2y = imag2.getHeight();
	}
	
	
	public void paint(Graphics g) {
		Toolkit.getDefaultToolkit().sync(); 

		draw(g);
	}
	
	public void draw(Graphics g) {
		
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
		g.drawImage(imag2, 0, 0, this);																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(300, 400, 20, 20);
		g.drawRect(350, 400, 20, 20);
		g.drawRect(0, 400, 20, 20);
		g.drawRect(790, 400, 20, 20);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(playerX, playerY, 20, 20);
		Toolkit.getDefaultToolkit().sync(); 


	}
	public void moveX(int dir) {
		playerX -= dir;

		if (playerX <= 300 || playerX >= imag2x- 300) {
			translateX = false;
		} else {
			translateX = true;
		}
		if (translateX) {
			x += dir;
			playerX = -x + 300;
		}
		repaint();
	}
	public void moveY(int dir) {
		playerY -= dir;

		if (playerY <= 300 || playerY >= imag2y - 300) {
			translateY = false;
		} else {
			translateY = true;
		}
		if (translateY) {
			y += dir;
			playerY = -y + 300;
		}
		repaint();
	}
	
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				repaint();
				delta--;
			}
		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_W) {
				moveY(-2);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				moveY(2);
			}
			if(e.getKeyCode()==KeyEvent.VK_A) {
				moveX(2);
			}
			if(e.getKeyCode()==KeyEvent.VK_D) {
				moveX(-2);
			}
		}
		public void keyReleased(KeyEvent e) {
			
		}
	}
}
//*********************************

