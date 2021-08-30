package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTabbedPane;
import javax.swing.border.Border;

public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	public TabbedPane( Color coloreSfondo, Color coloreTesto, Font font, Border bordo, String[] titoli, Component[] children ) {
		super();
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setBorder( bordo );

		if ( ( titoli != null && children != null ) && ( titoli.length > 0 && children.length == titoli.length ) ) {
			for ( int i = 0; i < titoli.length; i++ ) {
				add( titoli[i], children[i] );
			}
		}
	}

}
