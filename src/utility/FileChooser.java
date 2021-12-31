package utility;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;

/**
 * Classe per la scelta dei file utilizzando il <b>LookAndFeel</b> del sistema
 */
public class FileChooser extends JFileChooser {

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore della classe <code>FileChooser</code>
	 *
	 * @param view classe <code>FileSystemView</code> da cui parte la scelta
	 */
	public FileChooser( FileSystemView view ) {
		super( view );
	}

	/**
	 * Costruttore della classe <code>FileChooser</code>
	 *
	 * @param file classe <code>File</code> da cui parte la scelta
	 */
	public FileChooser( File file ) {
		super( file );
	}

	/**
	 * Costruttore della classe <code>FileChooser</code>
	 *
	 * @param percorso
	 */
	public FileChooser( String percorso ) {
		super( percorso );
	}

	/**
	 * Crea una finestra di dialogo per la scelta di un file
	 *
	 * @param percorso percorso file da cui parte la scelta
	 * @return la classe <code>FileChooser</code> creata
	 */
	public static FileChooser creaFileChooser( String percorso ) {
		FileChooser ritorno = null;
		LookAndFeel previousLF = UIManager.getLookAndFeel();
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
			ritorno = new FileChooser( percorso );
			UIManager.setLookAndFeel( previousLF );
		} catch ( IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e ) {
		}
		return ritorno;
	}

	/**
	 * Crea una finestra di dialogo per la scelta di un file
	 *
	 * @param file classe <code>File</code> da cui parte la scelta
	 * @return la classe <code>FileChooser</code> creata
	 */
	public static FileChooser creaFileChooser( File file ) {

		FileChooser ritorno = null;
		LookAndFeel previousLF = UIManager.getLookAndFeel();
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
			ritorno = new FileChooser( file );
			UIManager.setLookAndFeel( previousLF );
		} catch ( IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e ) {
		}
		return ritorno;
	}

	/**
	 * Crea una finestra di dialogo per la scelta di un file
	 *
	 * @param file view classe <code>FileSystemView</code> da cui parte la scelta
	 * @return la classe <code>FileChooser</code> creata
	 */
	public static FileChooser creaFileChooser( FileSystemView view ) {
		FileChooser ritorno = null;
		LookAndFeel previousLF = UIManager.getLookAndFeel();
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
			ritorno = new FileChooser( view );
			UIManager.setLookAndFeel( previousLF );
		} catch ( IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e ) {
		}
		return ritorno;
	}

	/**
	 * Mostra una finestra di dialogo per la scelta di un file
	 *
	 * @return il file scelto
	 */
	public static File dialogoSceltaFile() {
		File ritorno = null;
		FileChooser jfc = creaFileChooser( FileSystemView.getFileSystemView().getHomeDirectory() );
		if ( jfc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
			ritorno = jfc.getSelectedFile();
		}
		return ritorno;
	}

	/**
	 * Mostra una finestra di dialogo per la scelta di un file
	 *
	 * @param percorso percorso file da cui parte la scelta
	 * @return il file scelto
	 */
	public static File dialogoSceltaFile( String percorso ) {
		File ritorno = null;
		FileChooser jfc = creaFileChooser( percorso );
		if ( jfc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
			ritorno = jfc.getSelectedFile();
		}
		return ritorno;
	}

	/**
	 * Mostra una finestra di dialogo per la scelta di un file
	 *
	 * @param file view classe <code>File</code> da cui parte la scelta
	 * @return il file scelto
	 */
	public static File dialogoSceltaFile( File file ) {
		File ritorno = null;
		FileChooser jfc = creaFileChooser( file );
		if ( jfc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
			ritorno = jfc.getSelectedFile();
		}
		return ritorno;
	}

	/**
	 * Mostra una finestra di dialogo per la scelta di un file
	 *
	 * @param percorso percorso file da cui parte la scelta
	 * @return il file scelto
	 */
	public static File dialogoSceltaFile( FileSystemView view ) {
		File ritorno = null;
		FileChooser jfc = creaFileChooser( view );
		if ( jfc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
			ritorno = jfc.getSelectedFile();
		}
		return ritorno;
	}
}
