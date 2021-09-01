package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import preferenze.PreferenzeGUI;

public class Test {

	public static void main( String[] args ) {
		new Test();
	}

	private Test() {

		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_SCURO );

		Layout grid = gui.creaGridBagLayout();

		ActionListener azionenulla = new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {
			}
		};

		MenuBar menuBar = gui.creaMenuBar();
		menuBar.add(
				gui.creaBottoneCambiaTemaChiaroScuro( new PreferenzeGUI( PreferenzeGUI.TEMA_CHIARO ), new PreferenzeGUI( PreferenzeGUI.TEMA_SCURO ) ) );

		grid.add( gui.creaTextArea( 3, 10 ) );

		Finestra finestra = gui.creaFinestra( "Test", 500, 500, grid, menuBar, true );
	}
}
