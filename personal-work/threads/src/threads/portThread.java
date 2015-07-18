package threads;
import java.net.*;
// extends Thread is in the java library
public class portThread extends Thread {
	
   private String host;
   private int port;
   
   // constructor
   public portThread(String host, int port){
	   // This class variable will put it in the variable.
	   this.host= host;
	   this.port = port;
   }
   
   
   // one way to run thread
   public void run(){
	   try {
			Socket socket = new Socket(host,port);
			System.out.println("Print " + port + " is open....!");
			socket.close();
			return;
		   }catch (Exception e2) {
			// if try gets called the port scanning was not established
		// uncomment to see what ports are not open
			 //  System.out.println("Port " + port + " is not open..!");
		  }
   }
}
