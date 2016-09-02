package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChatPage {
	
	private JLayeredPane basicPane;
	private JLabel background;
	private JLayeredPane upPane;
	private JLayeredPane downPane;
	
	public ChatPage(){
		basicPane = new JLayeredPane();
		basicPane.setLayout(null);
		
		Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
		
		ImageIcon backgroundPicture = new ImageIcon("src/photo/background.png");
		Image tempBackGroundPicture = backgroundPicture.getImage().getScaledInstance(400, 600, backgroundPicture.getImage().SCALE_DEFAULT);
		background = new JLabel(new ImageIcon(tempBackGroundPicture));
		background.setBounds(0, 0, 400, 600);
		basicPane.add(background,JLayeredPane.DEFAULT_LAYER);
		
		upPane = new JLayeredPane();
		upPane.setBounds(0,0,400,45);
		upPane.setLayout(null);
		basicPane.add(upPane,JLayeredPane.MODAL_LAYER);
		
		downPane = new JLayeredPane();
		downPane.setBounds(0,500,400,100);
		downPane.setLayout(null);
		basicPane.add(downPane,JLayeredPane.MODAL_LAYER);
	}
	
	public JLayeredPane getPane(){
		return basicPane;
	}
}
