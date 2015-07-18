package designpatterns.mvc.controller;

import designpatterns.mvc.model.Model;
import designpatterns.mvc.view.View;

public class Controller {
  private View view;
  private Model model;
  
  public Controller(Model model, View view) {
	  this.model = model;
	  this.view = view;
	  
	  System.out.println("Hello this is your Controller, you can find me at Controller.java");
  }  
  
}
