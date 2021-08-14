package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.Border;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;
import utility.WrongValueException;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	public MenuBar( PreferenzeGUI gui ) {
		this( gui, null );
	}

	public MenuBar( PreferenzeGUI gui, Component[] componenti ) {
		this( gui.colori, gui.bordi, componenti );
	}

	public MenuBar( Colori colori, Bordi bordi ) {
		this( colori.sfondo(), bordi.bordoGenerico(), null );
	}

	public MenuBar( Colori colori, Bordi bordi, Component[] componenti ) {
		this( colori.sfondo(), bordi.bordoGenerico(), componenti );
	}

	public MenuBar( Color coloreSfondo, Border bordo ) {
		this( coloreSfondo, bordo, null );
	}

	public MenuBar( Color coloreSfondo, Border bordo, Component[] componenti ) {
		super();
		setBackground( coloreSfondo );
		setBorder( bordo );
		if ( componenti != null && componenti.length != 0 ) {
			for ( Component c : componenti ) {
				add( c );
			}
		}
	}

	public static MenuBar creaMenuBarDaHashMap( PreferenzeGUI gui, HashMap<String, Object> menu ) throws WrongValueException {
		return creaMenuBarDaHashMap( gui.colori.sfondo(), gui.colori.testo(), gui.fonts.fontGenerico( Fonts.PLAIN ),
			BorderFactory.createMatteBorder( 0, 0, 1, 0, gui.colori.bordoGenerico() ), menu );
	}

	public static MenuBar creaMenuBarDaHashMap( Colori colori, Fonts fonts, Bordi bordi, HashMap<String, Object> menu ) throws WrongValueException {
		return creaMenuBarDaHashMap( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoGenerico(), menu );
	}

	public static MenuBar creaMenuBarDaHashMap( Color coloreSfondo, Color coloreTesto, Font font, Border bordo, HashMap<String, Object> menu )
		throws WrongValueException {
		MenuBar ritorno = new MenuBar( coloreSfondo, bordo );

		for ( Map.Entry<String, Object> entry : menu.entrySet() ) {
			Object item = creaItem( coloreSfondo, coloreTesto, font, entry.getKey(), entry.getValue() );

			if ( item instanceof JMenu ) {
				ritorno.add( (JMenu) item );
			} else if ( item instanceof MenuItem ) {
				ritorno.add( (MenuItem) item );
			} else {
				System.out.println( "hai sbagliato qualcosa\t" );
			}
		}
		return ritorno;
	}

	private static Object creaItem( Color coloreSfondo, Color coloreTesto, Font font, String key, Object value ) throws WrongValueException {
		Object ritorno = null;

		if ( value instanceof ActionListener ) {
			MenuItem item = new MenuItem( coloreSfondo, coloreTesto, font, key, (ActionListener) value );
			ritorno = item;
		} else if ( value instanceof HashMap ) {
			JMenu menu = new JMenu( key );
			for ( Map.Entry<String, Object> entry : ( (HashMap<String, Object>) value ).entrySet() ) {
				String keyA = entry.getKey();
				Object valueA = entry.getValue();
				menu.add( (JMenuItem) creaItem( coloreSfondo, coloreTesto, font, keyA, valueA ) );
			}
			ritorno = menu;

		} else {
			throw new WrongValueException( "Valore HashMap sbagliato\n Valori accettabili: ActionListener, HashMap<String, Object>" );
		}

		return ritorno;
	}
}
