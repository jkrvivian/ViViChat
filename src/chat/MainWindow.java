package chat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow {
	private static JFrame window;

	public static void main(String[] args) {
		window = new JFrame("ViViChat");
		window.setIconImage((new ImageIcon("src/photo/logo.png")).getImage());
		window.setSize(400,600);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Login login = new Login();
		ChatPage chatPage = new ChatPage();
		window.setLayeredPane(login.getPane());
		window.setVisible(true);
		
	}
}
