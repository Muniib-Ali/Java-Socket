package socketsendreceive;

import java.io.*;
import java.net.*;

public class SocketServer_bare {
    public static void main( String[] args ) throws IOException {
         
    	int portNumber = 17777;
    	
    	ServerSocket ss = new ServerSocket( portNumber );
    	Socket s = ss.accept();
        BufferedReader in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
        System.out.println("incoming connection accepted" + s.getInetAddress());
        while ( true ) {
        	String message = in.readLine();
        	/*if(message == null) {
        		ss.close();
        		s.close();
        	}
            System.out.println( "Received: " + message );
            */
            if(message != null && !message.trim().isEmpty()) {
            	System.out.println( "Received: " + message );
            } else {
        		s.close();
        		ss.close();
        		return;
            }
        }
    }
}