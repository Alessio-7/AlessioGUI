package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JMenuItem;

import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

public class MenuItem extends JMenuItem {

	private static final long serialVersionUID = 1L;

	public MenuItem( PreferenzeGUI gui, String testo, ActionListener listener ) {
		this( gui.colori, gui.fonts, testo, listener, null );
	}

	public MenuItem( Colori colori, Fonts fonts, String testo, ActionListener listener ) {
		this( colori, fonts, testo, listener, null );
	}

	public MenuItem( PreferenzeGUI gui, String testo, ActionListener listener, Icon icona ) {
		this( gui.colori, gui.fonts, testo, listener, icona );
	}

	public MenuItem( Colori colori, Fonts fonts, String testo, ActionListener listener, Icon icona ) {
		this( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), testo, listener, icona );
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
		if ( listener != null ) {
			addActionListener( listener );
		}
		if ( icona != null ) {
			setIcon( icona );
		}
	}
}
