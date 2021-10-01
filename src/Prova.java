import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Layout;
import gui.MenuBar;
import preferenze.PreferenzeGUI;
import utility.ListaOggettiMenu;
import utility.WrongValueException;

public class Prova {

	public static void main( String[] args ) {

		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
			}
		};

		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_SCURO );
		ListaOggettiMenu menu = new ListaOggettiMenu();
		ListaOggettiMenu submenu = new ListaOggettiMenu();
		submenu.add( "giorigio", a );
		submenu.add( "", gui.creaSeparatore() );
		submenu.add( "giorigio", a );
		menu.add( "roberto", submenu );

		Layout l = gui.creaGridBagLayout();
		l.add( gui.creaBottoneCambiaTemaChiaroScuro( new PreferenzeGUI( PreferenzeGUI.TEMA_CHIARO ), new PreferenzeGUI( PreferenzeGUI.TEMA_SCURO ) ) );

		try {
			gui.creaFinestra( "", l, MenuBar.creaMenuBarDaListaOggettiMenu( gui, menu ), true );
		} catch ( WrongValueException e1 ) {
			e1.printStackTrace();
		}
	}
}
