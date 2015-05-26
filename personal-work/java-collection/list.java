import java.util.*;

public class List {

	public static void main(String[] args) {
		//  reference : https://www.youtube.com/watch?v=vTgNIh3-aEI
		// TODO Auto-generated method stub
           // Ordered or sequenced collections of objects.
	       // You can access each element in the list via an index
		   // Examples : ArrayList, LinkedList
		   // You can duplicate entries or null values
		
		//creating a list
		// datatype from left to right should match
		ArrayList<String> myToDoList = new ArrayList<String>();
		
		myToDoList.add("Get Groceries");
		myToDoList.add("car wash");
		myToDoList.add("Take son to swim lesson");
		
		// foreach construct to iterate over a collection
		// java will iterate over the right hand of the arg. and save them to eachItemInList
		for (String eachItemInList : myToDoList){
			System.out.println(eachItemInList);
		}
		
		// another way to trigger a list. 
		// will loop through the list length
		for ( int i = 0; i < myToDoList.size(); ++i){
			System.out.println(myToDoList.get(i));
		}
		
		// Another way to iterate through the list 
		Iterator<String> myIter = myToDoList.iterator();
		while (myIter.hasNext()){
			System.out.println(myIter.next());
		}
	}

}
