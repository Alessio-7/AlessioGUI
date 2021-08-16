package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import preferenze.PreferenzeGUI;

public class Label extends JLabel {

	private static final long serialVersionUID = 1L;

	public static final Font FONT_GENERICO = PreferenzeGUI.fontsPredefiniti().fontGenerico( Font.PLAIN );
	public static final Font FONT_TITOLO = PreferenzeGUI.fontsPredefiniti().fontTitolo( Font.PLAIN );
	public static final Font FONT_TITOLO_SECONDARIO = PreferenzeGUI.fontsPredefiniti().fontTitoloSecondario( Font.PLAIN );
	public static final Font FONT_TITOLO_TERZIARIO = PreferenzeGUI.fontsPredefiniti().fontTitoloTerziario( Font.PLAIN );

	public Label( String testo ) {
		this( new PreferenzeGUI(), testo, FONT_GENERICO );
	}

	public Label( PreferenzeGUI gui, String testo, Font font ) {
		this( testo, gui.colori.sfondo(), gui.colori.testo(), font, BorderFactory.createEmptyBorder() );
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

}
