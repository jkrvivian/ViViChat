package chat;

import java.awt.Font;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.lang.Thread;


public class Server extends Thread {
	
	private ServerSocket server;
	private JFrame serverWindow;
	private JTextArea message;
    //private ArrayList<>;
    
	public Server() 
	{
		serverWindow = new JFrame("Server");
		serverWindow.setSize(400,600);
		serverWindow.setLocationRelativeTo(null);
		serverWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serverWindow.setVisible(true);
		
		message = new JTextArea();
		message.setSize(200, 400);
		message.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
		serverWindow.add(message);
		
		//start server
		try{
			server = new ServerSocket(1233);
		}catch(java.io.IOException e)
		{
			System.out.println("Error"+'\n'+"IOException: " + e);
		}
		message.append("Server listening...\n");
	}
	
	public void run()
	{
		while(true)
		{
			Socket tunnel;
			String clientIP = null;
			try{
				tunnel = server.accept();
				clientIP = server.getInetAddress().toString();
				
				ObjectInputStream clientInput = new ObjectInputStream(tunnel.getInputStream());
				ObjectOutputStream serverOutput = new ObjectOutputStream(tunnel.getOutputStream());
				String data;
				
				message.append("connected successfully!\n");
				message.append("connected with " + clientIP + "\n");
				
				while(true)
				{
					data = (String)clientInput.readObject();
					
					if(data.equals("exit"))
					{
						clientInput.close();
						tunnel.close();
						message.append("Server listening...\n");
					}
					else
						message.append(clientIP + "¡@say :" + data + "\n");
				}
			} catch(IOException e) {
				System.out.println(clientIP + " has something wrong while connecting...");
				System.out.println(e);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	public static void main (String args[]) throws IOException
	{
		Server myServer = new Server();
		myServer.run();
	}
}

