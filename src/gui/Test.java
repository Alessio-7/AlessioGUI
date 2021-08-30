package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import preferenze.Fonts;
import preferenze.PreferenzeGUI;

public class Test {

	public static void main( String[] args ) {
		new Test();
	}

	private Test() {

		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_SCURO );
		PreferenzeGUI gui2 = new PreferenzeGUI( PreferenzeGUI.TEMA_CHIARO );

		// JPanel grid = gui.creaGridBagLayout();
		JPanel grid = gui.creaGridLayout( 1, 1 );
		JPanel grid2 = gui2.creaGridBagLayout();

		ActionListener f = new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
			}
		};

		PreferenzeGUI[] guis = new PreferenzeGUI[] { gui, gui2 };

		JPanel[] grids = new JPanel[] { grid, grid2 };
		for ( int i = 0; i < 2; i++ ) {

		}

		TabbedPane pane = new TabbedPane( gui.colori.sfondo(), gui.colori.testo(), gui.fonts.fontGenerico( Fonts.PLAIN ), gui.bordi.bordoGenerico(), null,
				null );
		pane.add( "ciao", gui.creaBottone( "CIao", f ) );
		pane.add( "ciao", gui.creaBottone( "Roberto", f ) );
		pane.add( "ciao", gui.creaBottone( "Roberto", f ) );

		pane.setBackground( null );

		grid.add( pane );

		Finestra finestra = gui.creaFinestra( "Test", 500, 500, grid, true );
		// gui2.creaFinestra( "Test", 500, 500, grid2, true );
		// System.out.println( ColorChooser.mostraDialogoColore( finestra, "ciao" ) );
	}
}
