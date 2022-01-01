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

/**
 * Sottoclasse di <code>JTextArea</code> che pu&ograve; impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class TextArea extends JTextArea implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui       la classe <code>PreferenzeGUI</code> su cui si basa la GUI
	 *                  del <code>TextArea</code>
	 * @param testo     il testo scritto nel <code>TextArea</code>
	 * @param righe     il numero di righe del <code>TextArea</code>
	 * @param colonne   il numero di colonne del <code>TextArea</code>
	 * @param editabile se il <code>TextArea</code> &egrave; editabile
	 */
	public TextArea( PreferenzeGUI gui, String testo, int righe, int colonne, boolean editabile ) {
		this( gui.colori, gui.fonts, gui.bordi, testo, righe, colonne, editabile );
		gui.addObserver( this );
	}

	/**
	 * Costruttore che impiega le interfaccie <code>Colori</code>,
	 * <code>Fonts</code>, <code>Bordi</code>
	 *
	 * @param colori    l'interfaccia <code>Colori</code> su cui si basano i colori
	 *                  del <code>TextArea</code>
	 * @param fonts     l'interfaccia <code>Fonts</code> su cui si basano i font del
	 *                  <code>TextArea</code>
	 * @param bordi     l'interfaccia <code>Bordi</code> su cui si basano i bordi
	 *                  del <code>TextArea</code>
	 * @param testo     il testo scritto nel <code>TextArea</code>
	 * @param righe     il numero di righe del <code>TextArea</code>
	 * @param colonne   il numero di colonne del <code>TextArea</code>
	 * @param editabile se il <code>TextArea</code> &egrave; editabile
	 */
	public TextArea( Colori colori, Fonts fonts, Bordi bordi, String testo, int righe, int colonne, boolean editabile ) {
		this( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoSecondario(), testo, righe, colonne, editabile );
	}

	/**
	 * Costruttore con parametri specifici
	 *
	 * @param coloreSfondo il colore dello sfondo del <code>TextArea</code>
	 * @param coloreTesto  il colore del testo del <code>TextArea</code>
	 * @param font         il font del testo del <code>TextArea</code>
	 * @param bordo        il bordo del <code>TextArea</code>
	 * @param testo        il testo scritto nel <code>TextArea</code>
	 * @param righe        il numero di righe del <code>TextArea</code>
	 * @param colonne      il numero di colonne del <code>TextArea</code>
	 * @param editabile    se il <code>TextArea</code> &egrave; editabile
	 */
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
