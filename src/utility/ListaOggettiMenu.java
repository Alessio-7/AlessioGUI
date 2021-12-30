package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListaOggettiMenu {

	private HashMap<String, Object> oggetti;
	private ArrayList<String> ordineOggetti;

	public ListaOggettiMenu() {
		oggetti = new HashMap<String, Object>();
		ordineOggetti = new ArrayList<String>();
	}

	public void add( String testo, Object obj ) {
		oggetti.put( testo, obj );
		ordineOggetti.add( testo );
	}

	public Map.Entry<String, Object> getOggetto( int index ) {
		return new java.util.AbstractMap.SimpleEntry<String, Object>( ordineOggetti.get( index ), oggetti.get( ordineOggetti.get( index ) ) );
	}

	public int getSize() {
		return ordineOggetti.size();
	}

}
