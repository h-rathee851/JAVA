import java.awt.Graphics;

public interface Mover {
	
	
	 

	
	 public void setMovementVector(int xIncrement, int yIncrement);
	 
	 public void draw(Graphics surface);
	 
	 public int getX();
	 
	 public int getY();
	 
	 public void setxDirection();
	 
	 public void setyDirection();
	 
	 public int getHeight();
	 
	 public int getWidth();
	 
	 public boolean doBounce();
	 
	 public void setX(int newX);
	 
	 public void setY(int newY);
	 
	 

}
