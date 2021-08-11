package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.Border;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

public class Bottone extends JButton {

	private static final long serialVersionUID = 1L;

	public Bottone( String testo, ActionListener actionListener ) {
		this( new PreferenzeGUI(), testo, actionListener );
	}

	public Bottone( PreferenzeGUI preferenze, String testo, ActionListener actionListener ) {
		this( preferenze, testo, Font.BOLD, 2, new Insets( 5, 5, 5, 5 ), actionListener, preferenze.colori.primario() );
	}

	public Bottone( PreferenzeGUI preferenze, String testo, int stileFont, int grandezzaBordi, Insets spazio, ActionListener actionListener,
			Color coloreFocus ) {
		this( preferenze.colori, preferenze.fonts, preferenze.bordi, testo, stileFont, grandezzaBordi, spazio, actionListener, coloreFocus );
	}

	public Bottone( Colori colori, Fonts fonts, Bordi bordi, String testo, int stileFont, int grandezzaBordi, Insets spazio, ActionListener actionListener,
			Color coloreFocus ) {
		this( testo, colori.sfondo(), colori.testo(), fonts.fontInteragibile( stileFont ), bordi.bordoInteragibile( grandezzaBordi, spazio ),
				bordi.bordoInteragibileFocus( grandezzaBordi, spazio, coloreFocus ), actionListener );
	}

	public Bottone( String testo, Color coloreSfondo, Color coloreTesto, Font font, Border bordo, Border bordoFocus, ActionListener actionListener ) {
		super( testo );
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setFont( font );
		setBorder( bordo );
		setFocusPainted( false );
		if ( actionListener != null ) {
			addActionListener( actionListener );
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
