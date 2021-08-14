package gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JPanel;

import preferenze.PreferenzeGUI;
import utility.WrongValueException;

public class Test {

	public static void main( String[] args ) {
		new Test();
	}

	private Test() {

		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_SCURO );

		JPanel grid = gui.creaGridBagLayout();

		for ( int i = 0; i < 100; i++ ) {
			grid.add( gui.creaLabel( "BANANA" ), new GridBagConstraints( 0, i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets( 25, 25, 25, 25 ), 0, 0 ) );
		}

		ActionListener f = new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {
			}
		};

		HashMap<String, Object> menu = new HashMap<String, Object>();
		HashMap<String, Object> submenu = new HashMap<String, Object>();
		HashMap<String, Object> subsubmenu = new HashMap<String, Object>();
		subsubmenu.put( "c", f );
		submenu.put( "a", f );
		submenu.put( "b", subsubmenu );
		menu.put( "Menu", submenu );
		MenuBar bar = null;
		try {
			bar = MenuBar.creaMenuBarDaHashMap( gui, menu );
		} catch ( WrongValueException e ) {
			e.printStackTrace();
		}

		gui.creaFinestra( "Test", 500, 500, grid, bar, true );
	}
}
