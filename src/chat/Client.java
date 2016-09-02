package chat;

import java.awt.Font;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Client {
	
	private String host = "127.0.0.1";
	private int port = 1233;
	
	private JFrame clientWindow;
	private JTextArea message;
	
	public Client() throws UnknownHostException, IOException
	{
		
		clientWindow = new JFrame("Client");
		clientWindow.setSize(400,600);
		clientWindow.setLocationRelativeTo(null);
		clientWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientWindow.setVisible(true);
		
		Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
		message = new JTextArea();
		message.setSize(200, 400);
		message.setFont(font);
		clientWindow.add(message);
		
		Socket client = new Socket(host, port);
		try{
			BufferedOutputStream out = new BufferedOutputStream(client.getOutputStream());
			
			out.write("send from client".getBytes());
			out.flush();
			out.close();
			out = null;
			client.close();
			client = null;
		} catch(java.io.IOException e){
			System.out.println("Error:");
			System.out.println(e);
		}
	}
	
	public static void main(String args[]) throws UnknownHostException, IOException
	{
	         new Client();
	}
}

