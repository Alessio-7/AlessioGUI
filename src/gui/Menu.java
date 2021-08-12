package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import utility.WrongValueException;

public class Menu {

	public static JMenuBar creaMenuBarDaHashMap( Colori colori, Fonts fonts, Bordi bordi, HashMap<String, ?> menuItems ) throws WrongValueException {
		JMenuBar ritorno = new JMenuBar();
		ritorno.setBackground( colori.sfondo() );
		ritorno.setBorder( bordi.bordoGenerico() );

		ActionListener f = new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {
				// TODO Auto-generated method stub

			}
		};

		Map<Object, Object> a = Stream.of( new Object[][] {
			{
				"Menu",
				new Object[][] {
					{
						"Salva",
						f },
					{
						"Salva in modi",
						new Object[][] {
							{
								"modo1",
								f },
							{
								"modo2",
								f }, } },
					{
						"Ciao",
						f, } } },
			{
				"Ciao",
				f }, } )
			.collect( Collectors.toMap( data -> data[0], data -> data[1] ) );

		ritorno.add( (JMenu) creaItem( "", a ) );

		return ritorno;
	}

	private static Object creaItem( String key, Object value ) throws WrongValueException {
		Object ritorno = null;

		if ( value instanceof ActionListener ) {
			JMenuItem item = new JMenuItem( key );
			item.addActionListener( (ActionListener) value );
			ritorno = item;
		} else if ( value instanceof Map ) {

			JMenu menu = new JMenu( key );
			for ( Map.Entry<String, ?> entry : ( (HashMap<String, ?>) value ).entrySet() ) {
				String keyA = entry.getKey();
				Object valueA = entry.getValue();
				menu.add( (JMenuItem) creaItem( keyA, valueA ) );
			}

		} else {
			throw new WrongValueException( "Valore HashMap sbagliato\n Valori accettabili: ActionListener, HashMap<String, ?>" );
		}

		return ritorno;
	}

}
