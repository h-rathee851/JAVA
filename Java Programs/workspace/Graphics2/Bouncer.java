import java.awt.Graphics;

public class Bouncer implements Mover {
	private int x;
	private int y;
	private int xDirection;
	private int yDirection;
	private int height;
	private int width;
	private Sprite sprite;
	private int[] coordinates = new int[2];
	private int[] increment = new int[2];
	final private boolean bounce=true;

	/** Create a Bouncer that positions sprite at (startX, startY). */
	public Bouncer(int startX, int startY, Sprite sprite, int height, int width) {
		x = startX;
		y = startY;
		coordinates[0] = x;
		coordinates[1] = y;
		this.sprite = sprite;
		this.height=height;
		this.width=width;
	}

	/** Starts moving the object in the direction (xIncrement, yIncrement). */
	public void setMovementVector(int xIncrement, int yIncrement) {
		xDirection = xIncrement;
		yDirection = yIncrement;
		increment[0] = xDirection;
		increment[1] = yDirection;
	}

	/** Draws the sprite at its current position on to surface. */
	public void draw(Graphics surface) {

		MovingPatterns move = new MovingPatterns();
		coordinates[0] = x;
		coordinates[1] = y;
		coordinates = move.draw(surface, coordinates, sprite, increment);
		 x = coordinates[0];
		 y = coordinates[1];
		increment = move.bouncer(coordinates, increment, sprite);
		

	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setxDirection(){
		increment[0]=-increment[0];
	}
	
	public void setyDirection(){
		increment[1]=-increment[1];
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public boolean doBounce(){
		return bounce;
	}
	
	public void setX(int newX){
		this.x=newX;
	}
	
	public void setY(int newY){
		this.y=newY;
	}
}
