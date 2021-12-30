package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPasswordField;
import javax.swing.border.Border;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

/**
 * Sottoclasse di <code>JPasswordField</code> che può impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class PasswordField extends JPasswordField implements Observer {

	private static final long serialVersionUID = 1L;

	private MouseListener cambiaBordo;

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 * 
	 * @param gui     la classe <code>PreferenzeGUI</code> su cui si basa la GUI del
	 *                <code>PasswordField</code>
	 * @param colonne il numero di colonne del <code>PasswordField</code>
	 */
	public PasswordField( PreferenzeGUI gui, int colonne ) {
		this( gui.colori, gui.fonts, gui.bordi, colonne );
		gui.addObserver( this );
	}

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 * 
	 * @param gui          la classe <code>PreferenzeGUI</code> su cui si basa la
	 *                     GUI del <code>PasswordField</code>
	 * @param colonne      il numero di colonne del <code>PasswordField</code>
	 * @param testoDefault il testo scritto di default
	 */
	public PasswordField( PreferenzeGUI gui, int colonne, String testoDefault ) {
		this( gui.colori, gui.fonts, gui.bordi, colonne, testoDefault );
		gui.addObserver( this );
	}

	/**
	 * Costruttore che impiega le interfaccie <code>Colori</code>,
	 * <code>Fonts</code>, <code>Bordi</code>
	 * 
	 * @param colori  l'interfaccia <code>Colori</code> su cui si basano i colori
	 *                del <code>PasswordField</code>
	 * @param fonts   l'interfaccia <code>Fonts</code> su cui si basano i font del
	 *                <code>PasswordField</code>
	 * @param bordi   l'interfaccia <code>Bordi</code> su cui si basano i bordi del
	 *                <code>PasswordField</code>
	 * @param colonne il numero di colonne del <code>PasswordField</code>
	 */
	public PasswordField( Colori colori, Fonts fonts, Bordi bordi, int colonne ) {
		this( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoInteragibile(), bordi.bordoInteragibileFocus(), colonne,
				null );
	}

	/**
	 * Costruttore che impiega le interfaccie <code>Colori</code>,
	 * <code>Fonts</code>, <code>Bordi</code>
	 * 
	 * @param colori       l'interfaccia <code>Colori</code> su cui si basano i
	 *                     colori del <code>PasswordField</code>
	 * @param fonts        l'interfaccia <code>Fonts</code> su cui si basano i font
	 *                     del <code>PasswordField</code>
	 * @param bordi        l'interfaccia <code>Bordi</code> su cui si basano i bordi
	 *                     del <code>PasswordField</code>
	 * @param colonne      il numero di colonne del <code>PasswordField</code>
	 * @param testoDefault il testo scritto di default
	 */
	public PasswordField( Colori colori, Fonts fonts, Bordi bordi, int colonne, String testoDefault ) {
		this( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoInteragibile(), bordi.bordoInteragibileFocus(), colonne,
				testoDefault );
	}

	/**
	 * Costruttore con parametri specifici
	 * 
	 * @param coloreSfondo il colore dello sfondo del <code>PasswordField</code>
	 * @param coloreTesto  il colore del testo del <code>PasswordField</code>
	 * @param font         il font del testo del <code>PasswordField</code>
	 * @param bordo        il bordo del <code>PasswordField</code>
	 * @param bordoFocus   il bordo del <code>PasswordField</code> quando il mouse
	 *                     passa sopra
	 * @param colonne      il numero di colonne del <code>PasswordField</code>
	 */
	public PasswordField( Color coloreSfondo, Color coloreTesto, Font font, Border bordo, Border bordoFocus, int colonne ) {
		this( coloreSfondo, coloreTesto, font, bordo, bordoFocus, colonne, null );
	}

	/**
	 * Costruttore con parametri specifici
	 * 
	 * @param coloreSfondo il colore dello sfondo del <code>PasswordField</code>
	 * @param coloreTesto  il colore del testo del <code>PasswordField</code>
	 * @param font         il font del testo del <code>PasswordField</code>
	 * @param bordo        il bordo del <code>PasswordField</code>
	 * @param bordoFocus   il bordo del <code>PasswordField</code> quando il mouse
	 *                     passa sopra
	 * @param colonne      il numero di colonne del <code>PasswordField</code>
	 * @param testoDefault il testo scritto di default
	 */
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
		cambiaBordo = new MouseListener() {

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
		};
		addMouseListener( cambiaBordo );
	}

	@Override
	public void update( Observable o, Object arg ) {

		PreferenzeGUI gui = ( PreferenzeGUI ) arg;
		setBackground( gui.colori.sfondo() );
		setForeground( gui.colori.testo() );
		setFont( gui.fonts.fontGenerico( Fonts.PLAIN ) );
		setBorder( gui.bordi.bordoInteragibile() );
		setCaretColor( gui.colori.testo() );
		removeMouseListener( cambiaBordo );
		cambiaBordo = new MouseListener() {

			@Override
			public void mouseClicked( MouseEvent arg0 ) {
			}

			@Override
			public void mouseEntered( MouseEvent e ) {
				setBorder( gui.bordi.bordoInteragibileFocus() );
			}

			@Override
			public void mouseExited( MouseEvent e ) {
				setBorder( gui.bordi.bordoInteragibile() );
			}

			@Override
			public void mousePressed( MouseEvent e ) {
			}

			@Override
			public void mouseReleased( MouseEvent e ) {
			}
		};
		addMouseListener( cambiaBordo );
	}

}
