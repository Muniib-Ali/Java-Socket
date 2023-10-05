package socketsendreceive;

import java.io.*;
import java.net.*;

public class SocketClient_bare {
    public static void main( String[] args ) throws IOException {
        
    	System.out.println("connecting:....");
    	int portNumber = 17777;
    	String hostName = "127.0.0.1";
    	
        Socket s = new Socket( hostName, portNumber );
        
        PrintWriter out = new PrintWriter( s.getOutputStream(), true );
        BufferedReader in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
        
        BufferedReader userInput = new BufferedReader( new InputStreamReader(System.in) );
        
        System.out.println("connected to server" + s.getInetAddress()+":" + s.getPort());
        String message = "";
        while ( true ) {
        	System.out.print("send: ");
        	message = userInput.readLine();	//reads keyboard until user hits a newline
        	if(message.equals("CLOSECONNECTION")) {
        		s.close();
        		
        		return;
        	}
            out.println( message );
        }
    }
}




