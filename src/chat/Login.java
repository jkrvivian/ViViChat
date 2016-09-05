package chat;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Login {

	private String host = "127.0.0.1";
	private int port = 1233;
	private Socket clientSocket;
	private ObjectOutputStream clientOutput;
	
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
		Image tempIconPicture = iconPicture.getImage().getScaledInstance(200, 225, iconPicture.getImage().SCALE_DEFAULT);
		
		icon = new JLabel(new ImageIcon(tempIconPicture));
		icon.setBounds(100,75,200,225);
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
				//connect to server
				try {
					
					if(clientSocket == null)
						clientSocket = new Socket(host, port);
					if(clientOutput == null)
						clientOutput = new ObjectOutputStream(clientSocket.getOutputStream());
					
					try{
						clientOutput.writeObject(new String("Hello"));
						clientOutput.flush();
					} catch(java.io.IOException e1){
						
					}
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
	
	public Socket getSocket(){
		return clientSocket;
	}
}
