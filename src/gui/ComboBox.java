package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

/**
 * Sottoclasse di <code>JComboBox</code> che pu&ograve; impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class ComboBox extends JComboBox<Object> implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * mouse listener per cambiare bordo
	 */
	private MouseListener cambiaBordo;
	/**
	 * colore del bottone
	 */
	private Color coloreBottone;

	/**
	 * colore della freccia
	 */
	private Color coloreFreccia;

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui   la classe <code>PreferenzeGUI</code> su cui si basa la GUI della
	 *              <code>ComboBox</code>
	 * @param lista la lista di <code>Object</code> che deve contenere la
	 *              <code>ComboBox</code>
	 */
	public ComboBox( PreferenzeGUI gui, Object[] lista ) {
		this( gui.colori, gui.fonts, gui.bordi, lista );
		gui.addObserver( this );
	}

	/**
	 * Costruttore che impiega le interfaccie <code>Colori</code>,
	 * <code>Fonts</code>, <code>Bordi</code>
	 *
	 * @param colori l'interfaccia <code>Colori</code> su cui si basano i colori
	 *               della <code>ComboBox</code>
	 * @param fonts  l'interfaccia <code>Fonts</code> su cui si basano i font della
	 *               <code>ComboBox</code>
	 * @param bordi  l'interfaccia <code>Bordi</code> su cui si basano i bordi della
	 *               <code>ComboBox</code>
	 * @param lista  la lista di <code>Object</code> che deve contenere la
	 *               <code>ComboBox</code>
	 */
	public ComboBox( Colori colori, Fonts fonts, Bordi bordi, Object[] lista ) {
		this( colori.suSfondo(), colori.testo(), colori.primario(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoInteragibile(),
				bordi.bordoGenericoFocus(), lista );
	}

	/**
	 * Costruttore con parametri specifici
	 *
	 * @param coloreSfondo    il colore dello sfondo dela <code>ComboBox</code>
	 * @param coloreTesto     il colore del testo della <code>ComboBox</code>
	 * @param coloreSelezione il colore dell'oggetto selezionato
	 * @param font            il font della <code>ComboBox</code>
	 * @param bordo           il bordo della <code>ComboBox</code>
	 * @param bordoFocus      il bordo della <code>ComboBox</code> quando il mouse
	 *                        passa sopra
	 * @param lista           la lista di <code>Object</code> che deve contenere la
	 *                        <code>ComboBox</code>
	 */
	public ComboBox( Color coloreSfondo, Color coloreTesto, Color coloreSelezione, Font font, Border bordo, Border bordoFocus, Object[] lista ) {
		super( lista );
		this.coloreBottone = coloreSfondo;
		this.coloreFreccia = coloreTesto;
		setUI( new ComboBoxUI() );
		Object child = this.getAccessibleContext().getAccessibleChild( 0 );
		BasicComboPopup popup = ( BasicComboPopup ) child;
		JList<?> list = popup.getList();
		list.setBackground( coloreSfondo );
		list.setSelectionBackground( coloreSfondo );
		list.setForeground( coloreTesto );
		list.setSelectionForeground( coloreSelezione );
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setBorder( bordo );
		setFont( font );
		setFocusable( false );
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

	private class ComboBoxUI extends BasicComboBoxUI {

		@Override
		protected JButton createArrowButton() {
			final JButton button = new BasicArrowButton( SwingConstants.SOUTH, coloreBottone, coloreBottone, coloreFreccia, coloreBottone );
			button.setName( "ComboBox.arrowButton" );
			button.setBorder( BorderFactory.createLineBorder( coloreBottone ) );
			return button;
		}
	}

	@Override
	public void update( Observable o, Object arg ) {

		PreferenzeGUI gui = ( PreferenzeGUI ) arg;

		this.coloreBottone = gui.colori.suSfondo();
		this.coloreFreccia = gui.colori.testo();
		setUI( new ComboBoxUI() );
		Object child = this.getAccessibleContext().getAccessibleChild( 0 );
		BasicComboPopup popup = ( BasicComboPopup ) child;
		JList<?> list = popup.getList();
		list.setBackground( gui.colori.suSfondo() );
		list.setSelectionBackground( gui.colori.suSfondo() );
		list.setForeground( gui.colori.testo() );
		list.setSelectionForeground( gui.colori.primario() );
		setBackground( gui.colori.suSfondo() );
		setForeground( gui.colori.testo() );
		setBorder( gui.bordi.bordoInteragibile() );
		setFont( gui.fonts.fontGenerico( Fonts.PLAIN ) );
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
