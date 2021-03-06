
//*********************************

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;

import org.mapeditor.core.Map;
import org.mapeditor.core.MapLayer;
import org.mapeditor.core.ObjectGroup;
import org.mapeditor.core.Tile;
import org.mapeditor.core.TileLayer;
import org.mapeditor.io.MapReader;
import org.mapeditor.io.TMXMapReader;
import org.mapeditor.view.OrthogonalRenderer;


public class Main extends JPanel implements Runnable{

	static final int GAME_WIDTH = 600;
	static final int GAME_HEIGHT = 600;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);

	// FileSystemTiledReader n = new FileSystemTiledReader();
	// TiledMap m = n.getMap("testFUll.tmx");
	// List<TiledTileset> e = m.getTilesets();
	// TiledTileset o = e.get(0);
	// Collection<TiledTile> pp = o.getTiles();

	MapReader reader = new MapReader();
	// final InputStream stream;
	Map mapREAL;

	OrthogonalRenderer renderer;
	
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	MapDrawer map = new MapDrawer();
	Player player = new Player();
	Random random;
	int x = 0;
	int y = 0;
	int playerX = 300;
	int playerY = 300;
	int imag2x;
	int imag2y;
	boolean movingX = false;
	boolean movingY = false;
	boolean translateX = true;
	boolean translateY = true;
	
	
	public Main() {
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		// map.loadImg();
		imag2x = map.imag2x;
		imag2y = map.imag2y;
		loadMap();
		gameThread = new Thread(this);
		gameThread.start();
		
	}

	public void loadMap() {
		try {
			System.out.println("doing this");
			mapREAL = reader.readMap("tilemaps\testFULL.tmx");
			System.out.println(mapREAL.getFilename());
		} catch (Exception e) {
			//TODO: handle exception
			
		}
		
		// mapREAL.setLayer(0, m);
	
		renderer = new OrthogonalRenderer(mapREAL);
	}
	
	
	public void paint(Graphics g) {

		Toolkit.getDefaultToolkit().sync(); 
		// draw(g);
		for (MapLayer layer : mapREAL.getLayers()) {
            if (layer instanceof TileLayer) {
                renderer.paintTileLayer((Graphics2D) g, (TileLayer) layer);
            } else if (layer instanceof ObjectGroup) {
                renderer.paintObjectGroup((Graphics2D) g, (ObjectGroup) layer);
            }
        }
	}
	
	public void draw(Graphics g) {
		
		
		
		g.translate(player.translationX, player.translationY);
		//shoudl start 1 TILE BACK!!!
		g.clearRect(-1000, -1000, 10000, 10000);
		// for (int i = 10; i < 400 / 20; i++) {
		// 	g.setColor(Color.PINK);
		// 	for (int e = 0; e < 800 / 20; e++) {
		// 		g.drawRect(e*20, i*20, 20, 20);
		// 		g.fillRect(e*20, i*20, 20, 20);
		// 	}
		// }
		
		map.draw(g, this);
		g.setColor(Color.BLACK);
		g.fillRect(400, 400, 20, 20);
		player.draw(g);
		
		Toolkit.getDefaultToolkit().sync(); 


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
				
				if (player.movingX == 1) {
					if (player.playerX + 23 >= 400 && player.playerX + 22 <= 420 && (player.playerY <= 420 && player.playerY >= 380)){
						System.out.println("collision");
					} else {
						player.moveX(-4, 2 * map.imag2x);

					}
				}
				if (player.movingX == -1) {
					if (player.playerX - 20 == 400 && (player.playerY <= 420 && player.playerY >= 380)){
						System.out.println("collision");
					} else {
						player.moveX(4, 2* map.imag2x);

					}
				}
				
				if (player.movingY == 1) {
					if (player.playerY - 20 == 400 && (player.playerX <= 420 && player.playerX >= 380)){
						System.out.println("collision");
					} else {
						player.moveY(4, map.imag2y);

					}
				}
				
				if (player.movingY == -1) {
					if (player.playerY + 20 == 400 && (player.playerX <= 420 && player.playerX >= 380)){
						System.out.println("collision");
					} else {
						player.moveY(-4, map.imag2y);

					}
				}				
				repaint();
				delta--;
			}
			
		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}
	}
	public static void main(String[] args) {
		
	}
}
//*********************************

