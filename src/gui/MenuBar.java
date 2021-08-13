package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import utility.WrongValueException;

public class MenuBar {

	public static JMenuBar creaMenuBarDaHashMap( Colori colori, Fonts fonts, Bordi bordi, HashMap<String, ?> menufgkj ) throws WrongValueException {
		JMenuBar ritorno = new JMenuBar();
		ritorno.setBackground( colori.sfondo() );
		ritorno.setBorder( bordi.bordoGenerico() );

		ActionListener f = new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {
			}
		};

		HashMap<String, Object> menu = new HashMap<String, Object>();
		menu.put( "Menu", f );
		menu.put( "Menu", f );

		for ( Map.Entry<String, Object> entry : menu.entrySet() ) {
			Object item = creaItem( colori, fonts, entry.getKey(), entry.getValue() );

			// TODO errore: non si vede l'item

			if ( item instanceof JMenu ) {
				ritorno.add( (JMenu) item );
				System.out.println( "hai sxxxxxxxxxxxxxxxxxxxxxbagliato qualcosa\t" );
			} else if ( item instanceof MenuItem ) {
				ritorno.add( (MenuItem) item );
				System.out.println( item );
			} else {
				System.out.println( "hai sbagliato qualcosa\t" );
			}
		}
		return ritorno;
	}

	private static Object creaItem( Colori colori, Fonts fonts, String key, Object value ) throws WrongValueException {
		Object ritorno = null;

		if ( value instanceof ActionListener ) {
			MenuItem item = new MenuItem( colori, fonts, key, (ActionListener) value );
			ritorno = item;
		} else if ( value instanceof HashMap ) {
			JMenu menu = new JMenu( key );
			for ( Map.Entry<String, Object> entry : ( (HashMap<String, Object>) value ).entrySet() ) {
				String keyA = entry.getKey();
				Object valueA = entry.getValue();
				menu.add( (JMenuItem) creaItem( colori, fonts, keyA, valueA ) );
			}
			ritorno = menu;

		} else {
			throw new WrongValueException( "Valore HashMap sbagliato\n Valori accettabili: ActionListener, HashMap<String, Object>" );
		}

		return ritorno;
	}

}
