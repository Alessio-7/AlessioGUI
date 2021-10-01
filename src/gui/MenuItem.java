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

public class MenuItem extends JMenuItem implements Observer {

	private static final long serialVersionUID = 1L;

	private boolean parteSubMenu;

	public MenuItem( PreferenzeGUI gui, String testo, ActionListener listener, boolean parteSubMenu ) {
		this( gui.colori, gui.fonts, testo, listener, null, parteSubMenu );
		gui.addObserver( this );
	}

	public MenuItem( PreferenzeGUI gui, String testo, ActionListener listener, Icon icona, boolean parteSubMenu ) {
		this( gui.colori, gui.fonts, testo, listener, icona, parteSubMenu );
		gui.addObserver( this );
	}

	public MenuItem( Colori colori, Fonts fonts, String testo, ActionListener listener, Icon icona, boolean parteSubMenu ) {
		this( parteSubMenu ? colori.subMenu() : colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), testo, listener, icona );
		this.parteSubMenu = parteSubMenu;
	}

	public MenuItem( Color coloreSfondo, Color coloreTesto, Font font, String testo, ActionListener listener ) {
		this( coloreSfondo, coloreTesto, font, testo, listener, null );
	}

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
