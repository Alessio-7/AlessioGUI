package gui;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import preferenze.Fonts;
import preferenze.PreferenzeGUI;

/**
 * Sottoclasse della classe <code>JCheckBox</code>
 */
public class CheckBox extends JCheckBox {

	private static final long serialVersionUID = 1L;

	// TODO update gui

	/**
	 * Costruttore della classe <code>CheckBox</code>
	 *
	 * @param label       <code>Label</code> che accompagna il <code>CheckBox</code>
	 * @param selezionato se il <code>CheckBox</code> &egrave; selezionato
	 */
	public CheckBox( Label label, boolean selezionato ) {
		super( label.getText(), selezionato );
		setIcon( new ImageIcon( "res/CheckBox/icon.png" ) );
		setRolloverIcon( new ImageIcon( "res/CheckBox/rolloverIcon.png" ) );
		setRolloverSelectedIcon( new ImageIcon( "res/CheckBox/rolloverSelectedIcon.png" ) );
		setSelectedIcon( new ImageIcon( "res/selectedIcon.png" ) );
		setBackground( label.getBackground() );
		setForeground( label.getForeground() );
		setFont( label.getFont() );
		setBorder( label.getBorder() );
		setFocusPainted( false );
		setOpaque( true );
	}

	/**
	 * Costruttore della classe <code>CheckBox</code>
	 *
	 * @param gui         la classe <code>PreferenzeGUI</code> su cui si basa la GUI
	 *                    del <code>CheckBox</code>
	 * @param selezionato se il <code>CheckBox</code> &egrave; selezionato
	 */
	public CheckBox( PreferenzeGUI gui, boolean selezionato ) {
		super();
		setIcon( new ImageIcon( "res/CheckBox/icon.png" ) );
		setSelectedIcon( new ImageIcon( "res/CheckBox/selectedIcon.png" ) );
		setRolloverIcon( new ImageIcon( "res/CheckBox/rolloverIcon.png" ) );
		setRolloverSelectedIcon( new ImageIcon( "res/CheckBox/rolloverSelectedIcon.png" ) );
		setSelected( selezionato );
		setBackground( gui.colori.sfondo() );
		setForeground( gui.colori.testo() );
		setFont( gui.fonts.fontGenerico( Fonts.PLAIN ) );
		setBorder( gui.bordi.bordoVuotoGenerico() );
		setFocusPainted( false );
		setOpaque( true );

		// System.out.println( new ImageIcon( CheckBox.class.getResource(
		// "resources/CheckBox/selectedIcon.png" ) ).getIconHeight() );
	}
}
