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

public class Bottone extends JButton implements Observer {

	private static final long serialVersionUID = 1L;

	private MouseListener cambiaBordo;

	public Bottone( PreferenzeGUI gui, String testo, ActionListener actionListener ) {
		this( gui.colori, gui.fonts, gui.bordi, testo, actionListener );
		gui.addObserver( this );
	}

	public Bottone( Colori colori, Fonts fonts, Bordi bordi, String testo, ActionListener actionListener ) {
		this( testo, colori.interagibile(), colori.primario().brighter(), colori.testo(), fonts.fontInteragibile( Fonts.BOLD ), bordi.bordoInteragibile(),
				bordi.bordoInteragibileFocus(), actionListener );
	}

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
