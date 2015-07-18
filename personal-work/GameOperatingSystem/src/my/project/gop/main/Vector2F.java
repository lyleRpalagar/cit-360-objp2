package my.project.gop.main;

public class Vector2F {

	public float xpos;
	public float ypos;
	
	// public static variables
	public static float worldXpos;
	public static float worldYpos;
	
	
	// 1st constructor 
	public Vector2F(){
		// dont want to give it two locations, leave it defaulted to 0.0f
		this.xpos = 0.0f;
		this.ypos = 0.0F;
	}
	
	// 2nd constructor
	// if we are passing two floats than we are setting the two variables ypos and xpos
	public Vector2F(float xpos, float ypos) {
		 this.xpos = xpos;
		 this.ypos = ypos;
	}
	
	
	
	public  static Vector2F zero(){
		return new Vector2F(0,0);
	}
	
	// normalize etc if we shoot a bullet we need to normalize otherwise if we were to shoot a 2nd bullet in the same direction it will change the first bullets direction to the 2nd bullet
	public void normalize(){
		double length = Math.sqrt(xpos * xpos + ypos * ypos );
		
		if(length != 0.0){
			float s = 1.0f / (float) length;
			xpos = xpos*s;
			ypos = ypos*s;
		}
	}
	
	public Vector2F getScreenLocation(){
		return new Vector2F(xpos,ypos);
	}
	
	public Vector2F getWorldLocation(){
		return new Vector2F(xpos- worldXpos, ypos - worldYpos);
	}

	
	public boolean equals(Vector2F vec){
	// need to return if the 2 Vectors are in the same direction
		return(this.xpos == vec.xpos && this.ypos == vec.ypos);
	}
	
	public Vector2F copy(Vector2F vec){
	// Copy of the vector that we are passing through
	  xpos = vec.xpos;
	  ypos = vec.ypos;
	  return new Vector2F(xpos,ypos);
	}
	
	// adding a new vector for what we already have
	public Vector2F add(Vector2F vec){
		xpos = xpos + vec.xpos;
		ypos = ypos + vec.ypos;
		return new Vector2F(xpos, ypos);
	}
	
	// set the world variables to get it later
	public static void setWorldVariables(float wx, float wy){
		worldXpos = wx;
		worldYpos = wy;
	}
	
	// distance method to determine the distance of two vectors
	public static double getDistanceOnScreen(Vector2F vec1, Vector2F vec2){
		float v1 = vec1.xpos - vec2.xpos;
	    float v2 = vec1.ypos - vec2.ypos;
	    return Math.sqrt(v1*v1 + v2*v2);
	}
	
	public double getDistanceBetweenWorldVectors(Vector2F vec){
		float dx = Math.abs(getWorldLocation().xpos - vec.getWorldLocation().xpos);
		float dy = Math.abs(getWorldLocation().ypos - vec.getWorldLocation().ypos);
		return Math.abs(dx * dx - dy * dy);
	}
	
	
	
	
	
	
	
}
