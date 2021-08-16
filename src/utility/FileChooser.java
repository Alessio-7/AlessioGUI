package utility;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;

public class FileChooser extends JFileChooser {

	private static final long serialVersionUID = 1L;

	public FileChooser( FileSystemView view ) {
		super( view );
	}

	public FileChooser( File file ) {
		super( file );
	}

	public FileChooser( String percorso ) {
		super( percorso );
	}

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

	public static File dialogoSceltaFile() {
		File ritorno = null;
		FileChooser jfc = creaFileChooser( FileSystemView.getFileSystemView().getHomeDirectory() );
		if ( jfc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
			ritorno = jfc.getSelectedFile();
		}
		return ritorno;
	}

	public static File dialogoSceltaFile( String percorso ) {
		File ritorno = null;
		FileChooser jfc = creaFileChooser( percorso );
		if ( jfc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
			ritorno = jfc.getSelectedFile();
		}
		return ritorno;
	}

	public static File dialogoSceltaFile( File file ) {
		File ritorno = null;
		FileChooser jfc = creaFileChooser( file );
		if ( jfc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
			ritorno = jfc.getSelectedFile();
		}
		return ritorno;
	}

	public static File dialogoSceltaFile( FileSystemView view ) {
		File ritorno = null;
		FileChooser jfc = creaFileChooser( view );
		if ( jfc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
			ritorno = jfc.getSelectedFile();
		}
		return ritorno;
	}
}
