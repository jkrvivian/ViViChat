package chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server extends java.lang.Thread {
	
		private ServerSocket server;
	
		public Server() throws IOException
		{
			//start server
			try{
				server = new ServerSocket(1233);
			}catch(java.io.IOException e)
			{
				System.out.println("Error");
				System.out.println("IOException: " + e);
			}
			
			System.out.println("Server listening...");
		}
		
		public void run()
		{
			while(true)
			{
				Socket tunnel;
				ObjectInputStream in;
				
				try{
					tunnel = server.accept();
					System.out.println("connected successfully!");		
					System.out.println("connected with " + server.getInetAddress());
					
					in=new ObjectInputStream (tunnel.getInputStream());
					//	PrintWriter out=new PrintWriter(tunnel.getOutputStream());
						
						while(true)
						{
							String input = in.readObject().toString();
							int len = input.length();
							if(len == -1)
							{
								in.close();
								in = null;								
								break;
							}
							System.out.println(len);
							System.out.println(input);
						}
						tunnel.close();
						
				} catch(IOException e) {
					System.out.println("something wrong while connecting...");
					System.out.println(e);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
	  }
	public static void main (String args[]) throws IOException
	{
		(new Server()).start();
	}
}

