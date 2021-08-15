package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenuBar;
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
		this( colori.sfondo(), bordi.bordoMenuBar(), null );
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
		return creaMenuBarDaHashMap( gui.colori, gui.fonts, gui.bordi, menu );
	}

	public static MenuBar creaMenuBarDaHashMap( Colori colori, Fonts fonts, Bordi bordi, HashMap<String, Object> menu ) throws WrongValueException {
		return creaMenuBarDaHashMap( colori.sfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoMenuBar(), menu );
	}

	public static MenuBar creaMenuBarDaHashMap( Color coloreSfondo, Color coloreTesto, Font font, Border bordo, HashMap<String, Object> menu )
		throws WrongValueException {
		MenuBar ritorno = new MenuBar( coloreSfondo, bordo );

		for ( Map.Entry<String, Object> entry : menu.entrySet() ) {
			Object item = creaItem( coloreSfondo, coloreTesto, font, bordo, entry.getKey(), entry.getValue() );

			if ( item instanceof Menu ) {
				ritorno.add( (Menu) item );
			} else if ( item instanceof MenuItem ) {
				ritorno.add( (MenuItem) item );
			} else {
				System.out.println( "hai sbagliato qualcosa\t" );
			}
		}
		return ritorno;
	}

	private static Object creaItem( Color coloreSfondo, Color coloreTesto, Font font, Border bordo, String key, Object value )
		throws WrongValueException {
		Object ritorno = null;

		if ( value instanceof ActionListener ) {
			MenuItem item = new MenuItem( coloreSfondo, coloreTesto, font, key, (ActionListener) value );
			ritorno = item;
		} else if ( value instanceof HashMap ) {
			ArrayList<Component> componenti = new ArrayList<Component>();
			for ( Map.Entry<String, Object> entry : ( (HashMap<String, Object>) value ).entrySet() ) {
				String keyA = entry.getKey();
				Object valueA = entry.getValue();
				componenti.add( (Component) creaItem( coloreSfondo, coloreTesto, font, bordo, keyA, valueA ) );
			}
			Menu menu = new Menu( coloreSfondo, coloreTesto, font, key, componenti.toArray( new Component[componenti.size()] ), null );
			ritorno = menu;

		} else if ( value instanceof Separatore ) {
			System.out.println( "a" );
			ritorno = value;
		}

		else {
			throw new WrongValueException( "Valore HashMap sbagliato\n Valori accettabili: ActionListener, HashMap<String, Object>, Separatore" );
		}

		return ritorno;
	}
}
