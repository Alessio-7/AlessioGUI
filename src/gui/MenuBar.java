package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JMenuBar;
import javax.swing.border.Border;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;
import utility.ListaOggettiMenu;
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

	public static MenuBar creaMenuBarDaListaOggettiMenu( PreferenzeGUI gui, ListaOggettiMenu menu ) throws WrongValueException {
		return creaMenuBarDaListaOggettiMenu( gui.colori, gui.fonts, gui.bordi, menu );
	}

	public static MenuBar creaMenuBarDaListaOggettiMenu( Colori colori, Fonts fonts, Bordi bordi, ListaOggettiMenu menu ) throws WrongValueException {
		return creaMenuBarDaListaOggettiMenu( colori.sfondo(), colori.suSfondo(), colori.testo(), fonts.fontGenerico( Fonts.PLAIN ),
			bordi.bordoMenuBar(), menu );
	}

	public static MenuBar creaMenuBarDaListaOggettiMenu( Color coloreSfondo, Color coloreSfondoMenu, Color coloreTesto, Font font, Border bordo,
		ListaOggettiMenu menu ) throws WrongValueException {
		MenuBar ritorno = new MenuBar( coloreSfondo, bordo );

		for ( int i = 0; i < menu.getSize(); i++ ) {
			Map.Entry<String, Object> entry = menu.getOggetto( i );
			Object item = creaItem( coloreSfondoMenu, coloreTesto, font, bordo, entry.getKey(), entry.getValue() );
			( (Component) item ).setBackground( coloreSfondo );
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
		} else if ( value instanceof ListaOggettiMenu ) {
			ArrayList<Component> componenti = new ArrayList<Component>();
			ListaOggettiMenu listaMenu = (ListaOggettiMenu) value;
			for ( int j = 0; j < listaMenu.getSize(); j++ ) {
				Map.Entry<String, Object> entry = listaMenu.getOggetto( j );
				String keyA = entry.getKey();
				Object valueA = entry.getValue();
				componenti.add( (Component) creaItem( coloreSfondo, coloreTesto, font, bordo, keyA, valueA ) );
			}
			Menu menu = new Menu( coloreSfondo, coloreTesto, font, key, componenti.toArray( new Component[componenti.size()] ), null );
			ritorno = menu;

		} else if ( value instanceof Separatore ) {
			ritorno = value;
		}

		else {
			throw new WrongValueException( "Valore ListaOggettiMenu sbagliato\n Valori accettabili: ActionListener, ListaOggettiMenu, Separatore" );
		}

		return ritorno;
	}
}
