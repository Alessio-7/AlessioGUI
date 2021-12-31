package preferenze;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import gui.Bottone;
import gui.CheckBox;
import gui.ComboBox;
import gui.DateChooser;
import gui.Finestra;
import gui.Label;
import gui.Layout;
import gui.Menu;
import gui.MenuBar;
import gui.MenuItem;
import gui.PasswordField;
import gui.PopupMenu;
import gui.RadioButton;
import gui.ScrollPane;
import gui.Separatore;
import gui.TextArea;
import gui.TextField;
import gui.WrapLayout;
import utility.Dialog;
import utility.ListaOggettiMenu;
import utility.WrongValueException;

/**
 * Classe con le informazioni per lo sviluppo della GUI
 *
 */
public class PreferenzeGUI extends Observable {

	/**
	 * Colori predefiniti del tema chiaro
	 */
	public static final Colori TEMA_CHIARO = new ColoriChiari();

	/**
	 * Colori predefiniti del tema scuro
	 */
	public static final Colori TEMA_SCURO = new ColoriScuri();

	/**
	 * Interfaccia <code>Colori</code> utilizzata per i colori della GUI
	 */
	public Colori colori;

	/**
	 * Interfaccia <code>Fonts</code> utilizzata per i fonts della GUI
	 */
	public Fonts fonts;

	/**
	 * Interfaccia <code>Bordi</code> utilizzata per i bordi della GUI
	 */
	public Bordi bordi;

	/**
	 * Costruttore che utilizza i valori predefiniti per i colori, i font e i bordi
	 */
	public PreferenzeGUI() {
		this( coloriPredefiniti(), fontsPredefiniti(), bordiPredefiniti() );
	}

	/**
	 * Costruttore che utilizza colori personalizzati e i valori predefiniti per i
	 * font e i bordi
	 *
	 * @param colori l'interfaccia <code>Colori</code> utilizzata per i colori della
	 *               GUI
	 */
	public PreferenzeGUI( Colori colori ) {
		this( colori, new DefaultFonts(), new DefaultBordi( colori ) );
	}

	/**
	 * Costruttore che utilizza colori, font e bordi personalizzati
	 *
	 * @param colori l'interfaccia <code>Colori</code> utilizzata per i colori della
	 *               GUI
	 * @param fonts  l'interfaccia <code>Fonts</code> utilizzata per i font della
	 *               GUI
	 * @param bordi  l'interfaccia <code>Bordi</code> utilizzata per i bordi della
	 *               GUI
	 */
	public PreferenzeGUI( Colori colori, Fonts fonts, Bordi bordi ) {
		this.colori = colori;
		this.fonts = fonts;
		this.bordi = bordi;
	}

	/**
	 * Imposta i valori delle interfaccie colori, fonts e bordi prendendoli dalla
	 * classe <code>PreferenzeGUI</code>
	 *
	 * @param nuovaGui classe da cui prendere i valori delle interfaccie colori,
	 *                 fonts e bordi
	 */
	public void cambiaGUI( PreferenzeGUI nuovaGui ) {
		cambiaGUI( nuovaGui.colori, nuovaGui.fonts, nuovaGui.bordi );
	}

	/**
	 * Imposta i valori delle interfaccie colori, fonts e bordi usando interfaccie
	 * personalizzate
	 *
	 * @param colori l'interfaccia <code>Colori</code> utilizzata per i colori della
	 *               GUI
	 * @param fonts  l'interfaccia <code>Fonts</code> utilizzata per i font della
	 *               GUI
	 * @param bordi  l'interfaccia <code>Bordi</code> utilizzata per i bordi della
	 *               GUI
	 */
	public void cambiaGUI( Colori colori, Fonts fonts, Bordi bordi ) {
		this.colori = colori;
		this.fonts = fonts;
		this.bordi = bordi;
		setChanged();
		notifyObservers( this );
	}

	/**
	 * Ritorna l'interfaccia <code>Colori</code> predefinita
	 *
	 * @return interfaccia <code>Colori</code> predefinita
	 */
	public static Colori coloriPredefiniti() {
		return TEMA_CHIARO;
	}

	/**
	 * Ritorna l'interfaccia <code>DefaultFonts</code>
	 *
	 * @return interfaccia <code>DefaultFonts</code>
	 */
	public static DefaultFonts fontsPredefiniti() {
		return new DefaultFonts();
	}

	/**
	 * Ritorna l'interfaccia <code>DefaultBordi</code>
	 *
	 * @return interfaccia <code>DefaultBordi</code>
	 */
	public static DefaultBordi bordiPredefiniti() {
		return new DefaultBordi( coloriPredefiniti() );
	}

	/**
	 * Crea la classe <code>Bottone</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param testo          il testo del <code>Bottone</code>
	 * @param actionListener actionListener la classe <code>ActionListener</code>
	 *                       che viene aggiunta al <code>Bottone</code>
	 * @return la classe <code>Bottone</code> creata
	 */
	public Bottone creaBottone( String testo, ActionListener actionListener ) {
		return new Bottone( this, testo, actionListener );
	}

