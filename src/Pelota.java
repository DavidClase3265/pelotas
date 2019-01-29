import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class Pelota {

	private double vx;
	private double vy;
	private double x;
	private double y;
	private int diametro;
	private Dimension dim;
	private Color color;
	private int xmax;
	private int ymax;
	
	public Pelota(Color color, int radio, double x, double y, double d, double v, Dimension dim) {
		this.color = color;
		this.x = x - radio;
		this.y = y - radio;
		vx = v * Math.cos(d);
		vy = v * Math.sin(d);
		diametro = 2 * radio;
		this.dim = dim;
	}
	
	public void mover(long t) {
		double dx = t * vx / 1000000000d;
		double dy = t * vy / 1000000000d;
		x += dx;
		y += dy;
		if (x < 0) {//cada x es para izq y pa abajo y la y pa derech ay arriba creo y eso es para el margen donde rebotan las pelotas, para que en el siguiente frame no se muestre que se sale, que rebote
			x = Math.abs(dx) -x;
			vx *= -1;
		}
		
		else if (x + diametro > dim.width) {
			xmax = dim.width -1;
			x = xmax - diametro - (dx -(x + diametro - xmax));
			vx *= -1;
		}
			
	
	
	//hay que repetir todo pero para y
	if (y < 0) {
		y = Math.abs(dy) -y;
		vy *= -1;
	}
	
	else if (y + diametro > dim.height) {
		ymax = dim.height -1;
		y = ymax - diametro - (dy -(y + diametro - ymax));
		vy *= -1;
	}
		
}
					
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval((int) x, (int) y, diametro, diametro);
		g.setColor(Color.BLACK);
		g.drawOval((int) x, (int) y, diametro, diametro);
	}
	
	
	
}
