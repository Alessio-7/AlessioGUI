package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Finestra extends JFrame {

	private static final long serialVersionUID = 1L;

	public static final Dimension schermo = Toolkit.getDefaultToolkit().getScreenSize();

	public Finestra( String titolo, int larghezza, int altezza, int extendedState ) {
		this( titolo, larghezza, 0, schermo.width, altezza, 0, schermo.height, ( schermo.width - larghezza ) / 2, ( schermo.height - altezza ) / 2,
			extendedState, Finestra.EXIT_ON_CLOSE );
	}

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
