package preferenze;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.border.Border;

/**
 * Interfaccia per generare i bordi dei componenti della GUI
 */
public interface Bordi {

	/**
	 * Ritorna un bordo vuoto per uso generico
	 *
	 * @return bordo vuoto per uso generico
	 */
	public Border bordoVuotoGenerico();

	/**
	 * Ritorna un bordo per uso generico
	 *
	 * @return bordo per uso generico
	 */
	public Border bordoGenerico();

	/**
	 * Ritorna un bordo per quando il mouse passa sopra un componente per uso
	 * generico
	 *
	 * @return bordo per quando il mouse passa sopra un componente per uso generico
	 */
	public Border bordoGenericoFocus();

	/**
	 * Ritorna un bordo per i componenti interagibili
	 *
	 * @return bordo per i componenti interagibili
	 */
	public Border bordoInteragibile();

	/**
	 * Ritorna un bordo per quando il mouse passa sopra un componente interagibile
	 *
	 * @return un bordo per quando il mouse passa sopra un componente interagibile
	 */
	public Border bordoInteragibileFocus();

	/**
	 * Ritorna un bordo secondario per uso generico
	 *
	 * @return bordo secondario per uso generico
	 */
	public Border bordoSecondario();

	/**
	 * Ritorna un bordo secondario per quando il mouse passa sopra un componente per
	 * uso generico
	 *
	 * @return bordo secondario per quando il mouse passa sopra un componente per
	 *         uso generico
	 */
	public Border bordoSecondarioFocus();

	/**
	 * Ritorna il bordo utilizzato per la <code>MenuBar</code>
	 *
	 * @return il bordo utilizzato per la <code>MenuBar</code>
	 */
	public Border bordoMenuBar();

	/**
	 * Ritorna un bordo per uso generico
	 *
	 * @param grandezza la grandezza del bordo
	 * @param spazio    lo spazio del bordo
	 * @return bordo per uso generico
	 */
	public Border bordoGenerico( int grandezza, Insets spazio );

	/**
	 * Ritorna un bordo per quando il mouse passa sopra un componente per uso
	 * generico
	 *
	 * @param grandezza la grandezza del bordo
	 * @param spazio    lo spazio del bordo
	 * @param colore    colore del bordo
	 * @return bordo per quando il mouse passa sopra un componente per uso generico
	 */
	public Border bordoGenericoFocus( int grandezza, Insets spazio, Color colore );

	/**
	 * Ritorna un bordo per i componenti interagibili
	 *
	 * @param grandezza la grandezza del bordo
	 * @param spazio    lo spazio del bordo
	 * @return bordo per i componenti interagibili
	 */
	public Border bordoInteragibile( int grandezza, Insets spazio );

	/**
	 * Ritorna un bordo per quando il mouse passa sopra un componente interagibile
	 *
	 * @param grandezza la grandezza del bordo
	 * @param spazio    lo spazio del bordo
	 * @param colore    colore del bordo
	 * @return bordo per quando il mouse passa sopra un componente per uso generico
	 */
	public Border bordoInteragibileFocus( int grandezza, Insets spazio, Color colore );

	/**
	 * Ritorna un bordo secondario per uso generico
	 *
	 * @param grandezza la grandezza del bordo
	 * @param spazio    lo spazio del bordo
	 * @return bordo secondario per uso generico
	 */
	public Border bordoSecondario( int grandezza, Insets spazio );

	/**
	 * Ritorna un bordo secondario per quando il mouse passa sopra un componente per
	 * uso generico
	 *
	 * @param grandezza la grandezza del bordo
	 * @param spazio    lo spazio del bordo
	 * @param colore    colore del bordo
	 * @return bordo secondario per quando il mouse passa sopra un componente per
	 *         uso generico
	 */
	public Border bordoSecondarioFocus( int grandezza, Insets spazio, Color colore );

}
