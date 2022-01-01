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

/**
 * Sottoclasse di <code>JMenuBar</code> che pu&ograve; impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class MenuBar extends JMenuBar implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui la classe <code>PreferenzeGUI</code> su cui si basa la GUI della
	 *            <code>MenuBar</code>
	 */
	public MenuBar( PreferenzeGUI gui ) {
		this( gui, null );
	}

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui        la classe <code>PreferenzeGUI</code> su cui si basa la GUI
	 *                   della <code>MenuBar</code>
	 * @param componenti array di componenti da aggiungere alla <code>MenuBar</code>
	 */
	public MenuBar( PreferenzeGUI gui, Component[] componenti ) {
		this( gui.colori, gui.bordi, componenti );
		gui.addObserver( this );
	}

	/**
	 * Costruttore che impiega le interfaccie <code>Colori</code>,
	 * <code>Bordi</code>
	 *
	 * @param colori l'interfaccia <code>Colori</code> su cui si basano i colori
	 *               della <code>MenuBar</code>
	 * @param bordi  l'interfaccia <code>Bordi</code> su cui si basano i bordi della
	 *               <code>MenuBar</code>
	 */
	public MenuBar( Colori colori, Bordi bordi ) {
		this( colori.sfondo(), bordi.bordoMenuBar(), null );
	}

	/**
	 * Costruttore che impiega le interfaccie <code>Colori</code>,
	 * <code>Bordi</code>
	 *
	 * @param colori     l'interfaccia <code>Colori</code> su cui si basano i colori
	 *                   della <code>MenuBar</code>
	 * @param bordi      l'interfaccia <code>Bordi</code> su cui si basano i bordi
	 *                   della
	 * @param componenti array di componenti da aggiungere alla <code>MenuBar</code>
	 */
	public MenuBar( Colori colori, Bordi bordi, Component[] componenti ) {
		this( colori.sfondo(), bordi.bordoMenuBar(), componenti );
	}

	/**
	 * Costruttore con parametri specifici
	 *
	 * @param coloreSfondo colore dello sfondo della <code>MenuBar</code>
	 * @param bordo        bordo della <code>MenuBar</code>
	 */
	public MenuBar( Color coloreSfondo, Border bordo ) {
		this( coloreSfondo, bordo, null );
	}

	/**
	 * Costruttore con parametri specifici
	 *
	 * @param coloreSfondo colore dello sfondo della <code>MenuBar</code>
	 * @param bordo        bordo della <code>MenuBar</code>
	 * @param componenti   array di componenti da aggiungere alla
	 *                     <code>MenuBar</code>
	 */
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

	/**
	 * Permette la creazione agevolata di una <code>MenuBar</code> tramite la
	 * <code>ListaOggettiMenu</code>
	 *
	 * @param gui  la classe <code>PreferenzeGUI</code> su cui si basa la GUI della
	 *             <code>MenuBar</code> e degli altri componenti
	 * @param menu la <code>ListaOggettiMenu</code> da cui generare la
	 *             <code>MenuBar</code>
	 * @return la classe <code>MenuBar</code>
	 * @throws WrongValueException lancia l'eccezione se il valore nella
	 *                             <code>ListaOggettiMenu</code> non è valido
	 *                             <p>
	 *                             valori accettabili:
	 *                             <ul>
	 *                             <li><code>ActionListener</code> per generare un
	 *                             <code>MenuItem</code></li>
	 *                             <li><code>ListaOggettiMenu</code> per generare un
	 *                             <i>sub menu</i> <code>Menu</code></li>
	 *                             <li><code>Separatore</code> per genereare un
	 *                             <code>Separatore</code>, non necessita di nessun
	 *                             parametro <code>testo</code></li>
	 *                             </ul>
	 */
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
			ArrayList<Component> componenti = new ArrayList<>();
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
