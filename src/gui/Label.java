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

	public static final Font FONT_GENERICO = PreferenzeGUI.fontsPredefiniti().fontGenerico( Font.PLAIN );
	public static final Font FONT_TITOLO = PreferenzeGUI.fontsPredefiniti().fontTitolo( Font.PLAIN );
	public static final Font FONT_TITOLO_SECONDARIO = PreferenzeGUI.fontsPredefiniti().fontTitoloSecondario( Font.PLAIN );
	public static final Font FONT_TITOLO_TERZIARIO = PreferenzeGUI.fontsPredefiniti().fontTitoloTerziario( Font.PLAIN );

	public Label( PreferenzeGUI gui, String testo, Font font ) {
		this( testo, gui.colori.sfondo(), gui.colori.testo(), font, BorderFactory.createEmptyBorder() );
		gui.addObserver( this );
	}

	public Label( String testo, Color sfondo, Color coloreTesto, Font font, Border bordo ) {
		super( testo );
		setOpaque( true );
		setBackground( sfondo );
		setForeground( coloreTesto );
		setFont( font );
		setBorder( bordo );
	}

	public Label() {
		super();
	}

	@Override
	public void update( Observable o, Object arg ) {

		PreferenzeGUI gui = ( PreferenzeGUI ) arg;

		setBackground( gui.colori.sfondo() );
		setForeground( gui.colori.testo() );
	}

}
