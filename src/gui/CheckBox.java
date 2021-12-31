package gui;

import javax.swing.Icon;
import javax.swing.JCheckBox;

/**
 * Sottoclasse della classe <code>JCheckBox</code>
 */
public class CheckBox extends JCheckBox {

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore della classe <code>CheckBox</code>
	 *
	 * @param label       <code>Label</code> che accompagna la <code>CheckBox</code>
	 * @param icona       icona del <code>CheckBox</code>
	 * @param selezionato se la <code>CheckBox</code> è selezionato
	 */
	public CheckBox( Label label, Icon icona, boolean selezionato ) {
		super( label.getText(), icona, selezionato );
		setBackground( label.getBackground() );
		setForeground( label.getForeground() );
		setFont( label.getFont() );
		setBorder( label.getBorder() );
		setFocusPainted( false );
		setOpaque( true );
	}
}
