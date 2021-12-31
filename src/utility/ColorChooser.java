package utility;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JColorChooser;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe per la scelta dei colori utilizzando il <b>LookAndFeel</b> del sistema
 */
public class ColorChooser {

	/**
	 * Mostra la finestra di dialogo per la scelta del colore
	 *
	 * @param componente il componente che chiama la finestra di dialogo
	 * @param titolo     titolo della finestra di dialogo
	 * @return il colore scelto
	 */
	public static Color mostraDialogoColore( Component componente, String titolo ) {
		return mostraDialogoColore( componente, titolo, null );
	}

	/**
	 * Mostra la finestra di dialogo per la scelta del colore
	 *
	 * @param componente     il componente che chiama la finestra di dialogo
	 * @param titolo         titolo della finestra di dialogo
	 * @param coloreIniziale il colore da cui parte la scelta
	 * @return il colore scelto
	 */
	public static Color mostraDialogoColore( Component componente, String titolo, Color coloreIniziale ) {
		Color ritorno = null;
		LookAndFeel previousLF = UIManager.getLookAndFeel();
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
			ritorno = JColorChooser.showDialog( componente, titolo, coloreIniziale );

			UIManager.setLookAndFeel( previousLF );
		} catch ( IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e ) {
		}

		return ritorno;
	}
}
