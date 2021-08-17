package preferenze;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JPanel;

import gui.Bottone;
import gui.CheckBox;
import gui.ComboBox;
import gui.Finestra;
import gui.Label;
import gui.Menu;
import gui.MenuBar;
import gui.MenuItem;
import gui.PasswordField;
import gui.RadioButton;
import gui.ScrollPane;
import gui.Separatore;
import gui.TextArea;
import gui.TextField;
import utility.Dialog;

public class PreferenzeGUI {

	public static final Colori TEMA_CHIARO = new ColoriChiari();
	public static final Colori TEMA_SCURO = new ColoriScuri();

	public Colori colori;
	public Fonts fonts;
	public Bordi bordi;

	private void cambiaUiManager() {

	}

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
		cambiaUiManager();
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

	public CheckBox creaCheckBox( Label label, Icon icona, boolean selezionato ) {
		return new CheckBox( label, icona, selezionato );
	}

	public CheckBox creaCheckBox( Label label, boolean selezionato ) {
		return new CheckBox( label, null, selezionato );
	}

	public RadioButton creaRadioButton( Label label, Icon icona, boolean selezionato ) {
		return new RadioButton( label, icona, selezionato );
	}

	public RadioButton creaRadioButton( Label label, boolean selezionato ) {
		return new RadioButton( label, null, selezionato );
	}

	public Label creaLabel( String testo, Font font ) {
		return new Label( this, testo, font );
	}

	public Label creaLabel( String testo ) {
		return new Label( this, testo, Label.FONT_GENERICO );
	}

	public TextField creaTextField( int colonne ) {
		return new TextField( this, colonne );
	}

	public PasswordField creaTextField( int colonne, String testoDefault ) {
		return new PasswordField( this, colonne, testoDefault );
	}

	public PasswordField creaPasswordField( int colonne ) {
		return new PasswordField( this, colonne );
	}

	public PasswordField creaPasswordField( int colonne, String testoDefault ) {
		return new PasswordField( this, colonne, testoDefault );
	}

	public TextField creaTextField( String testoDefault ) {
		return new TextField( this, testoDefault.length(), testoDefault );
	}

	public TextArea creaTextArea( String testo, int righe, int colonne, boolean editabile ) {
		return new TextArea( this, testo, righe, colonne, editabile );
	}

	public TextArea creaTextArea( String testo, boolean editabile ) {
		return new TextArea( this, testo, 2, testo.length(), editabile );
	}

	public TextArea creaTextArea( int righe, int colonne ) {
		return new TextArea( this, "", righe, colonne, true );
	}

	public ComboBox creaComboBox( Object[] lista ) {
		return new ComboBox( this, lista );
	}

	public JPanel creaGridLayout( int righe, int colonne, Component[] componenti ) {
		JPanel grid = new JPanel( new GridLayout( righe, colonne ) );
		grid.setBackground( colori.sfondo() );
		if ( componenti != null ) {
			for ( Component c : componenti ) {
				grid.add( c );
			}
		}
		return grid;
	}

	public JPanel creaGridLayout( int righe, int colonne ) {
		return creaGridLayout( righe, colonne, null );
	}

	public JPanel creaGridBagLayout() {
		JPanel grid = new JPanel( new GridBagLayout() );
		grid.setBackground( colori.sfondo() );
		return grid;
	}

	public ScrollPane creaScrollPane( JPanel view ) {
		return new ScrollPane( this, view );
	}

	public Finestra creaFinestra( String titolo, JPanel child, boolean visibile ) {
		return creaFinestra( titolo, child, null, visibile );
	}

	public Finestra creaFinestra( String titolo, JPanel child, MenuBar menuBar, boolean visibile ) {
		Finestra ritorno = new Finestra( titolo, Finestra.schermo.width / 2, Finestra.schermo.height / 2, Finestra.MAXIMIZED_BOTH );
		ritorno.add( creaScrollPane( child ), BorderLayout.CENTER );
		ritorno.setVisible( visibile );
		if ( menuBar != null ) {
			ritorno.setJMenuBar( menuBar );
		}
		return ritorno;
	}

	public Finestra creaFinestra( String titolo, int larghezza, int altezza, JPanel child, boolean visibile ) {
		return creaFinestra( titolo, larghezza, altezza, child, null, visibile );
	}

	public Finestra creaFinestra( String titolo, int larghezza, int altezza, JPanel child, MenuBar menuBar, boolean visibile ) {
		Finestra ritorno = new Finestra( titolo, larghezza, altezza, Finestra.NORMAL );
		ritorno.add( creaScrollPane( child ), BorderLayout.CENTER );
		ritorno.setVisible( visibile );
		if ( menuBar != null ) {
			ritorno.setJMenuBar( menuBar );
		}
		return ritorno;
	}

	public MenuItem creaMenuItem( String testo, ActionListener listener ) {
		return new MenuItem( this, testo, listener );
	}

	public MenuItem creaMenuItem( String testo, ActionListener listener, Icon icona ) {
		return new MenuItem( this, testo, listener, icona );
	}

	public Menu creaMenu( String testo, Component[] componenti ) {
		return new Menu( this, testo, componenti );
	}

	public Menu creaMenu( String testo, Component[] componenti, Icon icona ) {
		return new Menu( this, testo, componenti, icona );
	}

	public Separatore creaSeparatore() {
		return new Separatore( this );
	}

	public MenuBar creaMenuBar( Component[] componenti ) {
		return new MenuBar( this, componenti );
	}

	public MenuBar creaMenuBar() {
		return new MenuBar( this );
	}

	public JPanel creaGruppo( Label label, ComboBox comboBox ) {
		return creaGridLayout( 2, 1, new Component[] {
			label,
			comboBox } );
	}

	public JPanel creaPasswordFieldSH( PasswordField pswField ) {
		Bottone sh = new Bottone( this, "👁", new ActionListener() {
			boolean mostra = false;

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				mostra = !mostra;
				if ( mostra ) {
					pswField.setEchoChar( (char) 0 );
				} else {
					pswField.setEchoChar( '•' );
				}
			}

		} );
		sh.setFont( new Font( "Arial Unicode MS", Font.PLAIN, 11 ) );
		JPanel grid = creaGridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.VERTICAL;
		grid.add( pswField );
		grid.add( sh, gbc );
		return grid;
	}

	public Dialog creaDialog( Frame finestra, String titolo, boolean modale, int larghezza, int altezza, JPanel child, JPanel panelBottoni,
		boolean visibile ) {
		Dialog dialog = new Dialog( finestra, titolo, modale, larghezza, altezza );
		dialog.add( child, BorderLayout.CENTER );
		dialog.add( panelBottoni, BorderLayout.SOUTH );
		dialog.setVisible( visibile );
		return dialog;
	}

	public JPanel creaPanelBottoni( String[] testoBottoni, ActionListener[] listeners ) {

		JPanel grid = creaGridLayout( 1, testoBottoni.length );
		grid.setBackground( colori.suSfondo() );
		( (GridLayout) grid.getLayout() ).setHgap( 5 );

		for ( int i = 0; i < testoBottoni.length; i++ ) {
			grid.add( creaBottone( testoBottoni[i], listeners[i] ) );
		}

		JPanel grid2 = creaGridBagLayout();
		grid2.setBackground( colori.suSfondo() );
		grid2.add( grid,
			new GridBagConstraints( 0, 0, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets( 10, 0, 10, 10 ), 0, 0 ) );

		return grid2;
	}
}