	/**
	 * Crea una classe <code>CheckBox</code>
	 *
	 * @param label       <code>Label</code> che accompagna il <code>CheckBox</code>
	 * @param icona       icona del <code>CheckBox</code>
	 * @param selezionato se il <code>CheckBox</code> è selezionato
	 * @return la classe <code>CheckBox</code> creata
	 */
	public CheckBox creaCheckBox( Label label, Icon icona, boolean selezionato ) {
		return new CheckBox( label, icona, selezionato );
	}

	/**
	 * Crea una classe <code>CheckBox</code>
	 *
	 * @param label       <code>Label</code> che accompagna il <code>CheckBox</code>
	 * @param selezionato se il <code>CheckBox</code> è selezionato
	 * @return la classe <code>CheckBox</code> creata
	 */
	public CheckBox creaCheckBox( Label label, boolean selezionato ) {
		return new CheckBox( label, null, selezionato );
	}

	/**
	 * Crea una classe <code>RadioButton</code>
	 *
	 * @param label       <code>Label</code> che accompagna il
	 *                    <code>RadioButton</code>
	 * @param icona       icona del <code>RadioButton</code>
	 * @param selezionato se il <code>RadioButton</code> è selezionato
	 * @return la classe <code>RadioButton</code> creata
	 */
	public RadioButton creaRadioButton( Label label, Icon icona, boolean selezionato ) {
		return new RadioButton( label, icona, selezionato );
	}

	/**
	 * Crea una classe <code>RadioButton</code>
	 *
	 * @param label       <code>Label</code> che accompagna il
	 *                    <code>RadioButton</code>
	 * @param selezionato se il <code>RadioButton</code> è selezionato
	 * @return la classe <code>RadioButton</code> creata
	 */
	public RadioButton creaRadioButton( Label label, boolean selezionato ) {
		return new RadioButton( label, null, selezionato );
	}

	/**
	 * Crea la classe <code>Label</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param testo il testo della <code>Label</code>
	 * @param font  il font della <code>Label</code>
	 * @return la classe <code>Label</code> creata
	 */
	public Label creaLabel( String testo, Font font ) {
		return new Label( this, testo, font );
	}

	/**
	 * Crea la classe <code>Label</code> impiegando questa classe
	 * <code>PreferenzeGUI</code> e utilizzando il font generico della
	 * <code>Label</code>
	 *
	 * @param testo il testo della <code>Label</code>
	 * @return la classe <code>Label</code> creata
	 */
	public Label creaLabel( String testo ) {
		return new Label( this, testo, Label.FONT_GENERICO );
	}

	/**
	 * Crea la classe <code>TextField</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param colonne il numero di colonne del <code>TextField</code>
	 * @return la classe <code>TextField</code> creata
	 */
	public TextField creaTextField( int colonne ) {
		return new TextField( this, colonne );
	}

	/**
	 * Crea la classe <code>TextField</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param colonne      il numero di colonne del <code>TextField</code>
	 * @param testoDefault il testo scritto di default
	 * @return la classe <code>TextField</code> creata
	 */
	public TextField creaTextField( int colonne, String testoDefault ) {
		return new TextField( this, colonne, testoDefault );
	}

	/**
	 * Crea la classe <code>TextField</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>, utilizzando la lunghezza del testo scritto di
	 * default come numero di colonne
	 *
	 * @param testoDefault il testo scritto di default
	 * @return la classe <code>TextField</code> creata
	 */
	public TextField creaTextField( String testoDefault ) {
		return new TextField( this, testoDefault.length(), testoDefault );
	}

	/**
	 * Crea la classe <code>PasswordField</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param colonne il numero di colonne del <code>PasswordField</code>
	 * @return la classe <code>PasswordField</code> creata
	 */
	public PasswordField creaPasswordField( int colonne ) {
		return new PasswordField( this, colonne );
	}

	/**
	 * Crea la classe <code>PasswordField</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param colonne      il numero di colonne del <code>PasswordField</code>
	 * @param testoDefault il testo scritto di default
	 * @return la classe <code>PasswordField</code> creata
	 */
	public PasswordField creaPasswordField( int colonne, String testoDefault ) {
		return new PasswordField( this, colonne, testoDefault );
	}

	/**
	 * Crea la classe <code>TextArea</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param testo     il testo scritto nel <code>TextArea</code>
	 * @param righe     il numero di righe del <code>TextArea</code>
	 * @param colonne   il numero di colonne del <code>TextArea</code>
	 * @param editabile se il <code>TextArea</code> è editabile
	 * @return la classe <code>TextArea</code> creata
	 */
	public TextArea creaTextArea( String testo, int righe, int colonne, boolean editabile ) {
		return new TextArea( this, testo, righe, colonne, editabile );
	}

