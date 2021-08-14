package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.border.Border;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

public class Menu extends JMenu {

	private static final long serialVersionUID = 1L;

	public Menu( PreferenzeGUI gui, String testo, Component[] componenti ) {
		this( gui.colori, gui.fonts, gui.bordi, testo, componenti, null );
	}

	public Menu( PreferenzeGUI gui, String testo, Component[] componenti, Icon icona ) {
		this( gui.colori, gui.fonts, gui.bordi, testo, componenti, icona );
	}

	public Menu( Colori colori, Fonts fonts, Bordi bordi, String testo, Component[] componenti, Icon icona ) {
		this( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoGenerico(), testo, componenti, icona );
	}

	public Menu( Color coloreSfondo, Color coloreTesto, Font font, Border bordo, String testo, Component[] componenti, Icon icona ) {
		super( testo );
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setFont( font );
		setBorder( bordo );
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
