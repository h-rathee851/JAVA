import java.awt.Graphics;

public class MovingPatterns {

	public int[] draw(Graphics graphics, int[] coordinates, Sprite sprite, int[] increment) {

		int x = coordinates[0];
		int y = coordinates[1];
		int xDirection = increment[0];
		int yDirection = increment[1];
		x += xDirection;
		y += yDirection;
		sprite.draw(graphics, x, y);
		// Move the center of the object each time we draw it

		coordinates[0] = x;
		coordinates[1] = y;
		return coordinates;
	}

	public int[] bouncer( int[] coordinates, int[] increment, Sprite sprite) {
		int x = coordinates[0];
		int y = coordinates[1];
		int xDirection = increment[0];
		int yDirection = increment[1];

		for (Mover shape : DrawGraphics.shapes) {

			if (shape.getX() != x && shape.getY() != y) {

				if (shape.getClass().getName() != "StraightMover") {

					if (((shape.getX() - x) <= sprite.getWidth() && -shape.getWidth() <= (shape.getX() - x))
							&& ((shape.getY() - y) <= sprite.getHeight() && -shape.getHeight() <= (shape.getY() - y))) {
						
						if (((shape.getX() - x-xDirection) < sprite.getWidth() && -shape.getWidth() < (shape.getX() - x-xDirection))
								&& ((shape.getY() - y-yDirection) < sprite.getHeight() && -shape.getHeight() < (shape.getY() - y-yDirection))){
						
						xDirection = -xDirection;
						yDirection = -yDirection;
						
						
						}
					

						

						

						if (((shape.getX() - x - sprite.getWidth()) > (shape.getY() - y - sprite.getHeight()))
								&& ((shape.getX() - x + shape.getWidth()) < (shape.getY() - y + shape.getHeight()))) {

							if ((shape.getX() - x) <= sprite.getWidth() && (shape.getX() - x) > 0) {
								//shape.setX(x + sprite.getWidth());
							}

							if ((shape.getX() - x) >= -shape.getWidth() && (shape.getX() - x) < 0) {
								//shape.setX(x - shape.getWidth());
							}

						}

						if (((shape.getX() - x - sprite.getWidth()) <= (shape.getY() - y - sprite.getHeight()))
								&& ((shape.getX() - x + shape.getWidth()) >= (shape.getY() - y + shape.getHeight()))) {
							if ((shape.getY() - y) <= sprite.getHeight() && (shape.getY() - y) > 0) {
								//shape.setY(y + sprite.getHeight());
							}
							if ((shape.getY() - y) >= -shape.getHeight() && (shape.getY() - y) < 0) {
								//shape.setY(y - shape.getHeight());
							}

						}
						
					
						

					}
					
				}
				
				
			}
		}
		

		if ((x <= 0 && xDirection < 0) || (x + sprite.getWidth() >= SimpleDraw.WIDTH && xDirection > 0)) {
			xDirection = -xDirection;
		}
		if ((y <= 0 && yDirection < 0) || (y + sprite.getHeight() >= SimpleDraw.HEIGHT && yDirection > 0)) {
			yDirection = -yDirection;
		}
		increment[0] = xDirection;
		increment[1] = yDirection;

		return increment;

	}
}
