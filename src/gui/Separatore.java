package gui;

import java.awt.Color;

import javax.swing.JSeparator;

import preferenze.Colori;
import preferenze.PreferenzeGUI;

public class Separatore extends JSeparator {

	private static final long serialVersionUID = 1L;

	public Separatore( PreferenzeGUI gui ) {
		this( gui.colori );
	}

	public Separatore( Colori colori ) {
		this( colori.sfondo(), colori.testo() );
	}

	public Separatore( Color coloreSfondo, Color coloreLinea ) {
		super();
		setOpaque( true );
		setBackground( coloreSfondo );
		setForeground( coloreLinea );

	}
}
