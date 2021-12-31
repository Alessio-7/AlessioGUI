package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.JMenuItem;

import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

/**
 * Sottoclasse di <code>JMenuItem</code> che può impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class MenuItem extends JMenuItem implements Observer {

	private static final long serialVersionUID = 1L;

	private boolean parteSubMenu;

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui          la classe <code>PreferenzeGUI</code> su cui si basa la
	 *                     GUI del <code>MenuItem</code>
	 * @param testo        testo del <code>MenuItem</code>
	 * @param listener     <code>ActionListener</code> da aggiungere al
	 *                     <code>MenuItem</code>
	 * @param parteSubMenu se fa parte di un <i>sub menu<i>, in tal caso avrà uno
	 *                     sfondo diverso
	 */
	public MenuItem( PreferenzeGUI gui, String testo, ActionListener listener, boolean parteSubMenu ) {
		this( gui.colori, gui.fonts, testo, listener, null, parteSubMenu );
		gui.addObserver( this );
	}

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui          la classe <code>PreferenzeGUI</code> su cui si basa la
	 *                     GUI del <code>MenuItem</code>
	 * @param testo        testo del <code>MenuItem</code>
	 * @param listener     <code>ActionListener</code> da aggiungere al
	 *                     <code>MenuItem</code>
	 * @param icona        icona da aggiungere al <code>MenuItem</code>
	 * @param parteSubMenu se fa parte di un <i>sub menu<i>, in tal caso avrà uno
	 *                     sfondo diverso
	 */
	public MenuItem( PreferenzeGUI gui, String testo, ActionListener listener, Icon icona, boolean parteSubMenu ) {
		this( gui.colori, gui.fonts, testo, listener, icona, parteSubMenu );
		gui.addObserver( this );
	}

	/**
	 * Costruttore che impiega le interfaccie <code>Colori</code> e
	 * <code>Fonts</code>
	 *
	 * @param colori       l'interfaccia <code>Colori</code> su cui si basano i
	 *                     colori del <code>MenuItem</code>
	 * @param fonts        l'interfaccia <code>Fonts</code> su cui si basano i font
	 *                     del <code>MenuItem</code>
	 * @param testo        testo del <code>MenuItem</code>
	 * @param listener     <code>ActionListener</code> da aggiungere al
	 *                     <code>MenuItem</code>
	 * @param icona        icona da aggiungere al <code>MenuItem</code>
	 * @param parteSubMenu se fa parte di un <i>sub menu<i>, in tal caso avrà uno
	 *                     sfondo diverso
	 */
	public MenuItem( Colori colori, Fonts fonts, String testo, ActionListener listener, Icon icona, boolean parteSubMenu ) {
		this( parteSubMenu ? colori.subMenu() : colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), testo, listener, icona );
		this.parteSubMenu = parteSubMenu;
	}

	/**
	 * Costruttore con parametri specifici
	 *
	 * @param coloreSfondo colore dello sfondo del <code>MenuItem</code>
	 * @param coloreTesto  colore del testo del <code>MenuItem</code>
	 * @param font         font del <code>Menu</code>
	 * @param testo        testo del <code>MenuItem</code>
	 * @param listener     <code>ActionListener</code> da aggiungere al
	 *                     <code>MenuItem</code>
	 */
	public MenuItem( Color coloreSfondo, Color coloreTesto, Font font, String testo, ActionListener listener ) {
		this( coloreSfondo, coloreTesto, font, testo, listener, null );
	}

	/**
	 * Costruttore con parametri specifici
	 *
	 * @param coloreSfondo colore dello sfondo del <code>MenuItem</code>
	 * @param coloreTesto  colore del testo del <code>MenuItem</code>
	 * @param font         font del <code>Menu</code>
	 * @param testo        testo del <code>MenuItem</code>
	 * @param listener     <code>ActionListener</code> da aggiungere al
	 *                     <code>MenuItem</code>
	 * @param icona        icona da aggiungere al <code>MenuItem</code>
	 */
	public MenuItem( Color coloreSfondo, Color coloreTesto, Font font, String testo, ActionListener listener, Icon icona ) {
		super( testo );
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setFont( font );
		setFocusPainted( false );
		setOpaque( true );
		setBorderPainted( false );
		if ( listener != null ) {
			addActionListener( listener );
		}
		if ( icona != null ) {
			setIcon( icona );
		}
	}

	@Override
	public void update( Observable o, Object arg ) {

		PreferenzeGUI gui = ( PreferenzeGUI ) arg;
		setBackground( parteSubMenu ? gui.colori.subMenu() : gui.colori.sfondo() );
		setForeground( gui.colori.testo() );
		setFont( gui.fonts.fontGenerico( Fonts.PLAIN ) );
	}

}
