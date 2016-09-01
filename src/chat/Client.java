package chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	
	private String host = "127.0.0.1";
	private int port = 1233;
	public Client() throws UnknownHostException, IOException
	{
		Socket client = new Socket(host, port);
		try{
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			
			out.writeObject("send from client ");
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

