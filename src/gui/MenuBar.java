package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenuBar;
import javax.swing.border.Border;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.PreferenzeGUI;
import utility.ListaOggettiMenu;
import utility.WrongValueException;

public class MenuBar extends JMenuBar implements Observer {

	private static final long serialVersionUID = 1L;

	public MenuBar( PreferenzeGUI gui ) {
		this( gui, null );
	}

	public MenuBar( PreferenzeGUI gui, Component[] componenti ) {
		this( gui.colori, gui.bordi, componenti );
		gui.addObserver( this );
	}

	public MenuBar( Colori colori, Bordi bordi ) {
		this( colori.sfondo(), bordi.bordoMenuBar(), null );
	}

	public MenuBar( Colori colori, Bordi bordi, Component[] componenti ) {
		this( colori.sfondo(), bordi.bordoMenuBar(), componenti );
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
		MenuBar ritorno = new MenuBar( gui );

		for ( int i = 0; i < menu.getSize(); i++ ) {
			Map.Entry<String, Object> entry = menu.getOggetto( i );
			Object item = creaItem( gui, entry.getKey(), entry.getValue(), false );
			if ( item instanceof Menu ) {
				ritorno.add( ( Menu ) item );
			} else if ( item instanceof MenuItem ) {
				ritorno.add( ( MenuItem ) item );
			} else {
				System.out.println( "hai sbagliato qualcosa\t" );
			}
		}
		return ritorno;
	}

	private static Object creaItem( PreferenzeGUI gui, String key, Object value, boolean parteSubMenu ) throws WrongValueException {
		Object ritorno = null;

		if ( value instanceof ActionListener ) {
			MenuItem item = new MenuItem( gui, key, ( ActionListener ) value, parteSubMenu );
			ritorno = item;
		} else if ( value instanceof ListaOggettiMenu ) {
			ArrayList<Component> componenti = new ArrayList<Component>();
			ListaOggettiMenu listaMenu = ( ListaOggettiMenu ) value;
			for ( int j = 0; j < listaMenu.getSize(); j++ ) {
				Map.Entry<String, Object> entry = listaMenu.getOggetto( j );
				String keyA = entry.getKey();
				Object valueA = entry.getValue();
				componenti.add( ( Component ) creaItem( gui, keyA, valueA, true ) );
			}
			Menu menu = new Menu( gui, key, componenti.toArray( new Component[componenti.size()] ), null, parteSubMenu );
			ritorno = menu;

		} else if ( value instanceof Separatore ) {
			ritorno = value;
		}

		else {
			throw new WrongValueException( "Valore ListaOggettiMenu sbagliato\n Valori accettabili: ActionListener, ListaOggettiMenu, Separatore" );
		}

		return ritorno;
	}

	@Override
	public void update( Observable o, Object arg ) {

		PreferenzeGUI gui = ( PreferenzeGUI ) arg;
		setBackground( gui.colori.sfondo() );
		setBorder( gui.bordi.bordoMenuBar() );
	}
}
