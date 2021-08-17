package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import preferenze.PreferenzeGUI;

public class Test {

	public static void main( String[] args ) {
		new Test();
	}

	private Test() {

		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_SCURO );
		PreferenzeGUI gui2 = new PreferenzeGUI( PreferenzeGUI.TEMA_CHIARO );

		JPanel grid = gui.creaGridBagLayout();
		JPanel grid2 = gui2.creaGridBagLayout();

		ActionListener f = new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
			}
		};

		PreferenzeGUI[] guis = new PreferenzeGUI[] {
			gui,
			gui2 };

		JPanel[] grids = new JPanel[] {
			grid,
			grid2 };
		for ( int i = 0; i < 2; i++ ) {

		}

		gui.creaFinestra( "Test", 500, 500, grid, true );
		gui2.creaFinestra( "Test", 500, 500, grid2, true );
	}
}
