import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Star implements Sprite {
	final private int width=70;
    final private int height=70;
    private Color color;
    int x;
    int y;
   
	
	 public Star(Color color) {
	       
	        this.color = color;
	    }

	    public void draw(Graphics surface, int x, int y) {
	        // Draw the object
	    	this.x=x;
	    	this.y=y;
	    	
	    	int[] yPoints={y+(height/2),y,y+(height/2),y+(height)};
	    	int[] xPoints={x,x+(width/2),x+(width),x+(width/2)};
	        surface.setColor(color);
	        surface.fillPolygon(xPoints, yPoints, 4);	       
	        surface.setColor(Color.BLACK);
	        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
	        surface.drawPolygon(xPoints,yPoints,4);
	        surface.setColor(color);
	        surface.drawRect(x, y, width, height);
	        
	    }

	    public int getWidth() {
	        return width;
	    }

	    public int getHeight() {
	        return height;
	    }

}
