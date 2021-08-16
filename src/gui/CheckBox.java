package gui;

import javax.swing.Icon;
import javax.swing.JCheckBox;

public class CheckBox extends JCheckBox {

	private static final long serialVersionUID = 1L;

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
