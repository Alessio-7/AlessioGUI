package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import preferenze.PreferenzeGUI;
import utility.ListaOggettiMenu;
import utility.WrongValueException;

public class Test {

	public static void main( String[] args ) {
		new Test();
	}

	private Test() {

		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_SCURO );

		JPanel grid = gui.creaGridBagLayout();

		grid.add( gui.creaComboBox( new String[] {
			"ciao",
			"ciao2" } ) );

		ActionListener f = new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {
			}
		};

		ListaOggettiMenu menu = new ListaOggettiMenu();
		ListaOggettiMenu submenu = new ListaOggettiMenu();
		ListaOggettiMenu subsubmenu = new ListaOggettiMenu();
		subsubmenu.add( "c", f );
		submenu.add( "a", f );
		submenu.add( "", gui.creaSeparatore() );
		submenu.add( "b", subsubmenu );
		menu.add( "Menu", submenu );
		MenuBar bar = null;
		try {
			bar = MenuBar.creaMenuBarDaListaOggettiMenu( gui, menu );
		} catch ( WrongValueException e ) {
			e.printStackTrace();
		}

		gui.creaFinestra( "Test", 500, 500, grid, bar, true );
	}
}
