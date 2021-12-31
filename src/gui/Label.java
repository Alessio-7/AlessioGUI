package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import preferenze.PreferenzeGUI;

/**
 * Sottoclasse di <code>JLabel</code> che può impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class Label extends JLabel implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * Font generico per la <code>Label</code>
	 */
	public static final Font FONT_GENERICO = PreferenzeGUI.fontsPredefiniti().fontGenerico( Font.PLAIN );

	/**
	 * Font da titolo per la <code>Label</code>
	 */
	public static final Font FONT_TITOLO = PreferenzeGUI.fontsPredefiniti().fontTitolo( Font.PLAIN );

	/**
	 * Font da titolo secondario per la <code>Label</code>
	 */
	public static final Font FONT_TITOLO_SECONDARIO = PreferenzeGUI.fontsPredefiniti().fontTitoloSecondario( Font.PLAIN );

	/**
	 * Font da titolo terziario per la <code>Label</code>
	 */
	public static final Font FONT_TITOLO_TERZIARIO = PreferenzeGUI.fontsPredefiniti().fontTitoloTerziario( Font.PLAIN );

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui   la classe <code>PreferenzeGUI</code> su cui si basa la GUI della
	 *              <code>Label</code>
	 * @param testo il testo della <code>Label</code>
	 * @param font  il font del testo della <code>Label</code>
	 */
	public Label( PreferenzeGUI gui, String testo, Font font ) {
		this( testo, gui.colori.sfondo(), gui.colori.testo(), font, BorderFactory.createEmptyBorder() );
		gui.addObserver( this );
	}

	/**
	 * Costruttore con parametri specifici
	 *
	 * @param testo       il testo della <code>Label</code>
	 * @param sfondo      il colore dello sfondo della <code>Label</code>
	 * @param coloreTesto il colore del testo della <code>Label</code>
	 * @param font        il font del testo della <code>Label</code>
	 * @param bordo       il bordo della <code>Label</code>
	 */
	public Label( String testo, Color coloreSfondo, Color coloreTesto, Font font, Border bordo ) {
		super( testo );
		setOpaque( true );
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setFont( font );
		setBorder( bordo );
	}

	@Override
	public void update( Observable o, Object arg ) {

		PreferenzeGUI gui = ( PreferenzeGUI ) arg;

		setBackground( gui.colori.sfondo() );
		setForeground( gui.colori.testo() );
	}

}
