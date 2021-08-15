package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JMenu;

import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

public class Menu extends JMenu {

	// TODO risolvere errore: sepratore si aggiunge sempre all'inizio del popmenu

	private static final long serialVersionUID = 1L;

	public Menu( PreferenzeGUI gui, String testo, Component[] componenti ) {
		this( gui.colori, gui.fonts, testo, componenti, null );
	}

	public Menu( PreferenzeGUI gui, String testo, Component[] componenti, Icon icona ) {
		this( gui.colori, gui.fonts, testo, componenti, icona );
	}

	public Menu( Colori colori, Fonts fonts, String testo, Component[] componenti, Icon icona ) {
		this( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), testo, componenti, icona );
	}

	public Menu( Color coloreSfondo, Color coloreTesto, Font font, String testo, Component[] componenti, Icon icona ) {
		super( testo );
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setFont( font );
		setOpaque( true );
		getPopupMenu().setBackground( coloreSfondo );
		getPopupMenu().setBorderPainted( false );
		setBorderPainted( false );
		;
		if ( icona != null ) {
			setIcon( icona );
		}
		if ( componenti != null && componenti.length != 0 ) {
			for ( Component c : componenti ) {
				add( c );
			}
		}
	}
}
