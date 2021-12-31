package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JMenu;

import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

/**
 * Sottoclasse di <code>JMenu</code> che può impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class Menu extends JMenu implements Observer {

	private static final long serialVersionUID = 1L;

	private boolean parteSubMenu;

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui          la classe <code>PreferenzeGUI</code> su cui si basa la
	 *                     GUI del <code>Menu</code>
	 * @param testo        testo del <code>Menu</code>
	 * @param componenti   array di componenti da aggiungere al <code>Menu</code>
	 * @param parteSubMenu se fa parte di un <i>sub menu<i>, in tal caso avrà uno
	 *                     sfondo diverso
	 */
	public Menu( PreferenzeGUI gui, String testo, Component[] componenti, boolean parteSubMenu ) {
		this( gui.colori, gui.fonts, testo, componenti, null, parteSubMenu );
		gui.addObserver( this );
	}

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui          la classe <code>PreferenzeGUI</code> su cui si basa la
	 *                     GUI del <code>Menu</code>
	 * @param testo        testo del <code>Menu</code>
	 * @param componenti   array di componenti da aggiungere al <code>Menu</code>
	 * @param icona        icona da aggiungere al <code>Menu</code>
	 * @param parteSubMenu se fa parte di un <i>sub menu<i>, in tal caso avrà uno
	 *                     sfondo diverso
	 */
	public Menu( PreferenzeGUI gui, String testo, Component[] componenti, Icon icona, boolean parteSubMenu ) {
		this( gui.colori, gui.fonts, testo, componenti, icona, parteSubMenu );
		gui.addObserver( this );
	}

	/**
	 * Costruttore che impiega le interfaccie <code>Colori</code> e
	 * <code>Fonts</code>
	 *
	 * @param colori       l'interfaccia <code>Colori</code> su cui si basano i
	 *                     colori del <code>Menu</code>
	 * @param fonts        l'interfaccia <code>Fonts</code> su cui si basano i font
	 *                     del <code>Menu</code>
	 * @param testo        testo del <code>Menu</code>
	 * @param componenti   array di componenti da aggiungere al <code>Menu</code>
	 * @param icona        icona da aggiungere al <code>Menu</code>
	 * @param parteSubMenu se fa parte di un <i>sub menu<i>, in tal caso avrà uno
	 *                     sfondo diverso
	 */
	public Menu( Colori colori, Fonts fonts, String testo, Component[] componenti, Icon icona, boolean parteSubMenu ) {
		this( parteSubMenu ? colori.subMenu() : colori.sfondo(), colori.bordoSecondario(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), testo,
				componenti, icona );
		this.parteSubMenu = parteSubMenu;
	}

	/**
	 * Costruttore con parametri specifici
	 *
	 * @param coloreSfondo          colore dello sfondo del <code>Menu</code>
	 * @param coloreSfondoPopUpMenu colore dello sfondo del <code>PopUpMenu</code>
	 * @param coloreTesto           colore del testo del <code>Menu</code>
	 * @param font                  font del <code>Menu</code>
	 * @param testo                 testo del <code>Menu</code>
	 * @param componenti            array di componenti da aggiungere al
	 *                              <code>Menu</code>
	 */
	public Menu( Color coloreSfondo, Color coloreSfondoPopUpMenu, Color coloreTesto, Font font, String testo, Component[] componenti ) {
		this( coloreSfondo, coloreSfondoPopUpMenu, coloreTesto, font, testo, componenti, null );
	}

	/**
	 * Costruttore con parametri specifici
	 *
	 * @param coloreSfondo          colore dello sfondo del <code>Menu</code>
	 * @param coloreSfondoPopUpMenu colore dello sfondo del <code>PopUpMenu</code>
	 * @param coloreTesto           colore del testo del <code>Menu</code>
	 * @param font                  font del <code>Menu</code>
	 * @param testo                 testo del <code>Menu</code>
	 * @param componenti            array di componenti da aggiungere al
	 *                              <code>Menu</code>
	 * @param icona                 icona da aggiungere al <code>Menu</code>
	 */
	public Menu( Color coloreSfondo, Color coloreSfondoPopUpMenu, Color coloreTesto, Font font, String testo, Component[] componenti, Icon icona ) {
		super( testo );
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setFont( font );
		setOpaque( true );
		getPopupMenu().setBackground( coloreSfondoPopUpMenu );
		getPopupMenu().setBorder( BorderFactory.createMatteBorder( 2, 2, 2, 2, coloreSfondoPopUpMenu ) );
		setBorderPainted( false );
		if ( icona != null ) {
			setIcon( icona );
		}
		if ( componenti != null && componenti.length != 0 ) {
			for ( Component c : componenti ) {
				add( c );
			}
		}
	}

	@Override
	public void update( Observable o, Object arg ) {

		PreferenzeGUI gui = ( PreferenzeGUI ) arg;
		setBackground( parteSubMenu ? gui.colori.subMenu() : gui.colori.sfondo() );
		setForeground( gui.colori.testo() );
		setFont( gui.fonts.fontGenerico( Fonts.PLAIN ) );
		getPopupMenu().setBackground( gui.colori.bordoSecondario() );
		getPopupMenu().setBorder( BorderFactory.createMatteBorder( 2, 2, 2, 2, gui.colori.bordoSecondario() ) );
	}
}
