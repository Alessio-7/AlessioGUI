package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.border.Border;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

public class TextField extends JTextField {

	public TextField( PreferenzeGUI gui ) {
		this( gui.colori, gui.fonts, gui.bordi );
	}

	public TextField( PreferenzeGUI gui, String testoDefault ) {
		this( gui.colori, gui.fonts, gui.bordi, testoDefault );
	}

	public TextField( Colori colori, Fonts fonts, Bordi bordi ) {
		this( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoInteragibile(), bordi.bordoInteragibileFocus(), null );
	}

	public TextField( Colori colori, Fonts fonts, Bordi bordi, String testoDefault ) {
		this( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoInteragibile(), bordi.bordoInteragibileFocus(),
			testoDefault );
	}

	public TextField( Color coloreSfondo, Color coloreTesto, Font font, Border bordo, Border bordoFocus ) {
		this( coloreSfondo, coloreTesto, font, bordo, bordoFocus, null );
	}

	public TextField( Color coloreSfondo, Color coloreTesto, Font font, Border bordo, Border bordoFocus, String testoDefault ) {
		super();
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setFont( font );
		setBorder( bordo );
		if ( testoDefault != null ) {
			setText( testoDefault );
		}
		addMouseListener( new MouseListener() {

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
			}

			@Override
			public void mousePressed( MouseEvent e ) {
			}

			@Override
			public void mouseReleased( MouseEvent e ) {
			}
		} );
	}
}
