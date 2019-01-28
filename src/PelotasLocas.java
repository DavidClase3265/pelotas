import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class PelotasLocas extends Juego {

	private static final int MINRADIO = 5;
	private static final int MAXRADIO = 20;
	private static final int MINVEL = 30;
	private static final int MAXVEL = 200;
	private static final Random r = new Random();
	
	private Pelota [] pelotas;
	
	public PelotasLocas(Lienzo lienzo, int numeroPelotas) {
		super(lienzo);
		pelotas = new Pelota[numeroPelotas];
		for (int i=0; i<pelotas.length; i++) {
			Color color=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
			int radio=r.nextInt(MAXRADIO-MINRADIO+1)+MINRADIO;
			double x = r.nextDouble()*601+100;		//por lo del main
	        double y = r.nextDouble()*351+100;
			double dir=r.nextDouble();
			double vel= r.nextDouble()*(MAXVEL-MINVEL+1)+MINVEL;
			pelotas[i] = new Pelota(color, radio, x, y, dir, vel, lienzo.getSize());
		}
	}

	

	@Override
	public void siguiente(long ns) {
		for (int i=0; i<pelotas.length; i++)
			pelotas[i].mover(ns);
	}

	@Override
	public void render(Graphics g) {
		g.fillRect(0, 0, getLienzo().getWidth(), getLienzo().getHeight());
		for (int i=0; i<pelotas.length; i++)
			pelotas[i].paint(g);
	}

}