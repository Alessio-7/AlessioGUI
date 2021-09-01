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

public class Menu extends JMenu implements Observer {

	private static final long serialVersionUID = 1L;

	private boolean parteSubMenu;

	public Menu( PreferenzeGUI gui, String testo, Component[] componenti, boolean parteSubMenu ) {
		this( gui.colori, gui.fonts, testo, componenti, null, parteSubMenu );
		gui.addObserver( this );
	}

	public Menu( PreferenzeGUI gui, String testo, Component[] componenti, Icon icona, boolean parteSubMenu ) {
		this( gui.colori, gui.fonts, testo, componenti, icona, parteSubMenu );
		gui.addObserver( this );
	}

	public Menu( Colori colori, Fonts fonts, String testo, Component[] componenti, Icon icona, boolean parteSubMenu ) {
		this( parteSubMenu ? colori.bordoSecondario() : colori.sfondo(), colori.bordoSecondario(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), testo,
				componenti, icona );
		this.parteSubMenu = parteSubMenu;
	}

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
		setBackground( parteSubMenu ? gui.colori.bordoSecondario() : gui.colori.sfondo() );
		setForeground( gui.colori.testo() );
		setFont( gui.fonts.fontGenerico( Fonts.PLAIN ) );
		getPopupMenu().setBackground( gui.colori.bordoSecondario() );
		getPopupMenu().setBorder( BorderFactory.createMatteBorder( 2, 2, 2, 2, gui.colori.bordoSecondario() ) );
	}
}
