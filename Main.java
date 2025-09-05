import java.net.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		int port = 5000;
		Socket socket = null;
		ServerSocket serverSocket = null;
		DataInputStream in = null;

		try{
			//making a new server socket
			serverSocket = new ServerSocket(port);
			
			//i am not sure why we are putting
			//the server socket with accept method inside the socket?
			socket = serverSocket.accept();
		}
		catch(Exception e){
			System.out.println(e);
			return;	
		}

		try{
			//we are taking a data input stream
			//within that we are passing a buffered input stream?
			//i think this is because the response is a buffer not a concrete variable
			//within the buffered stream, we are passing the stuff the socket is sending
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

		}
		catch(Exception e){
			System.out.println(e);
			return;
		}

		String msg = "";
		
		System.out.println("server is listening at port 5000");

		//the while loop will keep listening to the socket
		while(!msg.equals("over")){
			try{	
				//this puts the stuff coming into the message
				msg = in.readUTF();
				System.out.println(msg);
			}
			catch(Exception e){
				System.out.println(e);
				return;
			}
		}

		try{
			//hmm we are closing the socket but not the server socket?
			socket.close();
			in.close();
		}
		catch(Exception e){
			System.out.println(e);
			return;
		}
	}
}
