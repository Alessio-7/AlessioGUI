package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Sottoclasse di <code>JFrame</code> 
 */
public class Finestra extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Dimensioni dello schermo
	 */
	public static final Dimension schermo = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Costruttore sintetico che imposta le grandezze massime della finestra con le grandezze dello schermo e le grandezze minime a 0, 
	 * posiziona la <code>Finestra</code> al centro dello schermo e imposta l'operazione di chiusura con <code>Finestra.EXIT_ON_CLOSE</code>
	 * 
	 * @param titolo titolo della <code>Finestra</code>
	 * @param larghezza larghezza della <code>Finestra</code>
	 * @param altezza altezza della <code>Finestra</code>
	 * @param extendedState stato di estensione della <code>Finestra</code>
	 */
	public Finestra( String titolo, int larghezza, int altezza, int extendedState ) {
		this( titolo, larghezza, 0, schermo.width, altezza, 0, schermo.height, ( schermo.width - larghezza ) / 2, ( schermo.height - altezza ) / 2,
				extendedState, Finestra.EXIT_ON_CLOSE );
	}

	/**
	 * Costruttore con parametri specifici
	 * <p> 
	 * 
	 * Aggiunge inoltre il layout <code>BorderLayout</code>
	 * 
	 * @param titolo titolo della <code>Finestra</code>
	 * @param larghezza larghezza della <code>Finestra</code>
	 * @param larghezzaMin larghezza minima della <code>Finestra</code>
	 * @param larghezzaMax larghezza massima della <code>Finestra</code>
	 * @param altezza altezza della <code>Finestra</code>
	 * @param altezzaMin altezza minima della <code>Finestra</code>
	 * @param altezzaMax altezza massima della <code>Finestra</code>
	 * @param x coordinata x della <code>Finestra</code>
	 * @param y coordinata y della <code>Finestra</code>
	 * @param extendedState stato ti estensione della <code>Finestra</code>
	 * @param defaultCloseOperation operazione di chiusura default della <code>Finestra</code>
	 */
	public Finestra( String titolo, int larghezza, int larghezzaMin, int larghezzaMax, int altezza, int altezzaMin, int altezzaMax, int x, int y,
			int extendedState, int defaultCloseOperation ) {
		super( titolo );
		setSize( larghezza, altezza );
		setMinimumSize( new Dimension( larghezzaMin, altezzaMin ) );
		setMaximumSize( new Dimension( larghezzaMax, altezzaMax ) );
		setExtendedState( extendedState );
		setLocation( x, y );
		setDefaultCloseOperation( defaultCloseOperation );
		setLayout( new BorderLayout() );
	}
}
