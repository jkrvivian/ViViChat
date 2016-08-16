package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChatPage {
	
	private JLayeredPane basicPane;
	private JLabel background;
	
	public ChatPage(){
		basicPane = new JLayeredPane();
		basicPane.setLayout(null);
		
		ImageIcon backgroundPicture = new ImageIcon("src/photo/background.png");
		Image tempBackGroundPicture = backgroundPicture.getImage().getScaledInstance(400, 600, backgroundPicture.getImage().SCALE_DEFAULT);
		background = new JLabel(new ImageIcon(tempBackGroundPicture));
		background.setBounds(0, 0, 400, 600);
		basicPane.add(background,JLayeredPane.DEFAULT_LAYER);
		
	}
	
	public JLayeredPane getPane(){
		return basicPane;
	}
}
