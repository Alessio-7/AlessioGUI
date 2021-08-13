package gui;

import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JMenuItem;

import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

public class MenuItem extends JMenuItem {

	private static final long serialVersionUID = 1L;

	// TODO aggiungere più costruttori come in bottone

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
		super( testo );
		setBackground( colori.sfondo() );
		setForeground( colori.testo() );
		setFont( fonts.fontGenerico( Fonts.PLAIN ) );
		setFocusPainted( false );
		if ( listener != null ) {
			addActionListener( listener );
		}
		if ( icona != null ) {
			setIcon( icona );
		}
	}

}
