package utility;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;

import gui.Finestra;

public class Dialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public Dialog( Frame finestra, String titolo, boolean modale, int larghezza, int altezza ) {
		this( finestra, titolo, modale, larghezza, altezza, ( Finestra.schermo.width - larghezza ) / 2, ( Finestra.schermo.height - altezza ) / 2 );
	}

	public Dialog( Frame finestra, String titolo, boolean modale, int larghezza, int altezza, int x, int y ) {
		super( finestra, titolo, modale );
		setSize( larghezza, altezza );
		setResizable( false );
		setLocation( x, y );
		setLayout( new BorderLayout() );
	}
}
