import java.io.*;
import java.net.*;

public class Client{
	public static void main(String[] args){
		Socket socket = null;
		DataInputStream in = null;
		DataOutputStream out = null;

		try{
			socket = new Socket("127.0.0.1", 5000);
			
			//this takes input from terminal
			in = new DataInputStream(System.in);
			
			//this sends output stream
			out = new DataOutputStream(socket.getOutputStream());
		}
		catch(Exception e){
			System.out.println(e);
			return;
		}
		
		//this will hold the message from terminal
		String msg = "";
	
		//a while loop to keep sending the messages
		while(!msg.equals("over")){
			try{
				//ig this always keeps reading the input stream
				msg = in.readLine();

				//this writes the input stream to the output stream
				out.writeUTF(msg);
			}
			catch(Exception e){
				System.out.println(e);
				return;
			}

		}
		//we'll finally try to close the connection
		try{
			in.close(); //to close the input stream when the loop is over
			out.close(); //to close the output stream
			socket.close(); //finally we'll close the socket itself to terminate the connection
		}
		catch(Exception e){
			System.out.println(e);
			return;
		}

	}
}
