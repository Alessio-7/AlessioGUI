package preferenze;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import gui.Bottone;
import gui.ComboBox;
import gui.Finestra;
import gui.Label;
import gui.Menu;
import gui.ScrollPane;
import utility.WrongValueException;

public class PreferenzeGUI {

	public static final Colori TEMA_CHIARO = new ColoriChiari();
	public static final Colori TEMA_SCURO = new ColoriScuri();

	public Colori colori;
	public Fonts fonts;
	public Bordi bordi;

	public PreferenzeGUI() {
		this( coloriPredefiniti(), fontsPredefiniti(), bordiPredefiniti() );
	}

	public PreferenzeGUI( Colori colori ) {
		this( colori, new DefaultFonts(), new DefaultBordi( colori ) );
	}

	public PreferenzeGUI( Colori colori, Fonts fonts, Bordi bordi ) {
		this.colori = colori;
		this.fonts = fonts;
		this.bordi = bordi;
	}

	public static Colori coloriPredefiniti() {
		return TEMA_CHIARO;
	}

	public static DefaultFonts fontsPredefiniti() {
		return new DefaultFonts();
	}

	public static DefaultBordi bordiPredefiniti() {
		return new DefaultBordi( coloriPredefiniti() );
	}

	public Bottone creaBottone( String testo, ActionListener actionListener ) {
		return new Bottone( this, testo, actionListener );
	}

	public Label creaLabel( String testo, Font font ) {
		return new Label( this, testo, font );
	}

	public Label creaLabel( String testo ) {
		return new Label( this, testo, Label.FONT_GENERICO );
	}

	public ComboBox creaComboBox( Object[] lista ) {
		return new ComboBox( this, lista );
	}

	public JPanel creaGridBagLayout() {
		JPanel grid = new JPanel( new GridBagLayout() );
		grid.setBackground( colori.sfondo() );
		return grid;
	}

	public ScrollPane creaScrollPane( JPanel view ) {
		return new ScrollPane( this, view );
	}

	public Finestra creaFinestra( String titolo, int larghezza, int altezza, JPanel child, boolean visible ) {
		Finestra ritorno = new Finestra( titolo, larghezza, altezza, Finestra.NORMAL );
		ritorno.add( creaScrollPane( child ), BorderLayout.CENTER );
		ritorno.setVisible( visible );
		try {
			ritorno.setJMenuBar( Menu.creaMenuBarDaHashMap( colori, fonts, bordi, null ) );
		} catch ( WrongValueException e ) {
			e.printStackTrace();
		}
		return ritorno;
	}

	// TODO aggiungere jmenubar

	public Finestra creaFinestra( String titolo, JPanel child, boolean visible ) {
		Finestra ritorno = new Finestra( titolo, Finestra.schermo.width / 2, Finestra.schermo.height / 2, Finestra.MAXIMIZED_BOTH );
		ritorno.add( creaScrollPane( child ), BorderLayout.CENTER );
		ritorno.setVisible( visible );
		return ritorno;
	}
}
