import java.awt.*;  
import javax.swing.JFrame;  
import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import javax.swing.Timer;

public class GraphicsE extends Canvas {

    TileMap tileMap = new TileMap();

    public void paint(Graphics g) {
        for (;;) {
            try {
                Thread.sleep(100);
                g.clearRect(0, 0, 200, 200);

                g.translate(1, 0);
    
                for (int i = 0; i < tileMap.map.length; i++) {
                    g.drawRect(i * 20, 0, 20, 20);
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

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
