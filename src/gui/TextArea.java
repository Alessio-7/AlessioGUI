package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;
import javax.swing.border.Border;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

public class TextArea extends JTextArea implements Observer {

	private static final long serialVersionUID = 1L;

	public TextArea( PreferenzeGUI gui, String testo, int righe, int colonne, boolean editabile ) {
		this( gui.colori, gui.fonts, gui.bordi, testo, righe, colonne, editabile );
		gui.addObserver( this );
	}

	public TextArea( Colori colori, Fonts fonts, Bordi bordi, String testo, int righe, int colonne, boolean editabile ) {
		this( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoSecondario(), testo, righe, colonne, editabile );
	}

	public TextArea( Color coloreSfondo, Color coloreTesto, Font font, Border bordo, String testo, int righe, int colonne, boolean editabile ) {
		super( testo, righe, colonne );
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setCaretColor( coloreTesto );
		setCaretPosition( getText().length() );
		setFont( font );
		setBorder( bordo );
		setEditable( editabile );
	}

	@Override
	public void update( Observable o, Object arg ) {
		PreferenzeGUI gui = ( PreferenzeGUI ) arg;
		setBackground( gui.colori.sfondo() );
		setForeground( gui.colori.testo() );
		setCaretColor( gui.colori.testo() );
		setFont( gui.fonts.fontGenerico( Fonts.PLAIN ) );
		setBorder( gui.bordi.bordoSecondario() );
	}

}
