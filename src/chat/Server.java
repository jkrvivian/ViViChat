package chat;

import java.awt.Font;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;


public class Server extends java.lang.Thread {
	
		private ServerSocket server;
		private JFrame serverWindow;
		private JTextArea message;
	    //private ArrayList<>;
	    
		public Server() throws IOException
		{
			serverWindow = new JFrame("Server");
			serverWindow.setSize(400,600);
			serverWindow.setLocationRelativeTo(null);
			serverWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			serverWindow.setVisible(true);
			
			Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
			message = new JTextArea();
			message.setSize(200, 400);
			message.setFont(font);
			serverWindow.add(message);
			
			//start server
			try{
				server = new ServerSocket(1233);
			}catch(java.io.IOException e)
			{
				System.out.println("Error");
				System.out.println("IOException: " + e);
			}
			message.append("Server listening...\n");
			System.out.println("Server listening...");
		}
		
		public void run()
		{
			while(true)
			{
				Socket tunnel;
				BufferedInputStream in;
				
				try{
					tunnel = server.accept();
					message.append("connected successfully!\n");
					message.append("connected with " + server.getInetAddress() + "\n");
					System.out.println("connected successfully!");		
					System.out.println("connected with " + server.getInetAddress());
					
					in=new BufferedInputStream (tunnel.getInputStream());
					//	PrintWriter out=new PrintWriter(tunnel.getOutputStream());

						while(true)
						{
							byte[] input = new byte[2048];
							int len;							
							if((len =  in.read(input)) < 0)
							{
								in.close();
								in = null;								
								break;
							}
							String data = new String(input, 0 ,len);
							message.append(Integer.toString(len)+ "\n");
							message.append(data+ "\n");
							System.out.println(len);
							System.out.println(data);
						}
						tunnel.close();
						
				} catch(IOException e) {
					System.out.println("something wrong while connecting...");
					System.out.println(e);
				}
		    }
	  }
	public static void main (String args[]) throws IOException
	{
		(new Server()).start();
	}
}

