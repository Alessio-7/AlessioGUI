package gui;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import preferenze.Fonts;
import preferenze.PreferenzeGUI;

/**
 * Sottoclasse della classe <code>JRadioButton</code>
 */
public class RadioButton extends JRadioButton {

	private static final long serialVersionUID = 1L;

	// TODO update gui

	/**
	 * Costruttore della classe <code>RadioButton</code>
	 *
	 * @param label       <code>Label</code> che accompagna il
	 *                    <code>RadioButton</code>
	 * @param selezionato se il <code>RadioButton</code> &egrave; selezionato
	 */
	public RadioButton( Label label, boolean selezionato ) {
		super( label.getText(), selezionato );
		setIcon( new ImageIcon( "res/RadioButton/icon.png" ) );
		setSelectedIcon( new ImageIcon( "res/RadioButton/selectedIcon.png" ) );
		setRolloverIcon( new ImageIcon( "res/RadioButton/rolloverIcon.png" ) );
		setRolloverSelectedIcon( new ImageIcon( "res/RadioButton/rolloverSelectedIcon.png" ) );
		setBackground( label.getBackground() );
		setForeground( label.getForeground() );
		setFont( label.getFont() );
		setBorder( label.getBorder() );
		setFocusPainted( false );
		setOpaque( true );
	}

	/**
	 * Costruttore della classe <code>RadioButton</code>
	 *
	 * @param gui         la classe <code>PreferenzeGUI</code> su cui si basa la GUI
	 *                    del <code>RadioButton</code>
	 * @param selezionato se il <code>RadioButton</code> &egrave; selezionato
	 */
	public RadioButton( PreferenzeGUI gui, boolean selezionato ) {
		super();
		setSelected( selezionato );
		setIcon( new ImageIcon( "res/RadioButton/icon.png" ) );
		setSelectedIcon( new ImageIcon( "res/RadioButton/selectedIcon.png" ) );
		setRolloverIcon( new ImageIcon( "res/RadioButton/rolloverIcon.png" ) );
		setRolloverSelectedIcon( new ImageIcon( "res/RadioButton/rolloverSelectedIcon.png" ) );
		setBackground( gui.colori.sfondo() );
		setForeground( gui.colori.testo() );
		setFont( gui.fonts.fontGenerico( Fonts.PLAIN ) );
		setBorder( gui.bordi.bordoVuotoGenerico() );
		setFocusPainted( false );
		setOpaque( true );
	}
}
