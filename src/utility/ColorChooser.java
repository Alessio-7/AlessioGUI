package utility;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JColorChooser;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ColorChooser {

	public static Color mostraDialogoColore( Component componente, String titolo ) {
		return mostraDialogoColore( componente, titolo, null );
	}

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
