import java.awt.*;  
import javax.swing.JFrame;  
import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import javax.swing.Timer;

public class GraphicsE extends Canvas implements KeyListener {

    TileMap tileMap = new TileMap();
    int x = 0;
    int y = 0;

    public void paint(Graphics g) {
        for (;;) {
            try {
                Thread.sleep(100);
                g.clearRect(0, 0, 200, 200);

                g.translate(x, y);
    
                for (int i = 0; i < tileMap.map.length; i++) {
                    g.drawRect(i * 20, 0, 20, 20);
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

    }

    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
            x = 1;
            y = 0;
        }
        else {
            x = 0;
            y = 0;
        }
    }
    public void keyReleased(KeyEvent e) {
        
    }
    public static void main(String[] args) {
        GraphicsE graphics = new GraphicsE();
        JFrame fram = new JFrame();
        fram.setSize(400,400);  
        //f.setLayout(null); 
        fram.add(graphics); 
        fram.setVisible(true); 
    }
}
