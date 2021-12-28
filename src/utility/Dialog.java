package utility;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.ComboBox;
import gui.Finestra;
import gui.Label;
import gui.TextField;
import preferenze.PreferenzeGUI;

public class Dialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private boolean scelta = false;
	private int ritornoSiNo = -1;

	public enum Messaggio {
		INFO, AVVERTENZA, ERRORE
	}

	public Dialog( Frame finestra, String titolo, boolean modale, int larghezza, int altezza ) {
		this( finestra, titolo, modale, larghezza, altezza, ( Finestra.schermo.width - larghezza ) / 2, ( Finestra.schermo.height - altezza ) / 2 );
	}

	public Dialog( Frame finestra, String titolo, boolean modale, int larghezza, int altezza, int x, int y ) {
		super( finestra, titolo, modale );
		setSize( larghezza, altezza );
		setResizable( false );
		setLocation( x, y );
		setLayout( new BorderLayout() );
	}

	public static Dialog mostraDialogMessaggio( PreferenzeGUI gui, Messaggio messaggio, Frame finestra, String titolo, String testo ) {

		Label label = gui.creaLabel( "    " + testo );

		label.setIcon( getIcona( messaggio ) );

		JPanel grid2 = gui.creaGridBagLayout();
		grid2.add( label );

		Dialog dialog = new Dialog( finestra, titolo, true, 300, 200 );
		dialog.add( grid2, BorderLayout.CENTER );
		dialog.add( gui.creaPanelBottoni( new String[] { "   Ok   " }, new ActionListener[] { new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				dialog.dispose();
			}
		} } ), BorderLayout.SOUTH );
		dialog.setVisible( true );

		return dialog;
	}

	public static Object mostraDialogComboBox( PreferenzeGUI gui, Frame finestra, String titolo, String testoScelta, Object[] scelte ) {

		Object ritorno = null;

		Dialog dialog = new Dialog( finestra, titolo, true, 300, 200 );
		dialog.setDefaultCloseOperation( Dialog.DO_NOTHING_ON_CLOSE );

		dialog.scelta = false;

		JPanel grid = gui.creaGridBagLayout();
		ComboBox comboBox = gui.creaComboBox( scelte );
		grid.add( gui.creaLabelComponenteVerticale( gui.creaLabel( testoScelta ), comboBox ) );

		dialog.add( grid, BorderLayout.CENTER );
		dialog.add( gui.creaPanelBottoni( new String[] { "Ok", "Cancella" }, new ActionListener[] { new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				dialog.scelta = true;
				dialog.dispose();
			}
		}, new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				dialog.dispose();
			}
		} } ), BorderLayout.SOUTH );
		dialog.setVisible( true );

		while ( dialog.isDisplayable() ) {
		}

		if ( dialog.scelta ) {
			ritorno = comboBox.getSelectedItem();
		}

		return ritorno;
	}

	public static String mostraDialogInputTesto( PreferenzeGUI gui, Frame finestra, String titolo, String testoScelta ) {

		String ritorno = "";

		Dialog dialog = new Dialog( finestra, titolo, true, 300, 200 );
		dialog.setDefaultCloseOperation( Dialog.DO_NOTHING_ON_CLOSE );

		dialog.scelta = false;

		JPanel grid = gui.creaGridBagLayout();
		TextField textField = gui.creaTextField( 10 );
		grid.add( gui.creaLabelComponenteVerticale( gui.creaLabel( testoScelta ), textField ) );

		dialog.add( grid, BorderLayout.CENTER );
		dialog.add( gui.creaPanelBottoni( new String[] { "Ok", "Cancella" }, new ActionListener[] { new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				dialog.scelta = true;
				dialog.dispose();
			}
		}, new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				dialog.dispose();
			}
		} } ), BorderLayout.SOUTH );
		dialog.setVisible( true );

		while ( dialog.isDisplayable() ) {
		}

		if ( dialog.scelta ) {
			ritorno = textField.getText();
		}

		return ritorno;
	}

	public static int mostraDialogSiNo( PreferenzeGUI gui, Frame finestra, String titolo, Messaggio messaggio, String testo ) {

		Dialog dialog = new Dialog( finestra, titolo, true, 300, 200 );
		dialog.setDefaultCloseOperation( Dialog.DO_NOTHING_ON_CLOSE );

		dialog.scelta = false;
		dialog.ritornoSiNo = -1;

		JPanel grid = gui.creaGridBagLayout();
		Label label = gui.creaLabel( "    " + testo );
		label.setIcon( getIcona( messaggio ) );
		grid.add( label );

		dialog.add( grid, BorderLayout.CENTER );
		dialog.add( gui.creaPanelBottoni( new String[] { "Sì", "No", "Cancella" }, new ActionListener[] { new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				dialog.scelta = true;
				dialog.ritornoSiNo = 1;
				dialog.dispose();
			}
		}, new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				dialog.scelta = true;
				dialog.ritornoSiNo = 0;
				dialog.dispose();
			}
		}, new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				dialog.dispose();
			}
		} } ), BorderLayout.SOUTH );
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
				case AVVERTENZA: {
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
