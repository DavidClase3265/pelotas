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
		if (x <= 100 || x + diametro+100 >= dim.width)   //cada x es para izq y pa abajo y la y pa derech ay arriba creo y eso es para el margen donde rebotan las pelotas
			vx *= -1;
		else if (y <= 100 || y + diametro  + 100 >= dim.height)
			vy *= -1;
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval((int) x, (int) y, diametro, diametro);
		g.setColor(Color.BLACK);
		g.drawOval((int) x, (int) y, diametro, diametro);
	}
	
	
	
}
