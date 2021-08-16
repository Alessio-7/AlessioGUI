package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPasswordField;
import javax.swing.border.Border;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

public class PasswordField extends JPasswordField {

	private static final long serialVersionUID = 1L;

	public PasswordField( PreferenzeGUI gui, int colonne ) {
		this( gui.colori, gui.fonts, gui.bordi, colonne );
	}

	public PasswordField( PreferenzeGUI gui, int colonne, String testoDefault ) {
		this( gui.colori, gui.fonts, gui.bordi, colonne, testoDefault );
	}

	public PasswordField( Colori colori, Fonts fonts, Bordi bordi, int colonne ) {
		this( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoInteragibile(), bordi.bordoInteragibileFocus(), colonne,
			null );
	}

	public PasswordField( Colori colori, Fonts fonts, Bordi bordi, int colonne, String testoDefault ) {
		this( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoInteragibile(), bordi.bordoInteragibileFocus(), colonne,
			testoDefault );
	}

	public PasswordField( Color coloreSfondo, Color coloreTesto, Font font, Border bordo, Border bordoFocus, int colonne ) {
		this( coloreSfondo, coloreTesto, font, bordo, bordoFocus, colonne, null );
	}

	public PasswordField( Color coloreSfondo, Color coloreTesto, Font font, Border bordo, Border bordoFocus, int colonne, String testoDefault ) {
		super();
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setFont( font );
		setBorder( bordo );
		setCaretColor( coloreTesto );
		setColumns( colonne );
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
