package chat;

import java.awt.Font;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Client {
	
	private String host = "127.0.0.1";
	private int port = 1233;
	private Scanner scanner;
	
	private JFrame clientWindow;
	
	public Client() throws UnknownHostException, IOException
	{
		//gui
		ChatPage chatPage = new ChatPage();
		clientWindow = new JFrame("Client");
		clientWindow.setSize(400,600);
		clientWindow.setLocationRelativeTo(null);
		clientWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		clientWindow.setLayeredPane(chatPage.getPane());
		clientWindow.setVisible(true);		
		
		Socket client = new Socket(host, port);
		scanner = new Scanner(System.in);
		
		try{
			BufferedOutputStream out = new BufferedOutputStream(client.getOutputStream());
			while(true)
			{
				String data = scanner.nextLine();
				if(data.length() >= 0)
				{
					out.write(data.getBytes());
					out.flush(); System.out.println("1");
				}
				else
				{
					out.close();
					out = null;
					break;
				}
			}
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

