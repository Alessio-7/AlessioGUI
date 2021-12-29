package gui;

import javax.swing.Icon;
import javax.swing.JRadioButton;

public class RadioButton extends JRadioButton {

	private static final long serialVersionUID = 1L;

	public RadioButton( Label label, Icon icona, boolean selezionato ) {
		super( label.getText(), selezionato );
		setBackground( label.getBackground() );
		setForeground( label.getForeground() );
		setBorder( label.getBorder() );
		setFocusPainted( false );
	}
}
