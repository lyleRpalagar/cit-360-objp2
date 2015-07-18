package threads;
import java.io.IOException;
import java.net.*;

public class main {
   private static String host;
	public static void main(String[] args) {

		
		/* 
		 * If uncomment you can see that this simple program with no threading the results are slow.
		 *   host = "localhost";
       for (int i = 1; i < 10001; i++){
    	   // test if socket is open
    	   try {
			Socket socket = new Socket(host,i);
			System.out.println("Print " + i + " is open....!");
		    socket.close();
		   }catch (Exception e2) {
			// if try gets called the port scanning was not established
			System.out.println("Port " + i + " is not open..!");
		  }
       }
       
       */
		
		/* This program will have threading and will 
		 * run to see if all the ports would run at the same time ( not litterly ) */
		
       host = "localhost";
       for (int i = 1; i < 10001; i++){
    	   // test if socket is open
    	  portThread t = new portThread(host, i );
    	  // calls the run 
    	  t.start();
       }
	}

}
