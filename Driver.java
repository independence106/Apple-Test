import java.awt.*;
import javax.swing.*;

public class Driver extends JFrame{

	Main panel;
	
	Driver(){
		panel = new Main();
		this.add(panel);
		this.setTitle("Pong Game");
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
    public static void main(String[] args) {
        Driver driver = new Driver();
    }
}