import java.util.*;


public class Map {
	// reference: https://www.youtube.com/watch?v=j442WG8YzM4
	// reference: https://www.youtube.com/watch?v=J-klDVEtwkM
	    // static going to be used in the main method
	    // hashmap < variable (key), what you want it to be associated (value)>
	static HashMap<String, Boolean> map = new HashMap<>();
    public static void main(String[] args){
    	// Allow to store certain variables with a value
    	// Everytime we get Kenny from the HashMap we will get true
    	map.put("Kenny", true);
    	map.put("Joe", false);
    	map.put("Java", false);
    	map.put("Java", true); // ! if there is a duplicate key the value is override
    	
    	map.remove("Java"); // ! value will be null
    	//get the key
    	System.out.println(map.get("Kenny"));
    	System.out.println(map.get("Java"));
    	// you are going to be use hashmap from when you program.
    	
    	// you can check if the hashmap contains a key "KEYname"
    	if(map.containsKey("Jack")) System.out.println(1);
    	
    	// you can check if the hashmap contains a value 
    	if(map.containsValue(Boolean.FALSE)) System.out.println(2);
    	
    	
    	// loop through and checks the values of the hashmap
    	for(String s : map.keySet()){
    		System.out.println(3);
    	}
    	
    	// loop through and checks the values of the hashmap 
    	for(Boolean b: map.values()){
    		System.out.println(4);
    	}
        

    	
    	
    }
}