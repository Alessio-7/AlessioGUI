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
		setIcon( new ImageIcon( "resources/CheckBox/icon.png" ) );
		setSelectedIcon( new ImageIcon( "resources/CheckBox/selectedIcon.png" ) );
		setRolloverIcon( new ImageIcon( "resources/CheckBox/rolloverIcon.png" ) );
		setRolloverSelectedIcon( new ImageIcon( "resources/CheckBox/rolloverSelectedIcon.png" ) );
		setBackground( label.getBackground() );
		setForeground( label.getForeground() );
		setFont( label.getFont() );
		setBorder( label.getBorder() );
		setFocusPainted( false );
		setOpaque( true );
		setSelectedIcon( new ImageIcon( "resources/selectedIcon.png" ) );
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
		setIcon( new ImageIcon( "resources/CheckBox/icon.png" ) );
		setSelectedIcon( new ImageIcon( "resources/CheckBox/selectedIcon.png" ) );
		setRolloverIcon( new ImageIcon( "resources/CheckBox/rolloverIcon.png" ) );
		setRolloverSelectedIcon( new ImageIcon( "resources/CheckBox/rolloverSelectedIcon.png" ) );
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
