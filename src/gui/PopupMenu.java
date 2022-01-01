package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPopupMenu;

import preferenze.Colori;
import preferenze.PreferenzeGUI;
import utility.ListaOggettiMenu;
import utility.WrongValueException;

/**
 * Sottoclasse di <code>JPopupMenu</code> che pu&ograve; impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class PopupMenu extends JPopupMenu implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui  la classe <code>PreferenzeGUI</code> su cui si basa la GUI del
	 *             <code>PopupMenu</code>
	 * @param menu <code>ListaOggettiMenu</code> da cui generare i componenti da
	 *             aggiungere al <code>PopupMenu</code>
	 */
	public PopupMenu( PreferenzeGUI gui, ListaOggettiMenu menu ) {
		this( gui );

		for ( int i = 0; i < menu.getSize(); i++ ) {
			Map.Entry<String, Object> entry = menu.getOggetto( i );
			Object item;
			try {
				item = creaItem( gui, entry.getKey(), entry.getValue() );
				if ( item instanceof Menu ) {
					add( ( Menu ) item );
				} else if ( item instanceof MenuItem ) {
					add( ( MenuItem ) item );
				}
			} catch ( WrongValueException e ) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui la classe <code>PreferenzeGUI</code> su cui si basa la GUI del
	 *            <code>PopupMenu</code>
	 */
	public PopupMenu( PreferenzeGUI gui ) {
		this( gui.colori );
		gui.addObserver( this );
	}

	/**
	 * Costruttore che impiega l' interfaccia <code>Colori</code>
	 *
	 * @param colori l'interfaccia <code>Colori</code> su cui si basano i colori del
	 *               <code>PopupMenu</code>
	 */
	public PopupMenu( Colori colori ) {
		this( colori.subMenu() );
	}

	/**
	 * Costruttore con parametri specifici
	 *
	 * @param coloreSfondo colore dello sfondo del <code>PopupMenu</code>
	 */
	public PopupMenu( Color coloreSfondo ) {
		setBorderPainted( false );
		setBackground( coloreSfondo );
	}

	private static Object creaItem( PreferenzeGUI gui, String key, Object value ) throws WrongValueException {
		Object ritorno = null;

		if ( value instanceof ActionListener ) {
			MenuItem item = new MenuItem( gui, key, ( ActionListener ) value, true );
			item.setBorderPainted( false );
			ritorno = item;
		} else if ( value instanceof ListaOggettiMenu ) {
			ArrayList<Component> componenti = new ArrayList<>();
			ListaOggettiMenu listaMenu = ( ListaOggettiMenu ) value;
			for ( int j = 0; j < listaMenu.getSize(); j++ ) {
				Map.Entry<String, Object> entry = listaMenu.getOggetto( j );
				String keyA = entry.getKey();
				Object valueA = entry.getValue();
				componenti.add( ( Component ) creaItem( gui, keyA, valueA ) );
			}
			Menu menu = new Menu( gui, key, componenti.toArray( new Component[componenti.size()] ), null, true );
			menu.setBorderPainted( false );
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
	public void update( Observable osservabile, Object obj ) {
		PreferenzeGUI gui = ( PreferenzeGUI ) obj;
		setBackground( gui.colori.subMenu() );
	}

}
