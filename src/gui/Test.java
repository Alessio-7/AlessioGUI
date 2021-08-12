package gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import preferenze.PreferenzeGUI;

public class Test {

	public static void main( String[] args ) {
		new Test();
	}

	private Test() {

		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_SCURO );

		JPanel grid = gui.creaGridBagLayout();

		for ( int i = 0; i < 100; i++ ) {
			grid.add( gui.creaBottone( "pòjkhòaskjhflòakjhdlzkjhdlaskjhdalkjhdkajhsdkajshd", null ), new GridBagConstraints( 0, i, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 25, 25, 25, 25 ), 0, 0 ) );
		}

		// gui.creaFinestra( "Test", 500, 500, grid, true );
	}
}