	/**
	 * Crea la classe <code>TextArea</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>, mettendo 2 righe e utilizzando la lunghezza del
	 * testo come numero di colonne
	 *
	 * @param testo     il testo scritto nel <code>TextArea</code>
	 * @param editabile se il <code>TextArea</code> è editabile
	 * @return la classe <code>TextArea</code> creata
	 */
	public TextArea creaTextArea( String testo, boolean editabile ) {
		return new TextArea( this, testo, 2, testo.length(), editabile );
	}

	/**
	 * Crea la classe <code>TextArea</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>,scrivendo un testo vuoto e impostando che sia
	 * editabile
	 *
	 * @param righe   il numero di righe del <code>TextArea</code>
	 * @param colonne il numero di colonne del <code>TextArea</code>
	 * @return la classe <code>TextArea</code> creata
	 */
	public TextArea creaTextArea( int righe, int colonne ) {
		return new TextArea( this, "", righe, colonne, true );
	}

	/**
	 * Crea la classe <code>ComboBox</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param lista la lista di <code>Object</code> che deve contenere la
	 *              <code>ComboBox</code>
	 * @return la classe <code>ComboBox</code> creata
	 */
	public ComboBox creaComboBox( Object[] lista ) {
		return new ComboBox( this, lista );
	}

	/**
	 * Crea la classe <code>DateChooser</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @return la classe <code>DateChooser</code> creata
	 */
	public DateChooser creaDateChooser() {
		return new DateChooser( this );
	}

	/**
	 * Crea la classe <code>Layout</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param manager la classe <code>LayoutManager</code> che viene aggiunta al
	 *                <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaLayout( LayoutManager manager ) {
		return new Layout( this, manager );
	}

	/**
	 * Crea la classe <code>Layout</code> con sfondo trasparente impiegando questa
	 * classe <code>PreferenzeGUI</code>
	 *
	 * @param manager la classe <code>LayoutManager</code> che viene aggiunta al
	 *                <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaLayoutTrasparente( LayoutManager manager ) {
		return new Layout( this, manager, true );
	}

	/**
	 * Crea la classe <code>Layout</code> con il layout manager
	 * <code>GridLayout</code>, impiegando questa classe <code>PreferenzeGUI</code>
	 *
	 * @param righe      numero di righe del <code>GridLayout</code>
	 * @param colonne    numero di colonne del <code>GridLayout</code>
	 * @param componenti componenti da aggiungere al <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaGridLayout( int righe, int colonne, Component[] componenti ) {
		Layout grid = new Layout( this, new GridLayout( righe, colonne ) );
		if ( componenti != null ) {
			for ( Component c : componenti ) {
				grid.add( c );
			}
		}
		return grid;
	}

	/**
	 * Crea la classe <code>Layout</code> con il layout manager
	 * <code>GridLayout</code> senza componenti, impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param righe   numero di righe del <code>GridLayout</code>
	 * @param colonne numero di colonne del <code>GridLayout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaGridLayout( int righe, int colonne ) {
		return creaGridLayout( righe, colonne, null );
	}

	/**
	 * Crea la classe <code>Layout</code> con il layout manager
	 * <code>GridBagLayout</code>, impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaGridBagLayout() {
		return new Layout( this, new GridBagLayout() );
	}

	public GridBagConstraints creaGridBagConstraints( int gridx, int gridy, int anchor, int fill, int topInsets, int leftInsets, int bottomInsets,
			int rightInsets ) {
		return creaGridBagConstraints( gridx, gridy, 1, 1, 1.0, 1.0, anchor, fill, topInsets, leftInsets, bottomInsets, rightInsets, 0, 0 );
	}

	public GridBagConstraints creaGridBagConstraints( int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor,
			int fill, int topInsets, int leftInsets, int bottomInsets, int rightInsets, int ipadx, int ipady ) {
		return new GridBagConstraints( gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
				new Insets( topInsets, leftInsets, bottomInsets, rightInsets ), ipadx, ipady );
	}

	public GridBagConstraints creaGridBagConstraints( int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor,
			int fill, Insets insets, int ipadx, int ipady ) {
		return new GridBagConstraints( gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady );
	}

	/**
	 * Crea la classe <code>Layout</code> con il layout manager
	 * <code>WrapLayout</code>, impiegando questa classe <code>PreferenzeGUI</code>
	 *
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaWrapLayout() {
		return new Layout( this, new WrapLayout() );
	}

	/**
	 * Crea la classe <code>Layout</code> con il layout manager
	 * <code>WrapLayout</code>, impiegando questa classe <code>PreferenzeGUI</code>
	 *
	 * @param align l'alliniamento del layout
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaWrapLayout( int align ) {
		return new Layout( this, new WrapLayout( align ) );
	}

	/**
	 * Crea la classe <code>Layout</code> con il layout manager
	 * <code>BoxLayout</code>, impiegando questa classe <code>PreferenzeGUI</code>
	 *
	 * @param axis l'asse di alliniamento del layout
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaBoxLayout( int axis ) {
		Layout l = new Layout( this, null );
		l.setLayout( new BoxLayout( l, axis ) );
		return l;
	}

	/**
	 * Crea la classe <code>ScrollPane</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param view componente da mostrare nello <code>ScrollPane</code>
	 * @return la classe <code>ScrollPane</code> creata
	 */
	public ScrollPane creaScrollPane( JPanel view ) {
		return new ScrollPane( this, view );
	}

