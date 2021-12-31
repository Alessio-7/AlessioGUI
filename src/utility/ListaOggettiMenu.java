package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe per la creazione agevolata dei menu
 */
public class ListaOggettiMenu {

	private HashMap<String, Object> oggetti;
	private ArrayList<String> ordineOggetti;

	/**
	 * Costruttore che inizializza la classe <code>ListaOggettiMenu</code>
	 */
	public ListaOggettiMenu() {
		oggetti = new HashMap<>();
		ordineOggetti = new ArrayList<>();
	}

	/**
	 * Aggiunge un oggetto alla <code>ListaOggettiMenu</code>
	 * <p>
	 * <b>ATTENZIONE</b>, i valori consentiti come parametro <code>obj</code> sono:
	 * <ul>
	 * <li><code>ActionListener</code> per generare un <code>MenuItem</code></li>
	 * <li><code>ListaOggettiMenu</code> per generare un <i>sub menu</i>
	 * <code>Menu</code></li>
	 * <li><code>Separatore</code> per genereare un <code>Separatore</code>, non
	 * necessita di nessun parametro <code>testo</code></li>
	 * </ul>
	 *
	 * @param testo il testo che deve presentare l'oggetto
	 * @param obj   l'oggetto
	 */
	public void add( String testo, Object obj ) {
		oggetti.put( testo, obj );
		ordineOggetti.add( testo );
	}

	/**
	 * Ritorna un <code>Map.Entry</code> contenete il testo e l'oggetto immesso
	 *
	 * @param index l'indice del <code>Map.Entry</code>
	 * @return <code>Map.Entry&ltString, Object&gt </code>
	 */
	public Map.Entry<String, Object> getOggetto( int index ) {
		return new java.util.AbstractMap.SimpleEntry<>( ordineOggetti.get( index ), oggetti.get( ordineOggetti.get( index ) ) );
	}

	/**
	 * Ritorna la grandezza della lista
	 *
	 * @return la grandezza della lista
	 */
	public int getSize() {
		return ordineOggetti.size();
	}

}
