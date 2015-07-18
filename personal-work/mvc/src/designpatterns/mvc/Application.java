package designpatterns.mvc;

import designpatterns.mvc.controller.Controller;
import designpatterns.mvc.model.Model;
import designpatterns.mvc.view.View;

/* This is our main class that will
 * connect our Model,View, and Controller.java classes*/

public class Application {

	public static void main(String[] args) {
       runApp();
	}
   public static void runApp(){
	    // Model; connecting the Model.java
	    Model model = new Model();
	     		   
	    // View; connecting the View.java, this is passing the model into the view to accept
	    View view = new View(model);
	    
	    // Controller; going to have reference to the model and the view
	    	// Controller send commands to the model and view so it will need a reference for both of them
        Controller controller = new Controller(model, view);
   }
}
