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

public class GraphicsE extends JPanel implements KeyListener {

    TileMap tileMap = new TileMap();
    int x = 0;
    int y = 0;

    public void paint(Graphics g) {        
        for (;;) {
            try {
                Thread.sleep(100);

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
            System.out.println("doing smthing");
            x = 0;
            y = 0;
        }
        repaint();
    }
    public void keyReleased(KeyEvent e) {
        
    }
    public static void main(String[] args) {
        GraphicsE g = new GraphicsE();
        JFrame f = new JFrame();
        f.add(g);

        //f.setLayout(null); 

        
        f.setSize(400, 400);
        f.addKeyListener(new KeyListener() {
            
            public void keyPressed(KeyEvent e) {
                System.out.println("e");
                
                f.repaint();

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            } 
        });
        f.setFocusable(true);
        f.setVisible(true);

    }
}
