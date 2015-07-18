package serialization2;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    
	
	
	public static void main(String[] args) throws Exception {
	   Save obj = new Save();
	   obj.i = 4;
	   
	   // store obj into a file
	   File f = new File("Obj.txt");
	   // defines the data being stored
	   FileOutputStream fos = new FileOutputStream(f);
	   // storing the object int he stream
	   ObjectOutputStream oos = new ObjectOutputStream(fos);
	  // writing the object in the file
	   oos.writeObject(obj);
	   
	   
	   //get the obj back from the file
	   
	   FileInputStream fis = new FileInputStream(f);
	   ObjectInputStream ois = new ObjectInputStream(fis);
	   // Read the obj from Save
	   Save obj1 = (Save) ois.readObject();
	   
	   System.out.println("Value of Obj1 " + obj1.i);
	   
	   
	   //uncomment to tell you, the directory path your file is located.
	   // System.out.printf("File is located at %s%n", f.getAbsolutePath());
	}

}	