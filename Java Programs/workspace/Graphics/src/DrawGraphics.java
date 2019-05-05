
import java.awt.*;
import java.util.*;

import javax.imageio.IIOException;






public class DrawGraphics {
	BouncingBox box1;
	BouncingBox box2;
	BouncingBox box3;
	BouncingOval oval1;
	BouncingImage image;
	ArrayList<BouncingBox> boxes= new ArrayList<BouncingBox>();

	
	/** Initializes this class for drawing. */
	public DrawGraphics() {
		box1 = new BouncingBox(200, 50, Color.BLUE);
		box1.setMovementVector(-2, 1);
		box2 = new BouncingBox(100, 50, Color.RED);
		box2.setMovementVector(-1, 2);
		box3 = new BouncingBox(500,100,Color.CYAN);
		box3.setMovementVector(3, 4);
		oval1 = new BouncingOval(200, 50, Color.GREEN);
		oval1.setMovementVector(0, 4);
		image= new BouncingImage(60,100,"simage.jpg");
		image.setMovementVector(1, 3);
		boxes.add( box1);
		boxes.add( box2);
		boxes.add(box3);
	}

	/**
	 * Draw the contents of the window on surface. Called 20 times per second.
	 */
	public void draw(Graphics surface) {
		
		surface.drawLine(50, 50, 800, 800);
		for(BouncingBox box : boxes){
			box.draw(surface);
			
		}
		oval1.draw(surface);
		
		surface.fillOval(0,0,25,20);
		while(image.loadImg){
		image.draw(surface);
		}
		
	
	}
}