	/**
	 * Crea la classe <code>Finestra</code> estesa a schermo intero a cui aggiunge
	 * uno <code>ScrollPane</code> contenete un componente personalizzato. Si può
	 * scegliere se alla creazione la <code>Finestra</code> sia visibile
	 *
	 * @param titolo   titolo della <code>Finestra</code>
	 * @param child    componente personjalizzato contenuto nello
	 *                 <code>ScrollPane</code>
	 * @param visibile se la finestra deve essere visibile alla fine della creazione
	 * @return la classe <code>Finestra</code> creata
	 */
	public Finestra creaFinestra( String titolo, JPanel child, boolean visibile ) {
		return creaFinestra( titolo, child, null, visibile );
	}

	/**
	 * Crea la classe <code>Finestra</code> estesa a schermo intero a cui aggiunge
	 * uno <code>ScrollPane</code> contenete un componente personalizzato e una
	 * <code>MenuBar</code>.S i può scegliere se alla creazione la
	 * <code>Finestra</code> sia visibile
	 *
	 * @param titolo   titolo della <code>Finestra</code>
	 * @param child    componente personjalizzato contenuto nello
	 *                 <code>ScrollPane</code>
	 * @param menuBar  <code>MenuBar</code> da aggiungere alla <code>Finestra</code>
	 * @param visibile se la finestra deve essere visibile alla fine della creazione
	 * @return la classe <code>Finestra</code> creata
	 */
	public Finestra creaFinestra( String titolo, JPanel child, MenuBar menuBar, boolean visibile ) {
		Finestra ritorno = new Finestra( titolo, Finestra.schermo.width / 2, Finestra.schermo.height / 2, Frame.MAXIMIZED_BOTH );
		ritorno.add( creaScrollPane( child ), BorderLayout.CENTER );
		ritorno.setVisible( visibile );
		if ( menuBar != null ) {
			ritorno.setJMenuBar( menuBar );
		}
		return ritorno;
	}

	/**
	 * Crea la classe <code>Finestra</code> centrata nello schermo a cui aggiunge
	 * uno <code>ScrollPane</code> contenete un componente personalizzato. Si può
	 * scegliere se alla creazione la <code>Finestra</code> sia visibile
	 *
	 * @param titolo    titolo della <code>Finestra</code>
	 * @param larghezza larghezza della <code>Finestra</code>
	 * @param altezza   altezza della <code>Finestra</code>
	 * @param child     componente personjalizzato contenuto nello
	 *                  <code>ScrollPane</code>
	 * @param visibile  se la finestra deve essere visibile alla fine della
	 *                  creazione
	 * @return la classe <code>Finestra</code> creata
	 */
	public Finestra creaFinestra( String titolo, int larghezza, int altezza, JPanel child, boolean visibile ) {
		return creaFinestra( titolo, larghezza, altezza, child, null, visibile );
	}

	/**
	 * Crea la classe <code>Finestra</code> centrata nello schermo a cui aggiunge
	 * uno <code>ScrollPane</code> contenete un componente personalizzato e una
	 * <code>MenuBar</code>. Si può scegliere se alla creazione la
	 * <code>Finestra</code> sia visibile
	 *
	 * @param titolo    titolo della <code>Finestra</code>
	 * @param larghezza larghezza della <code>Finestra</code>
	 * @param altezza   altezza della <code>Finestra</code>
	 * @param child     componente personjalizzato contenuto nello
	 *                  <code>ScrollPane</code>
	 * @param menuBar   <code>MenuBar</code> da aggiungere alla
	 *                  <code>Finestra</code>
	 * @param visibile  se la finestra deve essere visibile alla fine della
	 *                  creazione
	 * @return la classe <code>Finestra</code> creata
	 */
	public Finestra creaFinestra( String titolo, int larghezza, int altezza, JPanel child, MenuBar menuBar, boolean visibile ) {
		Finestra ritorno = new Finestra( titolo, larghezza, altezza, Frame.NORMAL );
		ritorno.add( creaScrollPane( child ), BorderLayout.CENTER );
		ritorno.setVisible( visibile );
		if ( menuBar != null ) {
			ritorno.setJMenuBar( menuBar );
		}
		return ritorno;
	}

