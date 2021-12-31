package gui;

import javax.swing.Icon;
import javax.swing.JRadioButton;

/**
 * Sottoclasse della classe <code>JRadioButton</code>
 */
public class RadioButton extends JRadioButton {

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore della classe <code>RadioButton</code>
	 *
	 * @param label       <code>Label</code> che accompagna il
	 *                    <code>RadioButton</code>
	 * @param icona       icona del <code>RadioButton</code>
	 * @param selezionato se il <code>RadioButton</code> è selezionato
	 * @return la classe <code>RadioButton</code> creata
	 */
	public RadioButton( Label label, Icon icona, boolean selezionato ) {
		super( label.getText(), selezionato );
		setBackground( label.getBackground() );
		setForeground( label.getForeground() );
		setBorder( label.getBorder() );
		setFocusPainted( false );
	}
}
