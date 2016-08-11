package chat;

import javax.swing.*;
import java.awt.*;

public class Login {

	private JFrame login;
	private JLayeredPane basicPane;
	private JTextField account;
	private JTextField password;
	private JLabel background;
	private JLabel icon;
	
	private Login(){
		
		login = new JFrame("Login");
		login.setSize(400,600);
		login.setLocationRelativeTo(null);
		basicPane = login.getLayeredPane();
		basicPane.setLayout(null);
		
		ImageIcon iconPicture = new ImageIcon("src/photo/icon.png");
		Image tempIconPicture = iconPicture.getImage().getScaledInstance(245, 200, iconPicture.getImage().SCALE_DEFAULT);
		
		icon = new JLabel(new ImageIcon(tempIconPicture));
		icon.setBounds(90,75,245,200);
		basicPane.add(icon,JLayeredPane.MODAL_LAYER);
		
		ImageIcon backgroundPicture = new ImageIcon("src/photo/background.png");
		Image tempBackGroundPicture = backgroundPicture.getImage().getScaledInstance(400, 600, backgroundPicture.getImage().SCALE_DEFAULT);
		background = new JLabel(new ImageIcon(tempBackGroundPicture));
		background.setBounds(0, 0, 400, 600);
		basicPane.add(background,JLayeredPane.DEFAULT_LAYER);
		
		account = new JTextField("account");
		account.setBounds(100, 350, 200, 35);
		basicPane.add(account,JLayeredPane.MODAL_LAYER);
		
		password = new JTextField("password");
		password.setBounds(100, 400, 200, 35);
		basicPane.add(password,JLayeredPane.MODAL_LAYER);
		
		login.setVisible(true);
	}
	
	public static void main(String[] args) {
		Login l = new Login();

	}
}
