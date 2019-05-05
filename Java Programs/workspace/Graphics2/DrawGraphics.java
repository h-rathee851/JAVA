import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {

	static ArrayList<Mover> shapes = new ArrayList<Mover>();
	// StraightMover star;

	/** Initializes this class for drawing. */
	public DrawGraphics() {
		Rectangle box1 = new Rectangle(40, 30, Color.RED);
		Rectangle box2 = new Rectangle(80, 70, Color.BLUE);
		Rectangle box3 = new Rectangle(40, 60, Color.CYAN);
		Star star1 = new Star(Color.GREEN);
		Star star2 = new Star(Color.RED);
		shapes.add(new Bouncer(100, 0, box1, box1.getHeight(), box1.getWidth()));
		shapes.add(new Bouncer(100, 70, box2, box2.getHeight(), box2.getWidth()));
		shapes.add(new Bouncer(120, 140, box3, box3.getHeight(), box3.getWidth()));
		shapes.add(new Bouncer(200, 0, star1, star1.getHeight(), star1.getWidth()));
		shapes.add(new StraightMover(0, 0, star2, star2.getHeight(), star2.getWidth()));
		shapes.get(0).setMovementVector(2, 1);
		shapes.get(1).setMovementVector(2, 2);
		shapes.get(2).setMovementVector(-2, -2);
		shapes.get(3).setMovementVector(3, 2);
		shapes.get(4).setMovementVector(1, 1);
		
	}

	/** Draw the contents of the window on surface. */
	public void draw(Graphics surface) {
		for (Mover shape : shapes) {
			shape.draw(surface);
		}

	}
}
