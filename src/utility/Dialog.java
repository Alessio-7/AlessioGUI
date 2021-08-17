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

import gui.Finestra;
import gui.Label;
import preferenze.PreferenzeGUI;

public class Dialog extends JDialog {

	private static final long serialVersionUID = 1L;

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
		label.setIcon( icona );

		JPanel grid2 = gui.creaGridBagLayout();
		grid2.add( label );

		Dialog dialog = new Dialog( finestra, titolo, true, 300, 200 );
		dialog.add( grid2, BorderLayout.CENTER );
		dialog.add( gui.creaPanelBottoni( new String[] {
			"   Ok   " },
			new ActionListener[] {
				new ActionListener() {

					@Override
					public void actionPerformed( ActionEvent arg0 ) {
						dialog.dispose();
					}
				} } ),
			BorderLayout.SOUTH );
		dialog.setVisible( true );

		return dialog;
	}
}
