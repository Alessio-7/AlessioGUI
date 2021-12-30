package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.border.Border;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

/**
 * Sottoclasse di <code>JButton</code> che può impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */

public class Bottone extends JButton implements Observer {

	private static final long serialVersionUID = 1L;

	private MouseListener cambiaBordo;

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 * 
	 * @param gui            la classe <code>PreferenzeGUI</code> su cui si basa la
	 *                       GUI del <code>Bottone</code>
	 * @param testo          il testo del <code>Bottone</code>
	 * @param actionListener la classe <code>ActionListener</code> che viene
	 *                       aggiunta al <code>Bottone</code> GUI del bottone
	 * @param testo          il testo del bottone
	 * @param actionListener la classe <code>ActionListener</code> che viene
	 *                       aggiunta al bottone
	 */
	public Bottone( PreferenzeGUI gui, String testo, ActionListener actionListener ) {
		this( gui.colori, gui.fonts, gui.bordi, testo, actionListener );
		gui.addObserver( this );
	}

	/**
	 * Costruttore che impiega le interfaccie <code>Colori</code>,
	 * <code>Fonts</code>, <code>Bordi</code>
	 * 
	 * @param colori         l'interfaccia <code>Colori</code> su cui si basano i
	 *                       colori del <code>Bottone</code>
	 * @param fonts          l'interfaccia <code>Fonts</code> su cui si basano i
	 *                       font del <code>Bottone</code>
	 * @param bordi          l'interfaccia <code>Bordi</code> su cui si basano i
	 *                       bordi del <code>Bottone</code>
	 * @param testo          il testo del <code>Bottone</code>
	 * @param actionListener la classe <code>ActionListener</code> che viene
	 *                       aggiunta al <code>Bottone</code> colori del
	 *                       bottone
	 * @param fonts          l'interfaccia <code>Fonts</code> su cui si basano i
	 *                       font del bottone
	 * @param bordi          l'interfaccia <code>Bordi</code> su cui si basano i
	 *                       bordi del bottone
	 * @param testo          il testo del bottone
	 * @param actionListener la classe <code>ActionListener</code> che viene
	 *                       aggiunta al bottone
	 */
	public Bottone( Colori colori, Fonts fonts, Bordi bordi, String testo, ActionListener actionListener ) {
		this( testo, colori.interagibile(), colori.primario().brighter(), colori.testo(), fonts.fontInteragibile( Fonts.BOLD ), bordi.bordoInteragibile(),
				bordi.bordoInteragibileFocus(), actionListener );
	}

	/**
	 * Costruttore con parametri specifici
	 * 
	 * @param testo               il testo del <code>Bottone</code>
	 * @param coloreSfondo        il colore dello sfondo del <code>Bottone</code>
	 * @param coloreSfondoPremuto il colore dello sfondo del <code>Bottone</code>
	 *                            quando è premuto
	 * @param coloreTesto         il colore del testo del <code>Bottone</code>
	 * @param font                il font del testo del <code>Bottone</code>
	 * @param bordo               il bordo del <code>Bottone</code>
	 * @param bordoFocus          il bordo del <code>Bottone</code> quando il mouse
	 *                            passa sopra
	 * @param actionListener      la classe <code>ActionListener</code> che viene
	 *                            aggiunta al <code>Bottone</code> 
	 * @param testo               il testo del bottone
	 * @param coloreSfondo        il colore dello sfondo del bottone
	 * @param coloreSfondoPremuto il colore dello sfondo del bottone quando è
	 *                            premuto
	 * @param coloreTesto         il colore del testo del bottone
	 * @param font                il font del testo del bottone
	 * @param bordo               il bordo del bottone
	 * @param bordoFocus          il bordo del bottone quando il mouse passa sopra
	 * @param actionListener      la classe <code>ActionListener</code> che viene
	 *                            aggiunta al bottone
	 */
	public Bottone( String testo, Color coloreSfondo, Color coloreSfondoPremuto, Color coloreTesto, Font font, Border bordo, Border bordoFocus,
			ActionListener actionListener ) {
		super( testo );
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setFont( font );
		setBorder( bordo );
		setName( "" );
		setContentAreaFilled( false );
		setOpaque( true );
		setFocusPainted( false );
		if ( actionListener != null ) {
			addActionListener( actionListener );
		}
		cambiaBordo = new MouseListener() {

			@Override
			public void mouseClicked( MouseEvent arg0 ) {

			}

			@Override
			public void mouseEntered( MouseEvent e ) {
				setBorder( bordoFocus );
			}

			@Override
			public void mouseExited( MouseEvent e ) {
				setBorder( bordo );
				setBackground( coloreSfondo );
			}

			@Override
			public void mousePressed( MouseEvent e ) {
				setBackground( coloreSfondoPremuto );
			}

			@Override
			public void mouseReleased( MouseEvent e ) {
				setBackground( coloreSfondo );
			}
		};
		addMouseListener( cambiaBordo );
	}

	@Override
	public void update( Observable osservabile, Object obj ) {
		PreferenzeGUI gui = ( PreferenzeGUI ) obj;
		setBackground( gui.colori.interagibile() );
		setForeground( gui.colori.testo() );
		setFont( getName().equals( "bottone emoji" ) ? new Font( "Segoe UI Emoji", Font.PLAIN, 11 ) : gui.fonts.fontInteragibile( Fonts.BOLD ) );
		setBorder( gui.bordi.bordoInteragibile() );
		removeMouseListener( cambiaBordo );
		cambiaBordo = new MouseListener() {

			@Override
			public void mouseClicked( MouseEvent arg0 ) {
			}

			@Override
			public void mouseEntered( MouseEvent e ) {
				setBorder( gui.bordi.bordoInteragibileFocus() );
			}

			@Override
			public void mouseExited( MouseEvent e ) {
				setBorder( gui.bordi.bordoInteragibile() );
				setBackground( gui.colori.interagibile() );
			}

			@Override
			public void mousePressed( MouseEvent e ) {
				setBackground( gui.colori.primario().brighter() );
			}

			@Override
			public void mouseReleased( MouseEvent e ) {
				setBackground( gui.colori.interagibile() );
			}
		};
		addMouseListener( cambiaBordo );
	}
}
