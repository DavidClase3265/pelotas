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
		
		int tamRef = Math.max(lienzo.getWidth(), lienzo.getHeight());
		int minRadio = (int) (tamRef * 0.02); //2 por ciento
		int maxRadio = (int) (tamRef * 0.10); //10 por ciento de ese tamaño
		
		for (int i=0; i<pelotas.length; i++) {
			Color color=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)); //o con double
			int radio=r.nextInt(maxRadio-minRadio+1)+minRadio;
			int xymin=10 + radio;
			int xmax = lienzo.getWidth() -10 -radio ;	//por si el lienzo no fuese cuadrado, bueno, el lo hace asi, pero se puede hacer de muchas maneras
			int ymax = lienzo.getHeight() -10 -radio;	//por si el lienzo no fuese cuadrado
			int x = r.nextInt(xmax-xymin+1 )+xymin;		//por lo del main puedes o el 601 y 100 pero como todo es mejor con variables pues mejor con hget.width
	        int y = r.nextInt(ymax-xymin+1 )+xymin;
			double dir=r.nextDouble() * 2 * Math.PI; //Para los radianes ya que esta con radianes, double entre 0 y 1 y necesitamos uno entre los radianes por lo de cos y sen
			double vel= r.nextInt(MAXVEL-MINVEL+1)+MINVEL;
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