	/**
	 * Crea la classe <code>MenuItem</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param testo        testo del <code>MenuItem</code>
	 * @param listener     <code>ActionListener</code> da aggiungere al
	 *                     <code>MenuItem</code>
	 * @param parteSubMenu se fa parte di un <i>sub menu<i>, in tal caso avrà uno
	 *                     sfondo diverso
	 * @return ritorna la classe <code>MenuItem</code> creata
	 */
	public MenuItem creaMenuItem( String testo, ActionListener listener, boolean parteSubMenu ) {
		return new MenuItem( this, testo, listener, parteSubMenu );
	}

	/**
	 * Crea la classe <code>MenuItem</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param testo        testo del <code>MenuItem</code>
	 * @param listener     <code>ActionListener</code> da aggiungere al
	 *                     <code>MenuItem</code>
	 * @param icona        icona da aggiungere al <code>MenuItem</code>
	 * @param parteSubMenu se fa parte di un <i>sub menu<i>, in tal caso avrà uno
	 *                     sfondo diverso
	 * @return ritorna la classe <code>MenuItem</code> creata
	 */
	public MenuItem creaMenuItem( String testo, ActionListener listener, Icon icona, boolean parteSubMenu ) {
		return new MenuItem( this, testo, listener, icona, parteSubMenu );
	}

	/**
	 * Crea la classe <code>Menu</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param testo        testo del <code>Menu</code>
	 * @param componenti   array di componenti da aggiungere al <code>Menu</code>
	 * @param parteSubMenu se fa parte di un <i>sub menu<i>, in tal caso avrà uno
	 *                     sfondo diverso
	 * @return ritorna la classe <code>Menu</code> creata
	 */
	public Menu creaMenu( String testo, Component[] componenti, boolean parteSubMenu ) {
		return new Menu( this, testo, componenti, parteSubMenu );
	}

	/**
	 * Crea la classe <code>Menu</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param testo        testo del <code>Menu</code>
	 * @param componenti   array di componenti da aggiungere al <code>Menu</code>
	 * @param icona        icona da aggiungere al <code>Menu</code>
	 * @param parteSubMenu se fa parte di un <i>sub menu<i>, in tal caso avrà uno
	 *                     sfondo diverso
	 * @return ritorna la classe <code>Menu</code> creata
	 */
	public Menu creaMenu( String testo, Component[] componenti, Icon icona, boolean parteSubMenu ) {
		return new Menu( this, testo, componenti, icona, parteSubMenu );
	}

	/**
	 * Crea la classe <code>Separatore</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @return la classe <code>Separatore</code> creata
	 */
	public Separatore creaSeparatore() {
		return new Separatore( this );
	}

	/**
	 * Crea la classe <code>MenuBar</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param componenti componenti da aggiungere alla <code>MenuBar</code>
	 *
	 * @return la classe <code>MenuBar</code> creata
	 */
	public MenuBar creaMenuBar( Component[] componenti ) {
		return new MenuBar( this, componenti );
	}

	/**
	 * Crea la classe <code>MenuBar</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @return la classe <code>MenuBar</code> creata
	 */
	public MenuBar creaMenuBar() {
		return new MenuBar( this );
	}

	/**
	 * Crea la classe <code>MenuBar</code> tramite la classe
	 * <code>ListaOggettiMenu</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param menu <code>ListaOggettiMenu</code> da cui generare i componenti da
	 *             aggiungere alla <code>MenuBar</code>
	 *
	 * @return la classe <code>MenuBar</code> creata
	 */
	public MenuBar creaMenuBarDaListaOggettiMenu( ListaOggettiMenu menu ) {
		MenuBar ritorno = null;
		try {
			ritorno = MenuBar.creaMenuBarDaListaOggettiMenu( this, menu );
		} catch ( WrongValueException e ) {
			e.printStackTrace();
		}
		return ritorno;
	}

	/**
	 * Crea la classe <code>PopupMenu</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @return la classe <code>PopupMenu</code> creata
	 */
	public PopupMenu creaPopupMenu() {
		return new PopupMenu( this );
	}

	/**
	 * Crea la classe <code>PopupMenu</code> tramite la classe
	 * <code>ListaOggettiMenu</code> impiegando questa classe
	 * <code>PreferenzeGUI</code>
	 *
	 * @param menu <code>ListaOggettiMenu</code> da cui generare i componenti da
	 *             aggiungere al <code>PopupMenu</code>
	 *
	 * @return la classe <code>PopupMenu</code> creata
	 */
	public PopupMenu creaPopupMenuDaListaOggettiMenu( ListaOggettiMenu menu ) {
		return new PopupMenu( this, menu );
	}

