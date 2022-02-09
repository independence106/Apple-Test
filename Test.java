
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;


	@SuppressWarnings("serial")
public class Test extends JFrame implements Runnable {
		private Image dbImage;
		private Graphics dbg;
		
		final int SCREEN_WIDTH = 500;
		final int SCREEN_HEIGHT = 500;
		final int PLAYER_WIDTH = 10;
		final int PLAYER_HEIGHT = 40;
		final int BALL_X = 6;
		final int BALL_Y = 5;
	
		String string = "";
		boolean lost = false;
		int mx, my, difficultyCenter, level, randColor, fps;
		FontMetrics font;
		
		int collisionSide;
		int collisionSideTwo;
		int invisibleCollision;
		boolean playerOnePoint = false;
		boolean playerTwoPoint = false;
		int playerTwoPoints = 0;
		int playerOnePoints = 0;
		int yError;
		boolean mouseClicked = false;
		Color startHover, difficultyHover;
		boolean lose = false;
		
		int losing = 80;
		int winning = 20;
		
		ArrayList<Color> colors = new ArrayList<Color>();
		
		ArrayList<String> difficulty = new ArrayList<String>();
		
		public Test() {
			setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
			setTitle("Box Collision");
			setResizable(false);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			addKeyListener(new AL());
			addMouseListener(new ML());
			addMouseMotionListener(new MM());
			colors.addAll(Arrays.asList(Color.red, Color.blue, Color.yellow, Color.CYAN, Color.pink, Color.magenta 
					, Color.green, Color.orange));
			
			

		}
		
		public class MM extends MouseMotionAdapter {
			public void mouseMoved(MouseEvent e) {
				mx = e.getX();
				my = e.getY();
			}
		}
		
		public class ML extends MouseAdapter {
			public void mousePressed(MouseEvent e) {
				mouseClicked = true;
			}
			
			public void mouseReleased(MouseEvent e) {
				mouseClicked = false;
			}
		}
		
		public class AL extends KeyAdapter {
			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == e.VK_UP)
					setYDirectionOne(-5);
				if(keyCode == e.VK_DOWN) 
					setYDirectionOne(5);
				if(keyCode == e.VK_W)
					setYDirectionTwo(-5);
				if(keyCode == e.VK_S)
					setYDirectionTwo(5);
			}
			@SuppressWarnings("static-access")
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == e.VK_UP)
					setYDirectionOne(0);
				if(keyCode == e.VK_DOWN) 
					setYDirectionOne(0);
				if(keyCode == e.VK_W)
					setYDirectionTwo(0);
				if(keyCode == e.VK_S)
					setYDirectionTwo(0);
			}
			
		}
		
		public void run() {
			try {
				while(true) {
					drawMainMenu();
					System.out.println("doing stuff");
					Thread.sleep(fps);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void move() {
			
		}
		
		
		public void setYDirectionOne(int yDir) {
			
		}
		
		public void setYDirectionTwo(int yDir) {
			
		}
		
		
		public void drawMainMenu() { 
			if(font != null) {
				if(mx >= (SCREEN_WIDTH / 2) - (font.stringWidth("Difficulty: " + difficulty.get(level)) / 2) 
						&& mx <= (SCREEN_WIDTH / 2) + (font.stringWidth("Difficulty: " + difficulty.get(level)) / 2) 
						&& my >= 150 && my <= 240) {
					difficultyHover = Color.gray;
					if(mouseClicked) {
						if(level < 2) {
							level++;
							mouseClicked = false;
							difficultyHover = Color.gray;
						} else if (level >= 2){
							level = 0;
							mouseClicked = false;
						}
					}
				} else {
					difficultyHover = Color.white;
				}
				
				if(mx >= (SCREEN_WIDTH / 2) - (font.stringWidth("Start") / 2) && mx <= (SCREEN_WIDTH / 2) 
						+ (font.stringWidth("Start") / 2) && my >= 40 && my <= 100) {
					startHover = Color.gray;
					if(mouseClicked) {
						
						mouseClicked = false;
					}
				} else {
					startHover = Color.white;
				}
			}
			
			if(level == 0) {
				losing = 80;
				winning = 20;
				fps = 30;
			} else if (level == 1) {
				losing = 60;
				winning = 20;
				fps = 25;
			} else if (level == 2) {
				losing = 30;
				winning = 5;
				fps = 20;
			}
		}
		
		public void loseGame() {
			
		}
		
		public void paint(Graphics g) {
			dbImage = createImage(getWidth(), getHeight());
			dbg = dbImage.getGraphics();
			paintComponent(dbg);
			g.drawImage(dbImage, 0, 0, this);
		}
		
		public void paintComponent(Graphics g) {
			
			
			
		
				g.setFont(new Font("Monaco", Font.PLAIN, 40));
				g.drawString(string, 100, 100);
			
			
			repaint();
		}
		
		public static void main(String[] args) {
			Main jg = new Main();
			
			Thread t1 = new Thread(jg);
			t1.start();
		}
	}	
