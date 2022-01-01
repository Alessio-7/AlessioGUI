package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JSeparator;

import preferenze.Colori;
import preferenze.PreferenzeGUI;

/**
 * Sottoclasse di <code>JSeparator</code> che pu&ograve; impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class Separatore extends JSeparator implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui la classe <code>PreferenzeGUI</code> su cui si basa la GUI del
	 *            <code>Separatore</code>
	 */
	public Separatore( PreferenzeGUI gui ) {
		this( gui.colori );
		gui.addObserver( this );
	}

	/**
	 * Costruttore che impiega l' interfaccia <code>Colori</code>
	 *
	 * @param colori l'interfaccia <code>Colori</code> su cui si basano i colori del
	 *               <code>Separatore</code>
	 */
	public Separatore( Colori colori ) {
		this( colori.bordoSecondario(), colori.bordoGenerico() );
	}

	/**
	 * Costruttore con parametri specifici
	 *
	 * @param coloreSfondo colore dello sfondo del <code>Separatore</code>
	 * @param coloreLinea  colore della linea del <code>Separatore</code>
	 */
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
