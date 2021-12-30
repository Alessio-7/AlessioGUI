package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JSeparator;

import preferenze.Colori;
import preferenze.PreferenzeGUI;

/**
 * Sottoclasse di <code>JSeparator</code> che può impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class Separatore extends JSeparator implements Observer {

	private static final long serialVersionUID = 1L;

	public Separatore( PreferenzeGUI gui ) {
		this( gui.colori );
		gui.addObserver( this );
	}

	public Separatore( Colori colori ) {
		this( colori.bordoSecondario(), colori.bordoGenerico() );
	}

	public Separatore( Color coloreSfondo, Color coloreLinea ) {
		super();
		setOpaque( true );
		setBackground( coloreSfondo );
		setForeground( coloreLinea );

	}

	@Override
	public void update( Observable osservabile, Object obj ) {
		PreferenzeGUI gui = ( PreferenzeGUI ) obj;
		setBackground( gui.colori.bordoSecondario() );
		setForeground( gui.colori.bordoGenerico() );
	}
}