	/**
	 * Crea una classe <code>Layout</code> con layout manager
	 * <code>GridBagLayout</code> contenete una <code>Label</code> con il font
	 * generico e un <code>Component</code> ancorati a sinistra per disporli
	 * verticalmente con un distanziamento tra i due di 5 pixel
	 *
	 * @param testoLabel testo della <code>Label</code> da aggiungere al
	 *                   <code>Layout</code>
	 * @param componente <code>Component</code> da aggiungere al <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaLabelComponenteVerticale( String testoLabel, Component componente ) {
		return creaLabelComponenteVerticale( creaLabel( testoLabel ), componente );
	}

	/**
	 * Crea una classe <code>Layout</code> con layout manager
	 * <code>GridBagLayout</code> contenete una <code>Label</code> e un
	 * <code>Component</code> ancorati a sinistra per disporli verticalmente con un
	 * distanziamento tra i due di 5 pixel
	 *
	 * @param label      <code>Label</code> da aggiungere al <code>Layout</code>
	 * @param componente <code>Component</code> da aggiungere al <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaLabelComponenteVerticale( Label label, Component componente ) {
		Layout l = creaGridBagLayout();
		l.add( label, creaGridBagConstraints( 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, 10, 0, 0, 0 ) );
		l.add( componente, creaGridBagConstraints( 0, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, 5, 0, 5, 0 ) );
		l.setBorder( bordi.bordoGenerico( 0, new Insets( 10, 10, 10, 10 ) ) );
		return l;
	}

	/**
	 * Crea una classe <code>Layout</code> con layout manager
	 * <code>GridBagLayout</code> contenete una <code>Label</code> con il font
	 * generico ancorata a destra e un <code>Component</code> ancorato a sinistra
	 * per disporli orizzontalmente con un distanziamento tra i due di 10 pixel
	 *
	 * @param testoLabel testo della <code>Label</code> da aggiungere al
	 *                   <code>Layout</code>
	 * @param componente <code>Component</code> da aggiungere al <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaLabelComponenteOrizzontale( String testoLabel, Component componente ) {
		return creaLabelComponenteOrizzontale( creaLabel( testoLabel ), componente );
	}

	/**
	 * Crea una classe <code>Layout</code> con layout manager
	 * <code>GridBagLayout</code> contenete una <code>Label</code> e un
	 * <code>Component</code> ancorato a sinistra per disporli orizzontalmente con
	 * un distanziamento tra i due di 10 pixel
	 *
	 * @param label      <code>Label</code> da aggiungere al <code>Layout</code>
	 * @param componente <code>Component</code> da aggiungere al <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaLabelComponenteOrizzontale( Label label, Component componente ) {
		Layout l = creaGridBagLayout();
		l.add( label, creaGridBagConstraints( 0, 0, 1, 1, 0.1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH, 0, 0, 0, 10, 0, 0 ) );
		l.add( componente, creaGridBagConstraints( 1, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, 0, 0, 0, 0 ) );
		l.setBorder( bordi.bordoGenerico( 0, new Insets( 10, 10, 10, 10 ) ) );
		return l;
	}

	/**
	 * Crea una classe <code>Layout</code> con layout manager
	 * <code>GridBagLayout</code> contenete delle <code>Label</code> ancorate a
	 * sinistra e dei <code>Component</code> a destra
	 *
	 * @param testoLabel array da cui generare le <code>Label</code> da aggiungere
	 *                   al <code>Layout</code>
	 * @param componenti array di <code>Component</code> da aggiungere al
	 *                   <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaGruppoLabelComponenteOrizzontale( String[] testoLabel, Component[] componenti ) {
		Label[] label = new Label[testoLabel.length];
		for ( int i = 0; i < label.length; i++ ) {
			label[i] = creaLabel( testoLabel[i] );
		}
		return creaGruppoLabelComponenteOrizzontale( label, componenti );
	}

	/**
	 * Crea una classe <code>Layout</code> con layout manager
	 * <code>GridBagLayout</code> contenete delle <code>Label</code> ancorate a
	 * sinistra e dei <code>Component</code> a destra
	 *
	 * @param label      array di <code>Label</code> da aggiungere al
	 *                   <code>Layout</code>
	 * @param componenti array di <code>Component</code> da aggiungere al
	 *                   <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaGruppoLabelComponenteOrizzontale( Label[] label, Component[] componenti ) {
		Layout l = creaGridBagLayout();
		for ( int i = 0; i < label.length; i++ ) {
			l.add( label[i], creaGridBagConstraints( 0, i, 1, 1, 0.1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH, 5, 0, 5, 5, 0, 0 ) );
			l.add( componenti[i], creaGridBagConstraints( 1, i, GridBagConstraints.CENTER, GridBagConstraints.NONE, 5, 5, 5, 0 ) );
		}
		l.setBorder( bordi.bordoGenerico( 0, new Insets( 10, 10, 10, 10 ) ) );
		return l;
	}

	/**
	 * Crea una classe <code>Layout</code> con layout manager
	 * <code>GridBagLayout</code> contenete delle <code>Label</code> e dei
	 * <code>Component</code> impilati
	 *
	 * @param testoLabel array da cui generare le <code>Label</code> da aggiungere
	 *                   al <code>Layout</code>
	 * @param componenti array di <code>Component</code> da aggiungere al
	 *                   <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaGruppoLabelComponenteVerticale( String[] testoLabel, Component[] componenti ) {
		Label[] label = new Label[testoLabel.length];
		for ( int i = 0; i < label.length; i++ ) {
			label[i] = creaLabel( testoLabel[i] );
		}
		return creaGruppoLabelComponenteVerticale( label, componenti );
	}

	/**
	 * Crea una classe <code>Layout</code> con layout manager
	 * <code>GridBagLayout</code> contenete delle <code>Label</code> e dei
	 * <code>Component</code> impilati
	 *
	 * @param label      array di <code>Label</code> da aggiungere al
	 *                   <code>Layout</code>
	 * @param componenti array di <code>Component</code> da aggiungere al
	 *                   <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaGruppoLabelComponenteVerticale( Label[] label, Component[] componenti ) {
		Layout l = creaGridBagLayout();
		for ( int i = 0; i < label.length; i++ ) {
			l.add( label[i], creaGridBagConstraints( 0, 2 * i, GridBagConstraints.WEST, GridBagConstraints.NONE, 10, 0, 0, 0 ) );
			l.add( componenti[i], creaGridBagConstraints( 0, ( 2 * i ) + 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 5, 0, 5, 0 ) );
		}
		l.setBorder( bordi.bordoGenerico( 0, new Insets( 10, 10, 10, 10 ) ) );
		return l;
	}

	/**
	 * Crea una classe <code>Layout</code> contenete un <code>PasswordField</code>
	 * di 10 colonne e un <code>Bottone</code> per mostrare e nascondere il testo
	 * della password
	 *
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaPasswordFieldSH() {
		return creaPasswordFieldSH( creaPasswordField( 10 ) );
	}

	/**
	 * Crea una classe <code>Layout</code> contenete un <code>PasswordField</code> e
	 * un <code>Bottone</code> per mostrare e nascondere il testo della password
	 *
	 * @param pswField la classe <code>PasswordField</code> da aggiungere al
	 *                 <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaPasswordFieldSH( PasswordField pswField ) {
		Bottone sh = new Bottone( this, "<html>&#128065;</html>", new ActionListener() {
			boolean mostra = false;

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				mostra = !mostra;
				if ( mostra ) {
					pswField.setEchoChar( ( char ) 0 );
					( ( Bottone ) arg0.getSource() ).setText( "<html>&#10060;</html>" );
				} else {
					pswField.setEchoChar( '•' );
					( ( Bottone ) arg0.getSource() ).setText( "<html>&#128065;</html>" );
				}
			}

		} );
		sh.setFont( new Font( "Segoe UI Emoji", Font.PLAIN, 11 ) );
		sh.setName( "bottone emoji" );
		Layout grid = creaGridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.VERTICAL;
		grid.add( pswField );
		grid.add( sh, gbc );
		return grid;
	}

	/**
	 * Crea una classe <code>Dialog</code> impiegando questa classe
	 * <code>PreferenzeGUI</code> e aggiungendo elementi al <code>Dialog</code>
	 *
	 * @param finestra       <code>Frame</code> a cui appartiene
	 * @param titolo         titolo del <code>Dialog</code>
	 * @param modale         se il <code>Dialog</code> è modale
	 * @param larghezza      larghezza della finestra del <code>Dialog</code>
	 * @param altezza        altezza della finestra del <code>Dialog</code>
	 * @param child          componente da mostrare nel <code>Dialog</code>
	 * @param panelloBottoni pannello dei bottoni del <code>Dialog</code>
	 * @param visibile       se mostrare dopo la creazione del <code>Dialog</code>
	 * @return la classe <code>Dialog</code> creata
	 */
	public Dialog creaDialog( JFrame finestra, String titolo, boolean modale, int larghezza, int altezza, JPanel child, JPanel panelloBottoni,
			boolean visibile ) {
		Dialog dialog = new Dialog( finestra, titolo, modale, larghezza, altezza );
		dialog.add( child, BorderLayout.CENTER );
		dialog.add( panelloBottoni, BorderLayout.SOUTH );
		dialog.setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );
		dialog.setVisible( visibile );
		return dialog;
	}

	/**
	 * Crea una classe <code>Layout</code> con sfondo diverso, per disporre i
	 * bottoni orizzontalmente e ancorati a destra
	 *
	 * @param bottoni array di <code>Bottone</code> da aggiungere al
	 *                <code>Layout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaPanelloBottoni( Bottone[] bottoni ) {

		Layout grid = new Layout( this, new GridLayout( 1, bottoni.length ) ) {
			private static final long serialVersionUID = 1L;

			@Override
			public void update( Observable arg0, Object obj ) {
				PreferenzeGUI gui = ( PreferenzeGUI ) obj;
				setBackground( gui.colori.suSfondo() );
				repaint();
			}
		};
		grid.setBackground( colori.suSfondo() );
		( ( GridLayout ) grid.getLayout() ).setHgap( 5 );

		for ( Bottone element : bottoni ) {
			grid.add( element );
		}

		Layout grid2 = new Layout( this, new GridBagLayout() ) {
			private static final long serialVersionUID = 1L;

			@Override
			public void update( Observable arg0, Object obj ) {
				PreferenzeGUI gui = ( PreferenzeGUI ) obj;
				setBackground( gui.colori.suSfondo() );
				repaint();
			}
		};
		grid2.setBackground( colori.suSfondo() );
		grid2.add( grid, new GridBagConstraints( 0, 0, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets( 5, 0, 5, 10 ), 0, 0 ) );

		return grid2;
	}

	/**
	 * Crea una classe <code>Layout</code> con layout manager
	 * <code>GridLayout</code> per disporre dei bottoni in una griglia
	 *
	 * @param righe   numero di righe del <code>GridLayout</code>
	 * @param colonne numero di colonne del <code>GridLayout</code>
	 * @param bottoni array di <code>Bottone</code> da aggiungere al
	 *                <code>Layout</code>
	 * @param Hgap    spazio orizzontale tra le componenti del
	 *                <code>GridLayout</code>
	 * @param Vgap    spazio verticale tra le componenti del <code>GridLayout</code>
	 * @return la classe <code>Layout</code> creata
	 */
	public Layout creaGrigliaBottoni( int righe, int colonne, Bottone[] bottoni, int Hgap, int Vgap ) {
		Layout gBottoni = creaGridLayout( righe, colonne );
		( ( GridLayout ) gBottoni.getLayout() ).setHgap( Hgap );
		( ( GridLayout ) gBottoni.getLayout() ).setVgap( Vgap );

		for ( Bottone element : bottoni ) {
			gBottoni.add( element );
		}

		return gBottoni;
	}

	/**
	 * Crea una classe <code>Bottone</code> che permette di cambiare il tema
	 * predefinito chiaro quello predefinito scuro
	 *
	 * @return la classe <code>Bottone</code> creata
	 */
	public Bottone creaBottoneCambiaTemaChiaroScuro() {
		return creaBottoneCambiaTemaChiaroScuro( new PreferenzeGUI( TEMA_CHIARO ), new PreferenzeGUI( TEMA_SCURO ) );
	}

	/**
	 * Crea una classe <code>Bottone</code> che permette di cambiare il tema
	 * personalizzato chiaro quello personalizzato scuro, con testo predefinito
	 *
	 * @param temaChiaro la classe <code>PreferenzeGUI</code> con i valori del tema
	 *                   chiaro
	 * @param temaScuro  la classe <code>PreferenzeGUI</code> con i valori del tema
	 *                   scuro
	 * @return la classe <code>Bottone</code> creata
	 */
	public Bottone creaBottoneCambiaTemaChiaroScuro( PreferenzeGUI temaChiaro, PreferenzeGUI temaScuro ) {
		return creaBottoneCambiaTemaChiaroScuro( "<html>&#9728;</html>", "<html>&#127769;</html>", true, temaChiaro, temaScuro );
	}

	/**
	 * Crea una classe <code>Bottone</code> che permette di cambiare il tema
	 * personalizzato chiaro e quello personalizzato scuro, con testo personalizzato
	 *
	 * @param testoTemaChiaro testo del bottone quando è impostato il tema chiaro
	 * @param testoTemaScuro  testo del bottone quando è impostato il tema scuro
	 * @param testoEmoji      se il testo è un emoji, in tal caso utilizza il font
	 *                        <b>Segoe UI Emoji</b>
	 * @param temaChiaro      la classe <code>PreferenzeGUI</code> con i valori del
	 *                        tema chiaro
	 * @param temaScuro       la classe <code>PreferenzeGUI</code> con i valori del
	 *                        tema scuro
	 * @return la classe <code>Bottone</code> creata
	 */
	public Bottone creaBottoneCambiaTemaChiaroScuro( String testoTemaChiaro, String testoTemaScuro, boolean testoEmoji, PreferenzeGUI temaChiaro,
			PreferenzeGUI temaScuro ) {

		Bottone ritorno = creaBottone( testoTemaChiaro, new ActionListener() {

			boolean temaScuroBool = false;

			@Override
			public void actionPerformed( ActionEvent e ) {
				if ( temaScuroBool ) {
					cambiaGUI( temaChiaro );
					( ( Bottone ) e.getSource() ).setText( testoTemaChiaro );
				} else {
					cambiaGUI( temaScuro );
					( ( Bottone ) e.getSource() ).setText( testoTemaScuro );
				}
				temaScuroBool = !temaScuroBool;
			}
		} );
		if ( testoEmoji ) {
			ritorno.setFont( new Font( "Segoe UI Emoji", Font.PLAIN, 11 ) );
			ritorno.setName( "bottone emoji" );
		}

		return ritorno;
	}
}
