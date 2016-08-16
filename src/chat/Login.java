package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Login {

	private JLayeredPane basicPane;
	private JTextField account;
	private JTextField password;
	private JLabel background;
	private JLabel icon;
	private JButton registerBtn;
	private JButton loginBtn;
	
	public Login(){
		
		basicPane = new JLayeredPane();
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
		
		ImageIcon loginPicture = new ImageIcon("src/photo/loginBtn.png");
		Image temploginPicture = loginPicture.getImage().getScaledInstance(120, 45, loginPicture.getImage().SCALE_DEFAULT);
		ImageIcon loginSelectedPicture = new ImageIcon("src/photo/loginBtnSelected.png");
		Image temploginSelectedPicture = loginSelectedPicture.getImage().getScaledInstance(120, 45, loginSelectedPicture.getImage().SCALE_DEFAULT);
		
		loginBtn = new JButton();
		loginBtn.setIcon(new ImageIcon(temploginPicture));
		loginBtn.setBounds(130, 460, 120, 45);
		loginBtn.setContentAreaFilled(false);
		loginBtn.setBorderPainted(false);
		loginBtn.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				loginBtn.setIcon(new ImageIcon(temploginSelectedPicture));
			}
			public void mouseExited(MouseEvent e) {
				loginBtn.setIcon(new ImageIcon(temploginPicture));
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		basicPane.add(loginBtn,JLayeredPane.MODAL_LAYER);
		
		registerBtn = new JButton("Build a new account");
		registerBtn.setBounds(95, 520, 200, 20);
		registerBtn.setContentAreaFilled(false);
		registerBtn.setBorderPainted(false);
		basicPane.add(registerBtn,JLayeredPane.MODAL_LAYER);
	}
	
	public JLayeredPane getPane(){
		return basicPane;
	}
	
}
