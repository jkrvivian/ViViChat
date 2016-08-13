package chat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow {
	private JFrame window;
	
	public MainWindow(){
		
		window = new JFrame("ViViChat");
		window.setIconImage((new ImageIcon("src/photo/logo.png")).getImage());
		window.setSize(400,600);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		
	}
}
