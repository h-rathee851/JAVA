import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BouncingImage {
	int x;
	int y;
	String name;
	int xDirection = 0;
	int yDirection = 0;
	public boolean loadImg=true;

	final int SIZE = 40;

	/**
	 * Initialize a new box with its center located at (startX, startY), filled
	 * with startColor.
	 */
	public BouncingImage (int startX, int startY, String name) {
		x = startX;
		y = startY;
		this.name = name;
	}

	/** Draws the box at its current position on to surface. */
	public void draw(Graphics surface) {
		// Draw the object
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Image path not correct");
			loadImg=false;
		}
		// Image img = getImage("sonoo.jpg");
		surface.drawImage(image, x, y, 100, 100, Color.BLUE, null);

		// Move the center of the object each time we draw it
		x += xDirection;
		y += yDirection;
		

		// If we have hit the edge and are moving in the wrong direction,
		// reverse direction
		// We check the direction because if a box is placed near the wall, we
		// would get "stuck"
		// rather than moving in the right direction
		if ((x <= 0 && xDirection < 0) || (x + 100 >= SimpleDraw.WIDTH && xDirection > 0)) {
			xDirection = -xDirection;
		}
		if ((y <= 0 && yDirection < 0) || (y + 100 >= SimpleDraw.HEIGHT && yDirection > 0)) {
			yDirection = -yDirection;
		}

	}

	public void setMovementVector(int xIncrement, int yIncrement) {
		xDirection = xIncrement;
		yDirection = yIncrement;
	}
}
