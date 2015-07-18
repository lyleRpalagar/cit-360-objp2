package designpatterns.mvc.view;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import designpatterns.mvc.model.Model;

public class View extends JFrame {
      // store a reference to the model in the view class
	 private Model model;
	public View(Model model) throws HeadlessException {
		super("MVC Demo");
		this.model = model;
		
		System.out.println("Hello this is your view, you can find me in View.java");
	}
	
	
	
}
