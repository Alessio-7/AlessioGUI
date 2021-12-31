package utility;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import gui.Bottone;
import gui.ComboBox;
import gui.Finestra;
import gui.Label;
import gui.TextField;
import preferenze.PreferenzeGUI;

/**
 * Sottoclasse della classe <code>JDialog</code>
 */
public class Dialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private boolean scelta = false;
	private int ritornoSiNo = -1;

	/**
	 * Enum per il tipo di messaggio del <code>Dialog</code>
	 */
	public enum Messaggio {
		INFO, AVVERTIMENTO, ERRORE
	}

	/**
	 * Costruttore che centra nello schermo il <code>Dialog</code>
	 *
	 * @param finestra  finestra da cui viene generato il <code>Dialog</code>
	 * @param titolo    titolo del <code>Dialog</code>
	 * @param modale    se il <code>Dialog</code> è modale
	 * @param larghezza larghezza del <code>Dialog</code>
	 * @param altezza   altezza del <code>Dialog</code>
	 */
	public Dialog( JFrame finestra, String titolo, boolean modale, int larghezza, int altezza ) {
		this( finestra, titolo, modale, larghezza, altezza, ( Finestra.schermo.width - larghezza ) / 2, ( Finestra.schermo.height - altezza ) / 2 );
	}

	/**
	 * Costruttore del <code>Dialog</code>
	 *
	 * @param finestra  finestra da cui viene generato il <code>Dialog</code>
	 * @param titolo    titolo del <code>Dialog</code>
	 * @param modale    se il <code>Dialog</code> è modale
	 * @param larghezza larghezza del <code>Dialog</code>
	 * @param altezza   altezza del <code>Dialog</code>
	 * @param x         coordinata x del <code>Dialog</code>
	 * @param y         coordinata y del <code>Dialog</code>
	 */
	public Dialog( JFrame finestra, String titolo, boolean modale, int larghezza, int altezza, int x, int y ) {
		super( finestra, titolo, modale );
		setSize( larghezza, altezza );
		setResizable( false );
		setLocation( x, y );
		setLayout( new BorderLayout() );
	}

	/**
	 * Mostra un <code>Dialog</code> contenente un messaggio
	 *
	 * @param gui       classe <code>PreferenzeGUI</code> da cui generare il
	 *                  <code>Dialog</code>
	 * @param messaggio tipo di messaggio
	 * @param finestra  finestra da cui viene generato il <code>Dialog</code>
	 * @param titolo    titolo del <code>Dialog</code>
	 * @param testo     testo del messaggio
	 * @return la classe <code>Dialog</code> che mostra il messaggio
	 */
	public static Dialog mostraDialogMessaggio( PreferenzeGUI gui, Messaggio messaggio, Frame finestra, String titolo, String testo ) {

		Label label = gui.creaLabel( "    " + testo );

		label.setIcon( getIcona( messaggio ) );

		JPanel grid2 = gui.creaGridBagLayout();
		grid2.add( label );

		Dialog dialog = new Dialog( ( JFrame ) finestra, titolo, true, 300, 200 );
		dialog.add( grid2, BorderLayout.CENTER );
		dialog.add( gui.creaPanelloBottoni( new Bottone[] { gui.creaBottone( "   Ok   ", new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				dialog.dispose();
			}
		} ) } ), BorderLayout.SOUTH );
		dialog.setVisible( true );

		return dialog;
	}

	/**
	 * Mostra un <code>Dialog</code> per la scelta tra delle opzioni tramite un
	 * <code>ComboBox</code>
	 *
	 * @param gui         classe <code>PreferenzeGUI</code> da cui generare il
	 *                    <code>Dialog</code>
	 * @param finestra    finestra da cui viene generato il <code>Dialog</code>
	 * @param titolo      titolo del <code>Dialog</code>
	 * @param testoScelta testo della scelta
	 * @param scelte      array di oggetti tra cui scegliere
	 * @return l'oggetto scelto
	 */
	public static Object mostraDialogComboBox( PreferenzeGUI gui, Frame finestra, String titolo, String testoScelta, Object[] scelte ) {

		Object ritorno = null;

		Dialog dialog = new Dialog( ( JFrame ) finestra, titolo, true, 300, 200 );
		dialog.setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );

		dialog.scelta = false;

		JPanel grid = gui.creaGridBagLayout();
		ComboBox comboBox = gui.creaComboBox( scelte );
		grid.add( gui.creaLabelComponenteVerticale( gui.creaLabel( testoScelta ), comboBox ) );

		dialog.add( grid, BorderLayout.CENTER );
		dialog.add( gui.creaPanelloBottoni( new Bottone[] {

				gui.creaBottone( "Ok", new ActionListener() {

					@Override
					public void actionPerformed( ActionEvent arg0 ) {
						dialog.scelta = true;
						dialog.dispose();
					}
				} ), gui.creaBottone( "Cancella", new ActionListener() {

					@Override
					public void actionPerformed( ActionEvent arg0 ) {
						dialog.dispose();
					}
				} ) } ), BorderLayout.SOUTH );
		dialog.setVisible( true );

		while ( dialog.isDisplayable() )

		{
		}

		if ( dialog.scelta ) {
			ritorno = comboBox.getSelectedItem();
		}

		return ritorno;
	}

	/**
	 * Mostra un <code>Dialog</code> per l'input di un testo tramite un
	 * <code>TextField</code>
	 *
	 * @param gui         classe <code>PreferenzeGUI</code> da cui generare il
	 *                    <code>Dialog</code>
	 * @param finestra    finestra da cui viene generato il <code>Dialog</code>
	 * @param titolo      titolo del <code>Dialog</code>
	 * @param testoScelta testo della scelta
	 * @return l'input immesso
	 */
	public static String mostraDialogInputTesto( PreferenzeGUI gui, Frame finestra, String titolo, String testoScelta ) {

		String ritorno = "";

		Dialog dialog = new Dialog( ( JFrame ) finestra, titolo, true, 300, 200 );
		dialog.setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );

		dialog.scelta = false;

		JPanel grid = gui.creaGridBagLayout();
		TextField textField = gui.creaTextField( 10 );
		grid.add( gui.creaLabelComponenteVerticale( gui.creaLabel( testoScelta ), textField ) );

		dialog.add( grid, BorderLayout.CENTER );
		dialog.add( gui.creaPanelloBottoni( new Bottone[] {

				gui.creaBottone( "Ok", new ActionListener() {

					@Override
					public void actionPerformed( ActionEvent arg0 ) {
						dialog.scelta = true;
						dialog.dispose();
					}
				} ), gui.creaBottone( "Cancella", new ActionListener() {

					@Override
					public void actionPerformed( ActionEvent arg0 ) {
						dialog.dispose();
					}
				} ) } ), BorderLayout.SOUTH );
		dialog.setVisible( true );

		while ( dialog.isDisplayable() ) {
		}

		if ( dialog.scelta ) {
			ritorno = textField.getText();
		}

		return ritorno;
	}

	/**
	 * Mostra un <code>Dialog</code> per la scelta tra "Sì" o "No"
	 *
	 * @param gui       classe <code>PreferenzeGUI</code> da cui generare il
	 *                  <code>Dialog</code>
	 * @param finestra  finestra da cui viene generato il <code>Dialog</code>
	 * @param titolo    titolo del <code>Dialog</code>
	 * @param messaggio tipo di messaggio
	 * @param testo     testo della scelta
	 * @return
	 */
	public static int mostraDialogSiNo( PreferenzeGUI gui, Frame finestra, String titolo, Messaggio messaggio, String testo ) {

		Dialog dialog = new Dialog( ( JFrame ) finestra, titolo, true, 300, 200 );
		dialog.setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );

		dialog.scelta = false;
		dialog.ritornoSiNo = -1;

		JPanel grid = gui.creaGridBagLayout();
		Label label = gui.creaLabel( "    " + testo );
		label.setIcon( getIcona( messaggio ) );
		grid.add( label );

		dialog.add( grid, BorderLayout.CENTER );
		dialog.add( gui.creaPanelloBottoni( new Bottone[] { gui.creaBottone( "Sì", new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				dialog.scelta = true;
				dialog.ritornoSiNo = 1;
				dialog.dispose();
			}
		} ), gui.creaBottone( "No", new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				dialog.scelta = true;
				dialog.ritornoSiNo = 0;
				dialog.dispose();
			}
		} ), gui.creaBottone( "Cancella", new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				dialog.dispose();
			}
		} ) } ), BorderLayout.SOUTH );
		dialog.setVisible( true );

		while ( dialog.isDisplayable() ) {
		}

		return dialog.ritornoSiNo;
	}

	private static Icon getIcona( Messaggio messaggio ) {
		Icon icona = UIManager.getIcon( "OptionPane.informationIcon" );

		LookAndFeel previousLF = UIManager.getLookAndFeel();
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
			switch ( messaggio ) {
				case AVVERTIMENTO: {
					icona = UIManager.getIcon( "OptionPane.warningIcon" );
					break;
				}
				case ERRORE: {
					icona = UIManager.getIcon( "OptionPane.errorIcon" );
					break;
				}
				case INFO: {
					icona = UIManager.getIcon( "OptionPane.informationIcon" );
					break;
				}

			}
			UIManager.setLookAndFeel( previousLF );
		} catch ( IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e ) {
		}
		return icona;
	}
}
